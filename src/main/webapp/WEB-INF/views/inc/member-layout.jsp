<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, user-scalable=1">
<link href="${root}/resource/css/style.css" type ="text/css" rel ="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<!-- header -->
	<tiles:insertAttribute name="header" />
	<!-- aside -->
	<tiles:insertAttribute name="aside" />
	<!-- main -->
	<tiles:insertAttribute name="main" />
	<!-- footer -->
	<tiles:insertAttribute name="footer" />
</body>
</html>