<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="./css/main.css">
<script type="text/javascript" src="./js/main.js"></script>
<head>


<style type="text/css">

	#container {
		width: 1100px;
		margin: 50px auto;
		margin-top: 20px;
		height: 570px;
	}
	
	header {
		background: #E39890;
		height: 100px;
	}
	
	footer {
		background: #E39890;
		text-align: center;
		line-height: 20px;
		padding: 20px;
	}

</style>

</head>
<body>
	<header>
		<div style="padding: 30px;">
			<h3 style="display: inline; color:black;">
				<a href="./mainBoard.do">메인페이지로 이동.</a>
			</h3>
			
			<c:choose>
				<c:when test="${empty sessionScope.loginDto}">
				<div style="display: inline; float: right;">
					<button onclick="location.href='./loginServlet.do'">첫 페이지</button>
				</div>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${loginDto.auth eq 'A'}">
							<button onclick="location.href='./userListsBoard.do'">회원 목록 조회</button>
						</c:when>
						<c:otherwise>
							<button onclick="location.href='./myBoardLists.do'">내가 쓴 글 조회</button>
						</c:otherwise>
					</c:choose>
					<div style="display: inline; float: right;">
						<span style="color: black;">
							접속된 아이디: ${loginDto.id}(${loginDto.auth eq 'A'? "관리자":"사용자"})
						</span>
						<button onclick="location.href='./loginServlet.do'">로그아웃</button>
					</div>
				</c:otherwise>
			</c:choose>	
		</div>	
	
	</header>
</body>
</html>


