package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.EmpInfoDto;
import com.min.edu.dto.PaginDto;
import com.min.edu.model.IUserInfoDao;
import com.min.edu.model.UserInfoDaoImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserListsBoardServlet extends HttpServlet {

	private static final long serialVersionUID = -454833741166428347L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserListServlet GET 요청");
		
		IUserInfoDao dao = new UserInfoDaoImpl();
		
		String page = req.getParameter("page");
		if(page == null) {
			page = "1";
		}
		int selectPage = Integer.parseInt(page);
		
		
		PaginDto p = new PaginDto();
		p.setTotalCount(dao.userTotalCount()); 
		p.setCountList(5); 
		p.setCountPage(5); 
		p.setTotalPage(p.getTotalCount());
		p.setPage(selectPage);
		p.setStagePage(selectPage);
		p.setEndPage(p.getCountPage());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", p.getPage()*p.getCountList() -(p.getCountPage()-1)); 
		map.put("last", p.getPage()*p.getCountList()); 
		
		List<EmpInfoDto> lists = dao.userListSelectAll(map);
		req.setAttribute("lists", lists);
		req.setAttribute("page", p);
		
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/userList.jsp").forward(req, resp);
		
		
		
	}
	
}
