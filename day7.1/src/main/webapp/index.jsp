<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h5>Session ID - ${pageContext.session.id}</h5>
	<h5>
		<a href="login.jsp">User Login</a>
	</h5>
</body>
</html>