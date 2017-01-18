package com.zjgsu.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;
import org.junit.Test;

public class test_jython {
	static Process pc;
	static Runtime rt;
	

	public static void main(String args[]) {
		rt = Runtime.getRuntime();
		String ss = "python G:\\javaworkspace\\JudgeOnline\\python_script\\submit_code.py";
		try {
			pc = rt.exec(ss);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// readIt(); 注意这样也会产生堵塞
		writeIt();
	}

	public static void writeIt() {
		OutputStream fos = pc.getOutputStream();
		PrintStream ps = new PrintStream(fos);
		ps.print("ginxidx\n");
		ps.print("123456\n");
		ps.flush(); // 不加这个 后面的read就读不下去了
		readIt();
	}

	public static void readIt() {
		InputStream ios = pc.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(ios));
		String s;
		try {
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();
			ios.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test_process() {

		try {
			System.out.println("start");
			Process pr = Runtime.getRuntime().exec(
					"python G:\\javaworkspace\\JudgeOnline\\python_script\\submit_code.py");

			OutputStream fos = pr.getOutputStream();
			PrintStream ps = new PrintStream(fos);
			ps.print("another\n");
			ps.flush(); // 不加这个 后面的read就读不下去了

			BufferedReader in = new BufferedReader(new InputStreamReader(
					pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			in.close();

			pr.waitFor();
			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * try { Process proc = Runtime.getRuntime().exec(
		 * "python C:\\Users\\ciabok\\Desktop\\submit_code.py"); proc.waitFor();
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println("test finsh");
		 */
	}

}
