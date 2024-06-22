package com.test.edu;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.database.SqlSessionFactoryCreate;
import com.min.edu.dto.EduBoardDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

public class EduBoard_JUnitTest {

	SqlSession session;
	IBoardDao dao;

	@Before
	public void SqlSession_JUnitTest() {
		SqlSessionFactory factory = SqlSessionFactoryCreate.getFactory();
		SqlSession session = factory.openSession();
		
		dao = new BoardDaoImpl();
		assertNotNull(session);
	}
	
//	@Test
	public void selectAllBoard_JUnitTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 1); 
		map.put("last", 5);
		List<EduBoardDto> lists = dao.selectAllBoard(map);
		assertNotNull(lists);
	}

//  @Test
    public void selectDetailBoard_JUnitTest() {
    	EduBoardDto insertDto = new EduBoardDto();
        insertDto.setId("바보");
        insertDto.setTitle("test title");
        insertDto.setContent("test content");

        boolean isc = dao.insertBoard(insertDto);
        assertTrue(isc);

//      assertNotNull(insertDto.getSeq());
//      System.out.println(insertDto.getSeq());

        EduBoardDto selectDetailDto = dao.selectDetailBoard(String.valueOf(insertDto.getSeq()));
        assertNotNull(selectDetailDto);
    }
    
//  @Test
    public void modifyBoard_JUnitTest() {
        EduBoardDto insertDto = new EduBoardDto();
        insertDto.setId("바보");
        insertDto.setTitle("test");
        insertDto.setContent("test ");

        dao.insertBoard(insertDto);

        Map<String, Object> map = new HashMap<>();
        map.put("seq", String.valueOf(insertDto.getSeq()));
        map.put("content", "글 수정");

        boolean isc = dao.modifyBoard(map);
        assertTrue(isc);
    }
    
//  @Test
    public void deleteBoard_JUnitTest() {
        EduBoardDto insertDto = new EduBoardDto();
        insertDto.setId("바보");
        insertDto.setTitle("test");
        insertDto.setContent("test");

        dao.insertBoard(insertDto);
        boolean isc = dao.deleteBoard(String.valueOf(insertDto.getSeq()));
        assertTrue(isc);
    }
    
//  @Test
    public void multiDeleteBoard_JUnitTest() {
        String[] seqs = {"8", "9", "7"};
        boolean isc = dao.mutiDeleteBoard(Arrays.asList(seqs));
        assertTrue(isc);
    }
	
//	@Test
    public void InsertBoard_JUnittest() {
        EduBoardDto insertDto = new EduBoardDto();
        insertDto.setId("바보");
        insertDto.setTitle("test");
        insertDto.setContent("test");

        boolean isc = dao.insertBoard(insertDto);
        assertTrue(isc);
    }


    @Test
    public void selectMyBoard_JUnitTest() {
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 1); 
		map.put("last", 5);
		map.put("id", "바보");
		List<EduBoardDto> lists = dao.selectAllBoard(map);
		assertNotNull(lists);
    }



  
	 

   
	

}
