<%@page import="org.springframework.format.Printer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
	String url = "/web2018/resource/js/images";
	String path = request.getServletContext().getRealPath(url);
	
	File file = new File(path);
	
	String[] files = file.list();
	List<String> list = new ArrayList<>();
	for(String f : files){
		list.add(f);
	}
	for(String s : list)
%>

<!DOCTYPE html 5>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, user-scalable=1">
		<link href="style.css" type="text/css" rel="stylesheet"/>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript" src="example.js"></script>
	</head>
	<body>
		<section id="ex7" class="example">
			<h1>사진 갤러리 예제</h1>
			<div class="text-align-center viewer">
				
			</div>
			<div class="photo-box">
				<ul>
					<li><img class="" alt="이미지" src="images/acorn.png"></li>
					<li><img class="" alt="이미지" src="images/answeris.png"></li>
					<li><img class="" alt="이미지" src="images/hanbit.png"></li>
				</ul>
			</div>
			<div>
				<input class="btn btn-default btn-left" type="button" value="왼쪽" />
				<input class="btn btn-default btn-right" type="button" value="오른쪽" />
			</div>
		</section>

		<section id="ex6" class="example">
			<h1>노드 조작 예제</h1>
			<div class="text-align-center">
				a
			</div>
			<div>
				<input class="btn btn-default btn-add" type="button" value="노드추가" />
				<input class="btn btn-default btn-remove" type="button" value="노드삭제" />
			</div>
		</section>

		<section id="ex5" class="example">
			<h1>? 예제</h1>
			<div class="text-align-center">
				<img class="" alt="이미지" src="images/acorn.png">
				<img class="" alt="이미지" src="images/answeris.png">
				<img class="" alt="이미지" src="images/hanbit.png">
			</div>
			<div>
				<input class="btn btn-default btn-ok" type="button" value="확인" />
				<input class="btn btn-default btn-css" type="button" value="css 애니메이트" />
			</div>
		</section>

		<section id="ex4" class="example">
			<h1>효과주기 예제</h1>
			<div class="text-align-center">
				<img class="" alt="이미지" src="images/acorn.png">
				<img class="" alt="이미지" src="images/answeris.png">
			</div>
			<div>
				<input class="input" type="text" list="img-list" />
				<datalist id="img-list">
					<option>acorn.png</option>
					<option>answeris.png</option>
					<option>hanbit.png</option>
					<option>sist.png</option>
					<option>red.png</option>
				</datalist>
				<input class="btn btn-default btn-ok" type="button" value="확인" />
				<input class="btn btn-default btn-css" type="button" value="css 애니메이트" />
			</div>
		</section>

		<section id="ex3" class="example">
			<h1>속성과 스타일 수정하기 예제</h1>
			<div class="text-align-center">
				<img alt="이미지" src="images/acorn.png">
			</div>
			<div>
				<input class="input" type="text" list="img-list" />
				<datalist id="img-list">
					<option>acorn.png</option>
					<option>answeris.png</option>
					<option>hanbit.png</option>
					<option>sist.png</option>
					<option>red.png</option>
				</datalist>
				<input class="btn btn-default btn-ok" type="button" value="확인" />
				<input class="btn btn-default btn-toggle" type="button" value="토글" />
			</div>
		</section>

		<section id="ex2" class="example">
			<h1>이벤트 처리하기 예제</h1>
			<div>
				<input class="btn btn-default" type="button" value="확인" />
			</div>
		</section>

		<section id="ex1" class="example">
			<h1>노드선택 예제</h1>
			<div>
				<input class="btn btn-default" type="button" value="확인" />
			</div>
		</section>
	</body>
</html>