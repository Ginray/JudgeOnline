package com.zjgsu.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.SubmitProblem;

import org.apache.struts2.ServletActionContext;

import com.zjgsu.manager.JugeManager;
import com.zjgsu.oj.JugeSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class JudgeServiceImpl implements JudgeService{
	
	private JugeManager jugeManager=new JugeManager();
	
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
		String codeText= submitproblem.getCodetext();
		//System.out.println("提交的代码"+codeText);
		
		try {

			String direct = "";
			String msg = "";
			HttpServletRequest  request=ServletActionContext.getRequest();  
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			//servletContext中对象存取的数据是个全局的，生命周期也是长久的，直到web服务器关闭 
			ServletContext application=request.getSession().getServletContext(); 
			Thread jugeSystem=(JugeSystem)application.getAttribute("jugeSystem");
			if(jugeSystem==null){
				jugeSystem=new JugeSystem("Java");
				
				//这时候就开始run这个线程了
				jugeSystem.start();
				
				System.out.println("run juge targetNum="+((JugeSystem) jugeSystem).getTargetNumber());
				application.setAttribute("jugeSystem", jugeSystem);
				
			}
			
			
			System.out.println("-----------JugeServlet");
			codeText=codeText.trim();
			
//				System.out.println("codetext"+codeText);
//				System.out.println("juge1");
			if (codeText!=null) {
				if (username==null||"".equals(username)) {
					direct = "UserLogin.jsp";
					msg = "尚未登录";
				} else {
					jugeManager.setJugeSystem((JugeSystem) jugeSystem);
					System.out.println("begin add juge");
					
					String uId =request.getSession().getAttribute("userid").toString();
					String problemId =(String) request.getSession().getAttribute("problemId");
					if(uId!=null&&problemId!=null){
						jugeManager.addJuge(problemId,uId, codeText);
					}else{
						System.out.println("userId 或problemId 为空!");
					}
					
					direct="SubmitResult.jsp";
				}
			}else{
				//
			}
			

			System.out.println(msg);

			return;
		} catch (Exception e) {
			System.out.println(e + " JugeServlet");
		}
		
		
	}

}
