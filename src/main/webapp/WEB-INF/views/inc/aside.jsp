<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}" />

<nav class="aside">
	<!-- not authenticated -->
	<sec:authorize access="!isAuthenticated()">
	<section class="not-authenticated">
		<h1>
			<img src="${root}/resource/images/bg-profile.png"/>
		</h1>
		<h2>로그인 정보가 필요합니다.</h2>
		<div>
			<a href="${root}/member/login" class="btn">노트펍스 로그인</a>
		</div>	
	</section>
	</sec:authorize>
	<!-- authenticated -->
	<sec:authorize access="isAuthenticated()">
	<section class="authenticated">
		<h1>
			배타적으로 해야함
		</h1>
	</section>
	</sec:authorize>
	<%-- <ul>
		<li><a href="${root}/member/login">로그인</a></li>
		<!-- 스프링 4.0이상에서 지원하는 로드아웃 페이지 경로 -->
		<li><a href="${root}/member/logout">로그아웃</a></li>
		<li><a href="${root}/member/join">회원가입</a></li>
		<li><a href="${root}/author/index">저작자페이지</a></li>
		<li><a href="${root}/admin/index">관리자페이지</a></li>
	</ul> --%>
</nav>