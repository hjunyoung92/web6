package org.zerock.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/member/*")
public class LoginController extends AbstractController {
	private static final long serialVersionUID = 1L;

	public LoginController() {
        super();
    }
	
	public String sampleGET(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		
		//getAttribute는 오브젝트를 준다.
		Object value = session.getAttribute("LOGINID");
		
		if(value == null) {
			log.error("로그인안한사용자");
			return "redirect:/member/login";
		}
		
		return "/views/sample";
	}
	
	//첫페이지
	public String loginGET(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return "views/login";
	}
	
	public String loginPOST(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		log.info(uid);
		log.info(upw);
		
		if(!uid.equals(upw)) {
			log.error("login 실패");
			return "redirect:/member/login";
		} 
			
		HttpSession session = request.getSession();
		session.setAttribute("LOGINID", uid);		

		return "redirect:/msg/receive"; 
	}
	

}
