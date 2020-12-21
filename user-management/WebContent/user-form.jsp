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
			style="background-color: blue">
			<div>
				<h2 class="navbar-brand">User Management Application</h2>
			</div>

			<ul class="navbar-nav">
				<li>
					<a href="<%=request.getContextPath()%>/user/list" class="nav-link">Users</a>
				</li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
	
	<c:if test="${not empty message}">
		<p class="alert alert-danger">
  					${message}
		</p>
	</c:if>
	<c:choose>
		 <c:when test="${param['action'] eq 'new'}">
		  <div class="card">
			<div class="card-body">
				<form action="insert" method="post">
				<!-- <fieldset class="form-group">
					<label>User ID</label> 
						<input type="text"  class="form-control" name="id" required="required"/>
				</fieldset>
 -->
				<fieldset class="form-group">
					<label>User Name</label> 
					<input type="text" class="form-control"	name="name" required="required" />
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> 
					<input type="text" class="form-control"	name="email" required="required" />
				</fieldset>
				
				<fieldset class="form-group">
					<label>Password</label> 
					<input type="text" class="form-control"	name="password" required="required" />
				</fieldset>

				<fieldset class="form-group">
					<label>User Age</label> 
					<input type="text" class="form-control"	name="age" required="required"/>
				</fieldset>
				<fieldset class="form-group">
					<label>User PhoneNo</label> 
					<input type="text" class="form-control"	name="phoneno" required="required"/>
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
			  </form>
			</div>
		</div>
		 </c:when>
		 
		 <c:when test="${param['action'] eq 'edit'}">
		  <div class="card">
		  
			<div class="card-body">
			 <form action="update" method="post">
				<fieldset class="form-group">
					<label>User ID</label> 
						<input type="text" value="<c:out value='${user.id}' />" class="form-control" name="id" readonly="readonly"/>
				</fieldset>

				<fieldset class="form-group">
					<label>User Name</label> 
					<input type="text" value="<c:out value='${user.name}' />" class="form-control"	name="name" required="required" />
				</fieldset>
				
				<fieldset class="form-group">
					<label>User Email</label> 
					<input type="text" value="<c:out value='${user.email}' />" class="form-control"	name="email" required="required" readonly="readonly"/>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Password</label> 
					<input type="text" value="<c:out value='${user.password}' />" class="form-control"	name="password" required="required" />
				</fieldset>

				<fieldset class="form-group">
					<label>User Age</label> 
					<input type="text" value="<c:out value='${user.age}' />" class="form-control"	name="age" required="required"/>
				</fieldset>
				<fieldset class="form-group">
					<label>User PhoneNo</label> 
					<input type="text" value="<c:out value='${user.phoneno}' />" class="form-control"	name="phoneno" required="required"/>
				</fieldset>
				

				<button type="submit" class="btn btn-success">Save</button>
			</form>
			</div>
		</div>
		 </c:when>
		 
		 
	
	</c:choose>
	
			
	
	</div>
</body>
</html>