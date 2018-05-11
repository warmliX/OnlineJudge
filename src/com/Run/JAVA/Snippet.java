package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Test() {
       
    }
    
    public String getRemortIP(HttpServletRequest request) {
    	  if (request.getHeader("x-forwarded-for") == null) {
    	   return request.getRemoteAddr();
    	  }
    	  return request.getHeader("x-forwarded-for");
    	}
    
    public static void RunCa(String FileName,String text)
    {
		String url = "E:\\OnlineJudge\\"+FileName+".cpp";
		File file = new File(url);
		BufferedWriter bWriter;
		try {
			bWriter = new BufferedWriter(new FileWriter(file));
			bWriter.write(text);
			bWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Runtime runtime = Runtime.getRuntime();
        String cmd = "cmd /c g++ E:\\OnlineJudge\\"+FileName+".cpp -o E:\\OnlineJudge\\"+FileName;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getErrorStream()));
            String line=null;
            StringBuffer b=new StringBuffer();
            while ((line=br.readLine())!=null) {
                b.append(line+"\n");
            }
            if(b.toString().length() <= 0)
            	Runexe(FileName);
            else
            	System.out.println(b.toString());            
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void RunC(String FileName,String text)
    {
    	String url = "E:\\OnlineJudge\\"+FileName+".c";
		File file = new File(url);
		BufferedWriter bWriter;
		Runtime runtime = Runtime.getRuntime();
        String cmd = "cmd /c gcc -o E:\\OnlineJudge\\"+FileName+".exe E:\\OnlineJudge\\"+FileName+".c ";
		try {
			bWriter = new BufferedWriter(new FileWriter(file));
			bWriter.write(text);
			bWriter.close();
			System.out.println("¶Ïµã");
			BufferedReader br = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getErrorStream()));
            String line=null;
            StringBuffer b=new StringBuffer();
            while ((line=br.readLine())!=null) {
                b.append(line+"\n");
            }
            if(b.toString().length() <= 0)
            	Runexe(FileName);
            else
            	System.out.println(b.toString());
            br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void RunJAVA(String FileName,String text)
    {
    	String url = "E:\\OnlineJudge\\"+FileName+".java";
		File file = new File(url);
		BufferedWriter bWriter;
		Runtime runtime = Runtime.getRuntime();
        String cmd = "cmd /c E: && cd E:\\OnlineJudge && javac "+FileName+".java && java "+FileName+">"+FileName+".txt";
		try {
			bWriter = new BufferedWriter(new FileWriter(file));
			bWriter.write(text);
			bWriter.close();
			System.out.println("¶Ïµã");
			BufferedReader br = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getErrorStream()));
            String line=null;
            StringBuffer b=new StringBuffer();
            while ((line=br.readLine())!=null) {
                b.append(line+"\n");
            }
            System.out.println(b.toString());
            br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void Runexe(String FileName)
    {
    	Runtime runtime = Runtime.getRuntime();
        String cmd = "cmd /c E:\\OnlineJudge\\"+FileName+">E:\\OnlineJudge\\"+FileName+".txt";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getInputStream()));
            String line=null;
            StringBuffer b=new StringBuffer();
            while ((line=br.readLine())!=null) {
                b.append(line+"\n");
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String IP = getRemortIP(request);
		String text = request.getParameter("text");
		String FileName = IP.replace(":", "n");
		RunC(FileName,text);
	}
}
