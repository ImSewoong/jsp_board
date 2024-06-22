<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 화면</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/regist.js"></script>
</head>
<style type="text/css">
	table {
		width: 400px;
		margin: 200px auto;
		border-collapse: separate;
        border-spacing: 10px; 
	}
	tr, td, th{
		border: 1px solid black;
		padding : 10px;
	}
</style>
<body>
	<form method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" id="id" title="n" placeholder="아이디를 입력하세요">
					<input type="button" name="idchk"  value="중복검사" onclick="idCheck()">
					<div id="idChk">
					</div>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" id="name" placeholder="이름을 입력하세요">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요">
				</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>
					<input type="text" name="phone" id="phone" placeholder="전화번호">
				</td>
			</tr>
			<tr>
				<th>본인 사진</th>
				<td>
					<input type="file" name="img" id="imgName" value="사진입력" multiple="multiple">
				</td>
			</tr>
			<tr style="text-align: center;">
				<td colspan="2" >
					<input type="submit" value="가입">
					<input type="button" value="취소"> 
				</td>
			</tr>
		</table>
	</form>
	
	
</body>
	
</html>