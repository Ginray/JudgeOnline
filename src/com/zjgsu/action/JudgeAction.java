package com.zjgsu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.SubmitProblem;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zjgsu.service.JudgeService;

public class JudgeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JudgeService judgeservice;
	private SubmitProblem submitproblem;
	
	
	public SubmitProblem getSubmitproblem() {
		return submitproblem;
	}

	public void setSubmitproblem(SubmitProblem submitproblem) {
		this.submitproblem = submitproblem;
	}

	public JudgeService getJudgeservice() {
		return judgeservice;
	}

	public void setJudgeservice(JudgeService judgeservice) {
		this.judgeservice = judgeservice;
	}
	
	public String submitCode(){
		HttpServletRequest  request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		judgeservice.submitCode(submitproblem);
		return "success";
	}
	
}
