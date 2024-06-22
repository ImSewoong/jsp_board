package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.database.SqlSessionFactoryCreate;
import com.min.edu.dto.EduBoardDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardDaoImpl implements IBoardDao {
	
	private SqlSessionFactory factory = SqlSessionFactoryCreate.getFactory();
	private final String NS = "com.min.edu.model.BoardDaoImpl.";
	
	@Override
	public List<EduBoardDto> selectAllBoard(Map<String, Object> map) {
		log.info("BoardDaoImpl selectAllBoard");
		SqlSession session = factory.openSession();
		return session.selectList(NS + "selectAllBoard", map);
	}

	@Override
	public int countMyBoard() {
		log.info("BoardDaoImpl countMyBoard");
		SqlSession session = factory.openSession();
		return session.selectOne(NS+"countMyBoard");
	}

	@Override
	public EduBoardDto selectDetailBoard(String seq) {
		log.info("BoardDaoImpl selectDetailBoard");
		log.info("전달받은 값 : {}", seq);
		SqlSession session = factory.openSession();
		return session.selectOne(NS+"selectDetailBoard", seq);
	}

	@Override
	public boolean modifyBoard(Map<String, Object> map) {
		log.info("BoardDaoImpl modifyBoard");
		log.info("전달받은 값 {}", map);
		SqlSession session = factory.openSession(true);
		int n =session.update(NS+"modifyBoard", map);
		return (n==1)?true:false;
	}

	@Override
	public boolean deleteBoard(String seq) {
		log.info("BoardDaoImpl deleteBoard");
		log.info("전달받은 값 {}",seq);
		SqlSession session = factory.openSession(true);
		int n = session.delete(NS+"deleteBoard", seq);
		return (n==1)?true:false;
	}

	@Override
	public boolean mutiDeleteBoard(List<String> list) {
		log.info("BoardDaoImpl mutiDeleteBoard");
		log.info("전달받은 값 {}", list);
		SqlSession session = factory.openSession(true);
		int n = session.delete(NS+"mutiDeleteBoard", list);
		return (n>0)?true:false;
	}

	@Override
	public boolean insertBoard(EduBoardDto dto) {
		log.info("BoardDaoImpl insertBoard");
		log.info("전달받은 값 {}", dto);
		SqlSession session = factory.openSession(true);
		int n = session.insert(NS+"insertBoard", dto);
		return (n==1)?true:false;
	}
	
	//추가 한 거임 확인 해야함
	@Override
	public List<EduBoardDto> selectMyBoard(Map<String, Object> map) {
		log.info("BoardDaoImpl selectMyBoard"+map);
		SqlSession session = factory.openSession();
		return session.selectList(NS + "selectMyBoard", map);
	}
	
	@Override
	public int countMyBoardList(String name) {
		SqlSession session = factory.openSession();
		return session.selectOne(NS + "countMyBoardList",name);
	}
	
}
