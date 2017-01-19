package com.zjgsu.service;

import model.UserInfo;

public interface CategoryService {
	 public void save(UserInfo userinfo); //用来测试Hibernate环境  
	 public void update(UserInfo userinfo); //用来测试Spring和Hibernate整合后  
}
