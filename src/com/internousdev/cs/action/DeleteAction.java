package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.DeleteActionDAO;
import com.internousdev.cs.dao.SearchDAO;
import com.internousdev.cs.dto.CardDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport implements SessionAware{

	public String message="";
	private boolean SearchFlag = false;
	public ArrayList<CardDataDTO> aryDTO =new ArrayList<CardDataDTO>();
	public Map<String,Object> session;

	public String Delete(){
		String ret = ERROR;
		boolean DelCheck = false;

		DeleteActionDAO daDAO = new DeleteActionDAO();
		CardDataDTO DeleteCardData = (CardDataDTO)session.get("SearchCardData");

		if(DeleteCardData != null){
			DelCheck =daDAO.Delete(DeleteCardData);
		}
		if(DelCheck){
			message = "商品削除しました。";
		ret = SUCCESS;
		}else{
			message = "商品削除エラーが発生しました。";
		}

		SearchDAO sDAO = new SearchDAO();
		aryDTO = sDAO.Search("", 0, "", 0);

		return ret;
	}


	@SuppressWarnings("unchecked")
	public String DeleteCansell(){
		message = "商品追加をキャンセルしました。";
		aryDTO = (ArrayList<CardDataDTO>)session.get("SearchResult");
		return SUCCESS;
	}


	public boolean isSearchFlag() {
		return SearchFlag;
	}


	public void setSearchFlag(boolean searchFlag) {
		SearchFlag = searchFlag;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
