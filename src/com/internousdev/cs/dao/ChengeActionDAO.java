package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.cs.dto.CardDataDTO;
import com.internousdev.cs.util.DBConnector;

public class ChengeActionDAO {

	public boolean ChengeData(CardDataDTO ChengeCard){
		boolean Chengeflag = false;
		//UPDATE テーブル名 SET カラム名 = 要素.... WHERE 検索条件；

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try{
			String sql ="UPDATE carddata SET cardname = ? , color = ? , mana = ? , cardtype = ? , imgurl = ? , price = ? , card_stock = ? WHERE cardname = ? ;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ChengeCard.getChenge_cardname());
			ps.setString(2, ChengeCard.getColor());
			ps.setInt(3, ChengeCard.getMana());
			ps.setString(4, ChengeCard.getCardtype());
			String tmp = "cardimg/"+ChengeCard.getChenge_cardname()+".png";
			ps.setString(5, tmp);
			ps.setInt(6, ChengeCard.getPrice());
			ps.setInt(7, ChengeCard.getCard_stock());
			ps.setString(8, ChengeCard.getCardname());

			ps.execute();
			System.out.println("Chenge");
			Chengeflag = true;

		}catch(SQLException e){
			e.printStackTrace();
		}


		return Chengeflag;
	}

}
