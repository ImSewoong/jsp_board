package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.EduBoardDto;
import com.min.edu.dto.EmpInfoDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WriteBoardServlet extends HttpServlet {

	private static final long serialVersionUID = 1320969207789400297L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("WriteBoardServlet 화면이동 GET");
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("WriteBoardServlet POST");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		EmpInfoDto logindto = (EmpInfoDto)session.getAttribute("loginDto");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		log.info("전달받은 요청값 id {}, title {}, content {}", logindto.getId(), title, content);
		
		IBoardDao dao = new BoardDaoImpl();
		
		EduBoardDto dto = new EduBoardDto();
		dto.setId(logindto.getId());
		dto.setTitle(title);
		dto.setContent(content);
		
		boolean isc = dao.insertBoard(dto);
		if(isc) {
			resp.sendRedirect("./mainBoard.do");
		}else {
			resp.sendRedirect("./writeBoard.do");
		}
	}
	
}
