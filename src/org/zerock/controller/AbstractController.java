package org.zerock.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;


@Log4j
public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AbstractController() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String jspName = null;
		try {
			jspName = execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(jspName.startsWith("redirect:")) {
			String targetURL = jspName.substring(9);
			response.sendRedirect(targetURL);
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/" + jspName + ".jsp");
		dispatcher.forward(request, response);
	}

	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		log.info("boardController execute...");
		
		String way = request.getMethod();		
		String path = request.getServletPath();
		String methodName = request.getPathInfo();
		
		log.info("way : " + way);
		log.info("path : " + path);
		log.info("method name : " + methodName);
		
		
		String  target = (methodName + way).substring(1);
		
		//리플랙션, 메소드이름을 아니 메소드 이름으로 클래스를 찾아 들어간다. 클래스 이름이 곧 jsp이름이기에 리플렉트로 찾는다.
		Class clz = this.getClass();
		
		Method targetMethod = clz.getDeclaredMethod(target, HttpServletRequest.class, HttpServletResponse.class);
		
		//invoke는 에러가 뜰수 있다. 오브젝트를 돌려주는걸 String으로 다운캐스팅
		String result = (String)targetMethod.invoke(this, request, response);
		//단점 POST방식을 알 수 없다.
		
		return result;
	}
	
	protected Integer getInt(String paramName, HttpServletRequest request,int defaultValue) {
		
		Integer result = getInt(paramName, request);
		if(result == null) {
			return defaultValue;
		}
		return result;
	}
	
	protected Integer getInt(String paramName, HttpServletRequest request) {
		
		Integer result = null;
		
		try {
			result = Integer.parseInt(request.getParameter(paramName));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return result;
	}
}
