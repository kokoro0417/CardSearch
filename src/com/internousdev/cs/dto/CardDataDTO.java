package com.internousdev.cs.dto;

public class CardDataDTO {
	private String cardname ="";
	private String chenge_cardname ="";
	private int mana = 0;
	private String color ="";
	private String cardtype = "";
	private int price = 0;
	private int card_stock = 0;
	private String[] mesList = {"","カード名：","変更名：","マナ：","色：","カード種：","金額：","入荷数"};

	public void AllSet(String cardname,String chenge_cardname,int mana,String color,String cardtype,int price,int card_stock){
		setCardname(cardname);
		setChenge_cardname(chenge_cardname);
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


	public String getMesList() {
		return mesList[0];
	}


	public void setMesList(int index,String mes) {
		if(index >= 0 && index < 8){
			this.mesList[index] = mes;
		}
	}

	public String mesconp(int[] list){
		for(int i=1; i<8;i++){
			if(list[i]>0){
				mesList[0]=mesList[0]+mesList[i];
			}
		}
		return mesList[0];
	}



}
