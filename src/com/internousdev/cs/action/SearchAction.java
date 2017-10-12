package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.internousdev.cs.dao.SearchDAO;
import com.internousdev.cs.dto.SearchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{

	private String cardname;
	private String color;
	private int mana;
	private String cardtype;
	private String ability;
	private String Imgurl;
	public String message="";

	public Map<String,Object> sMAP = new HashMap<>();
	public ArrayList<SearchDTO> aryDTO =new ArrayList<SearchDTO>();

	SearchDTO sDTO = new SearchDTO();
	SearchDAO sDAO = new SearchDAO();



	public String execute(){
		String ret = ERROR;

		aryDTO = sDAO.Search(cardname,mana,cardtype);

		Iterator<SearchDTO> itr = aryDTO.iterator();
		if(!(itr.hasNext())){
			message = "検索結果がありません";
		}else{
			message = "";
		}


		System.out.println(cardname);
		System.out.println(mana);
		System.out.println(cardtype);

		System.out.println(sDTO.getCardname());
		System.out.println(sDTO.getMana());
		System.out.println(sDTO.getImgurl());

		sMAP.put("cardname", sDTO.getCardname());
		sMAP.put("mana", sDTO.getMana());
		sMAP.put("cardtype", sDTO.getCardtype());
		sMAP.put("imgurl", sDTO.getImgurl());

		ret = SUCCESS;

		return ret;
	}


	public String getCardname() {
		return cardname;
	}


	public void setCardname(String cardname) {
		this.cardname = cardname;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getMana() {
		return mana;
	}


	public void setMana(int mana) {
		this.mana = mana;
	}


	public String getCardtype() {
		return cardtype;
	}


	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}


	public String getAbility() {
		return ability;
	}


	public void setAbility(String ability) {
		this.ability = ability;
	}


	public String getImgurl() {
		return Imgurl;
	}


	public void setImgurl(String imgurl) {
		Imgurl = imgurl;
	}




}
