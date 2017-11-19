<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="com.cohs.pojo.BillToBeGenerated"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:center">
<h1>...These are the list of customer scheduled to check out today...</h1>
<form method="post" action="SeeDetailController">
<table border="1">
<th>Customer Id</th><th>Request Id</th>
<%List<BillToBeGenerated> billList=(List<BillToBeGenerated>)request.getAttribute("custList"); 
for(int i=0;i<billList.size();i++)
{
	BillToBeGenerated obj=billList.get(i);
	String temp=obj.getCustomerId()+"-"+obj.getRequestId();
%>
<tr>
<td>
<%=obj.getCustomerId() %>	
</td>
<td>
<%=obj.getRequestId() %>
</td>
<td>
<input type="checkbox" name="checkBoxGroup" value="<%=temp%>"></input>
</td>
</tr>

<% }%>
<tr><td><input type="submit" value="See Details"></input></td></tr>
</table>
</form>
</div>
</body>
</html>