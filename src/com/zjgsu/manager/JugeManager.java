package com.zjgsu.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


import com.zjgsu.oj.JugeSystem;
import com.zjgsu.oj.OutResult;
import com.zjgsu.oj.Target;

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

	public void setJugeResult() { // 结果提交到数据库
		
//			
	}
}
