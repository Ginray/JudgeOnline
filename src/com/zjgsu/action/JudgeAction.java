package com.zjgsu.action;

import javax.servlet.http.HttpServletRequest;

import model.SubmitProblem;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zjgsu.service.JudgeService;

public class JudgeAction extends ActionSupport{
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
		judgeservice.submitCode(submitproblem);
		return "success";
	}
	
}
