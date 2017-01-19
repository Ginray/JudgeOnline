package com.zjgsu.oj;

public class Engine implements IEngine {
	private Manager manager;
	public Engine(){
	}
	public void run() {
		if(manager==null){
			System.out.println("没有目标文件！");
			return;
		}
		manager.control();
	}
	public Manager getManager() {
		if(manager==null){
			System.out.println("没有目标文件！");
			return null;
		}
		return manager;
	}
	public void target(Target target) {
		if(target==null){
			System.out.println("没有目标文件!");
			return;
		}
		manager=new Manager(target);
	}
}
