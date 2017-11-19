<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="ServiceController">
<table style="margin:auto;">
<tr>
<td>
<label>Service Name</label>
</td>
<td>
<input type="text" name="sname"></input>
</td>
</tr>
<tr>
<td>
<label>Price</label>
</td>
<td>
<input type="text" name="sprice"></input>
</td>
</tr>
<tr>
<td>
<label>Duration</label>
</td>
<td>
<input type="text" name="sduration"></input>
</td>
</tr>
<tr style="text-align: center;">
<input type="submit" value="Add Service"></input>
</tr>
</table>
</form>
</body>
</html>