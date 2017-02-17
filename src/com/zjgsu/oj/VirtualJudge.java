package com.zjgsu.oj;

import com.zjgsu.manager.JugeManager;

import java.io.*;


/**
 * Created by Ginray on 2017/2/17.
 */
public class VirtualJudge {
    static Process pc;
    static Runtime rt;


    public static void judge(String pro_id,String code_type,String code,String userId) {
        rt = Runtime.getRuntime();
        String ss = "python G:\\IDEAProjects\\JudgeOnline\\python_script\\submit_code.py";
        try {
            pc = rt.exec(ss);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // readIt(); 注意这样也会产生堵塞
        writeIt(pro_id,code_type,code,userId);
    }

    public static void writeIt(String pro_id,String code_type,String code,String userId) {
        OutputStream fos = pc.getOutputStream();
        PrintStream ps = new PrintStream(fos);
        //ps.print("ginxidx\n");
        //ps.print("123456\n");
        ps.print(pro_id+"\n");
        ps.print(code_type+"\n");
        ps.print(code+"\n");
        ps.flush(); // 不加这个 后面的read就读不下去了
        readIt(pro_id,code,userId);
    }

    public static void readIt(String pro_id,String code,String userId) {
        OutResult result = new OutResult();
        JugeManager judgemanager = new JugeManager();
        result.code=code;
        result.problemId=Integer.parseInt(pro_id);
        result.userId=Integer.parseInt(userId);
        result.targetId=pro_id+"_"+userId;

        InputStream ios = pc.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(ios));
        String s;
        try {
            while ((s = br.readLine()) != null) {
                System.out.println(s);
                if(s.contains("Compilation Error")){
                    result.setState("compileError");
                }else if(s.contains("Wrong Answer")){
                    result.setState("wrongAnswer");
                }else if(s.contains("Accepted")){
                    result.setState("rightAnswer");
                }
            }
            br.close();
            ios.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result.getState()==null){
            result.setState("systemError");
        }
        judgemanager.setJugeResult(result);
    }

}
