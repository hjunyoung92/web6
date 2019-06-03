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
	
	public MsgVO selectOne(Integer mno) {
		MsgVO result = null;

		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			result = session.selectOne(PRE + mapperName + ".read", mno);

		} catch (Exception e) {
			throw e;
		}

		return result;
	}

	public void insert(MsgVO mvo) {
		log.info(mvo);

		SqlSession session = null;

		// openSession을 true로 안하는 대신 수동으로 session.commit()한다.
		try {
			session = MyBatisLoader.sqlSessionFactory.openSession();

			session.insert(PRE + mapperName + ".insertMsg", mvo);
			
			log.info("insert message...");
			
			List<MsgFileVO> files = mvo.getFiles();

//			 files.forEach(fileVO ->{
//				 session.insert(PRE + mapperName + ".insertFile", fileVO);
//			 });

			if(files != null && files.size() >0) {
				
				for (MsgFileVO fileVO : files) {
					session.insert(PRE + mapperName + ".insertFile", fileVO);
					log.info("insert file....");
				}
			}

			log.info("commiting");
			// 수동으로 커밋한다.
			session.commit();
			log.info("committed");

		} catch (Exception e) {
			// 대신 문제가 있으면 위의일 아무것도 안하고 롤백하여 보호한다.
			session.rollback();
			throw e;
		} finally {
			// 수동으로 연만큼 닫아주는거 잊지 않는다.
			session.close();
		}
	}
	
	public List<MsgVO> selectReceiveList(String userName){
		
		List<MsgVO> result = null;
		
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			result = session.selectList(PRE + mapperName + ".receiveList", userName);

		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}
	
}
