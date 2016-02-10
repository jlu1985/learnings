<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
</head>
<body>
	Hello ${pageContext.request.remoteUser }

	<form action="" method="post">
		<input type="submit" value="Log out" /> <input type="hidden"
			name="${_csrf.parameterName }" value="${_csrf.token }" />
	</form>
</body>


</html>