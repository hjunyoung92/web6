package org.zerock.test;

import org.junit.Test;
import org.zerock.dao.MsgDAO;
import org.zerock.domain.MsgFileVO;
import org.zerock.domain.MsgVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class MsgDAOTests {
	private MsgDAO dao = new MsgDAO();
	
	
	
	@Test
	public void testInsert() {
		
		MsgVO mvo = new MsgVO();
		mvo.setSender("user00");
		mvo.setWhom("user01");
		mvo.setMsg("영화보자");
		
		MsgFileVO file1 = new MsgFileVO();
		file1.setOriginname("테스트 파일.txt");
		file1.setSavename("11111_테스트파일.txt");
		
		mvo.addFile(file1);
		MsgFileVO file2 = new MsgFileVO();
		file2.setOriginname("테스트 파일2.txt");
		file2.setSavename("22222_테스트파일.txt");
		
		mvo.addFile(file2);
		
		MsgFileVO file3 = new MsgFileVO();
		file3.setOriginname("테스트 파일.txt");
		file3.setSavename("33333_테스트파일.txt");
		
		mvo.addFile(file3);
		MsgFileVO file4 = new MsgFileVO();
		file4.setOriginname("테스트 파일.txt");
		file4.setSavename("44444_테스트파일.txt");
		
		mvo.addFile(file4);
		
		dao.insert(mvo);
	}
	
	@Test
	public void testReceiveList() {
		dao.selectReceiveList("baba").forEach(vo->log.info(vo));
	}
	
	
}
