package com.zjgsu.oj;

import java.util.Date;
import java.util.TimerTask;

public class Controller extends Thread {
	private long limitTime;

	private long limitMemory;

	private Runtime rt;

	private OutResult result;

	private Process process;

	public Controller(Runtime rt, Target t) {
		this.limitTime = t.limitTime;
		this.rt = rt;
		this.limitMemory = t.limitMemory;

		process = null;
	}

	public void setOutResult(OutResult result) {
		this.result = result;
	}

	public String getResultState() {
		return result.getState();
	}

	public void setTarget(Target t) {
		this.limitTime = t.limitTime;
		this.limitMemory = t.limitMemory;
	}

	public void setProcess(Process p) {
		process = p;
	}

	public void run() {
		long oldTime = new Date().getTime();
		limitTime += oldTime;
		limitMemory = rt.freeMemory() - limitMemory;
		// System.out.println(" test time and mem");
		long nowTime;
		try {
			while (true) {
				nowTime = new Date().getTime();
//				 System.out.println(" nowTime=" + nowTime+" limitTime="+limitTime);
				// System.out.println(" freeMemory=" + rt.freeMemory()+"
				// limitMemrory="+limitMemory);
				if (nowTime > (limitTime) || rt.freeMemory() < limitMemory) {
					if (process == null) {

						System.out.println("  process is null");
						return;
					} else {
						process.destroy();
						process = null;
						if(nowTime > (limitTime)){
							result.setState("timeOut");
						}else{
							result.setState("memoryOut");
						}
//						System.out.println("limitOut");
						return;
					}
				} else {
					System.out.println("check time and memory.");

				}
				result.setTime(nowTime-oldTime);
				result.setMemory(rt.totalMemory()-rt.freeMemory());
				sleep(1000);
			}

		} catch (IllegalThreadStateException e) {
			System.out.println("进程尚未退出！");
			return;

		} catch (Exception ex) {
			System.out.println("程序" + ex.getMessage());
			return;
		}

	}

}
