package com.zjgsu.action;


import model.UserInfo;

import com.opensymphony.xwork2.ActionSupport;
import com.zjgsu.service.CategoryService;


public class TestAction extends ActionSupport {  
		private UserInfo category;//设置一个私有成员变量接收url带过来的参数，注意下面要写好get和set方法  
     
	    private CategoryService categoryService;  
	      
	    public void setCategoryService(CategoryService categoryService) {  
	        this.categoryService = categoryService;  
	    }  
	      
	    public String update() {  
	        System.out.println("----update----");  
	        System.out.println(categoryService);//由于已经和Spring整合，所以可以拿到这个categoryService了，打印出来就不是null了  
	        categoryService.update(category); //新加一条语句，来更新数据库  
	        return "index";  
	    }  
	      
	    public String save() {  
	        System.out.println("----save----");  
	        System.out.println(categoryService);  
	        return "index";  
	    }  
	  
	    public UserInfo getCategory() {  
	        return category;  
	    }  
	  
	    public void setCategory(UserInfo category) {  
	        this.category = category;  
	    }  
    
}
