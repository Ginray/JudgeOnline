package com.zjgsu.action;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.Submitstate;

import com.opensymphony.xwork2.ActionSupport;
import com.zjgsu.manager.ProblemManager;
import com.zjgsu.service.ProblemService;


public class ProblemAction extends ActionSupport{
	
	private Submitstate submitstate;
	private ProblemService problemservice;
	public Submitstate getSubmitstate() {
		return submitstate;
	}
	public void setSubmitstate(Submitstate submitstate) {
		this.submitstate = submitstate;
	}
	public ProblemService getProblemservice() {
		return problemservice;
	}
	public void setProblemservice(ProblemService problemservice) {
		this.problemservice = problemservice;
	}
	
	public String showState(){
		try{
			problemservice.showState();
			return "success";
		}catch (Exception e){
			System.out.println("在ProblemAction 出错"+e);
			return "fail";
		}
	}
	
	public String showProblem(){
		HttpServletRequest  request=ServletActionContext.getRequest();  
		String problemId = request.getParameter("problemId");
		System.out.println("---problemID "+problemId);
		ProblemManager problemManager = new ProblemManager();
		problemManager.setProblemId(Integer.parseInt(problemId));
		return "problem";
	}

	
}
