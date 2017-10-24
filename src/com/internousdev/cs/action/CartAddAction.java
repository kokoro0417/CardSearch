package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.SearchDAO;
import com.internousdev.cs.dto.CardDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAddAction extends ActionSupport implements SessionAware{

	private String cardname="";
	private int buycount=0;
	private int price=0;
	private boolean buyflag=false;
	public boolean CartCheck = false;
	public int CartInCount=1000;
	public String message = "";

	public Map<String,Object> session;
	public ArrayList<CardDataDTO> CartArray = new ArrayList<CardDataDTO>();
	public ArrayList<CardDataDTO> aryDTO =new ArrayList<CardDataDTO>();

	@SuppressWarnings("unchecked")
	public String execute(){
		CardDataDTO CartInDTO = new CardDataDTO();


		if(!(cardname.equals(""))){//カード名入力されていたら起動

			if(session.get("cartin") != null){//既にカートに何か入っていたら起動
				CartArray = (ArrayList<CardDataDTO>)session.get("cartin");

				Iterator<CardDataDTO> itr = CartArray.iterator();
				int tmpC = 0;
				while (itr.hasNext()) {
					CartInDTO = (CardDataDTO) itr.next();
					if(CartInDTO.getCardname().equals(cardname)){//カート内に現在選択商品が入っていたら位置記録
						CartInCount = tmpC;
					}
					tmpC++;
				}
			}

			SearchDAO sDAO = new SearchDAO();
			ArrayList<CardDataDTO> SearchAryDTO = sDAO.Search(cardname, 0, "", 0);//商品データ検索

			if(!(SearchAryDTO.isEmpty())){//商品存在したら起動
				CardDataDTO SearchDTO = SearchAryDTO.get(0);
				if(CartInCount != 1000){//CartInCountの値が初期値から変更されていたらカート内に選択商品がある
					CartInDTO = (CardDataDTO)CartArray.get(CartInCount);
					buycount = CartInDTO.getCart_count() + buycount;//カート内商品数上乗せ
					CartCheck = true;
				}

				if(buycount <= SearchDTO.getCard_stock()){//カートに入れたとき、カート内の個数が在庫を越えなければ
					buyflag = true;
				}
				if(buyflag){
					message = "カートに商品を追加しました(仮)";
					CardDataDTO BuyItemDTO = new CardDataDTO();
					BuyItemDTO.setCardname(cardname);
					BuyItemDTO.setCart_count(buycount);
					BuyItemDTO.setPrice(price);
					BuyItemDTO.setTotal_price(price * buycount);
					if(CartCheck){
						CartArray.set(CartInCount, BuyItemDTO);
					}else{
						CartArray.add(BuyItemDTO);
					}
					session.put("cartin", CartArray);

				}else{
					message = "在庫が足りず、カートに追加できませんでした。";
				}





			}
		}else{
			message = "商品がありませんでした。";
		}




		aryDTO = (ArrayList<CardDataDTO>)session.get("SearchResult");

		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public int getBuycount() {
		return buycount;
	}

	public void setBuycount(int buycount) {
		this.buycount = buycount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isBuyflag() {
		return buyflag;
	}

	public void setBuyflag(boolean buyflag) {
		this.buyflag = buyflag;
	}



}
