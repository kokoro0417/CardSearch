package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dto.CardDataDTO;
import com.internousdev.cs.dto.SearchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MultiChengeAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	public ArrayList<SearchDTO> aryDTO = new ArrayList<SearchDTO>();

	private String cardname ="";
	private String chenge_cardname ="";
	private int mana = 0;
	private String color ="";
	private String cardtype = "";
	private int price = 0;
	private int card_stock = 0;
	private int chenge_type = 0;
	public String message="";

	@SuppressWarnings("unchecked")
	public String execute(){

		CardDataDTO carddataDTO = new CardDataDTO();
		carddataDTO.AllSet(cardname, chenge_cardname, mana, color, cardtype, price, card_stock);

		//----必須項目の確認----
		int datacheck[] = data_check(carddataDTO,chenge_type);
		carddataDTO.mesconp(datacheck);
		//--------

		String tmpmes = "";

		switch(chenge_type){
		case 1:
			tmpmes="変更";
			break;
		case 2:
			tmpmes="追加";
			break;
		case 3:
			tmpmes="削除";
			break;
		default:
			tmpmes="入荷";
			break;

		}
		System.out.println(chenge_type+tmpmes);
		System.out.println(carddataDTO.getMesList());


		aryDTO = (ArrayList<SearchDTO>)session.get("SearchResult");

		return SUCCESS;
	}

	private int[] data_check(CardDataDTO carddataDTO,int selecttype){
		int check[] = {0,0,0,0,0,0,0,0};

		//未入力項目の洗い出し
		if(carddataDTO.getCardname().equals("")){//カード名
			check[1] = 1;
			check[0]++;
		}
		if(carddataDTO.getChenge_cardname().equals("")){//変更名
			check[2] = 1;
			check[0]++;
		}
		if(carddataDTO.getMana() == 0){//マナ
			check[3] = 1;
			check[0]++;
		}
		if(carddataDTO.getColor().equals("")){//色
			check[4] = 1;
			check[0]++;
		}
		if(carddataDTO.getCardtype().equals("")){//カード種
			check[5] = 1;
			check[0]++;
		}
		if(carddataDTO.getPrice()==0){//金額
			check[6] = 1;
			check[0]++;
		}
		if(carddataDTO.getCard_stock()==0){//入荷数
			check[7] = 1;
			check[0]++;
		}

		switch(selecttype){//必須項目のフィルタ
		case 3:
			check[7] = 0;
		default:
		case 0:
			check[2] = 0;
			check[3] = 0;
			check[4] = 0;
			check[5] = 0;
			check[6] = 0;
		break;
		case 2:
			check[1] = 0;
			break;
		case 1:
			check[7] = 0;
			break;
		}

		return check;
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

	public String getChenge_cardname() {
		return chenge_cardname;
	}

	public void setChenge_cardname(String chenge_cardname) {
		this.chenge_cardname = chenge_cardname;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public int getChenge_type() {
		return chenge_type;
	}

	public void setChenge_type(int chenge_type) {
		this.chenge_type = chenge_type;
	}



}
