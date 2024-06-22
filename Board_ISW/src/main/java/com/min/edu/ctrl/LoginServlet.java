package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.EmpInfoDto;
import com.min.edu.model.IUserInfoDao;
import com.min.edu.model.UserInfoDaoImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = 3828164570372890792L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LoginServlet GET요청");
		HttpSession session = req.getSession();
		session.invalidate();
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LoginServlet POST 요청");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String password = req.getParameter("pw");
		
		IUserInfoDao dao = new UserInfoDaoImpl();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", password);
		EmpInfoDto loginDto = dao.login(map);
		log.info("로그인된 정보 {}", loginDto);
		
		if(loginDto == null) {
		    resp.setContentType("text/html; charset=UTF-8");
		    PrintWriter out = resp.getWriter();
		    out.println("<script>alert('회원정보가 없습니다'); location.href='./loginServlet.do';</script>");
		    out.flush();
		    
		} else {
		    HttpSession session = req.getSession();
		    session.setAttribute("loginDto", loginDto);
		    resp.sendRedirect("./mainBoard.do");
		}
		
		
	}
	
	
}
