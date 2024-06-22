<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 페이지 보기</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container" class="container">
		<a href="./loginServlet.do">처음 페이지로 이동</a>
		<div class="btn">
		<c:if test="${loginDto.auth eq 'A'}">
			<input type="button" value="다중삭제" onclick="chSubmit()">
		</c:if>
		<input type="button" value="새글입력" onclick="location.href='./writeBoard.do'">
		</div>
		<form action="./multiDelete.do" method="post" onsubmit="return chkSubmit()">
			<table>
				<thead>
					<tr>
						<th><input type="checkbox" id="chkbox" class="allCheckBox" onclick="checkAll(this.checked)" > </th>
						<th>연번</th>
						<th>작성자</th>
						<th>제목</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:length(lists) == 0 }">
								<tr>
									<td colspan="5" style="color: blue; font-size: 15px; text-align: center;"> -- 작성된 글이 없습니다 --</td>
								</tr>
					</c:if>	
						<c:set var="size" value="${fn:length(lists)}"/>
						<c:if test="${fn:length(lists) ne 0 }">
								<c:forEach var="dto" items="${lists}" varStatus="vs">
									<c:if test="${dto.delflag eq 'N'}">
										<tr>
											<td><input type="checkbox" name="ch" class="ch" value="${dto.seq}"></td>
											<td style="width:10%;">${page.totalCount - (page.page-1)*page.countList - vs.index }</td>
											<td style="width:20%;">${dto.id}</td>
											<td style="width:45%;">
												<c:if test="${dto.delflag eq 'N'}">
													<a href="./detailBoard.do?seq=${dto.seq}">${dto.title}</a>
												</c:if>
											</td>
											<td style="width:20%;">
												<fmt:parseDate var="reg" value="${dto.createat}" pattern="yyyy-MM-dd hh:mm:ss" />
												<fmt:formatDate value="${reg}" pattern="yyyy년 MM월 dd일"/>
											</td>
										</tr>
									</c:if>
							</c:forEach>
					</c:if>
				</tbody>
			</table>
		</form>
		
		<div style="font-size: 20px; text-align: center; margin-top: 30px;">
			<ul >
				<fmt:parseNumber var="num3" integerOnly="true" value="${(page.totalPage-1) / page.countPage}" />
				<fmt:parseNumber var="num4" integerOnly="true" value="${(page.page-1) / page.countPage}" />
				
				<c:if test="${page.page > 1}">
					<c:choose>
						<c:when test="${(page.stagePage-page.countPage) < 0}">
							<li>
								<a href="./myBoardLists.do?page=1">&lt;</a>
							</li>
						</c:when>
						<c:otherwise>
						<li>
							<a href="./myBoardLists.do?page=${page.stagePage-page.countPage}">&lt;</a>
						</li>
						</c:otherwise>
					</c:choose>
				</c:if>
				
				<c:forEach var="i" begin="${page.stagePage}" end="${page.endPage}" step="1">
		            <li ${i==page.page?"class='active'":""}>
		            	<a href="./myBoardLists.do?page=${i}">${i}</a>
		            </li>
		         </c:forEach>
		         
				<fmt:parseNumber var="num1" integerOnly="true" value="${(page.totalPage-1) / page.countPage}" />
				<fmt:parseNumber var="num2" integerOnly="true" value="${(page.page-1) / page.countPage}" />
				
				<c:if test="${num1 > num2}">
					<li>
						<a href="./myBoardLists.do?page=${page.stagePage + page.countPage}">&gt;</a>
					</li>
				</c:if>
				
			</ul>
		</div>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>