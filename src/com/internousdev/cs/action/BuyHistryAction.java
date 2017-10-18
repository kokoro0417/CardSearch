package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.BuyItemHistryDAO;
import com.internousdev.cs.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyHistryAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	public boolean BuyHistryFlag = false;
	public ArrayList<BuyItemDTO> BuyHistry = new ArrayList<BuyItemDTO>();

	public String execute(){
		BuyItemHistryDAO bihDAO = new BuyItemHistryDAO();
		String user_id = (String)session.get("now_user");

		BuyHistry = bihDAO.SearchHistry(user_id);

		Iterator<BuyItemDTO> itr = BuyHistry.iterator();
		if(itr.hasNext()) {
			BuyHistryFlag = true;
		}

		return SUCCESS;
	}

	public void setSession(Map<String,Object> session){
		this.session =session;
	}

	public boolean isBuyHistryFlag() {
		return BuyHistryFlag;
	}

	public void setBuyHistryFlag(boolean buyHistryFlag) {
		BuyHistryFlag = buyHistryFlag;
	}



}
