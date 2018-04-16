<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section class="main">
	<h1>노트 등록 폼</h1>
	<form method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value=""/></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="file"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" rows="10" cols="40"></textarea>
				</td>
			</tr>
		</table>
		<div>
			<input type="submit" value="등록"/>
		</div>
	</form>
</section>

<script>
	window.addEventListener("load",function(){
		var submitButton = document.querySelector("input[value='등록']");
		submitButton.onclick = function(e){
			
			var request = new XMLHttpRequest();
			request.onload = function(evt){
				alert(request.responseText);
			}
			request.open("GET", "data");
			request.send();

			//e.preventDefault();
		}
	});
</script>