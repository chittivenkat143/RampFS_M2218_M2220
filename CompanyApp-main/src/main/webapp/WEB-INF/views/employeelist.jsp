<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Employee Management</title>
</head>
<body>

	<div class="container">
		<h1>Employee Management</h1>

		<div align="center" class="table-responsive">
			<div class="text-left">
				<button align="left" type="button" class="btn">
					<a href="/app">Add Employee</a>
				</button>
				<!-- <button  align="right" type="button" class="btn"><a href="/app/search">Search</a></button> -->
			</div>
			<form action="/app/searchEmployees" method="post">
				<div class="form-inline">
					<input type="text" class="form-control" name="searchText" placeholder="Search With Employee Details">
					<button class="btn btn-success" type="submit">Search</button>
				</div>
			</form>

			<input class="form-control" id="myInput" type="hidden" placeholder="Search Employee" />
			<table class="table" id="employeeList">
				<thead>
					<tr>
						<th>Employee Code</th>
						<th>Name</th>
						<th>ProjectDetails</th>
						<th>Mail Id</th>
						<th>Phone number</th>
						<th>View Activities</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				
				<c:choose>
				  <c:when test="${employeeList.size() > 0}">
				    <c:forEach items="${employeeList}" var="emp">
						<tr>
							<td>${emp.code}</td>
							<td>${emp.name}</td>
							<td>${emp.project}</td>
							<td>${emp.mailId}</td>
							<td>${emp.phoneNo}</td>
							<td>
								<button type="button" class="btn">
									<a href="employeeActivities?employeeId=${emp.employeeId}">Activities</a>
								</button>
							</td>
							<td>
								<button type="button" class="btn">
									<a href="updateEmployee?employeeId=${emp.employeeId}">EDIT</a>
								</button>
							</td>
							<td>
								<button type="button" class="btn">
									<a href="deleteEmployee/${emp.employeeId}">DELETE</a>
								</button>
							</td>
						</tr>
					</c:forEach>
				  </c:when>
				  <c:otherwise>
				    	<c:out value="${info}"/>
				  	</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>


	<script>
		
		$(document).ready(function() {
			$("#myInput").on("keyup",function() {
				var value = $(this).val().toLowerCase();
				$("#employeeList tr").filter(function() {
					$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)});
				});
		});

		/* $(document).ready(function(){
		 $("#myInput").on("keyup", function() {
		 var value = $(this).val().toLowerCase();
		 $.ajax({
		 contentType: "application/json; charset=utf-8",
		 type : "GET",
		 url : '/app/filterEmployees?filterStr=' + value,
		 success : function(data) {
		 $('#employeeList').val(data);
		 }
		 });
		 });
		 }); */
	</script>
</body>
</html>