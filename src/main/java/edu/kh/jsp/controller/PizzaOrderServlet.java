package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pizzaOrder")
public class PizzaOrderServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String size = req.getParameter("size"); // R / L
		
		int amount = Integer.parseInt(req.getParameter("amount"));
		// 숫자형태 String -> int 변환 "2" -> 2
		
		// 기본(10000원) + 사이즈(0 or 2000) * 수량(1~10)
		int temp = 0;
		if(size.equals("L")) temp = 2000;
		// 피자 사이즈가 L이라면 temp는 2000
		
		int total = (10000 + temp) * amount;
		// 총합 구하기
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/orderResult.jsp");
															// 여기서 오타나면 404 Not Found
		req.setAttribute("tot", total);
		
		// req, resp 객체 JSP로 위임
		dispatcher.forward(req, resp);
		// req - 파라미터, tot
		// resp - 응답용 스트링
		
		
		
		
		
		
	}
	
}
