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
<div class="font">								<!-- Ŭ����(��ü��ǥ��) -->
	<%-- <span class="start">���ݱ��� <span style="color:red">${count(vt_name)}</span>���� ȣ��ȣ ��ǥ�� �ǽõǾ����ϴ�.</span> --%>
	<c:choose>
	
	<c:when test="${ing != 0}">
		<span class="start"><span style="color:red"></span>${count}���� ȣ��ȣ ��ǥ�� ����ǰ� �ֽ��ϴ�.</span>
	</c:when>
	<c:when test="${ing == 0}">
		<span class="start">����� <span style="color:red"></span>${count}���� ȣ��ȣ ��ǥ�Դϴ�.</span>
	</c:when>
	</c:choose>
	<!-- <span class="end">
		
		<a href="newOne.do">�ֽż�</a> 	�����		
		
		<a href="popular.do">�α��</a> &nbsp;		����+�ݴ���ǥ��
			
	
	</span> -->
</div>
</body>
</html>