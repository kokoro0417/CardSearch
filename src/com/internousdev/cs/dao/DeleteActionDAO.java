package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.cs.dto.CardDataDTO;
import com.internousdev.cs.util.DBConnector;

public class DeleteActionDAO {

	public boolean Delete(CardDataDTO DelCard){
		boolean Delflag = false;
		//DELETE FROM テーブル名 WHERE 検索条件：検索条件に一致するものを削除

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try{
			String sql ="DELETE FROM carddata WHERE cardname = ? ;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, DelCard.getCardname());

			ps.execute();
			System.out.println("DELETE");
			Delflag = true;

		}catch(SQLException e){
			e.printStackTrace();
		}


		return Delflag;
	}

}
