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
	
	<h2 class = "main title">개인정보관리</h2>
	
	<form id = "InfoForm" method="post" >
		<table class="table table-hot">
		<tr>
			<th class="w80">아이디</th> 
			<td>${m.id}</td>
		</tr>	
		
		<tr>
			<th class="w80">비밀번호</th> 
			<td>*******</td>
		</tr>
		
		<tr>
			<th class="w80">이름</th> 
			<td>${m.name}</td>
		</tr>
		
		<tr>
			<th class="w80">이메일</th> 
			<td><input name = "email" value ="${m.email}"></td>
		</tr>
		
		<tr>
			<th class="w80">닉네임</th> 
			<td><input name = "nickname" value ="${m.nickname}"></td>
		</tr>
		

		</table>
		
	<table border="1" align="center">
	<tr>
		<td>
	
		<input type="submit" value="전송"/>
	<!-- 	<a class="btn btn-default" href="myinfo-list">수정하기</a> -->
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