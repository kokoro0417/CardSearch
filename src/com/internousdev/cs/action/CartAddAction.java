package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dto.BuyItemDTO;
import com.internousdev.cs.dto.SearchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAddAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	public ArrayList<BuyItemDTO> CartArry = new ArrayList<BuyItemDTO>();
	public ArrayList<SearchDTO> aryDTO =new ArrayList<SearchDTO>();

	@SuppressWarnings("unchecked")
	public String execute(){
		
		aryDTO = (ArrayList<SearchDTO>)session.get("SearchResult");

		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
