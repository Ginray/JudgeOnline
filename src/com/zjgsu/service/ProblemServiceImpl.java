package com.zjgsu.service;

import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;

import model.Problem;
import model.SolutionEntity;
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
    @Transactional
	public void saveState(Submitstate submitstate){
        try{
    		Session s=HibernateSessionFactory.getSession();
    		s.beginTransaction();
        	s.save(submitstate);
        	s.getTransaction().commit(); 
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
		String sql="select * from problem order by problem_id";
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
			
			/*这段是为了给题目描述添加缩进，然而效果并不是很好，而且看了很多OJ都是没有采用缩进，因此我也注释掉了。
			StringBuffer StringFlag=new StringBuffer(li.get(0).getDescription());
			StringFlag.insert(0,"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp");
			li.get(0).setDescription(StringFlag.toString());
			*/
			
			li.get(0).setSampleInput(li.get(0).getSampleInput().replace("\n", "<br />"));
			li.get(0).setSampleOutput(li.get(0).getSampleOutput().replace("\n", "<br />"));
			li.get(0).setInput(li.get(0).getInput().replace("\n", "<br />"));
			li.get(0).setOutput(li.get(0).getOutput().replace("\n", "<br />"));
			li.get(0).setDescription(li.get(0).getDescription().replace("\n", "<br />"));
			li.get(0).setHint(li.get(0).getHint().replace("\n", "<br />"));
			return li.get(0);
		}else{
			System.out.println("ProblemServiceImpl getProblemById 出错");
			return null;
		}
	}
	
	@Override
	public List<Problem> searchProblem(String keyword) {
		String sql="select * from problem where problem_id like"+"'%" + keyword+"%' "+"or title like"+"'%" + keyword+"%' "+"or source like"+"'%" + keyword+"%' ";
		Session s=HibernateSessionFactory.getSession();
		Query query = s.createSQLQuery(sql).addEntity(Problem.class);
		List<Problem> li = query.list();
		if(li.size()>0){
			return li;
		}else{
			System.out.println("ProblemServiceImpl searchProblem 未找到对应题目");
			return null;
		}
	}
	
	@Override
	public List<Submitstate> searchState(String keyword) {
		String sql="select * from submitstate where problem_id like"+"'%" + keyword+"%' "+"order by id desc ";
		Session s=HibernateSessionFactory.getSession();
		Query query = s.createSQLQuery(sql).addEntity(Submitstate.class);
		List<Submitstate> li = query.list();
		if(li.size()>0){
			return li;
		}else{
			System.out.println("ProblemServiceImpl searchState未找到对应state");
			return null;
		}
	}

	@Override
	public String returnInput(String problemId) {
		String sql="select * from solution where problem_id = "+problemId;
		Session s=HibernateSessionFactory.getSession();
		Query query = s.createSQLQuery(sql).addEntity(SolutionEntity.class);
		List<SolutionEntity> li = query.list();
		if(li.size()>0){
			return li.get(0).getInput();
		}else {
			System.out.println("ProblemServiceImpl returnInput未找到对应input");
			return null;
		}
	}

	@Override
	public String returnOutput(String problemId) {
		String sql="select * from solution where problem_id = "+problemId;
		Session s=HibernateSessionFactory.getSession();
		Query query = s.createSQLQuery(sql).addEntity(SolutionEntity.class);
		List<SolutionEntity> li = query.list();
		if(li.size()>0){
			return li.get(0).getOutput();
		}else{
			System.out.println("ProblemServiceImpl returnOutput未找到对应Output");
			return null;
		}
	}
}
