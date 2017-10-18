package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.cs.dto.BuyItemDTO;
import com.internousdev.cs.util.DBConnector;

public class BuyItemDAO {

	private boolean sqlflag = false ;

	public BuyItemDTO BuyAction(String cardname,int buycount){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		BuyItemDTO bDTO = new BuyItemDTO();

		String sql = "select * from carddata where cardname = ? ;";
		System.out.println(sql);

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cardname);


			ResultSet rs =ps.executeQuery();

			if(rs.next()){
				System.out.println("iftrue");

				bDTO.setCardname(rs.getString("cardname"));
				bDTO.setCount(buycount);
				bDTO.setCard_stock(rs.getInt("card_stock"));
				bDTO.setPrice(rs.getInt("price"));
				sqlflag = true;

				if(buycount > bDTO.getCard_stock()){
					bDTO.buyflag = false;
				}else{
					bDTO.buyflag = true;
				}

			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		if(sqlflag && bDTO.buyflag){
			sqlflag = false;
			int stock = bDTO.getCard_stock()-buycount;

			try{
				sql = "update carddata set card_stock = ?  where cardname = ?;";
				System.out.println(sql+cardname);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, stock);
				ps.setString(2, cardname);

				ps.execute();

				bDTO.setCard_stock(stock);
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



		return bDTO;
	}




}
