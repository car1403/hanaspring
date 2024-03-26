<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<!-- 127.0.0.1:8080/sb1/main.css  -->
	<link href="<c:url value="/css/main.css"  />" rel="stylesheet">
<style>
</style>
</head>

<body>
<header>
	<h1>Main Page</h1>
	<ul>
		<li><a href="<c:url value="/" />">MAIN</a></li>
		<li><a href="<c:url value="/login" />">LOGIN</a></li>
		<li><a href="<c:url value="/register" />">REGISTER</a></li>
		<li><a href="<c:url value="/cust/add" />">CUST ADD</a></li>
		<li><a href="<c:url value="/cust/get" />">CUST GET</a></li>
	</ul>	
</header>
<section>
	<c:choose>
		<c:when test="${centerpage == null }">
		   <jsp:include page="center.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
		   <jsp:include page="${centerpage}.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
</section>
<footer></footer>
</body>
</html>






