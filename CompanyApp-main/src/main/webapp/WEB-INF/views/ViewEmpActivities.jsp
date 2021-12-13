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
<title>View Employee Activities</title>
</head>
<body>
	<div class="container">
		<div align="center" class="table-responsive">
			<h2>Employee Activities</h2>
			<table class="table table-dark" id="employeedetails">
				<thead>
					<tr>
						<th>Employee Name</th>
						<th>${employee.name}</th>
					</tr>
					<tr>
						<th>Project</th>
						<th>${employee.project}</th>
					</tr>
					<tr>
						<th>EmailId</th>
						<th>${employee.mailId}</th>
					</tr>
					<tr>
						<th>Phone No.</th>
						<th>${employee.phoneNo}</th>
					</tr>
				</thead>
			</table>
			<table class="table table-dark" id="activityList">
				<thead>
					<tr>
						<th>Status</th>
						<th>Description</th>
						<th>Date Time</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<c:choose>
					<c:when test="${activities.size() > 0}">
						<c:forEach items="${activities}" var="act">
							<tr>
								<td>${act.status}</td>
								<td>${act.description}</td>
								<td>${act.datetime}</td>
								<td>
									<button type="button" class="btn">
										<a href="#">EDIT</a>
									</button>
								</td>
								<td>
									<button type="button" class="btn">
										<a href="#">DELETE</a>
									</button>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:out value="${info}" />
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
</body>
</html>