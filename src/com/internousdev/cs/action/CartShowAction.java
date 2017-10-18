package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartShowAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	public ArrayList<BuyItemDTO> CartArray = new ArrayList<BuyItemDTO>();

	private String cardname;
	private int buycount;
	private int price;
	private int total_price;

	@SuppressWarnings("unchecked")
	public String execute(){
		if(session.get("cartin") != null){//既にカートに何か入っていたら起動
			CartArray = (ArrayList<BuyItemDTO>)session.get("cartin");
		}
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

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}



}
