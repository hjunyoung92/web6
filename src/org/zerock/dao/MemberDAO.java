package org.zerock.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.util.ParameterMap;
import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.MemberVO;
import org.zerock.domain.MsgFileVO;
import org.zerock.domain.MsgVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberDAO {
	private static final String PRE = "org.zerock.dao.";
	protected String mapperName = "MemberMapper";

	
	public List<String> getUserList(){
		List<String> result = null;
		
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			result = session.selectList(PRE + mapperName + ".userlist");

		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}
	public void insert(MemberVO mvo) {
		log.info(mvo);

		SqlSession session = null;

		// openSession을 true로 안하는 대신 수동으로 session.commit()한다.
		try {
			session = MyBatisLoader.sqlSessionFactory.openSession(true);

			session.insert(PRE + mapperName + ".insert", mvo);
	
			session.commit();
			
		} catch (Exception e) {
			// 대신 문제가 있으면 위의일 아무것도 안하고 롤백하여 보호한다.
			session.rollback();
			throw e;
		} finally {
			// 수동으로 연만큼 닫아주는거 잊지 않는다.
			session.close();
		}
	}
	public MemberVO selectOne(String mid, String mpw) {
		MemberVO result = null;
		
		Map<String,String> paramMap = new HashMap <>();
		paramMap.put("mid", mid);
		paramMap.put("mpw", mpw);
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			result = session.selectOne(PRE + mapperName + ".read", paramMap);

		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}
}
