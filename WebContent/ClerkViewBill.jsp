<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="com.cohs.pojo.Bill"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Bill> list=(List<Bill>)request.getAttribute("all");

%>
<div>
<form method="get" action="DeleteBillController">
<table border="1">
<th>Bill ID</th>
<th>Customer ID
</th>
<th>Request ID</th>
<th>Room Rent</th>
<th>Service Charge</th>
<th>Total Price</th>
<%
for(int i=0;i<list.size();i++)
{
	Bill obj=list.get(i);

%>
<tr>
<td><%=obj.getBillId() %>
</td>
<td><%=obj.getCustomerId() %>
</td>
<td><%=obj.getRequestId() %>
</td>
<td><%=obj.getRoomRent() %>
</td>
<td><%=obj.getServicePrice() %>
</td>
<td><%=obj.getTotalPrice() %>
</td>
<td><input type="checkbox" name="checkboxgroup" value="<%=obj.getBillId()%>"></input>
</td>
</tr>
<%
}
%>
<tr>
<td><input type="submit" value="Delete"></input></td>
</tr>

</table>




</form>
</div>
</body>
</html>