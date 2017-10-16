package com.internousdev.cs.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.BuyItemDAO;
import com.internousdev.cs.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private String cardname;
	public int card_id;
	private int buycount;
	private int price;
	private boolean buyflag;
	public String message = "";

	public Map<String,Object> session;


	public String execute(){
		String ret = SUCCESS;

		session.put("buycardname", cardname);
		session.put("buycount", buycount);
		session.put("price", price);
		int intCount = Integer.parseInt(session.get("buycount").toString());
		int intPrice = Integer.parseInt(session.get("price").toString());

		session.put("total_price", intCount * intPrice);

		System.out.println(session.get("total_price")+"tp");

		BuyItemDAO bDAO = new BuyItemDAO();
		BuyItemDTO bDTO = bDAO.BuyAction(card_id, buycount);
		buyflag = bDTO.buyflag;


		if(buyflag){
			message = "購入完了しました。";
		}else{
			message = "在庫が足りず、購入できませんでした";
		}

		return ret;
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

	public void setSession(Map<String,Object> session){
		this.session = session;
	}



	public int getCard_id() {
		return card_id;
	}



	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}



	public String getCardname() {
		return cardname;
	}



	public void setCardname(String cardname) {
		this.cardname = cardname;
	}




	public boolean isBuyflag() {
		return buyflag;
	}



	public void setBuyflag(boolean buyflag) {
		this.buyflag = buyflag;
	}



	public String getMessage() {
		return message;
	}



}
