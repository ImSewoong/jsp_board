package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.EduBoardDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DetailBoardServlet extends HttpServlet {

	private static final long serialVersionUID = -3818823526637674461L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DetailBoardServlet 글 상세 GET");
		String seq = req.getParameter("seq");
//		log.info("전송된 요청값 {}",seq);
		
		IBoardDao dao = new BoardDaoImpl();
		EduBoardDto dto = dao.selectDetailBoard(seq);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
		
	}

}
