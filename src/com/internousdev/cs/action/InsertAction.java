package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.InsertActionDAO;
import com.internousdev.cs.dao.SearchDAO;
import com.internousdev.cs.dto.CardDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InsertAction extends ActionSupport implements SessionAware{

/*	private String cardname = "";
	private String color = "";
	private int mana = 0;
	private String cardtype = "";
	private int price = 0;
	private int card_stock = 0;*/
	public String message="";
	private boolean SearchFlag = false;
	public ArrayList<CardDataDTO> aryDTO =new ArrayList<CardDataDTO>();


	public Map<String,Object> session;

	public String Insert(){
		String ret= ERROR;
		CardDataDTO InsertCardData = (CardDataDTO)session.get("ChengeData");

		if(!(SearchFlag)){
			if(InsertCardData.getColor().isEmpty()){InsertCardData.setColor("_");}
			if(InsertCardData.getCardtype().isEmpty()){InsertCardData.setCardtype("_");}

			InsertActionDAO InsertDAO =new InsertActionDAO();

			ret=InsertDAO.InsertCard(InsertCardData);
		}

		if(ret.equals(SUCCESS)){
			message="カードが正常に追加されました。";
		}else{
			message="カードが正常に追加されませんでした。";
		}

		SearchDAO sDAO = new SearchDAO();
		aryDTO = sDAO.Search("", 0, "", 0);


		return ret;
	}

	@SuppressWarnings("unchecked")
	public String InsertCansell(){
		message = "商品追加をキャンセルしました。";
		aryDTO = (ArrayList<CardDataDTO>)session.get("SearchResult");
		return SUCCESS;
	}
/*
	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCard_stock() {
		return card_stock;
	}

	public void setCard_stock(int card_stock) {
		this.card_stock = card_stock;
	}*/

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public boolean isSearchFlag() {
		return SearchFlag;
	}

	public void setSearchFlag(boolean searchFlag) {
		SearchFlag = searchFlag;
	}



}
