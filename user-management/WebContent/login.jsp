<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

</head>
<body>

	<c:if test="${not empty user}">
		<c:redirect url="/user-list.jsp" />
	</c:if>

			<!--Bootsrap 4 CDN-->
			<link rel="stylesheet"
				href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
				integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
				crossorigin="anonymous">

			<!--Fontawesome CDN-->
			<link rel="stylesheet"
				href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
				integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
				crossorigin="anonymous">

			<!--Custom styles-->
			<link rel="stylesheet" type="text/css" href="styles.css">

			<div class="container">
				<div class="d-flex justify-content-center h-100">
					<div class="card">
						<div class="card-header">
							<h3>Sign In</h3>

						</div>
						<div class="card-body">
							<form action="login" method="post">
								<div class="input-group form-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fas fa-user"></i></span>
									</div>
									<input type="text" class="form-control" placeholder="username"
										name="username">
								</div>
								<div class="input-group form-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fas fa-key"></i></span>
									</div>
									<input type="password" class="form-control"
										placeholder="password" name="password">
								</div>
								<div class="form-group">
									<input type="submit" value="Login"
										class="btn float-right login_btn">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
	</div>
</body>

</html>
</body>
</html>
