package org.zerock.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.MsgFileVO;
import org.zerock.domain.MsgVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class MsgDAO {

	private static final String PRE = "org.zerock.dao.";
	protected String mapperName = "MsgMapper";

	public void insert(MsgVO vo) {
		log.info(vo);
		
		SqlSession session = null;
		
		try {
			session = MyBatisLoader.sqlSessionFactory.openSession(); 
			session.insert(PRE + mapperName + ".insertMsg", vo);
			
			log.info("insertMsg");
			
			List<MsgFileVO> files = vo.getFiles();
			
			
			for(MsgFileVO fileVO : files) {
				session.insert(PRE + mapperName + ".insertFile", files);
				log.info("insertFile");
			};
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		}finally {
			session.close();			
		}
		
		
		
	}
}
