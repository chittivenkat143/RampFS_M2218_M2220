<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<div align="center">
        <h1>Update Employee</h1>
        <form:form action="saveData" method="post" modelAttribute="employee">
        <table>
            <form:hidden path="employeeId"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Employee Code:</td>
                <td><form:input path="code" /></td>
            </tr>
            <tr>
                <td>Project Details:</td>
                <td><form:input path="project" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="mailId" /></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><form:input path="phoneNo" /></td>
            </tr>
            <tr align="center">
                <td colspan="2" >
                	<input type="submit" value="Update"/>               
                	<a href="/app/employeelist"><input type="button" value="Cancel"/></a>
                </td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>