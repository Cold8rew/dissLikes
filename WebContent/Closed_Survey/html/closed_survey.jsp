<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ sVo.vt_name }</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="Closed_Survey/css/closed_survey_style.css">
</head>
<body>
<div class="wrapper">
<div class="header">
	<c:import url="../../frame/html/header.jsp"></c:import>
</div>
<section id="mid">
	<div class="container" id="to_list">
		<i class="fas fa-chevron-left">목록으로</i>
	</div>
	<div class="container text-center mt-3 survey-name">
		<a class="btn btn-outline-secondary order-1 order-lg-0 fw-medium" href="#!">${ sVo.vt_type } > ${ sVo.vt_dtype }</a>
		<!-- <p id="content-name">반바지&레깅스 레이어드</p> -->
		<p id="content-name">${ sVo.vt_name }</p>
	</div>
	<div class="container text-center survey-result">
		<div class="row">
			<div class="col">
					<div class="container">
						<img class="survey-img" src="${sVo.vt_img_path}">
						<div class="overlay align-self-center">종료된 투표입니다.<br>
											<span class="closed_won">${ sVo.getWonSurv() }</span> 가 <span class="closed_gap">${ sVo.getGapSurv() }</span> 표<br>
											차이로 이겼습니다.
						</div>
				</div>
			</div>
			<div class="col">
				<p class="align-top mt-n3 d-day">투표 종료</p>
				<p class="align-top d-timer">00 : 00 : 00 : 00</p>
				<div class="container chart mx-5">
					<div class="overlay-chart align-self-center">
						<span class="chart_won">${ sVo.getWonSurv() }</span><br>
						${ sVo.getPercentSurv() }%
					</div>	
		 			<canvas id="myChart" width="400" height="400"></canvas>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br>
	
	<div class="container text-center d-grid gap-2 col-6 mx-auto mt-3 survey-other">
		<a href="allList.do">
			<button type="button" class="btn btn-warning rounded-pill">다른 투표 참여하기</button>
		</a>
	</div>
</section>
<br><br><br><br>
</div>
<div class="all_overlay"></div>

<div class=url>투표 공유하기</div><br>
<article class="block2-3">
	<a href="https://www.kakaocorp.com/page/service/service/KakaoTalk"><img src="After_Click/img/Kakao_logo.png" class="kakao"></a>
   	<a href="https://line.me"><img src="After_Click/img/Line_logo.png" class="line"></a>
   	<a href="https://twitter.com/"><img src="After_Click/img/Twitter_logo.png" class="twitter"></a>
   	<a href="https://www.instagram.com/"><img src="After_Click/img/Instagram_logo.png" class="insta"></a>
</article>

<c:import url="../../After_Click/Footer.jsp"></c:import>
<%-- <jsp:include page="Footer.jsp"></jsp:include> --%>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!-- local js file -->
<script type="text/javascript" src="${contextPath}/Closed_Survey/js/closed_survey_script.js"  data-agnum=${ sVo.vt_ag_num } data-dagnum=${ sVo.vt_dag_num } data-agwon=${ sVo.getWonSurv() }></script>
</body>
</html>