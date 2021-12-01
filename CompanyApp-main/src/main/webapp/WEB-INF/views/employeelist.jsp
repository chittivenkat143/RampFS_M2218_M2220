<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Employee Management</title>
</head>
<body>

<div class="container">
	<h1>Employee List</h1>
	<div align="center" class="table-responsive">
		<table class="table">
		   <thead>
			   <tr>
					<th>Name</th>
					<th>ProjectDetails</th>
					<th>Mail Id</th>
					<th>Phone number</th>
					<th>Edit</th>
					<th>Delete</th>
	           </tr>
           </thead>
			<c:forEach items="${employeeList}" var="emp">
				<tr>
					<td>${emp.name}</td>
					<td>${emp.project}</td>
					<td>${emp.mailId}</td>
					<td>${emp.phoneNo}</td>
					<td>
						<button type="button" class="btn"><a href="updateEmployee?employeeId=${emp.employeeId}">EDIT</a></button>
					</td>
					<td>
						<button type="button" class="btn"><a href="deleteEmployee/${emp.employeeId}">DELETE</a></button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>