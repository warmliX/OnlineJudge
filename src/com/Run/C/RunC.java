package com.Run.C;

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


@WebServlet("/RunC")
public class RunC extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RunC() {
        super();
    }

    public String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }

        return request.getHeader("x-forwarded-for");
    }

    public static void RunC(String FileName, String text,
        HttpServletResponse response) {
        String path = "E:\\OnlineJudge\\" + FileName;
        File dirpath = new File(path);

        if (!dirpath.exists()) {
            dirpath.mkdir();
        }

        String url = "E:\\OnlineJudge\\" + FileName + "\\" + FileName + ".c";
        File file = new File(url);
        BufferedWriter bWriter;
        Runtime runtime = Runtime.getRuntime();
        String cmd = "cmd /c gcc -o E:\\OnlineJudge\\" + FileName + "\\" +
            FileName + ".exe E:\\OnlineJudge\\" + FileName + "\\" + FileName +
            ".c ";

        try {
            bWriter = new BufferedWriter(new FileWriter(file));
            bWriter.write(text);
            bWriter.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                        runtime.exec(cmd).getErrorStream()));
            String line = null;
            StringBuffer b = new StringBuffer();

            while ((line = br.readLine()) != null) {
                b.append(line + "\n");
            }

            if (b.toString().length() <= 0) {
                Runexe(FileName, response);
            } else {
                response.getWriter().write(b.toString());
                return;
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Runexe(String FileName, HttpServletResponse response) {
        Runtime runtime = Runtime.getRuntime();
        String cmd = "cmd /c E:\\OnlineJudge\\" + FileName +"\\"+FileName+
            ">E:\\OnlineJudge\\" + FileName +"\\"+FileName+ ".txt";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                        runtime.exec(cmd).getInputStream()));
            String line = null;
            StringBuffer b = new StringBuffer();

            while ((line = br.readLine()) != null) {
                b.append(line + "\n");
            }

            if (b.toString().length() > 0) {
                response.getWriter().write(b.toString());
                return;
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    StringBuffer GetEnding(String FileName) {
        String url = "E:\\OnlineJudge\\" + FileName +"\\"+FileName+ ".txt";
        File file = new File(url);
        BufferedReader bReader = null;

        try {
            bReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        StringBuffer stringBuffer = new StringBuffer();
        String str = null;

        try {
            while ((str = bReader.readLine()) != null) {
                stringBuffer.append(str + "\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                bReader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return stringBuffer;
    }

    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        String IP = getRemortIP(request);

        response.setHeader("Content-type", "text/html;charset=UTF-8"); 
        response.setCharacterEncoding("utf-8");
        
        String text = request.getParameter("text");
        String Word = SafeC.Safe(text);
        if(!Word.equals("yes"))
        {
        	response.getWriter().write("½ûÖ¹"+Word+"¹Ø¼ü×Ö");
        	return;
        }
        
        String FileName = IP.replace(":", "n");
        RunC(FileName, text, response);

        StringBuffer stringBuffer = GetEnding(FileName);
        response.getWriter().write(stringBuffer.toString());

        //		response.getWriter().write(text);
    }
}
