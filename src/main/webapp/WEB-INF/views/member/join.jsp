<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<main>
	<section class="main">
		<h1>회원가입 폼</h1>
		<form method="post">
			<fieldset>
				<legend>회원가입 필드</legend>
				<table>
					<tr>
						<th>아이디 : </th>
						<!-- 스프링이 제공하는 login 기능의 name은 지정되어있다 -->
						<td><input type="text" name="id" placeholder="6~12자 이내의 영문 또는 숫자"/></td>
					</tr>
					<tr>
						<th>비밀번호 : </th>
						<td><input type="password" name="pwd"/></td>
					</tr>
					<tr>
						<th>이름 : </th>
						<td><input type="text" name="name"/></td>
					</tr>
					<tr>
						<th>사진 : </th>
						<td><input type="file" name="file"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인"/>
						</td>						
					</tr>
				</table>
			</fieldset>
		</form>
	</section>
</main>