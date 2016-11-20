package com.zjgsu.action;


import model.Submitstate;

import com.opensymphony.xwork2.ActionSupport;
import com.zjgsu.service.ProblemService;


public class ProblemAction extends ActionSupport{
	
	private Submitstate submitstate;
	private ProblemService peoblemservice;
	public Submitstate getSubmitstate() {
		return submitstate;
	}
	public void setSubmitstate(Submitstate submitstate) {
		this.submitstate = submitstate;
	}
	public ProblemService getPeoblemservice() {
		return peoblemservice;
	}
	public void setPeoblemservice(ProblemService peoblemservice) {
		this.peoblemservice = peoblemservice;
	}
	
	public String showState(){
		try{
			peoblemservice.showState();
			return "success";
		}catch (Exception e){
			System.out.println("在ProblemAction 出错"+e);
			return "fail";
		}
	}
	
}
