package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.model.IUserInfoDao;
import com.min.edu.model.UserInfoDaoImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class UserDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 2380523506118362856L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserDeleteServlet Post");
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("userId");
		
		log.info("탈퇴할 회원: {}",id);
		
		IUserInfoDao dao = new UserInfoDaoImpl();
		int n = dao.delUser(id);
		
		if(n==1) {
			resp.sendRedirect("./userListsBoard.do");
		}else {
			resp.sendRedirect("/WEB-INF/views/error.html");
		}
		
		
	}
	
}
