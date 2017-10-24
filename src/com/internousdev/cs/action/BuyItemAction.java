package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.BuyItemDAO;
import com.internousdev.cs.dao.BuyItemHistryDAO;
import com.internousdev.cs.dto.CardDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private String cardname;
	private int buycount;
	private int price;
	private boolean buyflag = false;
	public String message = "";
	private Date dateUtil = new Date();

	public Map<String,Object> session;
	public ArrayList<CardDataDTO> CartArray = new ArrayList<CardDataDTO>();

	@SuppressWarnings("unchecked")
	public String execute(){
		String ret = SUCCESS;

		if(session.get("cartin") != null){
			buyflag = true;
			CartArray = (ArrayList<CardDataDTO>)session.get("cartin");

			Iterator<CardDataDTO> itr = CartArray.iterator();
			BuyItemDAO bDAO = new BuyItemDAO();
			CardDataDTO tmpBIDTO = new CardDataDTO();
			BuyItemHistryDAO BIH_DAO = new BuyItemHistryDAO();
			while (itr.hasNext()) {
				tmpBIDTO = (CardDataDTO) itr.next();
				bDAO.BuyAction(tmpBIDTO.getCardname(), tmpBIDTO.getCart_count());
				BIH_DAO.BuyHistry((String)session.get("now_user"), tmpBIDTO, dateUtil);

			}

		}

/*
		int intCount = Integer.parseInt(session.get("buycount").toString());
		int intPrice = Integer.parseInt(session.get("price").toString());

		session.put("total_price", intCount * intPrice);

		System.out.println(session.get("total_price")+"tp");

		BuyItemDAO bDAO = new BuyItemDAO();
		BuyItemDTO bDTO = bDAO.BuyAction(cardname, buycount);
		buyflag = bDTO.buyflag;*/


		if(buyflag){
			session.remove("cartin");
			message = "購入完了しました。";
		}else{
			message = "カート内に商品がありません";
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
