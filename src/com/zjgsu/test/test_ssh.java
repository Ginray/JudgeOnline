package com.zjgsu.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import model.Submitstate;
import model.UserInfo;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zjgsu.oj.OutResult;
import com.zjgsu.service.CategoryService;
import com.zjgsu.service.CategoryServiceImpl;
import com.zjgsu.service.ProblemService;
import com.zjgsu.service.ProblemServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")  

public class test_ssh {
	@Resource
	private Date date;
    
    @Resource  
    private CategoryService categoryService;  
    
    
    //@Test //测试Spring IOC的开发环境  
    public void springIoc() {  
        System.out.println(date);  
    } 
    
    
    //注意：数据库的名字中包含'-'会报错
    // @Test  //测试Hibernate的开发环境，因为没有整合，可以直接new  
    public void hihernate() {  
        CategoryService categoryService = new CategoryServiceImpl();  
        UserInfo userinfo = new UserInfo("t","t","t","t",1,1); 
        categoryService.save(userinfo);  
    } 
    
    //注意：在修改的时候一定要有主键
    //@Test //测试Hibernate和Spring整合后  
    public void hibernateAndSpring() {  
        categoryService.update(new UserInfo("e","e","e","e",1,1)); //categoryService通过Spring从上面注入进来的  
    }  
    
    @Test
    public void testSubmit(){
		Submitstate submitstate = new Submitstate();
		submitstate.setUserId(100);
		submitstate.setProblemId(1);
		submitstate.setCodeLength(1);
		submitstate.setCodeType("Java");
		submitstate.setId(100);
		submitstate.setMemory("12345");
		submitstate.setRuntime("12345");
		submitstate.setState("AC");
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse("2016-11-24 21:34:11");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		submitstate.setSubmitDate(date);
	
		ProblemService problemservice = new ProblemServiceImpl();
		problemservice.saveState(submitstate);
    }
    
    @Test
    public void saveState(){
		Submitstate submitstate = new Submitstate();
		submitstate.setUserId(100);
		submitstate.setProblemId(22222);
		submitstate.setId(100);

	
		
		
		OutResult result = new OutResult();
		result.setMemory(123);
		result.setState("AC");
		result.setTime(100000);
		String code = "Submit Code";
		System.out.println(result.targetId + " id");
		
		submitstate.setId(100);
		submitstate.setState(result.getState());
		submitstate.setCodeType("java");
		submitstate.setMemory(String.valueOf(result.getMemory()));
		submitstate.setRuntime(String.valueOf(result.getTime()));
		submitstate.setSubmitDate(new Date());
		submitstate.setCodeLength(Integer.parseInt(String.valueOf(code.length())));
		
		
	
		
		

		ProblemService problemservice = new ProblemServiceImpl();
		problemservice.saveState(submitstate);
    }
}
