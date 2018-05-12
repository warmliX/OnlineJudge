package com.Run.Ca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RunCa")
public class RunCa extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public String getRemortIP(HttpServletRequest request) {
  	  if (request.getHeader("x-forwarded-for") == null) {
  	   return request.getRemoteAddr();
  	  }
  	  return request.getHeader("x-forwarded-for");
  	}
    
    public static void RunC(String FileName,String text,HttpServletResponse response)
    {
    	String url = "E:\\OnlineJudge\\"+FileName+".cpp";
		File file = new File(url);
		BufferedWriter bWriter;
		Runtime runtime = Runtime.getRuntime();
        String cmd = "cmd /c g++ E:\\OnlineJudge\\"+FileName+".cpp -o E:\\OnlineJudge\\"+FileName;
		try {
			bWriter = new BufferedWriter(new FileWriter(file));
			bWriter.write(text);
			bWriter.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getErrorStream()));
            String line=null;
            StringBuffer b=new StringBuffer();
            while ((line=br.readLine())!=null) {
                b.append(line+"\n");
            }
            if(b.toString().length() <= 0)
            	Runexe(FileName);
            else
            	response.getWriter().write(b.toString());
            br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void Runexe(String FileName,HttpServletResponse response)
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
            if(b.toString().length() > 0)
            	response.getWriter().write(b.toString());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    StringBuffer GetEnding(String FileName)
    {
    	String url = "E:\\OnlineJudge\\"+FileName+".txt";
		File file = new File(url);
    	BufferedReader bReader = null;
		try {
			bReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	StringBuffer stringBuffer = new StringBuffer();
    	String str = null;
    	try {
			while((str = bReader.readLine()) != null)
			{
				stringBuffer.append(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return stringBuffer;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String IP = getRemortIP(request);
		String text = request.getParameter("text");
		String FileName = IP.replace(":", "n");
		RunC(FileName,text);
		StringBuffer stringBuffer = GetEnding(FileName);
		response.getWriter().write("<a>"+stringBuffer.toString()+"</a>");
		doGet(request, response);
	}
}