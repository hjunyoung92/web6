package org.zerock.test;

import org.junit.Before;
import org.junit.Test;
import org.zerock.dao.TimeDAO;

import lombok.extern.log4j.Log4j;

@Log4j
public class TimeDAOTests {

	TimeDAO dao;
	
	
	//@before 테스트 진행하기전 실행하는 코드
	@Before
	public void ready() {
		dao = new TimeDAO();
		
		log.info(dao);
	}
	
	
	@Test
	public void testTime() throws Exception{
		log.info(dao.getTime());
	}
}

