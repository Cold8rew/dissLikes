<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>
<link rel="stylesheet" href="Vote_List/css/top_style.css" />


<title>Insert title here</title>
<script src="Vote_List/js/jquery-3.6.0.js"></script>
</head>
<body>
<div class="font">								<!-- 클릭수(전체투표수) -->
	<%-- <span class="start">지금까지 <span style="color:red">${count(vt_name)}</span>개의 호불호 투표가 실시되었습니다.</span> --%>
	<c:choose>
	
	<c:when test="${ing != 0}">
		<span class="start"><span style="color:red"></span>${count}개의 호불호 투표가 진행되고 있습니다.</span>
	</c:when>
	<c:when test="${ing == 0}">
		<span class="start">종료된 <span style="color:red"></span>${count}개의 호불호 투표입니다.</span>
	</c:when>
	</c:choose>
	<!-- <span class="end">
		
		<a href="newOne.do">최신순</a> 	등록일		
		
		<a href="popular.do">인기순</a> &nbsp;		찬성+반대투표수
			
	
	</span> -->
</div>
</body>
</html>