<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.cohs.pojo.BillToBeGenerated"%>
<%@page import="com.cohs.pojo.Room"%>
<%@page import="com.cohs.pojo.BillDetails"%>
<%@page import="com.cohs.pojo.BookedService"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% HttpSession session2=request.getSession(true);
   BillDetails billToGenerate=(BillDetails)session2.getAttribute("bill");

%>
Bill Details for Customer with ID:<%= billToGenerate.getCustomerId()%> and Request ID<%=billToGenerate.getRequestId() %>
<div>

<form action="GenerateBillController" method="get">
<table border="1">
<tr>
<td><label>Customer ID</label>
</td>
<td><label><%= billToGenerate.getCustomerId()%></label>
</td>
</tr>
<tr>
<td><label>Request ID</label>
</td>
<td><label><%=billToGenerate.getRequestId() %></label>
</td>
</tr>
<tr>
<td><label>Room Booked</label>
</td>
<td>
<table border="1">
<th>Room No</th><th>Room Rent</th><th>Booking Date</th><th>Booking upto</th>
<%
for(int i=0;i<billToGenerate.getRoomList().size();i++)
{
	Room room=billToGenerate.getRoomList().get(i);

%>
<tr>
<td><%=room.getRoomNo() %>
</td>
<td><%=room.getRoomRent() %>
</td>
<td><%=room.getBookedDate() %>
</td>
<td><%=room.getBookedUpto() %>
</td>
</tr>

<%} %>
</table>
</td>
</tr>
<tr>
<td>Service Booked</td>
<td>
<table border="1">
<th>Service Id</th><th>Service Name</th><th>Room No</th><th>Service Charge</th><th>Booking Date</th><th>Booking Upto</th>
<% 
for(int i=0;i<billToGenerate.getService().size();i++)
{
	BookedService service=billToGenerate.getService().get(i);
%>

<tr>
<td><%=service.getServiceId() %>
</td>
<td><%=service.getServiceName() %>
</td>
<td><%=service.getRoomNo() %>
</td>
<td><%=service.getServiceCharge() %>
</td>
<td><%=service.getBookedDate() %>
</td>
<td><%=service.getBookedUpto() %>
</td>
</tr>
<%} %>
</table>
</td>
</tr>
<tr>
<td>Advance Payment</td>
<td><%=billToGenerate.getAdvancePayment() %>
</td>
</tr>
<tr>
<td><label>Add any off line service charge</label>
</td>
<td><input type="text" name="offlinecharge"></input></td>
</tr>
<tr>
<td>
<input type="submit" value="Generate Bill"></input></td>
</tr>
</table>
</form>
</div>
</body>
</html>