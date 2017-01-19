package com.zjgsu.oj;

import java.io.File;

public class Target {
	public String targetId;
	public String fileName;
	public String filePath;
	public String fileExtension;
	public String objExtension;
	public String output;
	public String input;
	public long limitTime;
	public long limitMemory;
	public Target(){
		//System.out.println("====target");
		fileName="";
		filePath="";
		fileExtension="";
		objExtension="";
		output="";
		input="";
		limitTime=10;
		limitMemory=10;
		targetId="";
	}
	public Target(String filePath,String fileName,String fileExtension,String objExtension,String input,String output){
		this.filePath=filePath;
		this.fileExtension=fileExtension;
		this.fileName=fileName;
		this.objExtension=objExtension;
		this.output=output;
		this.input=input;
		limitTime=10;
		limitMemory=10;
	}
	public void setTargetId(String targetId){
		this.targetId=targetId;
	}
	public void setLimit(long limitTime,long limitMemory){
		this.limitTime=limitTime;
		this.limitMemory=limitMemory;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	

}
