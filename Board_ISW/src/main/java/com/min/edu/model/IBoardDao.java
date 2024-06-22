package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.EduBoardDto;

public interface IBoardDao {

	//전체글조회
	public List<EduBoardDto> selectAllBoard(Map<String, Object> map);
	
	//글갯수조회
	public int countMyBoard();
	
	//상세글조회
	public EduBoardDto selectDetailBoard(String seq);
	
	//글수정
	public boolean modifyBoard(Map<String, Object> map);
	
	//DB 글삭제     
	public boolean deleteBoard(String seq);
	
	//다중 글삭제
	public boolean mutiDeleteBoard (List<String> list);
	
	//글입력   
	public boolean insertBoard(EduBoardDto dto);
	
	
	//내가 쓴 글 조회
	public List<EduBoardDto> selectMyBoard(Map<String, Object> map);
	
	//내 글 조회
	public int countMyBoardList(String name);
}









