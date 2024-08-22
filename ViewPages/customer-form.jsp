<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
<div id="header">
<h1>crm</h1>
<h1>add customer</h1>

</div>
<div id="formWrapper">
<form:form action="saveCustomer" method="post" modelAttribute="customer">
<table>
<tbody>
<tr>
<td><label>Customer Id</label></td>
<td><form:input path="cId"/></td>
</tr>
<tr>
<td><label>First Name</label></td>
<td><form:input path="firstName"/></td>
</tr>
<tr>
<td><label>Last Name</label></td>
<td><form:input path="lastName"/></td>
</tr>
<tr>
<td><label>Email</label></td>
<td><form:input path="eMail"/></td>
</tr>
<tr>
<td><label></label></td>
<td><input type="submit"></td>
</tr>

</tbody>


</table>

</form:form>



</div>
</body>
</html>