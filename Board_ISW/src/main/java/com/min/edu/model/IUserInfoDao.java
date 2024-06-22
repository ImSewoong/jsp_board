package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.EmpInfoDto;

public interface IUserInfoDao {

	public EmpInfoDto login(Map<String, Object> map);
	
	//사용자 입력
	public int insertUser(EmpInfoDto dto);
	
	//아이디 중복체크 
	public String duplicateId(String id);
	
	//유저 전체 조회
	public List<EmpInfoDto> userListSelectAll(Map<String, Object> map); 
	
	//유저 카운트
	public int userTotalCount();
	
	//사용자 삭제
	public int delUser(String name);
	
	//사용자 승인
	public int okUser(String name);
	
	//사용자 거부
	public int noUser(String name);
	
	
	
}




