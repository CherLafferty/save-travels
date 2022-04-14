<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Save Travel Assignment</title>
</head>
<body>
	<div class="container">
		<h3>Test Travel Expense Page</h3>
		<div>
			<h1>Save Travels</h1>
			<p>${allTravels}</p>
			<table>
				<thead>
					<tr>
						<th>Expense</th>
						<th>Vendor</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allTravels}" var="travel">
						<tr>
							<td><c:out value="${travel.expenseName}" /></td>
							<td><c:out value="${travel.vendor}" /></td>
							<td><c:out value="${travel.amount}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<h2>Add an Expense:</h2>
			<form:form action="/expenses" method="post" modelAttribute="travel">
				<p>
					<form:label path="expenseName">Expense Name:</form:label>
					<form:errors path="expenseName" class="text-danger" />
					<form:input path="expenseName" />
				</p>
				<p>
					<form:label path="vendor">Vendor:</form:label>
					<form:errors path="vendor" class="text-danger" />
					<form:textarea path="vendor" />
				</p>
				<p>
					<form:label path="amount">Amount:</form:label>
					<form:errors path="amount" class="text-danger"/>
					<form:input path="amount" type="double" />
				</p>
				<p>
					<form:label path="description">Description:</form:label>
					<form:errors path="description" class="text-danger" />
					<form:input path="description" />
				</p>
				<input type="submit" value="Submit" />
			</form:form>

		</div>
	</div>
</body>
</html>