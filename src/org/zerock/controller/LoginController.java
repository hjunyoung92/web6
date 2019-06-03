package org.zerock.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.log4j.Log4j;
@Log4j
@WebServlet("/member/*")
public class LoginController extends AbstractController {
	
	
	public String sampleGET( HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession()	;
		
		Object value = session.getAttribute("LOGINID");
		
		if(value == null) {
			log.error("고르인 필새");
			return "redirect:/member/login";
		}
		
		return "/views/sample";
	}

	public String loginGET(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "views/login";
	}
	
	public String loginPOST(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		log.info(uid);
		log.info(upw);
		
		if(!uid.equals(upw)) {
			log.error("로그인실패");
			return "redirect:/member/login"; //이건 사실 스프링기법이다오
		}
			HttpSession session = request.getSession();
			session.setAttribute("LOGINID", uid);
			
		
		
		
		return "redirect:/msg/receive";
	}
}