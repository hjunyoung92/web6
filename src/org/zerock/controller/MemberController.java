package org.zerock.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.zerock.dao.MemberDAO;
import org.zerock.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/member/*")
public class MemberController extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	private MemberDAO dao = new MemberDAO();

	public MemberController() {
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

	public String joinGET(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "views/join";
	}

	public String joinPOST(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo.setMname(request.getParameter("mname")
				);
		
		dao.insert(vo);
		
		return "redirect:/member/login";
	}

	// 첫페이지
	public String loginGET(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return "views/login";
	}
	
	public String loginPOST(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		log.info(uid);
		log.info(upw);
		MemberVO  vo = dao.selectOne(uid, upw);
		
//		if(!uid.equals(upw)) {
//			log.error("login 실패");
//			return "redirect:/member/login";
//		} 
			
		HttpSession session = request.getSession();
		session.setAttribute("LOGINID", vo.getMid());		

		return "redirect:/msg/receive"; 
	}
	

}
