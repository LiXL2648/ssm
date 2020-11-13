<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>success</title>

<!--<link rel="stylesheet" type="text/css" href="styles.css">-->

</head>

<body>
	<c:choose>
		<c:when test="${code >= 1 }">
			添加成功
		</c:when>
		<c:otherwise>
			添加失败
		</c:otherwise>
	</c:choose>
</body>
</html>
