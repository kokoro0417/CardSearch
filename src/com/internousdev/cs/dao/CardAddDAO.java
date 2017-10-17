package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.cs.dto.CardAddDTO;
import com.internousdev.cs.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class CardAddDAO extends ActionSupport{


	public String AddCard(CardAddDTO caDTO){
		String ret = ERROR;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try{
			String sql = "INSERT INTO carddata VALUE(?,?,?,?,?,?,?);";
			System.out.println(sql);

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, caDTO.getCardname());
			ps.setString(2, caDTO.getColor());
			ps.setInt(3, caDTO.getMana());
			ps.setString(4, caDTO.getCardtype());
			String tmp = "cardimg/"+caDTO.getCardname()+".png";
			ps.setString(5, tmp);
			ps.setInt(6, caDTO.getPrice());
			ps.setInt(7, caDTO.getCard_stock());

			ps.execute();

			ret=SUCCESS;
			System.out.println("addcard");


		}catch(SQLException e){
			System.out.println("ca_e");
			e.printStackTrace();

		}

		try{
			con.close();
			System.out.println("caclose");
		}catch(SQLException e){
			e.printStackTrace();
		}

		return ret;
	}




}
