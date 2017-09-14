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
	
	<h2 class = "main title">1:1문의 작성</h2>
	
	<form id = "LetterInputForm" method="post" >
	
	<table class="table table-hot">
		<tr>
			<th class="w80">순번</th> 
			<td>${num}</td>
		</tr>	
		
		<tr>
			<th class="w80">아이디</th> 
			<td>${id}</td>
		</tr>
		
		<tr>
			<th class="w80">제목</th> 
			<td><input name = "title"/></td>
		</tr>
		
		<tr>
			<th class="w80">질문</th> 
			<td><textarea name = "content"></textarea></td>
		</tr>
		

		</table>
	
	
	<table border="1" align="center">
	<tr>
		<td>
	
	<input type="hidden" name="id" value="${id}"/>
	<input type="hidden" name="num" value="${num}"/>
	<input type="submit" value="전송"/>
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