<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style-mypage.css" type="text/css" rel="stylesheet" />

</head>
<body>

<!-- 헤더부분 -->
<jsp:include page="../../inc/header.jsp"/>



<div id="body" class="clearfix">
	<div class="content-container">
	
	<h2 class = "main title">MYPAGE</h2>
	
	
	<!-- aside부분 -->
<jsp:include page="../mypage/inc/aside.jsp"/>		
		<!-- 메인부분 -->
	<main id="main">
	
	<h2 class = "main title">1:1문의 현황</h2>
	
	<form id = "LetterForm" method="post" >
		<table class="table table-hot">
		<tr>
			<th class="w80">순번</th>
			<th class="w100 text-left">제목</th>
			<th class="w80">날짜</th>
			<th class="w80">답변여부</th>
		</tr>
		
		<c:forEach var="n" items="${list}">
					<tr>
						<td>${n.number}</td>
						<c:if test="${n.chk eq 'Y'}">
						<td class="title text-left text-indent"><a href="../member/myletter-detail?number=${n.number}">${n.title}</a></td>
						</c:if>
						<c:if test="${n.chk eq 'N'}">
						<td class="title text-left text-indent">${n.title}</td>
						</c:if>
						<td>${n.date}</td>
						<td>${n.chk}</td>
					</tr>
				</c:forEach>
		
		
		</table>
		
	<table border="1" align="center">
	<tr>
		<td>
	
	
		<a class="btn btn-default" href="myletter-reg">작성</a>
		</td>
	
	</tr>
	
	</table>

</form>

<!-- footer부분 -->
<jsp:include page="../../inc/footer.jsp"/>	

	</div>	
</main>

</body>




</html>