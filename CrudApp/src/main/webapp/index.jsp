<html>

<head>
 <link rel="stylesheet" href=css/bootstrap.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<form action="<%=request.getContextPath()%>/register" method="post">

		<div class="container mt-5">
			<div class="login-form bg-light">
				<h2 class="bg-primary text-white p-3 font-weight-bold">EMPLOYEE
					REGISTRATION</h2>

				<div class="form-group w-50 ml-5">

					<label for="name"><i class="fas fa-user mr-2"></i>Name</label> <input
						type="text" name="name" id="name" placeholder="Enter name"
						class="form-control">

				</div>

				<div class="form-group w-50 ml-5">

					<label for="password"><i class="fas fa-lock mr-2"></i>Password</label>
					<input type="text" name="password" id="password"
						placeholder="Enter password" class="form-control">

				</div>


				<div class="form-group w-50 ml-5">

					<label for="email"><i class="fas fa-envelope mr-2"></i>Email</label>
					<input type="text" name="email" id="email"
						placeholder="Enter email" class="form-control">

				</div>
				<div class="form-group w-50 ml-5">

					<label for="mobileNo"><i class="fas fa-mobile-alt mr-2"></i>Mobile
						No</label> <input type="number" name="mobileNo" id="mobileNo"
						placeholder="Enter mobile no" class="form-control">

				</div>

				<div class="form-group w-50 ml-5">

					<label for="address"><i class="fas fa-map-marker-alt mr-2"></i>Address</label>
					<input type="text" name="address" id="address"
						placeholder="Enter address" class="form-control">

				</div>
				<div class="form-group ml-5">

					<button type="submit" class="btn btn-primary font-weight-bold">
						REGISTER<i class="fas fa-sign-in-alt ml-2"></i>
					</button>
					<span class="font-weight-normal">Already Have An Account ? <a
						href="login.jsp" class="active-link">SIGN IN</a>
					</span>

				</div>
				<div class="bg-primary  p-4 text-center">
					<span class=" text-white font-weight-bold">&copy; abhinay
						technologies 2021-2022</span>
				</div>
			</div>

		</div>
	</form>
</body>
</html>
