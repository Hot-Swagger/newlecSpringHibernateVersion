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
<link href="${root}/resource/css/index.css" type ="text/css" rel ="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<!-- header -->
	<jsp:include page="inc/header.jsp" />
	<!-- aside -->
	<jsp:include page="inc/aside.jsp" />
	<!-- visual -->
	<section class="visual">
		<h1></h1>
	</section>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		//shutter
		$(function(){
			var shutter = $(".shutter");
			var shutterContent = $(".shutter ul");
			var shutterButton = $(".shutter-button-box > span");
						
			/* var wrapper = $("<div/>");
			//shutter 안에 있는 엘리먼트들을 wrapper 안으로 옮기고 wrapper를 shutter의 자식으로 바꿔주자
			wrapper
				.html(shutter.html());
			shutter
				.empty();
				.append(wrapper);*/
				
			shutterContent.detach();	// 트리에서 노드를 빼는 함수 (메모리에는 존재)
			var clipper = $("<div/>")
							.append(shutterContent)
							.appendTo(shutter)
							.css("overflow","hidden");
			
			shutterContent.css("transition","400ms");
			
			// 초기 상태 (펼쳐질 것인지, 접을것인지) : visited값을 이용
			if(${visited})
				shutterContent
				.css("margin-top",-shutter.outerHeight()+"px");	
			
			shutterButton.click(function(){
					shutterContent.css("margin-top",-shutter.outerHeight()+"px");
			});
			
			shutterContent.on("transitionend",function(){
				
				var marginTop = parseInt(shutterContent.css("margin-top"));
				
				if(marginTop < 0)
					shutterButton.css("background-image","url('resource/images/ic_expand_more_black_24dp_1x.png')");
				else
					shutterButton.css("background-image","url('resource/images/ic_expand_less_black_24dp_1x.png')");
			});
		});
		
		//tab-switch
		$(function(){
			var categoryUl = $(".category > ul");
			var categoryView = $(".category-views");
			var ajaxIcon = null;
			
			categoryUl.click(function(e){
				e.preventDefault();
				if(e.target === e.currentTarget)	// 같은 객체인지 비교
					return;
				if(ajaxIcon != null){
					alert("처리중입니다.")
					return;
				}
				var target = e.target;
				if(target.nodeName == "A")
					target = target.parentElement;
				var viewName = target.dataset.viewName;

				// view 객체 얻기
				var view = $("."+viewName);
				
				// view가 null이면
					// ajax로 가져오기
					
				/* // .load() == 기존의 내용을 ()안의 내용으로 대체하는 ajax
				categoryView.load('book-list-partial'); */
				if(view.length == 0){
					ajaxIcon = $("<img/>")
									.attr("src","resource/images/ajax-loader.gif")
									.css({
										position: "absolute",
										left:"17px",
										top:"20px"
									})
									.appendTo(target);

					/* $(target)
						.css("background","url('resource/images/ajax-loader.gif') no-repeat center")
						.css("position","relative"); */
					
					$.get(viewName+'-partial',function(data){
						
						
						
						var html = categoryView.html();
						categoryView.html(html+data);
						
						view = categoryView.find("."+viewName);
						
						ajaxIcon.remove();
						ajaxIcon = null;
					});
						
					/* switch(viewName){
					case 'book-list':
						$.get('book-list-partial',function(data){
							var html = categoryView.html();
							categoryView.html(html+data);
							ajaxIcon.remove();
							ajaxIcon = null;
						});
						break;
					case 'publish-list':
						$.get('publish-list-partial',function(data){
							var html = categoryView.html();
							categoryView.html(html+data);
							ajaxIcon.remove();
							ajaxIcon = null;
						});
						break;
					} */
				}
				
				categoryView.addClass("show");
					
				// view를 show 하기
				/* categoryView.children("section")
								.addClass("hidden");  */
				view
					.removeClass("hidden");
			});
		});
	</script>
	<section class="notepubs shutter"> <!-- clipper -->
		<h1 class="hidden">서비스 안내</h1>
		<div class="shutter-button-box" style="position:relative;">
			<span class="">확장/축소</span>
		</div>
		<ul>
			<li>
				<article>
					<h1>NOTE</h1>
					<h2>
						스스로 새롭게 알게된 지식은 노트로 기록해 보세요
						기록된 지식은 사라지지 않습니다.
						그것이 누적되면 나를 성장시키는 큰 자산이 됩니다.
					</h2>
					<div>
						<img src="${root}/resource/images/notes-sm.png"/>
					</div>
				</article>
			</li>
			<li>
				<article>
					<h1>BOOK</h1>
					<h2>
						단편적으로 기록한 노트들을 엮어서 관련있는 것들로 모아보세요.
						그러면 하나의 책이 됩니다.
						책은 지식을 체계적으로 이해하고 정리하는데 도움이 됩니다.
					</h2>
					<div>
						<img src="${root}/resource/images/book-sm.png"/>
					</div>
				</article>
			</li>
			<li>
				<article>
					<h1>OPEN</h1>
					<div></div>
				</article>
			</li>
			<li>
				<article>
					<h1>PUBLISH</h1>
					<div></div>
				</article>
			</li>
		</ul>
	</section>
	<!-- main -->
	<main class="main">
		<section class="category">
			<h1>카테고리</h1>
			<ul>
				<li data-view-name="note-list"><a href="">노트</a></li>
				<li data-view-name="book-list"><a href="">책</a></li>
				<li data-view-name="published-list"><a href="">출간본</a></li>
			</ul>
		</section>
		<div class="category-views">
	    	<section class="note-list">
	    		<h1 class="hidden">공개노트 목록</h1>
	    		<ul class="">
	    			<c:forEach var="note" items="${notes}">
					<li class="text">
						<div><a href="${note.id}">${note.title}</a></div>
						<!-- <div class="text ellipsis"> -->
						<div>
							<%-- <span class="text-concat">${note.content}</span> --%>
							${note.content}
						</div>
						<div><span>분류</span><span>${note.regDate}</span><span>(${note.commentCount})</span></div>
					</li>			
					</c:forEach>
	    		</ul>
	    	</section>
	    	<!-- <section class="book-list hidden">
	    		<h1 class="hidden">공개책 목록</h1>
	    		<ul class="">
	    			<li><a href="note/list">책...</a></li>
	    		</ul>
	    	</section> -->
	    	<!-- <section class="publish-list hidden">
	    		<h1 class="hidden">출간된책 목록</h1>
	    		<ul class="">
	    			<li><a href="note/list">책...</a></li>
	    		</ul>
	    	</section> -->
    	</div>
    </main>
	<!-- footer -->
	<jsp:include page="inc/footer.jsp" />
</body>
</html>
    