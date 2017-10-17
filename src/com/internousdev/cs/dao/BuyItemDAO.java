package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.cs.dto.BuyItemDTO;
import com.internousdev.cs.util.DBConnector;

public class BuyItemDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private BuyItemDTO bDTO = new BuyItemDTO();
	private boolean sqlflag = false ;

	public BuyItemDTO BuyAction(String cardname,int buycount){

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
				System.out.println(sql);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, stock);
				ps.setString(2, cardname);

				boolean scesflag = ps.execute();

				if(scesflag){
					bDTO.setCard_stock(stock);
				}

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
