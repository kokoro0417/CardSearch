package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.ChengeActionDAO;
import com.internousdev.cs.dao.SearchDAO;
import com.internousdev.cs.dto.CardDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ChengeAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	public ArrayList<CardDataDTO> aryDTO = new ArrayList<CardDataDTO>();
	public String message="";

	public String Chenge(){
		String ret = ERROR;
		boolean ChengeFlag = false;
		CardDataDTO ChengeCard = (CardDataDTO)session.get("ChengeData");
		CardDataDTO SearchCardData = (CardDataDTO)session.get("SearchCardData");

		if(ChengeCard.getChenge_cardname().equals("")){
			ChengeCard.setChenge_cardname(SearchCardData.getCardname());
		}
		if(ChengeCard.getColor().equals("")){
			ChengeCard.setColor(SearchCardData.getColor());
		}
		if(ChengeCard.getMana() == 0){
			ChengeCard.setMana(SearchCardData.getMana());
		}
		if(ChengeCard.getCardtype().equals("")){
			ChengeCard.setCardtype(SearchCardData.getCardtype());
		}
		if(ChengeCard.getPrice() == 0){
			ChengeCard.setPrice(SearchCardData.getPrice());
		}
		if(ChengeCard.getAdd_stock() == 0){
			ChengeCard.setCard_stock(SearchCardData.getCard_stock());
		}else{
			ChengeCard.setCard_stock(SearchCardData.getCard_stock()+ChengeCard.getAdd_stock());
		}

		ChengeActionDAO caDAO = new ChengeActionDAO();
		ChengeFlag = caDAO.ChengeData(ChengeCard);

		if(ChengeFlag){
			ret = SUCCESS;
			message = "情報変更を完了しました。";
		}else{
			message = "情報変更エラーが発生しました。";
		}


		SearchDAO sDAO = new SearchDAO();
		aryDTO = sDAO.Search("", 0, "", 0);


		return ret;
	}

	@SuppressWarnings("unchecked")
	public String ChengeCansell(){
		message = "情報変更をキャンセルしました。";
		aryDTO = (ArrayList<CardDataDTO>)session.get("SearchResult");
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}




}
