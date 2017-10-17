package com.internousdev.cs.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.CardAddDAO;
import com.internousdev.cs.dto.CardAddDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CAddDoneAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	public String message="";

	public String execute(){
		String ret= ERROR;

		CardAddDTO caDTO = (CardAddDTO)session.get("addcard");
		CardAddDAO caDAO =new CardAddDAO();

		ret=caDAO.AddCard(caDTO);

		if(ret.equals(SUCCESS)){
			message="カードが正常に追加されました。";
		}else{
			message="カードが正常に追加されませんでした。";
		}

		return ret;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
