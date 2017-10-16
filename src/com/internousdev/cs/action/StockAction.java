package com.internousdev.cs.action;

import java.util.ArrayList;
import java.util.Iterator;

import com.internousdev.cs.dao.SearchDAO;
import com.internousdev.cs.dao.StockActionDAO;
import com.internousdev.cs.dto.SearchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class StockAction extends ActionSupport{

	private String cardname;
	private int add_stock;
	private int card_stock;
	public String message="";
	public ArrayList<SearchDTO> aryDTO =new ArrayList<SearchDTO>();


	public String execute(){
		String ret= ERROR;
		String tmpname ="";

		SearchDAO sDAO = new SearchDAO();
		SearchDTO sDTO = new SearchDTO();
		SearchDTO sDTO2 = new SearchDTO();
		aryDTO = sDAO.Search(cardname, 0, "",1);

		Iterator<SearchDTO> itr = aryDTO.iterator();
		if(itr.hasNext()){
			sDTO = aryDTO.get(0);
			tmpname = sDTO.getCardname();
		}

		if(!(cardname.equals(null))){
			if(cardname.equals(tmpname)){
				StockActionDAO saDAO = new StockActionDAO();
				card_stock = add_stock + sDTO.getCard_stock();
				sDTO2 = saDAO.Stock(cardname, card_stock);
				sDTO2.setNameflag(true);

				aryDTO.set(0, sDTO2);

				ret= SUCCESS;
			}
		}

		if(ret.equals(SUCCESS)){
			message = "追加完了です";
		}else{
			if(sDTO2.isNameflag()){
				message = "在庫追加エラーが発生しました。";
			}else{
				message = "カード名が見つかりませんでした。";
			}

		}

		return ret;
	}


	public String getCardname() {
		return cardname;
	}


	public void setCardname(String cardname) {
		this.cardname = cardname;
	}


	public int getAdd_stock() {
		return add_stock;
	}


	public void setAdd_stock(int add_stock) {
		this.add_stock = add_stock;
	}


	public int getCard_stock() {
		return card_stock;
	}


	public void setCard_stock(int card_stock) {
		this.card_stock = card_stock;
	}



}
