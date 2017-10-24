package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.cs.dto.CardDataDTO;
import com.internousdev.cs.util.DBConnector;

public class SearchDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	//private SearchDTO sDTO = new SearchDTO();

	public ArrayList<CardDataDTO> Search(String cardname,int mana,String cardtype,int SearchCheck){

		ArrayList<CardDataDTO> aryDTO = new ArrayList<CardDataDTO>();

		PreparedStatement ps = null;
		String sql = "SELECT * FROM carddata";
		String tmp = "";
		int count = 0;



		if(!(cardname.equals(""))){
			switch(SearchCheck){
			case 2:
				tmp = (" cardname like '"+ cardname + "%'");
				break;
			case 3:
				tmp = (" cardname like '%"+ cardname + "%'");
				break;
			default :
				tmp = (" cardname = '"+ cardname + "'");
			}
			count++;
		}
		if(mana > 0 ){
			if(count>0){
				tmp = (tmp + " and");
			}
			tmp = (tmp + " mana = " + mana);
			count++;
		}
		if(!(cardtype.equals(""))){
			System.out.println(cardtype+"?");
			if(count>0){
				tmp = (tmp + " and");
			}
			tmp = (tmp + " cardtype = '" + cardtype + "'");
			count++;
		}

		try{
			if(count>0){
				sql = sql+" where "+tmp;
			}

			System.out.println(sql);

			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CardDataDTO cdDTO = new CardDataDTO();
				cdDTO.SearchSet(rs.getString("cardname"), rs.getInt("mana"), rs.getString("color"),rs.getString("cardtype"), rs.getString("imgurl"), rs.getInt("price"), rs.getInt("card_stock"));
				aryDTO.add(cdDTO);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
			System.out.println("close_sDAO");
		}catch(SQLException e){
			e.printStackTrace();
		}

		return aryDTO;
	}

}
