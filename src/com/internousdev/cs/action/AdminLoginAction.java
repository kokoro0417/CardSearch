package com.internousdev.cs.action;

import com.internousdev.cs.dao.AdminLoginDAO;
import com.internousdev.cs.dto.AdminLoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport{

	private String user_id ="";
	private String password ="";
	private String message ="";

	public String execute(){
		String ret = ERROR;

		AdminLoginDAO aDAO = new AdminLoginDAO();
		AdminLoginDTO aDTO = aDAO.Login(user_id, password);

		if(aDTO.getUser_id().equals(user_id)){
			if(aDTO.getPassword().equals(password)){
				if(!(user_id.equals(""))){
					ret = SUCCESS;
				}
			}
		}

		if(ret.equals(ERROR)){
			message ="管理者ログインエラー";
		}


		return ret;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}
