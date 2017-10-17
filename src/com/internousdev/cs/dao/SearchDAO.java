package com.internousdev.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.cs.dto.SearchDTO;
import com.internousdev.cs.util.DBConnector;

public class SearchDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	//private SearchDTO sDTO = new SearchDTO();
	ArrayList<SearchDTO> aryDTO = new ArrayList<SearchDTO>();


	public ArrayList<SearchDTO> Search(String cardname,int mana,String cardtype,int SearchCheck){

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
				SearchDTO sDTO = new SearchDTO();
				sDTO.setCardname(rs.getString("cardname"));
				sDTO.setMana(rs.getInt("mana"));
				sDTO.setCardtype(rs.getString("cardtype"));
				sDTO.setImgurl(rs.getString("imgurl"));
				sDTO.setPrice(rs.getInt("price"));
				sDTO.setCard_stock(rs.getInt("card_stock"));
				aryDTO.add(sDTO);
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
