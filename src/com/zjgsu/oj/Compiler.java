package com.zjgsu.oj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class Compiler {
	public String name;
	public String args;
	private Target target;
	private OutResult result;
	private Process process;
	private Runtime rt;
	public Compiler(String compilerName,String args,Target target,Runtime rt){
		this.name=compilerName;
		this.args=args;
		this.target=target;
		this.rt=rt;
		result=new OutResult();
	}
	
	public OutResult compile(){
		if(name==null||target==null||"".equals(name))
				return null;
		System.out.println();
		System.out.println("--begine compile--");
		System.out.println("name="+name);
		try {
			if(isTargetFileExit()){
				clearObjFile();
			}
			//newInputFile();

			process=rt.exec( name+" "+args+" \""+target.filePath+target.fileName+target.fileExtension+"\"");
//			System.out.println( name+" "+args+" \""+target.filePath+target.fileName+target.fileExtension+"\"");
			//redirectErroToFile("erroCompile.txt");
			//redirectStdoutToFile("outCompile.txt");
			redirectCompileInfoToResult();	
			if(isSuccess()){
				result.setState("compileSuccess");
			}else{
				result.setState("compileError");
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("´íÎó"+e.getMessage());
		}
		System.out.println("--end compile--");
		return result;
	}
	public OutResult compile(String compilerName,String args,Target target){
		compilerName="javac";
		if(compilerName==null||"".equals(compilerName))
				return null;
		//newInputFile();
		rt=Runtime.getRuntime();
		try {
			process=rt.exec(compilerName+" "+args+" \""+target.filePath+target.fileName+target.fileExtension+"\"");
			System.out.println("  "+compilerName+" "+args+" \""+target.filePath+target.fileName+target.fileExtension+"\""+" fasd");
			//redirectErroToFile( "erroCompile.txt");
			//redirectStdoutToFile("outCompile.txt");
			redirectCompileInfoToResult();	
			if(isSuccess()){
				result.setState("compileSuccess");
			}else{
				result.setState("compileError");
			}
		} catch (IOException e) {
			// e.printStackTrace();
		 	System.out.println("´íÎó"+e.getMessage());
		}
		return result;
	}
	private void redirectCompileInfoToResult() {
		InputStream isStdErro = process.getErrorStream();
		InputStream isStdIn = process.getInputStream();
		byte b[] = new byte[1024];
		try {
			int readBytes=isStdErro.read(b);
			if(readBytes<0)
				readBytes=0;
			String s=new String(b,0,readBytes);
			result.erroCompile=s;
			isStdErro.close();
			readBytes=isStdIn.read(b);
			readBytes-=2;  //²»°üÀ¨0d 0a
			if(readBytes<0)
				readBytes=0;
			String s1=new String(b,0,readBytes);
			result.outCompile=s1;
			result.targetId=target.targetId;
//			System.out.println(result.targetId+" =============="+target.targetId);
			isStdIn.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void clearObjFile(){
		File f=new File(target.filePath+target.fileName);
		//if(f.lastModified()<f.get)
			f.delete();
		System.out.println("  delete file.");
	}
	private boolean isTargetFileExit(){
		File f=new File(target.filePath+target.fileName+target.objExtension);
		if(f.exists()){
			return true;
		}
		return false;
	}
	private boolean isErro(){
		if(result.erroCompile==null){
			return false;
		
		}
		if(result.erroCompile.length()>0){
			return true;
		}
		return false;
	}
	private void newInputFile(){
		File inputFile=new File(target.filePath+target.fileName+target.fileExtension);
		try {
			OutputStream os = new FileOutputStream(inputFile);
			os.write(target.input.getBytes());
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("´íÎó"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("´íÎó"+e.getMessage());
		} 
	}
//	¾É°æ±¾
	private void redirectErroToFile(String stdoutFileName){
		File stdoutFile=new File(target.filePath+stdoutFileName);
		try {
			InputStream is=process.getErrorStream();
			OutputStream os = new FileOutputStream(stdoutFile);
			byte b[] = new byte[256];
			int readBytes;
			while((readBytes=is.read(b))!=-1){
				os.write(b,0,readBytes);
			}
			is.close();
			os.close();
				
		} catch (FileNotFoundException e) {
			System.out.println("´íÎó"+e.getMessage());
			//e.printStackTrace();
		}catch(IOException e){
			System.out.println("´íÎó"+e.getMessage());
		}
	}
	
//	¾É°æ±¾	
//	private boolean isErro(){
//		File ferro=new File(target.filePath+"erroCompile.txt");
//		//System.out.println("erro.txt l="+ferro.length());
//		if(ferro.exists()&&ferro.length()<=0){
//			return false;
//		}
//		return true;
//	}
//	¾É°æ±¾
	private boolean isOut(){
		File fout=new File(target.filePath+"outCompile.txt");
		if(fout.exists()&&fout.length()<=0){
			return true;
		}
		return false;
	}
	private boolean isSuccess(){
		if(isTargetFileExit()&&!isErro()){		//&&!isErro()
			return true;
		}
		return false;
	}
//	¾É°æ±¾
	private void redirectStdoutToFile(String stderroFileName){
		File erroFile=new File(target.filePath+stderroFileName);
		try {
			InputStream is=process.getInputStream();
			OutputStream os = new FileOutputStream(erroFile);
			byte b[] = new byte[256];
			int readBytes;
			while((readBytes=is.read(b))!=-1){
				os.write(b,0,readBytes);
			}
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("´íÎó"+e.getMessage());
			//e.printStackTrace();
		}catch(IOException e){
			System.out.println("´íÎó"+e.getMessage());
		}
	}
}
