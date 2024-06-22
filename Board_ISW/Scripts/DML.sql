-- 로그인 login
SELECT ID, PASSWORD , NAME , PHONE , ENABLE ,AUTH 
	FROM EMPINFO e 
	WHERE e.ID = '바보' AND PASSWORD = '1234';
	


-- 전체 글 조회 selectAllBoard
SELECT SEQ, ID, TITLE, CONTENT, DELFLAG, CREATEAT
		FROM(
			SELECT SEQ, ID, TITLE, CONTENT, DELFLAG, TO_CHAR(CREATEAT, 'YYYY-MM-DD HH:MI:SS') AS CREATEAT,
				ROW_NUMBER() OVER(ORDER BY SEQ DESC) RN
			FROM EDUBOARD
		)
		WHERE RN BETWEEN 1 AND 5;

-- countMyBoard
SELECT COUNT(*) 
		FROM EDUBOARD;	

-- 상세 글 조회 selectDetailBoard
SELECT SEQ, ID, TITLE, CONTENT , DELFLAG ,TO_CHAR(CREATEAT, 'YYYY-MM-DD HH:MI:SS') AS CREATEAT 
	 FROM EDUBOARD 
	 WHERE SEQ = '1';
	
-- 글 수정 modifyBoard
UPDATE EDUBOARD SET CONTENT = '나는 바보입니다'
 	WHERE SEQ = '1';
 
-- DB에서 글 삭제 deleteBoard
DELETE FROM EDUBOARD
		WHERE SEQ = '1';
	
-- 다중 글 삭제 mutiDeleteBoard
UPDATE EDUBOARD SET DELFLAG ='Y'
 	WHERE SEQ IN ('2','3');

	
-- 글입력 insertBoard
INSERT INTO EDUBOARD (SEQ, ID, TITLE, CONTENT, DELFLAG, CREATEAT)
		VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM EDUBOARD), '바보', '글제목', '글내용', 'N', SYSDATE);
	

	
-- 사용자 입력 insertUser
INSERT INTO EMPINFO e (ID, PASSWORD, NAME, 
						PHONE, ENABLE , AUTH)
	   VALUES('TEST', 'TEST', 'TEST', '000', 'D','USER');
	  
--아이디 중복체크 duplicateId
SELECT *
	FROM EMPINFO e
	WHERE ID = '바보';

-- 전체 userTotalCount
SELECT COUNT(*) 
	FROM EMPINFO e;

-- userListSelectAll
SELECT ID, PASSWORD , 
	NAME , PHONE , ENABLE , AUTH
	FROM(SELECT ID, PASSWORD , NAME , 
				PHONE , ENABLE , AUTH,
				ROW_NUMBER() OVER(ORDER BY ID) RN
				FROM EMPINFO)
	WHERE RN BETWEEN 1 AND 5;

-- 사용자 탈퇴
UPDATE EMPINFO e SET ENABLE='N'
WHERE ID = '바보';

-- 사용자 승인
UPDATE EMPINFO e SET ENABLE='Y'
WHERE ID = '바보';

-- 사용자 거부 
UPDATE EMPINFO e SET ENABLE='F'
WHERE ID = '바보';		

-- 내가 쓴 글 조회
SELECT SEQ, ID, TITLE, CONTENT, DELFLAG, CREATEAT
		FROM(
			SELECT SEQ, ID, TITLE, CONTENT, DELFLAG, TO_CHAR(CREATEAT, 'YYYY-MM-DD HH:MI:SS') AS CREATEAT,
				ROW_NUMBER() OVER(ORDER BY SEQ DESC) RN
			FROM EDUBOARD
		)
		WHERE RN BETWEEN 1 AND 5
		AND ID = '바보';




	