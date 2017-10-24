package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.cs.dto.CardDataDTO;
import com.internousdev.cs.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class InsertActionDAO extends ActionSupport{


	public String InsertCard(CardDataDTO InsertCardDTO){
		String ret = ERROR;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try{
			String sql = "INSERT INTO carddata VALUE(?,?,?,?,?,?,?);";
			System.out.println(sql);

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, InsertCardDTO.getChenge_cardname());
			ps.setString(2, InsertCardDTO.getColor());
			ps.setInt(3, InsertCardDTO.getMana());
			ps.setString(4, InsertCardDTO.getCardtype());
			String tmp = "cardimg/"+InsertCardDTO.getChenge_cardname()+".png";
			ps.setString(5, tmp);
			ps.setInt(6, InsertCardDTO.getPrice());
			ps.setInt(7, InsertCardDTO.getAdd_stock());

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
