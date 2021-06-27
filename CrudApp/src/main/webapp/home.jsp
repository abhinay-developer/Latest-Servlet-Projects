<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="css/bootstrap.css">
 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<style>
  body{
  
  background-image: url("https://cdn.pixabay.com/photo/2018/08/15/07/19/indian-flag-3607410_960_720.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  }

</style>
<body>

	<a href="<%=request.getContextPath()%>/empInfo"
		class="nav-link bg-dark text-white p-2 " style="width: 175px">Employee Info</a>

	<div style="float: right;" class="text-white">
		<strong>Your Email:</strong><%=session.getAttribute("username")%></div>
		
		<strong>Request Email <%=request.getAttribute("email")%></strong>



</body>
</html>