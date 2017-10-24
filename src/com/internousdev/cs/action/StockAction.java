package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.StockActionDAO;
import com.internousdev.cs.dto.CardDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class StockAction extends ActionSupport implements SessionAware{

	public int card_stock=0;
	public String message="";
	public Map<String,Object> session;
	//public CardDataDTO StockCardData;
	private boolean SearchFlag = false;
	public ArrayList<CardDataDTO> aryDTO =new ArrayList<CardDataDTO>();

	@SuppressWarnings("unchecked")
	public String StockIn(){
		String ret= ERROR;
		CardDataDTO StockCardData = (CardDataDTO)session.get("ChengeData");
		CardDataDTO SearchCardData = (CardDataDTO)session.get("SearchCardData");
		boolean addflag = false;

		if(!(StockCardData == null)){
			if(StockCardData.getAdd_stock() > 0){
				addflag = true;

				if(StockCardData.getCardname().equals(SearchCardData.getCardname())){
					StockActionDAO saDAO = new StockActionDAO();
					card_stock = StockCardData.getAdd_stock() + SearchCardData.getCard_stock();
					StockCardData = saDAO.Stock(StockCardData.getCardname(), card_stock);
					StockCardData.setNameflag(true);

					//aryDTO.set(0, StockCardData);

					ret= SUCCESS;
				}
			}
		}

		if(ret.equals(SUCCESS)){
			message = "在庫追加完了しました。";
		}else{
			if(StockCardData.isNameflag()){
				message = "在庫追加エラーが発生しました。";
			}else{
				message = "カード名が見つかりませんでした。";
			}

		}
		if(!(addflag)){
			message = "入庫数が0以下です。";
		}

		aryDTO = (ArrayList<CardDataDTO>)session.get("SearchResult");

		return ret;
	}

	@SuppressWarnings("unchecked")
	public String StockCansell(){
		message = "在庫追加をキャンセルしました。";
		aryDTO = (ArrayList<CardDataDTO>)session.get("SearchResult");
		return SUCCESS;
	}


	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public boolean isSearchFlag() {
		return SearchFlag;
	}

	public void setSearchFlag(boolean searchFlag) {
		SearchFlag = searchFlag;
	}

/*	public CardDataDTO getStockCardData() {
		return StockCardData;
	}

	public void setStockCardData(CardDataDTO stockCardData) {
		StockCardData = stockCardData;
	}*/



}
