package com.zjgsu.oj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Timer;

public class Executor {
	public String name;
	public String args;
	private Target target;
	private OutResult result;
	private Process process ;
	//private ProcessBuilder process;
	private Runtime rt;
 
	public Executor(String executorName, String args, Target target,Runtime rt) {
		this.name = executorName;
		this.args = args;
		this.target = target;
		result = new OutResult();
		result.setState("compileSuccess");
		result.targetId=target.targetId;
		this.rt=rt;
		process=null;
	}
	public Process getProcess(){
		if(process==null){
			System.out.println("  process is null.");
		}
		System.out.println("get  process");
		return process;
	}

	public OutResult execute(Controller controller) {
			
		try { 
			System.out.println();
			System.out.println("--begine excute--");
			System.out.println("正在执行"+name + " " + args + " " +target.fileName);
			process = rt.exec(name + " " + args + " " +target.fileName);
			controller.setProcess(process);
			controller.setOutResult(result);
			controller.start();
			
			//redirectErroToFile( "erroExcute.txt");
			
			redirectInputDataToProcess();
			//redirectStdoutToFile( "outExcute.txt");
			redirectExecuteInfoToResult();
			controller.interrupt(); 
			
			if (!isErro()) {
				result.setState("runSuccess");
				if (checkAnswerFromTarget()) {
					result.setState("rightAnswer");
					System.out.println("  memory="+result.getMemory()+" time="+result.getTime()+" sate="+result.getState());
				} else {
					result.setState("wrongAnswer");
				}
			} 
			else {
				//result.setState("limitOut");
			}
			System.out.println("--end excute--");
		} catch (IOException e) {
			// e.printStackTrace();
			result.setState("runError");
			System.out.println("错误" + e.getMessage());
			return result;
		}catch(Exception ex){
			System.out.println("错误" + ex.getMessage());
		}
		System.out.println(" result="+result.getState());
		return result;
		// try {
		//
		// String className="org.evilbinary.out."
		// + target.fileName;
		// //System.out.println(classPath);
		// Class mainClass = Class.forName(className);
		// Main main = (Main) mainClass.newInstance();
		// String[] a = null;
		// //main.main(a);
		// System.out.println("运行成功");
		// } catch (ClassNotFoundException e) {
		// System.out.println("没找到" + e.getMessage());
		// result.setState("运行出错");
		// // e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// // TODO Auto-generated catch block
		// // e.printStackTrace();
		// System.out.println("错误" + e.getMessage());
		// } catch (InstantiationException e) {
		// // TODO Auto-generated catch block
		// // e.printStackTrace();
		// System.out.println("错误" + e.getMessage());
		// }
	}
	private void redirectInputDataToProcess() {
		// TODO Auto-generated method stub
		if(!"".equals(target.input)){
			OutputStream osStdOut=process.getOutputStream();
			try {
				osStdOut.write(target.input.getBytes());
				osStdOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private boolean checkAnswerFromTarget(){
		target.output=target.output.replaceAll("\n","");
		System.out.println("-----target.output"+target.output);
		System.out.println("-----result.outExecute"+result.outExecute);
		if(target.output.equals(result.outExecute)){
			System.out.println("equal");
			return true;
		}
		return false;
	}
	private boolean isErro() {
		String resultState=result.getState();
		if( ("timeOut".equals(resultState)&&!"memoryOut".equals(resultState)) ){
			return true;
		}
		return false;
	}


	private void redirectExecuteInfoToResult(){
		InputStream isStdErro = process.getErrorStream();
		InputStream isStdIn = process.getInputStream();
		byte b[] = new byte[1024];
		try {
			int readBytes=isStdErro.read(b);
			 if(readBytes<0)
					readBytes=0;
			String s=new String(b,0,readBytes);
			result.erroExecute=s;
			isStdErro.close();
			readBytes=isStdIn.read(b);
			readBytes-=2;  //不包括0d 0a
			if(readBytes<0)
				readBytes=0;
			String s1=new String(b,0,readBytes);
			result.outExecute=s1;
//			System.out.println("resultoutExecute="+result.outExecute);
//			System.out.println("target answer"+target.answer);
//			if(target.answer.equals(result.outExecute)){
//				System.out.println("equal");
//			}
			isStdIn.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//旧版本
	private boolean checkAnswer() {
		try {
			File f1 = new File(target.filePath + target.fileName + ".txt");
			File f2 = new File(target.filePath + "outExcute.txt");
			
			if(!f1.exists()){
				f1.createNewFile();
				FileOutputStream fo1=new FileOutputStream(f1);
				fo1.write(target.output.getBytes());
				fo1.close();
			}
			FileInputStream fi1 = new FileInputStream(f1);
			FileInputStream fi2 = new FileInputStream(f2);
			// System.out.println("f1 hash="+fi1.hashCode()+"
			// "+"ad".hashCode());
			// System.out.println("f2 hash="+fi2.hashCode()+"
			// "+"ad".hashCode());
			if (f2.length() != f1.length())
				return false;
			if (f2.exists()) {
				int r1;
				while ((r1=fi1.read())>=0) {
					if(r1!=fi2.read())
						return false;
				}
			}
			fi1.close();
			fi2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
//	旧版本
	private void redirectErroToFile( String stdoutFileName) {
		File stdoutFile = new File(target.filePath + stdoutFileName);
		stdoutFile.delete();
		try {
			InputStream is = process.getErrorStream();
			OutputStream os = new FileOutputStream(stdoutFile);
			byte b[] = new byte[256];
			int readBytes;
			while ((readBytes = is.read(b)) != -1) {
				os.write(b, 0, readBytes);
			}
			is.close();
			os.close();

		} catch (FileNotFoundException e) {
			System.out.println("错误" + e.getMessage());
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("错误" + e.getMessage());
		}
	}
//	旧版本
	private void redirectStdoutToFile( String stderroFileName) {
		File erroFile = new File(target.filePath + stderroFileName);
		try {
			InputStream is = process.getInputStream();
			OutputStream os = new FileOutputStream(erroFile);
			byte b[] = new byte[256];
			int readBytes;
			while ((readBytes = is.read(b)) != -1) {
				os.write(b, 0, readBytes);
			}
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("错误" + e.getMessage());
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("错误" + e.getMessage());
		}
	}
//	旧版本
//	private boolean isErro() {
//		File ferro = new File(target.filePath + "erroExcute.txt");
//		// System.out.println("erro.txt l="+ferro.length());
//		if (ferro.exists() && ferro.length() <= 0) {
//			return false;
//		}
//		return true;
//	}

}
