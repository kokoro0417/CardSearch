package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.internousdev.cs.dto.CardDataDTO;
import com.internousdev.cs.util.DBConnector;
import com.internousdev.cs.util.DateUtil;


public class BuyItemHistryDAO {
	private DateUtil dateUtil = new DateUtil();

	public void BuyHistry(String user_id, CardDataDTO BuyItemDTO,Date date){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//String cardname,int buycount,int price,int total_price

		try{
			String sql = "INSERT INTO buy_card_data VALUE(?,?,?,?,?);";
			System.out.println(sql+BuyItemDTO.getCardname());

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, BuyItemDTO.getCardname());
			ps.setInt(3, BuyItemDTO.getTotal_price());
			ps.setInt(4, BuyItemDTO.getCart_count());
			ps.setString(5, dateUtil.getDate());

			ps.execute();
			System.out.println("INSERT INTO histry");

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

	public ArrayList<CardDataDTO> SearchHistry(String user_id){
		ArrayList<CardDataDTO> BuyHistry = new ArrayList<CardDataDTO>();

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try{
			String sql = "SELECT * FROM buy_card_data WHERE user_id = ? ;";
			System.out.println(sql+user_id);

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CardDataDTO tmpBIDTO = new CardDataDTO();
				tmpBIDTO.setCardname(rs.getString("cardname"));
				tmpBIDTO.setTotal_count(rs.getInt("total_count"));
				tmpBIDTO.setTotal_price(rs.getInt("total_price"));
				tmpBIDTO.setDatetime(rs.getString("datetime"));
				BuyHistry.add(tmpBIDTO);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}


		return BuyHistry;
	}

}
