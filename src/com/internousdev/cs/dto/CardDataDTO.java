package com.internousdev.cs.dto;

public class CardDataDTO {
	private String cardname ="";//カード名
	private String chenge_cardname ="";//カード変更名
	private int mana = 0;//マナ
	private String color ="";//色
	private String cardtype = "";//カードタイプ
	private int price = 0;//金額
	private int card_stock = 0;//在庫数
	private int add_stock = 0;//入荷数
	private String imgurl;//画像URL
	private int cart_count = 0;//カート内スタック個数
	private int total_count = 0;//合計購入個数
	private int total_price = 0;//合計金額
	private String Datetime;//購入日時
	public boolean buyflag = false;//カートアクション用フラグ
	public boolean nameflag = false;//カード名チェック用フラグ
	private String[] mesList = {"","カード名：","変更名：","マナ：","色：","カード種：","金額：","入荷数"};

	public void SearchSet(String cardname,int mana,String color,String cardtype,String imgurl,int price,int card_stock){
		setCardname(cardname);
		setMana(mana);
		setColor(color);
		setCardtype(cardtype);
		setImgurl(imgurl);
		setPrice(price);
		setCard_stock(card_stock);
	}

	public void ChengeSet(String cardname,String chenge_cardname,int mana,String color,String cardtype,int price,int add_stock){
		setCardname(cardname);
		setChenge_cardname(chenge_cardname);
		setColor(color);
		setMana(mana);
		setCardtype(cardtype);
		setPrice(price);
		setAdd_stock(add_stock);
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

	public int getAdd_stock() {
		return add_stock;
	}


	public void setAdd_stock(int add_stock) {
		this.add_stock = add_stock;
	}


	public String getImgurl() {
		return imgurl;
	}


	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}


	public int getCart_count() {
		return cart_count;
	}


	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}


	public int getTotal_price() {
		return total_price;
	}


	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}


	public String getDatetime() {
		return Datetime;
	}


	public void setDatetime(String datetime) {
		Datetime = datetime;
	}


	public boolean isBuyflag() {
		return buyflag;
	}


	public void setBuyflag(boolean buyflag) {
		this.buyflag = buyflag;
	}


	public boolean isNameflag() {
		return nameflag;
	}

	public void setNameflag(boolean nameflag) {
		this.nameflag = nameflag;
	}

	public void setMesList(String[] mesList) {
		this.mesList = mesList;
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

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}



}
