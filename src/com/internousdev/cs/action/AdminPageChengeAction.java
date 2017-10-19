package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.SearchDAO;
import com.internousdev.cs.dto.SearchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminPageChengeAction extends ActionSupport implements SessionAware{

	private int chengeflag = 0;
	public ArrayList<SearchDTO> aryDTO = new ArrayList<SearchDTO>();
	public Map<String, Object> session;


	public String execute(){
		String ret = ERROR;

		switch(chengeflag){
		case 1:
			ret = "Add";
			break;
		case 2:
			ret = "Chenge";
			SearchDAO sDAO = new SearchDAO();
			aryDTO = sDAO.Search("", 0, "", 0);
			session.put("SearchResult", aryDTO);

			break;
		default:
			ret = "Home";
		}


		return ret;
	}

	public int getChengeflag() {
		return chengeflag;
	}

	public void setChengeflag(int chengeflag) {
		this.chengeflag = chengeflag;
	}

	public ArrayList<SearchDTO> getAryDTO() {
		return aryDTO;
	}

	public void setAryDTO(ArrayList<SearchDTO> aryDTO) {
		this.aryDTO = aryDTO;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}





}
