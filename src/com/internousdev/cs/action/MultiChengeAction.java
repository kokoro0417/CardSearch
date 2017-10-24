package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.SearchDAO;
import com.internousdev.cs.dto.CardDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MultiChengeAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	public ArrayList<CardDataDTO> aryDTO = new ArrayList<CardDataDTO>();

	private String cardname ="";
	private String chenge_cardname ="";
	private int mana = 0;
	private String color ="";
	private String cardtype = "";
	private int price = 0;
	private int add_stock = 0;
	private int chenge_type = 0;
	public String message="";
	public boolean NameFlag = false;
	private boolean SearchFlag = false;
	private boolean ChengeFlag = false;

	@SuppressWarnings("unchecked")
	public String execute(){

		CardDataDTO ChengeDataDTO = new CardDataDTO();
		CardDataDTO SearchCardDataDTO = new CardDataDTO();
		ChengeDataDTO.ChengeSet(cardname, chenge_cardname, mana, color, cardtype, price, add_stock);

		SearchDAO sDAO = new SearchDAO();
		ArrayList<CardDataDTO> aryDTO = new ArrayList<CardDataDTO>();
		aryDTO = sDAO.Search(cardname, 0, "", 0);

		if(!(aryDTO.isEmpty())){
			SearchCardDataDTO = aryDTO.get(0);
			SearchFlag = true;
		}

		if(!(chenge_cardname.isEmpty())){
			aryDTO = sDAO.Search(chenge_cardname, 0, "", 0);

			if(aryDTO.isEmpty()){
				ChengeFlag = true;
			}
		}

		//----必須項目の確認----
/*		int datacheck[] = data_check(ChengeDataDTO,chenge_type);
		ChengeDataDTO.mesconp(datacheck);*/
		//--------

		String ret = ERROR;

		String tmpmes = "";

		switch(chenge_type){
		case 1:
			tmpmes="変更";
			ret = "chenge";
			if(cardname.equals("")){
				message = "カード名が未入力です。<br>";
				SearchFlag = false;
			}
			if(chenge_cardname.isEmpty()){
				chenge_cardname = cardname;
			}
			break;
		case 2:
			tmpmes="追加";
			ret = "ins";
			if(chenge_cardname.equals("")){
				message ="追加カード名が未入力です。<br>";
				//ChengeFlag = false;
			}else if(!(ChengeFlag)){
				message = "同名カードが既に登録されています。<br>";
			}
			break;
		case 3:
			tmpmes="削除";
			ret = "del";
			if(cardname.equals("") ){
				message = "カード名が未入力です。<br>";
				SearchFlag = false;
			}
			break;
		default:
			tmpmes="入荷";
			ret = "stock";
			if(cardname.equals("") ){
				message = "カード名が未入力です。<br>";
				SearchFlag = false;
			}
			if(add_stock == 0){
				message = message + "入荷数が未入力です。<br>";
				SearchFlag = false;
			}
			break;

		}

		if(message.length()>0){
			message = message + "キャンセルを押してください。";
		}
		System.out.println(chenge_type+tmpmes);

		session.put("ChengeData", ChengeDataDTO);
		session.put("SearchCardData", SearchCardDataDTO);
		aryDTO = (ArrayList<CardDataDTO>)session.get("SearchResult");

		return ret;
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

	public int getAdd_stock() {
		return add_stock;
	}

	public void setAdd_stock(int add_stock) {
		this.add_stock = add_stock;
	}

	public int getChenge_type() {
		return chenge_type;
	}

	public void setChenge_type(int chenge_type) {
		this.chenge_type = chenge_type;
	}

	public boolean isSearchFlag() {
		return SearchFlag;
	}

	public void setSearchFlag(boolean searchFlag) {
		SearchFlag = searchFlag;
	}

	public boolean isChengeFlag() {
		return ChengeFlag;
	}

	public void setChengeFlag(boolean chengeFlag) {
		ChengeFlag = chengeFlag;
	}



}
