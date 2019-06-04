package org.zerock.test;

import org.junit.Test;
import org.zerock.dao.MemberDAO;
import org.zerock.domain.MemberVO;

import lombok.extern.log4j.Log4j;
@Log4j
public class MemberDAOTests {
	private MemberDAO dao = new MemberDAO();
	
	@Test
	public void testInsert() {
		
		MemberVO vo = new MemberVO();
		vo.setMid("Cow");
		vo.setMpw("pwCow");
		vo.setMname("Heo Junyoung");
		
		dao.insert(vo);
	}
	
	@Test
	public void testRead() {
		MemberVO vo = dao.selectOne("Cow", "pwCow");
		
		log.info(vo);
				
	}
}
