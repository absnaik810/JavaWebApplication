<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.cohs.pojo.HotelService"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
function viewDiv()
{
	alert('hello');
	document.myForm.div1.style.visibility="hidden";
}
</style>
</head>
<body onload="viewDiv()">
<form method="get" action="BookService" name="myForm">
<h1>You Have Booked This Rooms</h1>
<%
ArrayList<String> roomNo=(ArrayList<String>)request.getAttribute("roomNo");
ArrayList<HotelService> list=(ArrayList<HotelService>)request.getAttribute("list");
%>
<table>
<%for(int i=0;i<roomNo.size();i++)
	{%>
	<tr>
	<td>
	<%=roomNo.get(i) %>
	</td>
	<td>
	<input type="checkbox" name="checkboxgroup" value="<%=roomNo.get(i)%>">
	</td>
	</tr>
<%} %>
</table>
<h1>Select a service from the below list</h1>
<table>
<%for(int i=0;i<list.size();i++)
	{
	HotelService obj=list.get(i);
	%>
	<tr>
	<td>
	<%=obj.getServiceId() %>
	</td>
	<td>
	<%=obj.getServiceName() %>
	</td>
	<td>
	<%=obj.getServicePrice() %>
	</td>
	<td>
	<input type="checkbox" name="checkboxgroup1" value="<%=obj.getServiceId()%>">
	</td>
	</tr>
<%} %>
</table>
<div name="div1">
Booking Date<input type="text" name="from"></input>
Booking Upto<input type="text" name="to"></input>
<input type="submit" value="Book">
</div>
</form>
</body>
</html>