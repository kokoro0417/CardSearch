package com.internousdev.cs.dto;

public class CardAddDTO {
	private String cardname = "";
	private String color = "";
	private int mana = 0;
	private String cardtype = "";
	private int price = 0;
	private int card_stock = 0;

	public void AllSet(String cardname,String color,int mana,String cardtype,int price,int card_stock){
		setCardname(cardname);
		setColor(color);
		setMana(mana);
		setCardtype(cardtype);
		setPrice(price);
		setCard_stock(card_stock);
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



}
