package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.EduBoardDto;
import com.min.edu.dto.PaginDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainpageServlet extends HttpServlet {

	private static final long serialVersionUID = -5312684051564268014L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("BoardListServlet GET : 모든 게시글 조회");
		IBoardDao dao = new BoardDaoImpl();
		
		String page = req.getParameter("page");
		if(page == null) {
			page = "1";
		}
		int selectPage = Integer.parseInt(page);
		
		
		PaginDto p = new PaginDto();
		p.setTotalCount(dao.countMyBoard()); 
		p.setCountList(5); 
		p.setCountPage(5); 
		p.setTotalPage(p.getTotalCount());
		p.setPage(selectPage);
		p.setStagePage(selectPage);
		p.setEndPage(p.getCountPage());

		

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", p.getPage()*p.getCountList() -(p.getCountPage()-1)); 
		map.put("last", p.getPage()*p.getCountList()); 
		List<EduBoardDto> lists = dao.selectAllBoard(map);
		req.setAttribute("lists", lists);
		req.setAttribute("page", p);
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
	}
	
}
