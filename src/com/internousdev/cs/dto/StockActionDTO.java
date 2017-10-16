package com.internousdev.cs.dto;

public class StockActionDTO {

	private String cardname;
	private int count;
	private int card_stock;
	private int nameflag = 0;


	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCard_stock() {
		return card_stock;
	}
	public void setCard_stock(int card_stock) {
		this.card_stock = card_stock;
	}
	public int getNameflag() {
		return nameflag;
	}
	public void setNameflag(int nameflag) {
		this.nameflag = nameflag;
	}




}
