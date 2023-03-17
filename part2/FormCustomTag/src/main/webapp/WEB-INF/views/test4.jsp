<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test3</h1>
	<form:form modelAttribute="test_user2" action="result">
		name : <form:input path="user_name"/><br/>
		ID : <form:input path="user_id"/><br/>
		password : <form:password path="user_pw" showPassword="true"/><br/>
		postNum : <form:input path="user_postcode"/><br/>
		address1 : <form:input path="user_address1"/><br/>
		address2 : <form:input path="user_address2"/><br/>
		<button type="submit">OK</button>
	</form:form>
</body>
</html>