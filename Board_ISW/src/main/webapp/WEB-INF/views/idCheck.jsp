<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복체크</title>
<script type="text/javascript">
	window.onload = function(){
		var id = opener.document.getElementsByName("id");
		document.getElementById("inputId").textContent=id.value;
	}
	function confirm(){
		var id = opener.document.getElementsByName("id")[0];
		id.title ="y";
		id.disabled = "disabled";
		self.close();
	}
	function cancel(){
		var id = opener.document.getElementsByName("id")[0];
		id.value="";
		id.focus();
		id.title ="n";
		self.close();
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td>
				<div id="inputId"></div>
			</td>
		</tr>
		<tr>
			<td>
				${isc?"사용할 수 있습니다":"사용할 수없습니다"}
			</td>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${isc}">
					<td>
						<input type="button" value="사용하기" onclick="confirm()">
					</td>
				</c:when>
				<c:otherwise>
					<td>
						<input type="button" value="창닫기" onclick="cancel()">
					</td>
				</c:otherwise>
			</c:choose>
			<td>
			
			</td>
		</tr>
	</table>
</body>
</html>