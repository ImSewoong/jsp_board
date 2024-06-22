package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.min.edu.model.IUserInfoDao;
import com.min.edu.model.UserInfoDaoImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdCheckAjaxServlet extends HttpServlet {

	private static final long serialVersionUID = 4865855859083364775L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("중복검사 Ajax 처리");
		String id = req.getParameter("id");
		
		IUserInfoDao dao = new UserInfoDaoImpl();
		
		
		boolean isc = (dao.duplicateId(id) == null)?false:true;
		
		JSONObject json = new JSONObject();
		json.put("isc", isc);
		
		
		resp.getWriter().print(json.toJSONString());
		
		
	}

}
