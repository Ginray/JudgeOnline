package com.zjgsu.oj;

public class OutResult {
	public String targetId;
	public String outCompile;
	public String outExecute;
	public String erroCompile;
	public String erroExecute;
	private long memory;
	private long time;
	private String state;
	public OutResult(){
		//System.out.println("====result");
		state="Œ¥±‡“Î";
		memory=0;
		time=0;
		outCompile=null;
		outExecute=null;
		erroCompile=null;
		erroExecute=null;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public long getMemory() {
		return memory;
	}
	public void setMemory(long memory) {
		this.memory = memory;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
}
