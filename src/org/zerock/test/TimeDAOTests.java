package org.zerock.test;

import org.junit.Before;
import org.junit.Test;
import org.zerock.dao.TimeDAO;

import lombok.extern.log4j.Log4j;

@Log4j
public class TimeDAOTests {

	TimeDAO dao;
	
	@Before
	public void ready() {
		dao = new TimeDAO();
		log.info(dao);
	}
	
	@Test
	public void testTime() throws Exception {
		
		log.info(dao.getTime());
		
	}
}
