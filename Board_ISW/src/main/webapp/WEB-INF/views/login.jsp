<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<style type="text/css">
	table {
		width: 350px;
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
	<form action="./loginServlet.do" method="post" >
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" placeholder="아이디">
				</td>			
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pw" placeholder="비밀번호">
				</td>			
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href='./registform.do';">
				</td>			
			</tr>
		</table>
			
	</form>
</body>


</html>