package com.zjgsu.manager;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.Submitstate;

import com.zjgsu.oj.JugeSystem;
import com.zjgsu.oj.OutResult;
import com.zjgsu.oj.Target;
import com.zjgsu.service.ProblemService;
import com.zjgsu.service.ProblemServiceImpl;

public class JugeManager {
	private JugeSystem system = null;
 
	public JugeManager() {

	}

	public void setJugeSystem(JugeSystem system) {
		this.system = system;
	}

	public void addJuge(String problemId, String userId, String code) {
		try {
			// Problem problem=problemManager.getProblemById(problemId);
			Target target = new Target();
			target.fileName = "Main";
			target.targetId = problemId + "_" + userId;
			target.filePath = "D:\\My Documents\\Java\\out\\";
			target.fileExtension = ".java";
			target.objExtension = ".class";
			
			
			target.input="123";
			target.output ="123";
			//这是后台数据
			System.out.println("input= "+target.input);
			System.out.println("output= "+target.output);
			
			
			target.setLimit(6000, 10000);	//默认时间和内存限定 
			
			system.addTarget(target);
			system.addCode(code);
//			System.out.println(system.getResutlNumber() + "==========");
			if (system.getResutlNumber() >= 1) {
				System.out.println(system.getResult());
				setJugeResult();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + " add JugeManager");
		}
	}

	/**
	 * 
	 */
	public void setJugeResult() { // 结果提交到数据库
		
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
		submitstate.setUserId(100);
		submitstate.setProblemId(1);
		submitstate.setId(100);

	
		
		
		OutResult result = system.getResult();
		String code = system.getCode();
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
		
		
		HttpServletRequest  request=ServletActionContext.getRequest();  
		
		

		ProblemService problemservice = new ProblemServiceImpl();
		problemservice.saveState(submitstate);

		
	}
	
	
}
