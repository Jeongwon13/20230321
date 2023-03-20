package edu.kh.jsp.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
// 1. extends
// 2. 어노테이션
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login") // web.xml에 작성하던 <servlet>, <servlet-mapping> 태그 대체 어노테이션
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// post 방식 요청 데이터 문자 인코딩 처리
		// 왜 req에 있는가?
		req.setCharacterEncoding("UTF-8");
		
		// 전달 받은 파라미터를 얻어와 변수에 저장
		String id = req.getParameter("inputId");
		String pw = req.getParameter("inputPw");
		
		System.out.println(id);
		System.out.println(pw);
		
		String result = null;
		
		if(id.equals("user01") && pw.equals("pass01!")) {
			result = "로그인 성공";
	} else {
		result = "아이디 또는 비밀번호 불일치";
	}
	
		
//		// 6. 응답 데이터 문서 형식, 문자 인코딩 지정
//		resp.setContentType("text/html; charset=UTF-8");
//		
//		// 응답용 스트림 얻어오기
//		PrintWriter out = resp.getWriter();
		
		// 위에 이제 안쓰고 JSP 사용해서 응답할거임~
		
		//===========================================================
		// *** JSP로 응답하기 *** vscode로 고고~
		
		// Dispatcher: 발송자, 필요한 정보를 제공하는 자
		// RequestDispatcher == 요청을 위임하는 역할의 객체
		// -> (정확히는 요청에 대한 응답 화면을 만들어서 클라이언트에게 출력하는 역할)을 위임하는 객체
		// (< >) 귀찮게 썼던 이 역할을 위임한다는 뜻.
		
		// req.getRequestDispatcher("JSP 경로")
		// - HttpServletRequest 객체가 생성될 때 내부에 요청을 위임하는 객체를 생성하는 방법을 포함하고 있다.
		
		// ** JSP 경로 작성 방법 **
		// -  webapp 폴더를 기준으로 파일 경로 작성
		
		// forward: 보내다 전달하다 전송하다
		// - forward의 역할은 페이지 이동이 아닌 값을 전달하는 것
		// Servlet의 역할 중 하나가 화면에 출력하는게 있는데
		// forward는 JSP에게 req, resp를 전달만 해주는 역할
		// 전달받은 JSP 응답을 대신 하는 것 뿐.
		// 결론: 페이지 이동하는 것이 아니고 -> 주소창에 요청 주소도 변경되지 않는다!!! // 이해 안됨
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp"); // 알바의 역할- 셰프에게 갖다 주지는 않고 경로만 지정함 //알바를만든거 파란색경로가 쉐프가 있는 곳
		
		// 만약 forward 하기 전에 뭐 다른거 더 줄게 있으면 forward 전에 도시락 여기서 쌈
		// req.setAttribute(String key, Object value)
						// 모든 타입 가능
		req.setAttribute("r", result); // r은 자기 마음대로 정해
						// result 업캐스팅 되어있는 상태 String => Object
		// 받는 쪽은 다운캐스팅...
		
		
		dispatcher.forward(req, resp); // 여기가 알바가 진짜 일을 한거 // 진짜로 갖다준게 forward 한거
		// req는 도시락처럼 끼워 넣어서 전달해줄 수 있는 거 // 웨이터가 알바한테 req.setAttribute("빨간도시락","도시락내용물) K:V
		// 쉐프가 도시락 까보는거셈
		// 쉐프가 음식 만들고 손님한테 다이렉트로 전달해줌(웨이터=서블릿을 거치지 않음) // 이게 web.xml임
		
		// 웨이터 = 서블릿, 쉐프 = JSP 
		// 웨이터가 알바를 씀 얘가 Dispatcher
		
		// 위에 순서가 정말 중요해 RequestDispatcher -> setAttribute -> forward
		
 	
	}
}
 