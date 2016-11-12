package com.zjgsu.service;

import java.util.List;

import model.UserInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjgsu.utils.HibernateSessionFactory;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Override
	public void save(UserInfo userinfo) {
		 Session session = HibernateSessionFactory.getSession();  
	        try {  
	            //手动事务  
	            session.getTransaction().begin();  
	            //执行业务逻辑  
	            session.save(userinfo);  
	            //手动提交  
	            session.getTransaction().commit();  
	        } catch(Exception e) {  
	        	System.out.println("----error"+e);
	            session.getTransaction().rollback();  
	            throw new RuntimeException(e);  
	        } finally {  
	            HibernateSessionFactory.closeSession();  
	        }         
	}

	
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
      
    @Override //Spring和Hibernate整合后的情况  
    @Transactional
    public void update(UserInfo userinfo) {  
        try{
        	String sql="select * from user_info where username= ? and password=? ";
        	Query query = getSession().createSQLQuery(sql).addEntity(UserInfo.class);
        	query.setString(0, "w");
        	query.setString(1, "w");
        	List<UserInfo> li = query.list();
    		//List<UserInfo> list= getSession().createQuery("from UserInfo as user where user.username=:userinfo.username and user.password=:userinfo.password").list(); 
    		System.out.println("---list"+li.size());
        	//getSession().delete(userinfo);
        	//getSession().save(userinfo);
        	//getSession().update(userinfo); 
        }catch(Exception e){
        	System.out.println("CategoryServiceImpl修改时发生错误"+e);
        }
    }  
    
    
	
}
