package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class SignUp extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");
 
		 String result = null;
		 String result2 = null;
		 
		 String inputId = req.getParameter("inputId");
		 String inputPw = req.getParameter("inputPw");
		 String inputPw2 = req.getParameter("inputPw");
		 String inputName = req.getParameter("inputName");
		 String inputEmail = req.getParameter("inputEmail");
		 String[] inputCheck = req.getParameterValues("ch");
		 
		 System.out.println(inputId);
		 System.out.println(inputPw);
		 System.out.println(inputPw2);
		 System.out.println(inputName);
		 System.out.println(inputEmail);
		 System.out.println(inputCheck);
		
		 
		 if(inputPw.equals(inputPw2)) {
			 result = "회원가입이 완료되었습니다.";
		 } else {
				 result = "정보를 제대로 입력 해주세요.";
			 }
		 
		 for(String check : inputCheck) {
			 result2 += check + " "; 
		 }
			 
	
		 RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
		 
		 req.setAttribute("r", result);
		 req.setAttribute("r2", result2);
		 
		 dispatcher.forward(req, resp);
		 
		
	} 
	}


