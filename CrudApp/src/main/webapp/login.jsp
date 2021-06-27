<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="css/bootstrap.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
.login-form {
	margin: auto;
}

body {
	
}
</style>

</head>
<body>
	<form action="login" method="post">
		<div>
			<img src="images/bg.jpg" width="50px" height="50px">
		</div>
		<div class="container mt-5">
			<div class="login-form bg-light w-50">
				<h2 class="text-white bg-success p-3 font-weight-bold">LOGIN</h2>
				<div class="form-group ml-2">
					<label for="email"><i class="far fa-envelope mr-2 "></i>Email</label>
					<input type="text" name="email" id="email"
						placeholder="Enter email" class="form-control" required="required">

				</div>
				<div class="form-group ml-2">
					<label for="password"><i class="fas fa-lock mr-2"></i>Password</label>
					<input type="password" name="password" id="password"
						placeholder="Enter password" class="form-control"
						required="required">

				</div>

				<div class="form-group ml-2">
					<button type="submit" class="btn btn-success font-weight-bold">
						LOGIN <i class="fas fa-sign-in-alt"></i>
					</button>

				</div>
				<div class="bg-success p-3 text-white text-center">&copy;
					abhinay technologies 2021-2022</div>
			</div>


		</div>
	</form>
</body>
</html>