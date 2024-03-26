<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<link href="main.css" rel="stylesheet">
<style>
</style>
</head>

<body>
<header>
	<h1>Main Page</h1>
	<ul>
		<li><a href="main.nhn">MAIN</a></li>
		<li><a href="login.nhn">LOGIN</a></li>
		<li><a href="register.nhn">REGISTER</a></li>
		<li><a href="selectall.nhn">SELECTALL</a></li>
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






