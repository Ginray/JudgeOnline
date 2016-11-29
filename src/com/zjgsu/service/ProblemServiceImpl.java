package com.zjgsu.service;

import java.util.List;
import java.util.Vector;

import model.Problem;
import model.Submitstate;
import model.UserInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjgsu.utils.HibernateSessionFactory;
@Service
@Transactional
public class ProblemServiceImpl implements  ProblemService{
	
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
	public List<Submitstate> showState() {
		String sql="select * from submitstate order by id desc ";
		Session s=HibernateSessionFactory.getSession();
		Query query = s.createSQLQuery(sql).addEntity(Submitstate.class);
		List<Submitstate> li = query.list();
		if(li.size()>0){
			return li;
		}else{
			System.out.println("ProblemServiceImpl出错");
			return null;
		}
	}
	
	@Override
	public void saveState(Submitstate submitstate){
        try{
    		Session s=HibernateSessionFactory.getSession();
        	s.save(submitstate);
        	
        }catch(Exception e){
        	System.out.println("CategoryServiceImpl  saveState 时发生错误"+e);
        }
	}
	
	@Override
	public String findUsername(int cid) {
		String sql="select * from user_info where uid = "+cid;
		Session s=HibernateSessionFactory.getSession();
		Query query = s.createSQLQuery(sql).addEntity(UserInfo.class);
		List<UserInfo> li = query.list();
		if(li.size()>0){
			return li.get(0).getNickname();
		}else{
			System.out.println("ProblemServiceImpl findUsername 出错");
			return null;
		}
	}
	
	@Override
	public List<Problem> showProblem() {
		String sql="select * from problem";
		Session s=HibernateSessionFactory.getSession();
		Query query = s.createSQLQuery(sql).addEntity(Problem.class);
		List<Problem> li = query.list();
		if(li.size()>0){
			return li;
		}else{
			System.out.println("ProblemServiceImpl出错");
			return null;
		}
	}

	@Override
	public Problem getProblemById(String id) {
		String sql="select * from problem where problem_id = "+id;
		Session s=HibernateSessionFactory.getSession();
		Query query = s.createSQLQuery(sql).addEntity(Problem.class);
		List<Problem> li = query.list();
		if(li.size()>0){
			return li.get(0);
		}else{
			System.out.println("ProblemServiceImpl getProblemById 出错");
			return null;
		}
	}
	
}
