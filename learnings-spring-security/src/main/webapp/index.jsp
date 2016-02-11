<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
</head>
<body>
	<a href="admin">admin</a>
	<a href="user">user</a>

	<form method="post" action="logout">
		<input hidden="true" name="${_csrf.parameterName}"
			value="${_csrf.token}"> <input type="submit" value="logout"></input>
	</form>

	<form action="admin" method="post">
		<!-- this results in 403 because csrf token is not submitted -->
		what if i don't have csrf? <input type="submit" value="no csrf">
	</form>
</body>
</html>
