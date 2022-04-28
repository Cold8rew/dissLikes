<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중인 투표</title>
<link rel="stylesheet" href="After_Click/css/style.css">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<script>
function Go_After() {
	var img_name = '${ img_name }';
	var url = decodeURIComponent(location.href);
	var url_arr = url.split('?', 1);
	if (url_arr == 'http://localhost:8080/disslikes/Result.do') {
		window.location.href ='<c:url value="Search_vt_id.do"/>?img_name=' + img_name;
	} 
	return;
}
</script>
</head>
<body onload="Go_After()">
<%-- 
<c:import url="../After_Click/Header.jsp"></c:import>
<jsp:include page="Header.jsp"></jsp:include>
<!-- 공통헤더. --> --%>
<c:import url="../frame/html/header.jsp"></c:import>

<c:import url="../After_Click/Main.jsp"></c:import>
<%-- <jsp:include page="Main.jsp"></jsp:include> --%>

<c:import url="../After_Click/Footer.jsp"></c:import>
<%-- <jsp:include page="Footer.jsp"></jsp:include> --%>

</body>
</html>