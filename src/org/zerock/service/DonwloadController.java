package org.zerock.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class DonwloadController
 */
@WebServlet("/download")
@Log4j
public class DonwloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonwloadController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("야이");
		String fileName = request.getParameter("fname");
		
		log.info("filename" + fileName);
		
		response.setContentType("application/octet-stream");
		OutputStream os = response.getOutputStream();
		
		InputStream fin = new FileInputStream("C://zzz//"+fileName);
		
		String filename = new String(fileName.getBytes(), "8859_1");

		response.setHeader("Content-Disposition", "attachment;filename=" + filename);

		
		byte[] buffer = new byte[1024*8];
		
		while(true) {
			int count = fin.read(buffer);
			if(count == -1) {break;}
			
			os.write(buffer,0,count);
		}
	}

	
	
}
