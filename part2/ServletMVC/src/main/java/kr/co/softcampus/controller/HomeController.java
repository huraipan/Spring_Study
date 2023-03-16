package kr.co.softcampus.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.softcampus.model.Test2Service;

import java.io.IOException;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 요청한 주소를 가져온다.
		String url = request.getRequestURI();
		// View로 사용할 JSP
		String viewName = null;
		
		if(url.contains("main.mvc")) {
			// System.out.println("request main");
			viewName = "main.jsp";
		}else if(url.contains("test1.mvc")) {
			//System.out.println("request test1");
			String str1 = request.getParameter("data1");
			String str2 = request.getParameter("data2");
			
			int number1 = Integer.parseInt(str1);
			int number2 = Integer.parseInt(str2);
			
			int result = number1 + number2;
			
			request.setAttribute("result", result);
			
			viewName = "test1.jsp";
		}else if(url.contains("test2.mvc")) {
			//System.out.println("request test2");
			
			// 모델 요청
			int result = Test2Service.minus(request);
			
			request.setAttribute("result", result);
			
			
			viewName = "test2.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewName);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
