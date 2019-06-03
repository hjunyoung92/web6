package org.zerock.dao;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Application Lifecycle Listener implementation class MyBatisLoader
 *
 */
public class MyBatisLoader {
	
	public static  SqlSessionFactory sqlSessionFactory;
	public int i;
	
	static {
    	String resource = "mybatis-config.xml";
    	InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
