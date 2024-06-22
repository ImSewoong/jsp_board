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
public class DuplicateServlet extends HttpServlet {

	private static final long serialVersionUID = 1738503178630638547L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DuplicateServlet GET 요청");
		String id = req.getParameter("id");
		log.info("요청받은 값 : "+id);
		
		IUserInfoDao dao = new UserInfoDaoImpl();
		String checkId = dao.duplicateId(id);
		boolean isc = false;
		if(checkId == null) {
			isc = true;
		}
		req.setAttribute("isc", isc);
		req.getRequestDispatcher("/WEB-INF/views/idCheck.jsp").forward(req, resp);
	}
	
	
}
