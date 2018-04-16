<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />

<nav class="aside">
	<ul>
		<li><a href="${root}/member/login">로그인</a></li>
		<!-- 스프링 4.0이상에서 지원하는 로드아웃 페이지 경로 -->
		<li><a href="${root}/logout">로그아웃</a></li>
		<li><a href="${root}/join">회원가입</a></li>
	</ul>
</nav>