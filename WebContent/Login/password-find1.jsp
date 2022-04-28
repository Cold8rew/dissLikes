<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="Login/picture/thumb.png" type="image/x-icon">
<title>DissLikes</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="Login/css/styles.css">
  <link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
</head>
<body>
<!-- 공통헤더. -->
<div class="header">
	<c:import url="../frame/html/header.jsp"></c:import>
</div>
	<section>
		<h1>비밀번호 찾기</h1>
		<article>
			<div class="login-form">
				<form action="passwordfind.do" method="post">
					<div>
						<ul class="text-title">이메일</ul>
						<input type="text" name="findemail" class="text-field" placeholder="email@site.com" required>
						<!-- <input type="image" src="picture/SendMail.png" onmouseover="this.src='picture/SendMailOn.png'" onmouseout="this.src='picture/SendMail.png'"> -->
						<input id="img1" type="image" src="Login/picture/SendMail.png">
					</div>
				</form>
			</div>
		</article>
	</section>
</body>
</html>