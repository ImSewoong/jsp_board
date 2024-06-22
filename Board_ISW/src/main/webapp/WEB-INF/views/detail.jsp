<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 조회</title>
</head>
<%@ include file="./header.jsp" %>
<style type="text/css">
	table, tr, td {
        margin: 0px;
        padding: 0px;
    }

    form {
        width: 65%;
        margin: 0 auto;
        padding: 20px;
        background-color: #f9f9f9;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    thead td {
        padding: 10px;
        border-bottom: 2px solid #ddd;
        background: #D9F0FF;
        font-weight: bold;
    }

    tbody td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
    }

    tfoot td {
        padding: 10px;
    }

    input[type="text"], textarea {
        width: calc(100% - 22px);
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    textarea {
        resize: none;
    }

    input[type="button"] {
        padding: 10px 20px;
        margin: 10px 5px;
        border: none;
        border-radius: 5px;
        background-color: #007bff;
        color: white;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="button"]:hover, input[type="reset"]:hover {
        background-color: #0056b3;
    }
</style>
<body>
	<div id="container" class="container">
		<a href="./mainBoard.do">뒤로가기</a>
		<table>
			<thead>
				<tr>
					<td>연번</td>
					<td>작성자</td>
					<td>제목</td>
					<td>날짜</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${dto.seq}</td>
					<td>${dto.id}</td>
					<td>${dto.title}</td>
					<td>
						<fmt:parseDate var="reg" value="${dto.createat}" pattern="yyyy-MM-dd hh:mm:ss" />
						<fmt:formatDate value="${reg}" pattern="yyyy년 MM월 dd일"/>
					</td>
				</tr>
				<tr>
					<td colspan="4" style="text-align: left; font-weight: bold; background: #D9F0FF;">&nbsp;&nbsp;내용</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea rows="5" cols="20" readonly="readonly">${dto.content}</textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" style="text-align: center;">
						<form style="background: none;">
							<input type="hidden" name="seq" value="${dto.seq}">
							<input type="button" value="삭제" onclick="deleteBoard()">
							<input type="button" value="수정" onclick="modify()">
						</form>
					</td>
				</tr>
			</tfoot>				
		</table>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>