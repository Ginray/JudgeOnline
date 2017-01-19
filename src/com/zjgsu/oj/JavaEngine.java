package com.zjgsu.oj;

public class JavaEngine extends Engine {
	
	private Manager javaManager;
	public JavaEngine(){
	}
	public void run() {
		if(javaManager==null){
			System.out.println("没有目标文件！");
			return;
		}
		javaManager.control();
	}
	public Manager getManager() {
		if(javaManager==null){
			System.out.println("没有目标文件！");
			return null;
		}
		return javaManager;
	}
	public void target(Target target) {
		if(target==null){
			System.out.println("没有目标文件!");
			return;
		}
		javaManager=new Manager(target);
	}
	

}
