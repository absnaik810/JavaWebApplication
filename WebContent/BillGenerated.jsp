<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.cohs.pojo.Bill"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession ssn=request.getSession(true);
Bill bill=(Bill)ssn.getAttribute("billGenerated");
 %>
<div>Bill has been successfully generated...</div>
<table>
<tr>
<td>Bill Id
</td>
<td><%=bill.getBillId() %>
</td>
</tr>
<tr>
<td>Customer Id
</td>
<td><%=bill.getCustomerId() %>
</td>
</tr>
<tr>
<td>Request Id</td>
<td><%=bill.getRequestId() %>
</td>
</tr>
<tr>
<td>Room Rent
</td>
<td><%=bill.getRoomRent() %>
</td>
</tr>
<tr>
<td>
Service Charge
</td>
<td>
<%=bill.getServicePrice() %>
</td>
</tr>
<tr>
<td>
Total Amount
</td>
<td>
<%=bill.getTotalPrice() %>
</td>
</tr>
</table>
</body>
</html>