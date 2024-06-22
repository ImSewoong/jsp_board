package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = -984601849166695005L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("RealDeleteServlet 관리자 DB 삭제 POST");

		String seq = req.getParameter("seq");
		log.info("전달받은 요청 값 {}", seq);

		IBoardDao dao = new BoardDaoImpl();
		Boolean isc = dao.deleteBoard(seq);

		if (isc) {
			resp.sendRedirect("./mainBoard.do");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/error.html").forward(req, resp);
		}

	}

}
