package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.internousdev.cs.dto.BuyItemDTO;
import com.internousdev.cs.util.DBConnector;
import com.internousdev.cs.util.DateUtil;


public class BuyItemHistryDAO {
	private DateUtil dateUtil = new DateUtil();

	public void BuyHistry(String user_id, BuyItemDTO bDTO,Date date){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//String cardname,int buycount,int price,int total_price

		try{
			String sql = "INSERT INTO buy_card_data VALUE(?,?,?,?,?);";
			System.out.println(sql+bDTO.getCardname());

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, bDTO.getCardname());
			ps.setInt(3, bDTO.getTotal_price());
			ps.setInt(4, bDTO.getCount());
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

	public ArrayList<BuyItemDTO> SearchHistry(String user_id){
		ArrayList<BuyItemDTO> BuyHistry = new ArrayList<BuyItemDTO>();

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try{
			String sql = "SELECT * FROM buy_card_data WHERE user_id = ? ;";
			System.out.println(sql+user_id);

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				System.out.println("rsnext");
				BuyItemDTO tmpBIDTO = new BuyItemDTO();
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
