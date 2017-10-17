package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.SearchDAO;
import com.internousdev.cs.dto.CardAddDTO;
import com.internousdev.cs.dto.SearchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CardAddAction extends ActionSupport implements SessionAware{

	private String cardname = "";
	private String color = "";
	private int mana = 0;
	private String cardtype = "";
	private int price = 0;
	private int card_stock = 0;
	public String message="";

	public Map<String,Object> session;

	public String execute(){
		int addcheck[] = add_check();

		String ret= ERROR;

		SearchDAO sDAO = new SearchDAO();

		if(addcheck[0]==0){
			ArrayList<SearchDTO> aryDTO = sDAO.Search(cardname, 0, "", 0);
			if(aryDTO.isEmpty()){
				message="追加カードの確認。よろしければOKボタンを押してください。";
				CardAddDTO caDTO = new CardAddDTO();
				caDTO.AllSet(cardname, color, mana, cardtype, price, card_stock);

				session.put("addcard", caDTO);

				ret= SUCCESS;
			}else{
				message="同名カードが既に登録されています。";
			}

		}else{
			message = message + "の入力がありません";
		}



		return ret;
	}

	private int[] add_check(){
		int check[] = {0,0,0,0,0,0};

		if(cardname.equals("")){
			check[1] = 1;
			check[0]++;
			message="カード名：";
		}
		if(color.equals("")){
			check[2] = 1;
			check[0]++;
			message=message+"色：";
		}
		if(mana==0){
			check[3] = 1;
			check[0]++;
			message=message+"マナ：";
		}
		if(cardtype.equals("")){
			check[4] = 1;
			check[0]++;
			message=message+"カードタイプ：";
		}
		if(price==0){
			check[5] = 1;
			check[0]++;
			message=message+"金額";
		}

		return check;
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
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
