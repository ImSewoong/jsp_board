<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 조회</title>

</head>
<%@ include file="./header.jsp" %>
<script type="text/javascript">
    function okUser(button) {
        var frm = button.closest('form');
        frm.action = "./userUpdate.do";
        frm.method = "post";
        if (confirm("유저를 승인하시겠습니까?")) {
            frm.submit();
        } else {
            alert("승인이 취소 되었습니다.");
        }
    }
    
    function delUser(button) {
        var frm = button.closest('form');
        frm.action = "./userDelete.do";
        frm.method = "post";
        if (confirm("유저를 탈퇴 하시겠습니까?")) {
            frm.submit();
        } else {
            alert("탈퇴가 취소 되었습니다.");
        }
    }
</script>
<style type="text/css">
	img{
		width: 60px;
		height: 70px;
	}
	
	button {
		margin-left: 10px;
	}
</style>

<body>
	<div id="container" class="container">
		<a href="./mainBoard.do">뒤로가기</a>
		
			<table>
				<thead>
					<tr>
						<th>사진</th>
						<th>id</th>
						<th>이름</th>
						<th>password</th>
						<th>전화번호</th>
						<th>상태</th>
						<th colspan="2">권한</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="size" value="${fn:length(lists)}"/>
					<c:if test="${size == 0 }">
								<tr>
									<td colspan="7" style="color: blue; font-size: 8px; text-align: center;"> -- 사용자가 없습니다. --</td>
								</tr>
					</c:if>	
						<c:if test="${size ne 0 }">
							<c:forEach var="dto" items="${lists}" varStatus="vs">
								<tr>
									<td><img alt="${dto.id}" src="./upload/${dto.photo}"></td>
									<td>${dto.id}</td>
									<td>${dto.name}</td>
									<td>${dto.password}</td>
									<td>${dto.phone}</td>
									<td>${dto.enable}</td>
									<td>${dto.auth}</td>
									<td>
										<form>
		                                    <input type="hidden" name="userId" value="${dto.id}">
		                                    <button type="button" onclick="okUser(this)">회원 승인</button>
		                                    <button type="button" onclick="delUser(this)">회원 탈퇴</button>
		                                </form>
									</td>
								<tr>
							</c:forEach>
					</c:if>
				</tbody>
			</table>
		
		<div style="font-size: 20px; text-align: center; margin-top: 30px;">
			<ul >
				<fmt:parseNumber var="num3" integerOnly="true" value="${(page.totalPage-1) / page.countPage}" />
				<fmt:parseNumber var="num4" integerOnly="true" value="${(page.page-1) / page.countPage}" />
				
				<c:if test="${page.page > 1}">
					<c:choose>
						<c:when test="${(page.stagePage-page.countPage) < 0}">
							<li>
								<a href="./userListsBoard.do?page=1">&lt;</a>
							</li>
						</c:when>
						<c:otherwise>
						<li>
							<a href="./userListsBoard.do?page=${page.stagePage-page.countPage}">&lt;</a>
						</li>
						</c:otherwise>
					</c:choose>
				</c:if>
				
				<c:forEach var="i" begin="${page.stagePage}" end="${page.endPage}" step="1">
		            <li ${i==page.page?"class='active'":""}>
		            	<a href="./userListsBoard.do?page=${i}">${i}</a>
		            </li>
		         </c:forEach>
		         
				<fmt:parseNumber var="num1" integerOnly="true" value="${(page.totalPage-1) / page.countPage}" />
				<fmt:parseNumber var="num2" integerOnly="true" value="${(page.page-1) / page.countPage}" />
				
				<c:if test="${num1 > num2}">
					<li>
						<a href="./userListsBoard.do?page=${page.stagePage + page.countPage}">&gt;</a>
					</li>
				</c:if>
				
			</ul>
		</div>
		
	</div>
			
</body>
<%@ include file="./footer.jsp" %>
</html>