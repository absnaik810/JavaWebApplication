<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="LoginCheck">
<table style="margin:auto;">
<tr>
<td>
<label>User Name</label>
</td>
<td>
<input type="text" name="username"></input>
</td>
</tr>
<tr>
<td>
<label>Password</label>
</td>
<td>
<input type="text" name="password"></input>
</td>
</tr>
<tr>
<td>
<label>Login As</label>
</td>
<td>
<select name="select">
<option>Customer</option>
<option>Admin</option>
<option>Clerk</option>
</select>
</td>
</tr>
<tr>
<td>
<input type="submit" value="Login"></input>
</td>
</tr>
</table>
</form>
</body>
</html>