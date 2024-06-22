<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지 입니다.</title>
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
		<form action="./modifyBoard.do" method="post">
			<input type="hidden" name="seq" value="${dto.seq}">
			<table>
				<thead>
					<tr>
						<td style="width: 20%;">아이디</td>
						<td style="width: 70%; text-align: left; font-weight: bold;">
							${dto.id}
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td >제목</td>
						<td>
							<input type="hidden" name="title" id="title" value="${dto.title}">
							${dto.title}
						</td>
					</tr>
					<tr>
						<td >내용</td>
						<td>
							<textarea rows="7" cols="300" name="content" id="content">${dto.content}</textarea>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" style="text-align: center;">
							<input type="button" value="수정" onclick="modifyForm()">
							<input type="button" value="취소" onclick="location.href='./detailBoard.do?seq=${dto.seq}';">
						</td>
					</tr>
				</tfoot>				
			</table>
		</form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>