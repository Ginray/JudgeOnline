package com.zjgsu.service;

import java.util.List;

import model.Problem;
import model.UserInfo;

public interface UserService {
	public String login(UserInfo userinfo);
	public String register(UserInfo userinfo);
	public void logout(UserInfo userinfo);
	public void modify(UserInfo userinfo);
	public List<UserInfo> getUser();

}
