package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.database.SqlSessionFactoryCreate;
import com.min.edu.dto.EmpInfoDto;
import com.min.edu.model.IUserInfoDao;
import com.min.edu.model.UserInfoDaoImpl;

public class EmpInfo_JUnitTest {

	private SqlSession session;
	private IUserInfoDao dao;
	
	@Before
	public void SqlSession_Test() {
		SqlSessionFactory factory = SqlSessionFactoryCreate.getFactory();
		session = factory.openSession();
		
		dao = new UserInfoDaoImpl();
		assertNotNull(session);
	}
	
//	@Test
	public void login_Test() {
		IUserInfoDao dao = new UserInfoDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "바보");
		map.put("pw", "1234");
		EmpInfoDto loginDto = dao.login(map);
		assertNotNull(loginDto);
	}
	
//	@Test
	public void insertUser_Test() {
		EmpInfoDto dto = new EmpInfoDto("바보2", "1234", "메롱", "000", "8515f0ccac964d96b79fa164999f82a9.png");
		int n = dao.insertUser(dto);
		assertNotEquals(0, n);
	}
	
	
//	@Test
	public void duplicateId_Test() {
		String idchk = dao.duplicateId("바보");
		assertNotNull(idchk);
	}
	
//	@Test
	public void userListSelectAll_Test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 1);
		map.put("last", 5);
		List<EmpInfoDto> lists = dao.userListSelectAll(map);
		assertNotNull(lists);
	}
	
//	@Test
	public void userTotalCount_Test() {
		int n = dao.userTotalCount();
		assertNotEquals(0, n);
	}
	
//	@Test
	public void delUser_Test() {
		int n = dao.delUser("바보");
		assertNotEquals(0, n);
	}
	
//	@Test
	public void noUser_Test() {
		int n = dao.noUser("바보");
		assertNotEquals(0, n);
	}
	
	@Test
	public void okUser_Test() {
		int n = dao.okUser("바보");
		assertNotEquals(0, n);
	}
	
	
	
}








