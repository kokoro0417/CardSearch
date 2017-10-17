package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.cs.dto.LoginActionDTO;
import com.internousdev.cs.util.DBConnector;

public class LoginActionDAO {

	public LoginActionDTO Login(int table,String user_id,String password){
		LoginActionDTO laDTO = new LoginActionDTO();

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM ";

		if(table == 0){
			sql = sql + "user_data WHERE user_id = ? AND password = ? ;";
		}else{
			sql = sql + "adminuser WHERE user_id = ? AND password = ? ;";
		}

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				laDTO.setUser_id(rs.getString("user_id"));
				laDTO.setPassword(rs.getString("password"));
				laDTO.setLoginflag(true);
			}


		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}


		return laDTO;
	}

}
