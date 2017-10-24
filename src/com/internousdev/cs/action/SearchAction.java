package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.SearchDAO;
import com.internousdev.cs.dto.CardDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware{

	private String cardname ="";
	private String color;
	private int mana =0;
	private String cardtype ="";
	private String Imgurl;
	public String message="";
	public int card_stock;
	public int SearchCheck = 1;
	public boolean Searchflag = false;

	public Map<String,Object> session;
	public ArrayList<CardDataDTO> aryDTO =new ArrayList<CardDataDTO>();

	SearchDAO sDAO = new SearchDAO();

	public String execute(){
		String ret = ERROR;

		aryDTO = sDAO.Search(cardname,mana,cardtype,SearchCheck);

		Iterator<CardDataDTO> itr = aryDTO.iterator();
		if(!(itr.hasNext())){
			message = "検索結果がありません";
		}else{
			message = "";

		}

		if(Searchflag){
			session.put("SearchResult", aryDTO);
		}

		ret = SUCCESS;

		return ret;
	}


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

	public String getImgurl() {
		return Imgurl;
	}


	public void setImgurl(String imgurl) {
		Imgurl = imgurl;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}


	public int getCard_stock() {
		return card_stock;
	}


	public void setCard_stock(int card_stock) {
		this.card_stock = card_stock;
	}


	public int getSearchCheck() {
		return SearchCheck;
	}


	public void setSearchCheck(int searchCheck) {
		SearchCheck = searchCheck;
	}


	public boolean isSearchflag() {
		return Searchflag;
	}


	public void setSearchflag(boolean searchflag) {
		Searchflag = searchflag;
	}




}
