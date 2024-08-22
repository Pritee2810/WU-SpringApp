<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LIST CUSTOMERS</title>
</head>
<body>
<div id="header" >
<H1>Customer Data </H1>
</div>

<input type="button" value ="add customer" onclick="window.location.href='showFormForAdd'"/>

<table border ="1">
<tr>
<th>Customer ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>	
<th colspan= 2>Action</th>	
</tr>
<c:forEach var ="customer" items ="${custData}"> 
<c:url value="/customer/showFormForUpdate" var="updatelink">
<c:param name= "customerID" value="${customer.cId}"></c:param>
</c:url>

<c:url value="/customer/deleteCustomer" var="deletelink">
<c:param name= "customerID" value="${customer.cId}"></c:param>
</c:url>

<tr>
<td>${customer.cId}</td>
<td>${customer.firstName}</td>
<td>${customer.lastName}</td>
<td>${customer.eMail}</td>
<td> 
<a href="${updatelink}">UPDATE</a>
</td>
<td>
<a href="${deletelink}">DELETE</a>
<!-- onClick="if(!(confirm("Are you sure you want to delete this customer?"))) return false">Delete</a> -->
</td>
</tr>
</c:forEach>
</table>

 
</body>
</html>