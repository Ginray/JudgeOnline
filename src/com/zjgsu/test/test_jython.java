package com.zjgsu.test;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;
import org.junit.Test;


public class test_jython {
	@Test
    public static void main(String args[]){  
       PythonInterpreter interpreter = new PythonInterpreter();  

	   PySystemState sys = interpreter.getSystemState();

       interpreter.execfile("C:\\Users\\ciabok\\Desktop\\test.py");  
       PyFunction func = (PyFunction)interpreter.get("adder",PyFunction.class);  
       int a=1,b=2;
       PyObject pyobj = func.__call__(new PyInteger(a),new PyInteger(b));  
       System.out.println(pyobj.toString());
	}
	
	
}
