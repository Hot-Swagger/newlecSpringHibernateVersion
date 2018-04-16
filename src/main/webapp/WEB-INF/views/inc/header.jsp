<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />

<header class="header">
	<h1>책 제목</h1>
	<nav class="main-menu">
		<h1 class="hidden">메인메뉴</h1>
		<ul>
			<li id="ham-button"><img src="${root}/resource/images/ic_menu_black_24dp_1x.png" alt="메뉴"></li>
			<li><a href="${root}/member/note/list">관리</a></li>
			<%-- <li><a href=""><img src="${root}/resource/images/ic_search_black_24dp_1x.png" alt="검색"></a></li> --%>
			<!-- <li></li> -->
		</ul>
	</nav>
</header>

<script>
	window.addEventListener("load",function(){
		var hamButton = document.querySelector("#ham-button");
		var aside = document.querySelector(".aside");
		hamButton.onclick = function(e){
			
			if(aside.classList.contains("show"))
				aside.classList.remove("show");
			else
				aside.classList.add("show");
		};
	});
</script>