<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>emp</title>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form:form action="${pageContext.request.contextPath }/emp/updateEmp" method="POST" modelAttribute="employee">
		<c:if test="${employee.empId != null }">
			<form:hidden path="empId"/>
			<input type="hidden" name="_method" value="PUT"/>
		</c:if>
    	EmpName: <form:input path="empName"/><br>
		Email:<form:input path="email"/>
		<br>
		<jsp:useBean id="genders" class="java.util.HashMap" scope="request"></jsp:useBean>
    	<c:set target="${genders }" property="1" value="男"></c:set>
    	<c:set target="${genders }" property="0" value="女"></c:set>
    	Gender: <form:radiobuttons path="gender" items="${genders }"/>
    	<br>
    	Birthday: <form:input path="birthday"/>
    	<br>
    	Department: <form:select items="${departments }" path="depId" 
    	itemLabel="depName" itemValue="depId"/>
    	<br>
    	<input type="submit" value="Submit">
	</form:form>
</body>
</html>
