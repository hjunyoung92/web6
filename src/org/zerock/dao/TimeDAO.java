package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;

public class TimeDAO {
	
	private static final String PRE = "org.zerock.dao.";
	protected String mapperName = "TimeMapper";
	
	public String getTime() throws Exception{
		
		
		String result = "";
		
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession()){
		
			result = session.selectOne( PRE + mapperName + ".getTime");
			
		} catch (Exception e) {
			throw e;
		}

		
		return result;
	}
}
