package com.internousdev.cs.action;

import com.internousdev.cs.util.SQLSupport;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	private String Table="";
	private int ElCount=1;
	private String InsCol1="";
	private String InsCol2="";
	private String InsCol3="";

	public String execute(){
		String[] InsCol = {"","",""};

		if(!(InsCol1.isEmpty())){
			InsCol[0]=InsCol1;
		}
		if(!(InsCol2.isEmpty())){
			InsCol[1]=InsCol2;
		}
		if(!(InsCol3.isEmpty())){
			InsCol[2]=InsCol3;

		}

		//InsCol[0] = InsCol[1]+ InsCol[2] + InsCol[3];

		SQLSupport sqls = new SQLSupport();
		String sql =sqls.InsertAllColumn(Table, ElCount);
		System.out.println(sql);
		sql =sqls.Insert(Table, InsCol[0]);
		System.out.println(sql);
		sql =sqls.Insert(Table, InsCol, ElCount);
		System.out.println(sql);

		return SUCCESS;
	}

	public String getTable() {
		return Table;
	}

	public void setTable(String table) {
		Table = table;
	}

	public int getElCount() {
		return ElCount;
	}

	public void setElCount(int elCount) {
		ElCount = elCount;
	}

	public String getInsCol1() {
		return InsCol1;
	}

	public void setInsCol1(String insCol1) {
		InsCol1 = insCol1;
	}

	public String getInsCol2() {
		return InsCol2;
	}

	public void setInsCol2(String insCol2) {
		InsCol2 = insCol2;
	}

	public String getInsCol3() {
		return InsCol3;
	}

	public void setInsCol3(String insCol3) {
		InsCol3 = insCol3;
	}

}
