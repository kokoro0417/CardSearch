package com.internousdev.cs.dto;


public class BuyItemDTO {

	private String cardname;
	private int price;
	private int count;
	private int card_stock;
	private int total_price;
	private int total_count;
	private String Datetime;

	public boolean buyflag = false;

	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public boolean isBuyflag() {
		return buyflag;
	}
	public void setBuyflag(boolean buyflag) {
		this.buyflag = buyflag;
	}
	public String getDatetime() {
		return Datetime;
	}
	public void setDatetime(String datetime) {
		Datetime = datetime;
	}




}
