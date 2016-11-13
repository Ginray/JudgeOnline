package com.zjgsu.service;

import model.UserInfo;

public interface UserService {
	public String login(UserInfo userinfo);
	public String register(UserInfo userinfo);
	public void logout(UserInfo userinfo);
	public void modify(UserInfo userinfo);
}
