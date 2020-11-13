<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>emps</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
</head>
<style>
	.table {
		width: 60%;
		margin: 20px auto;
	}
	.table .page-nav {
		text-align: center;
	}
</style>
<body>
	<c:if test="${info == null && info.total < 0 }">
		当前没有员工列表
	</c:if>
	<c:if test="${info != null && info.total >= 0 }">
		<table class="table table-bordered">
			<tr>
				<th>No</th>
				<th>EmpName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Birthday</th>
				<th>Department</th>
				<th>editor</th>
			</tr>
			<c:forEach items="${info.list }" var="emp" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>${emp.empName }</td>
					<td>${emp.email }</td>
					<td>${emp.gender==0?'女':'男' }</td>
					<td>${emp.birthdayStr }</td>
					<td>${emp.dep.depName }</td>
					<td>
						<a href="${pageContext.request.contextPath }/emp/getEmpById/${emp.empId }">update</a>/
						<a>delete</a>
					</td>
				</tr>
			</c:forEach>
			<tr class="page-nav">
				<td colspan="7">
					总记录数：${info.total }
					总页数：${info.pages }
					当前第 ${info.pageNum } 页
					<c:if test="${info.hasPreviousPage }">
						<a href="?pageNo=1">首页</a>
						<a href="?pageNo=${info.pageNum - 1 }">上一页</a>
					</c:if>
					<c:if test="${info.hasNextPage }">
						<a href="?pageNo=${info.pageNum + 1 }">下一页</a>
						<a href="?pageNo=${info.pages }">末页</a>
					</c:if>
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>
