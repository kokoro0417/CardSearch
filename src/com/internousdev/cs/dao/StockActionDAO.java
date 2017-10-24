package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.cs.dto.CardDataDTO;
import com.internousdev.cs.util.DBConnector;

public class StockActionDAO {

	private String cardname;
	private int count;
	private int card_stock;

	CardDataDTO cdDTO = new CardDataDTO();

	public CardDataDTO Stock(String cardname, int card_stock){

		DBConnector db =new DBConnector();
		Connection con = db.getConnection();
		String sql = "";

		try{
			sql = "UPDATE carddata SET card_stock = ?  where cardname = ? ;";
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, card_stock);
			ps.setString(2, cardname);

			ps.execute();

			cdDTO.setCardname(cardname);
			System.out.println("UPDATE");

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
			System.out.println("close_saDAO");
		}catch(SQLException e){
			e.printStackTrace();
		}

		return cdDTO;
	}

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




}
