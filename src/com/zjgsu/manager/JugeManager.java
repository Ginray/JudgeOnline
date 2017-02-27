package com.zjgsu.manager;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.zjgsu.oj.VirtualJudge;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import model.Submitstate;

import com.opensymphony.xwork2.ActionContext;
import com.zjgsu.oj.JugeSystem;
import com.zjgsu.oj.OutResult;
import com.zjgsu.oj.Target;
import com.zjgsu.service.ProblemService;
import com.zjgsu.service.ProblemServiceImpl;

import static oracle.net.aso.C00.l;
import static oracle.net.aso.C00.v;

public class JugeManager{
	
	private JugeSystem system = null;
 
	public JugeManager() {

	}

	public void setJugeSystem(JugeSystem system) {
		this.system = system;
	}

	public void addJuge(String problemId, String userId, String code) {
		try {
			ProblemService problemService  = new ProblemServiceImpl();
			// Problem problem=problemManager.getProblemById(problemId);
			Target target = new Target();
			target.fileName = "Main";
			target.targetId = problemId + "_" + userId;
			target.filePath = "C:\\Environment\\Output\\Java\\out\\";
			target.fileExtension = ".java";
			target.objExtension = ".class";
			target.userId=Integer.parseInt(userId);
			target.problemId=Integer.parseInt(problemId);

			target.input=problemService.returnInput(problemId);
			target.output=problemService.returnOutput(problemId);
			System.out.println("Input"+ target.input);
			System.out.println("Output"+target.output);
			//target.input="123";
			//target.output ="123";
			target.code=code;
			//这是后台数据
			System.out.println("input= "+target.input);
			System.out.println("output= "+target.output);
			
			
			target.setLimit(6000, 10000);	//默认时间和内存限定 
			
			system.addTarget(target);
			system.addCode(code);
//			System.out.println(system.getResutlNumber() + "==========");
			System.out.println("----addJuge");
			while (system.getResutlNumber()>= 1) {
				System.out.println(system.getResult());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + " add JugeManager");
		}
	}

	public void addVirtualJudge(String problemId, String code_type,String code,String userId){
		VirtualJudge virtualJudge=new VirtualJudge();
		virtualJudge.judge(problemId,code_type,code,userId);
	}

	/**
	 * 
	 */
	
	public void setJugeResult(OutResult result) { // 结果提交到数据库
		
		//测试是否能加入到数据库
		/*
		Submitstate submitstate = new Submitstate();
		submitstate.setUserId(48);
		submitstate.setProblemId(1);
		submitstate.setCodeLength(1);
		submitstate.setCodeType("Java");
		submitstate.setMemory("12345");
		submitstate.setRuntime("12345");
		submitstate.setState("AC");
		
		HttpServletRequest  request=ServletActionContext.getRequest();  
		
		
		
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
		
		*/
		
		Submitstate submitstate = new Submitstate();

		if(result==null){
			System.out.println("---result null  judgeManage");
			return ;
		}
		
		submitstate.setUserId(result.userId);
		submitstate.setProblemId(result.problemId);
		//submitstate.setId(100);

	
		String code = result.code;
		System.out.println(result.targetId + " id");
		String[] pu = result.targetId.split("_");
		SimpleDateFormat dayFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		submitstate.setState(result.getState());
		submitstate.setCodeType("java");
		submitstate.setMemory(String.valueOf(result.getMemory()));
		submitstate.setRuntime(String.valueOf(result.getTime()));
		submitstate.setSubmitDate(new Date());
		submitstate.setCodeLength(Integer.parseInt(String.valueOf(code.length())));
		
		
		//HttpServletRequest  request=ServletActionContext.getRequest();  
		
		

		ProblemService problemservice = new ProblemServiceImpl();
		problemservice.saveState(submitstate);

		
	}
	
	
}
