package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.EduBoardDto;
import com.min.edu.dto.EmpInfoDto;
import com.min.edu.dto.PaginDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyBoardListsServlet extends HttpServlet {

	private static final long serialVersionUID = -2356107220070841625L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("MyBoardListsServlet GET 요청");
		
		IBoardDao dao = new BoardDaoImpl();
		
		HttpSession session = req.getSession();

		EmpInfoDto loginDto = (EmpInfoDto) session.getAttribute("loginDto");
        String id = loginDto.getId();
	   
	    log.info("받은 값 :"+id);
        
		String page = req.getParameter("page");
		if(page == null) {
			page = "1";
		}
		
		int selectPage = Integer.parseInt(page);
		
		PaginDto p = new PaginDto();
		p.setTotalCount(dao.countMyBoardList(id)); 
		p.setCountList(5); 
		p.setCountPage(5); 
		p.setTotalPage(p.getTotalCount());
		p.setPage(selectPage);
		p.setStagePage(selectPage);
		p.setEndPage(p.getCountPage());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", p.getPage()*p.getCountList() -(p.getCountPage()-1)); 
		map.put("last", p.getPage()*p.getCountList()); 
		map.put("id", id);
		
		List<EduBoardDto> lists = dao.selectMyBoard(map);
		req.setAttribute("lists", lists);
		req.setAttribute("page", p);
		
		req.getRequestDispatcher("/WEB-INF/views/myBoard.jsp").forward(req, resp);
	}
	
	
}
