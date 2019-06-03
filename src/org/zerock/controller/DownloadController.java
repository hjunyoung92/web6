package org.zerock.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;

@WebServlet("/download")
@Log4j
public class DownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Download service.....");
		
		//음악파일
		String fileName = request.getParameter("fname");
		
		log.info("fileName: "+fileName);
		
		response.setContentType("application/octet-stream");
		
		OutputStream os = response.getOutputStream();
		
		FileInputStream fin = new FileInputStream("C:\\zzz\\"+fileName);
		
		String filename = new String(fileName.getBytes(), "8859_1");

		//파일이름에 날짜를 자르기
		filename= filename.substring(filename.indexOf("_")+1);
		
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		
		byte[] buffer = new byte[1024*8];
		
		while(true) {
			int count = fin.read(buffer);
			if( count == -1) break;
			os.write(buffer,0,count);
		}
	
	}

}
