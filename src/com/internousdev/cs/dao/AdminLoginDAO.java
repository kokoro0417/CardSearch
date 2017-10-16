package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.cs.dto.AdminLoginDTO;
import com.internousdev.cs.util.DBConnector;

public class AdminLoginDAO {

	private int id =0;
	private String user_id ="";
	private String password ="";

	AdminLoginDTO aDTO = new AdminLoginDTO();

	public AdminLoginDTO Login(String user_id,String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try{
			String sql = "SELECT * FROM adminuser where user_id = ? and password = ? ;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				aDTO.setUser_id(rs.getString("user_id"));
				aDTO.setPassword(rs.getString("password"));
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return aDTO;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}





}
