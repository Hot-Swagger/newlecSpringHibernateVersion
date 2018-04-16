<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

	<main class="main">
		<section class="note-list">
			<h1 class="hidden">노트목록</h1>
			<ul>
				<c:forEach var="note" items="${notes}">
				<li class="text">
					<div><a href="${note.id}">${note.title}</a></div>
					<!-- <div class="text ellipsis"> -->
					<div>
						<%-- <span class="text-concat">${note.content}</span> --%>
						${note.content}
					</div>
					<div><span>분류</span><span>${note.regDate}</span></div>
				</li>			
				</c:forEach>
			</ul>
		</section>
		
		<nav class="btn-list">
			<h1 class="hidden">버튼목록</h1>
			<ul>
				<li id="add-button"><a href="reg">추가</a></li>
				<!-- <li id="del-button"><a href="">삭제</a></li> -->
			</ul>
		</nav>
	</main>