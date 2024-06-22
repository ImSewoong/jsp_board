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
public class UserUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = -1271932511298960093L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    log.info("UserUpdateServlet 유저 승인POST");
	    req.setCharacterEncoding("UTF-8");
	    
	    
	    String id = req.getParameter("userId");
	    
	    if (id != null) {
	        log.info("승인 회원 아이디 : " + id);
	    } else {
	        log.info("userId 파라미터가 전달되지 않았습니다.");
	    }
	    
	    IUserInfoDao dao = new UserInfoDaoImpl();
	    
	    int n = dao.okUser(id);
	    
	    if(n==1) {
	    	resp.sendRedirect("./userListsBoard.do");
	    }else {
	    	resp.sendRedirect("/WEB-INF/views/error.html");
	    }
	    
	}
}


