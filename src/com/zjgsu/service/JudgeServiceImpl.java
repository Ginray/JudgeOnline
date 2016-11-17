package com.zjgsu.service;

import javax.servlet.http.HttpServletRequest;

import model.SubmitProblem;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class JudgeServiceImpl implements JudgeService{
	
	/*Spring和Hibernate整个后*/  
    private SessionFactory sessionFactory; //定义一个sessionFactory  
      
    //当需要使用sessoinFactory的时候，Spring会将sessionFactory注入进来  
	
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }    
    protected Session getSession() {  
        //从当前线程获取session，如果没有则创建一个新的session  
        return sessionFactory.getCurrentSession();  
    }
    
	
	@Override
	public void submitCode(SubmitProblem submitproblem) {
		String codetext= submitproblem.getCodetext();
		System.out.println("提交的代码"+codetext);	
	}

}
