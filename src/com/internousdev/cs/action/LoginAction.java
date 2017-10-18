package com.internousdev.cs.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cs.dao.LoginActionDAO;
import com.internousdev.cs.dto.LoginActionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String user_id = "";
	private String password;
	private int user_type = 0;
	public String message="";

	public Map<String,Object> session;

	public String execute(){
		String ret = ERROR;

		if(!(user_id.equals(""))){
			LoginActionDTO laDTO = new LoginActionDTO();
			LoginActionDAO laDAO = new LoginActionDAO();

			laDTO =laDAO.Login(user_type,user_id, password);
			session.put("now_user", laDTO.getUser_id());

			if(user_id.equals(laDTO.getUser_id()) && password.equals(laDTO.getPassword())){
				if(user_type == 0){
					ret = SUCCESS;
				}else{
					ret = "admin";
				}
			}
		}

		if(ret.equals(ERROR)){
			if(user_type == 1){
				message = "管理者";
			}
			message = message + "ログインエラー。";
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

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}



}
