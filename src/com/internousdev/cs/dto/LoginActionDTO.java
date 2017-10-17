package com.internousdev.cs.dto;

public class LoginActionDTO {
	private String user_id;
	private String password;
	private boolean loginflag = false;


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
	public boolean isLoginflag() {
		return loginflag;
	}
	public void setLoginflag(boolean loginflag) {
		this.loginflag = loginflag;
	}





}
