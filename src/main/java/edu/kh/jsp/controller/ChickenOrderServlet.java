package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chickenOrder")
public class ChickenOrderServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
	
		String side = req.getParameter("side");
		int amount = Integer.parseInt(req.getParameter("amount"));
		int total=0;
		 
		
		if(side.equals("s")) {
			 total = (20000 + 5000) * amount;
		} else if(side.equals("h")) {
			 total = (20000 + 3000) * amount;
		} else if(side.equals("m")) {
			 total = (20000 + 500) * amount;
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/orderResult2.jsp");
		req.setAttribute("tot", total);
		dispatcher.forward(req, resp);
	}
	
	
	
}
