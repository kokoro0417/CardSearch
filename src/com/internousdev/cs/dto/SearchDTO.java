package com.internousdev.cs.dto;

public class SearchDTO {

	private int card_id;
	private String cardname = "";
	private String color;
	private int mana;
	private String cardtype;
	private String ability;
	private String imgurl;
	private int price;
	private int card_stock;
	private boolean nameflag = false;


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
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
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
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public boolean isNameflag() {
		return nameflag;
	}
	public void setNameflag(boolean nameflag) {
		this.nameflag = nameflag;
	}





}
