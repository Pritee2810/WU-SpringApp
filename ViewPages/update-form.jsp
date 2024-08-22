
</html><%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>CRM-Customer Relationship Manager</title>

</head>

<body>

	<h1>UPDATE CUSTOMER DETAILS</h1>

	<form:form action="updateCustomerDetails" method="post" modelAttribute="boundCustomer">

		<table>

			<tbody>

				<tr>

					<td><label>Customer ID</label></td>

					<td><form:input path="cId" value="${customerDetails.id}"/></td>

				</tr>

				<tr>

					<td><label>First Name</label></td>

					<td><form:input path="firstName" value="${customerDetails.firstName}"/></td>

				</tr>

				<tr>

					<td><label>Last Name</label></td>

					<td><form:input path="lastName" value="${customerDetails.lastName}"/></td>

				</tr>

				<tr>

					<td><label>Email</label></td>

					<td><form:input path="eMail" value="${customerDetails.eMail}"/></td>

				</tr>

				<tr>

					<td><label></label></td>

					<td><input type="submit" value="SAVE CUSTOMER" /></td>

				</tr>

			</tbody>

		</table>

	</form:form>

</body>

</html>
 