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
	
	<h2 class = "main title">익명댓글</h2>
	
	<form id = "CommentForm" method="post" >
		<table class="table table-hot">
		<tr>
			<th class="w80">순번</th>
			<th>
			<input type="checkbox" id="allcheck" onclick="allChk(this);"/>
			</th>
			
			<th class="w100 text-left">댓글 </th>
			
			<th class="w80">날짜</th>
		</tr>
		
		<c:forEach var="n" items="${list}">
					<tr>
						<td>${n.number}</td>
						<td><input type="checkbox" name="deleteCheck" value="${n.number}"></td> 
						<td class="title text-left text-indent">${n.content}<a href="../guest/counseling-detail?number=${n.textnumber}">원문보기 ▶</a></td>
						<td>${n.date}</td>
		
					</tr>
				</c:forEach>
		
		
		</table>
		
	<table border="1" align="center">
	<tr>
	
		<td>
	
	<input name="button" type="submit" value="삭제"/> 
	
		</td>
	</tr>
	
	</table>


</form>

<!-- footer부분 -->
<jsp:include page="../../inc/footer.jsp"/>	

	</div>	
</main>

</body>

<script type="text/javascript">


function allChk(obj){
    var chkObj = document.getElementsByName("deleteCheck");
    var rowCnt = chkObj.length - 1;
    var check = obj.checked;
    if (check) {﻿
        for (var i=0; i<=rowCnt; i++){
         if(chkObj[i].type == "checkbox")
             chkObj[i].checked = true; 
        }
    } else {
        for (var i=0; i<=rowCnt; i++) {
         if(chkObj[i].type == "checkbox"){
             chkObj[i].checked = false; 
         }
        }
    }
} 


	

</script>



</html>