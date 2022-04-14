<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Save Travel Assignment</title>
</head>
<body>
	<div class="containter">
		<h2>Expense Details</h2>
		<a href="/expenses">Go back</a>
		<div>
			<table>
				<tr>
					<td> Expense Name: </td>
					<td><c:out value="${travel.expenseName}"/></td>
				</tr>
				<tr>
					<td> Expense Description: </td>
					<td><c:out value="${travel.description}"/></td>
				</tr>
				<tr>
					<td> Vendor: </td>
					<td><c:out value="${travel.vendor}"/></td>
				</tr>
				<tr>
					<td> Amount Spent: </td>
					<td><c:out value="${travel.amount}"/></td>
				</tr>				
			</table>
		</div>
	</div>
</body>
</html>