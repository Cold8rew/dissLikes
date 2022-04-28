<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>
<canvas id="myChart" width="400" height="400"></canvas>

<script>
var xValues = ["LIKE", "DISLIKE"];
var yValues = [${ sVo.vt_ag_num }, ${ sVo.vt_dag_num }];
var barColors = [
	'rgb(255,232,69)',
   	'rgb(69,92,255)'
];

new Chart("myChart", {
	  type: "doughnut",
	  data: {
	    labels: xValues,
	    datasets: [{
	        data: yValues,
	      backgroundColor: [
	           'rgb(255,232,69)',
	           'rgb(69,92,255)',
	         ],
	         borderColor: [
	              'rgb(255,255,255)'
	        ],
	        borderWidth: 10
	    }]
	  },
	  options: {
	         //cutoutPercentage: 40,
	       responsive: false,
	       plugins: {
	          legend: {
	             onClick:null,
	             position:'top',
	             labels: {
	               font:{
	                   family:"'Noto Sans KR', sans-serif",
	                   size: 25
	                },
	                color:'rgb(33,33,33)'
	             }
	          }
	       }

	     }
	   });
</script>

</body>
</html>
