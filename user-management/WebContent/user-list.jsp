<%@page import="com.manthan.user.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
     <c:if test = "${empty user}">
         <c:redirect url="/login.jsp"/>
     </c:if>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<h2 class="navbar-brand"> User Management App </h2>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/user/list"
					class="nav-link">Users</a></li>
			</ul>
			
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
			
			<span class="navbar-text">
      			Welcome ${user.name}    		
      		</span>
			
		</nav>
	</header>
	<br>
	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/user/new" class="btn btn-success">Add
					New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Age</th>
						<th>PhoneNo</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="user" items="${users}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.age}" /></td>
							<td><c:out value="${user.phoneno}" /></td>

							<td>
							    <a href="<%=request.getContextPath()%>/user/edit?id=<c:out value='${user.id}' />">Edit</a> /
								<a href="<%=request.getContextPath()%>/user/delete?id=<c:out value='${user.id}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>

</html>

</html>