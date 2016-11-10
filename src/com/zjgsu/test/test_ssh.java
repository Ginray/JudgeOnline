package com.zjgsu.test;
import java.util.Date;

import javax.annotation.Resource;

import model.UserInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zjgsu.service.CategoryService;
import com.zjgsu.service.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")  

public class test_ssh {
	@Resource
	private Date date;
    
    @Resource  
    private CategoryService categoryService;  
    
  
    @Test //测试Spring IOC的开发环境  
    public void springIoc() {  
        System.out.println(date);  
    } 
    
    
    //注意：数据库的名字中包含'-'会报错
    @Test  //测试Hibernate的开发环境，因为没有整合，可以直接new  
    public void hihernate() {  
        CategoryService categoryService = new CategoryServiceImpl();  
        UserInfo userinfo = new UserInfo("t","t","t","t"); 
        categoryService.save(userinfo);  
    } 
    
    //注意：在修改的时候一定要有主键
    @Test //测试Hibernate和Spring整合后  
    public void hibernateAndSpring() {  
        categoryService.update(new UserInfo(4,"e","e","e","e")); //categoryService通过Spring从上面注入进来的  
    }  
    
}
