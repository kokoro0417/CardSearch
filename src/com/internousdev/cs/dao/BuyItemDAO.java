package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.cs.dto.CardDataDTO;
import com.internousdev.cs.util.DBConnector;

public class BuyItemDAO {

	private boolean sqlflag = false ;

	public CardDataDTO BuyAction(String cardname,int buycount){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		CardDataDTO BuyItemDTO = new CardDataDTO();

		String sql = "select * from carddata where cardname = ? ;";
		System.out.println(sql);

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cardname);


			ResultSet rs =ps.executeQuery();

			if(rs.next()){
				System.out.println("iftrue");

				BuyItemDTO.setCardname(rs.getString("cardname"));
				BuyItemDTO.setCart_count(buycount);
				BuyItemDTO.setCard_stock(rs.getInt("card_stock"));
				BuyItemDTO.setPrice(rs.getInt("price"));
				sqlflag = true;

				if(buycount > BuyItemDTO.getCard_stock()){
					BuyItemDTO.buyflag = false;
				}else{
					BuyItemDTO.buyflag = true;
				}

			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		if(sqlflag && BuyItemDTO.buyflag){
			sqlflag = false;
			int stock = BuyItemDTO.getCard_stock()-buycount;

			try{
				sql = "update carddata set card_stock = ?  where cardname = ?;";
				System.out.println(sql+cardname);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, stock);
				ps.setString(2, cardname);

				ps.execute();

				BuyItemDTO.setCard_stock(stock);
				System.out.println("stock_update");

			}catch(SQLException e){
				e.printStackTrace();
			}

		}

		try{
			con.close();
			System.out.println("close_biDAO");
		}catch(SQLException e){
			e.printStackTrace();
		}



		return BuyItemDTO;
	}




}
