package org.zerock.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.dao.MemberDAO;
import org.zerock.dao.MsgDAO;
import org.zerock.domain.MsgFileVO;
import org.zerock.domain.MsgVO;
import org.zerock.domain.PageDTO;
import org.zerock.domain.PageVO;

import lombok.extern.log4j.Log4j;

@WebServlet("/msg/*")
@MultipartConfig(location = "C:/zzz")
@Log4j
public class MsgController extends AbstractController {
	private static final long serialVersionUID = 1L;

	private MsgDAO dao = new MsgDAO();
	private MemberDAO memberDAO = new MemberDAO();
	
	public String receiveGET (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("receive list.....");
		
		String userName = (String)request.getSession().getAttribute("LOGINID");
//		String userName = "baba";
//		String userName = "babamba";
		//TODO: paging
		//TODO: 1. countTotal -> done
		int current = getInt("page", request, 1);
		log.info(current);
		int total = dao.msgCountTotal(userName);
		request.setAttribute("pageManager", new PageDTO(current,total));

		//TODO: 2. overhaul receive dao query.
		PageVO pvo = new PageVO();
		pvo.setPage(current);
		pvo.setUserName(userName);
		//set list to request
		request.setAttribute("list", dao.selectReceiveList(pvo));
		
		//TODO: 3. setAtt. pageManager, new DTO
		request.setAttribute("pageMananger", new PageDTO(current, total));
		//TODO: 4. jsp
		return "msg/receive";
	}
	
	//끝
	public String readGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer mno = getInt("mno",request);

		MsgVO mvo = dao.selectOne(mno);
		dao.updateRead(mno);

		log.info(mvo);

		request.setAttribute("vo", mvo);
		
		
		return "msg/read";
	}
	
	
	public String registerGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("register GET");
		
		request.setAttribute("userList", memberDAO.getUserList());
		
		return "msg/register";
	
	}
	
	
	public String registerPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("register POST");
		
		//폼 값에서 받은 정보로 MsgVO를 만든다. 업로드 단계
		//final로 중간에 수정이 안되게 만든다.
		final MsgVO mvo = new MsgVO();
		mvo.setSender(request.getParameter("sender"));
		mvo.setWhom(request.getParameter("whom"));
		mvo.setMsg(request.getParameter("msg"));
		
		//foreach로 각 파일들 정보를 저장한다. part.getSub..이것으로 파일 이름을 받을수 있다.
		request.getParts().forEach( part -> {
			String fileName= part.getSubmittedFileName();
			
			//만약 파일이 없거나 파일이름이 비었을경우 그냥 끝낸다.
			if(fileName == null || fileName.trim().length() == 0) {return;}

			long time = System.currentTimeMillis();
			
			String saveName = time+"_"+fileName;
			
			try {
				part.write(saveName);
				
				//저장하는 단계
				MsgFileVO fileVO = new MsgFileVO();
				fileVO.setSavename(saveName);
				fileVO.setOriginname(fileName);
				
				mvo.addFile(fileVO);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		dao.insert(mvo);
		
		return "msg/register";
	
	}
}
