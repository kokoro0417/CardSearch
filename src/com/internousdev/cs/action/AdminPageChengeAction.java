package com.internousdev.cs.action;

import com.opensymphony.xwork2.ActionSupport;

public class AdminPageChengeAction extends ActionSupport{

	private int chengeflag = 0;

	public String execute(){
		String ret = ERROR;

		switch(chengeflag){
		case 1:
			ret = "Add";
			break;
		case 2:
			ret = "Chenge";
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



}
