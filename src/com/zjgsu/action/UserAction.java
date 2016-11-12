package com.zjgsu.action;

import model.UserInfo;

import com.opensymphony.xwork2.ActionSupport;
import com.zjgsu.service.UserService;

public class UserAction extends ActionSupport{
	
	private UserInfo userinfo;
	private UserService userservice;
	
	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public String userlogin(){
		try{
			if(userservice.login(userinfo).equals("success") )
				return "success";
			else
				return "fail";
		}catch( Exception e){
			return "fail";
		}
	}
	
	public String userregister(){
		try{
			if(userservice.register(userinfo).equals("success") )
				return "success";
			else
				return "fail";
		}catch( Exception e){
			return "fail";
		}
	}
}
