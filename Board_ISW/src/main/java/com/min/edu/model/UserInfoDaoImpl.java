package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.database.SqlSessionFactoryCreate;
import com.min.edu.dto.EmpInfoDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserInfoDaoImpl implements IUserInfoDao {

	private SqlSessionFactory factory = SqlSessionFactoryCreate.getFactory();
	private final String NS ="com.min.edu.model.UserInfoDaoImpl.";
	
	@Override
	public EmpInfoDto login(Map<String, Object> map) {
		log.info("UserInfoDaoImpl 로그인 : " +map);
		SqlSession session = factory.openSession();
		return session.selectOne(NS+"login", map);
	}

	@Override
	public int insertUser(EmpInfoDto dto) {
		log.info("insertUser 회원가입 : "+dto);
		SqlSession session = factory.openSession(true);
		return session.insert(NS+"insertUser",dto);
	}

	@Override
	public String duplicateId(String id) {
		log.info("duplicateId 아이디 중복체크 :"+id);
		SqlSession session = factory.openSession();
		return session.selectOne(NS+"duplicateId",id);
	}

	@Override
	public List<EmpInfoDto> userListSelectAll(Map<String, Object> map) {
		log.info("userListSelectAll 유저 정보 조회 : "+map);
		SqlSession session = factory.openSession();
		return session.selectList(NS+"userListSelectAll",map);
	}

	@Override
	public int userTotalCount() {
		log.info("userTotalCount");
		SqlSession session = factory.openSession();
		return session.selectOne(NS+"userTotalCount");
	}

	@Override
	public int delUser(String name) {
		log.info("사용자 삭제 :" + name);
		SqlSession session = factory.openSession(true);
		return session.delete(NS+"delUser",name);
	}

	@Override
	public int okUser(String name) {
		log.info("사용자 삭제 :" + name);
		SqlSession session = factory.openSession(true);
		return session.update(NS+"okUser",name);
	}

	@Override
	public int noUser(String name) {
		log.info("사용자 삭제 :" + name);
		SqlSession session = factory.openSession(true);
		return session.update(NS+"noUser",name);
	}
	
	
	
}





