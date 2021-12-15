<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

      <div align="center">
        <h1>New Employee</h1>
        
        <c:if test="${not empty exception.exceptionMessage}">
        	<div style="background-color: RED">
        		<c:out value="${exception.exceptionMessage}" />
        	</div>
        </c:if>
        
        <form:form action="saveData" method="post" modelAttribute="employee">
        <table>
            <form:hidden path="employeeId" value="${employee.employeeId}"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" value="${employee.name}"/></td>
            </tr>
            <tr>
            <tr>
                <td>Employee Code:</td>
                <td><form:input path="code" value="${employee.code}" disabled="false"/></td>
            </tr>
            <tr>
                <td>Project Details:</td>
                <td><form:input path="project" value="${employee.project}"/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="mailId" value="${employee.mailId}"/></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><form:input path="phoneNo" value="${employee.phoneNo}"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                	<input type="submit" value="Save">
                	<a href="#"><input type="button" value="Cancel"/></a>
                </td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>