<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.abhi.crud.model.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<!-- <link rel="stylesheet" href="css/bootstrap.css">
 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<script>
	function onDelete(empCode) {

		alert(empCode);
		if (confirm("Do you wanna delete?")) {
			$.ajax({
				url : "delete",
				type : "POST",
				data : {
					empCode : empCode
				},
				success : function(response) {
					alert(response);
					location.reload();

				},
				error : function(error) {
					alert(error);
				}
			});//ajax

		} else {
			return false;
		}
	}

	function onUpdateData(){
		alert("Updating");
		var email=$("#email").val();
		var address=$("#address").val();
		var mobileNumber=$("#mobileNumber").val();

		$.ajax({
			url : "update",
			type : "POST",
			data : {
				email : email,
				address:address,
				mobileNumber:mobileNumber
			},
			success : function(response) {
				alert(response);
				location.reload();


			},
			error : function(error) {
				alert(error);
			}
		});//ajax

		
	}
	
	
	
	
	function onUpdate(empCode) {

		
		alert(empCode);

		$.ajax({
			url : "empByCode",
			type : "GET",
			data : {
				empCode : empCode
			},
			success : function(response) {
				var objData = JSON.parse(response);
				alert(response);
				$("#email").val(objData.email);
				$("#address").val(objData.address);
				$("#mobileNumber").val(objData.mobileNumber);

			},
			error : function(error) {
				alert(error);
			}
		});//ajax

	}
</script>
</head>
<body>
	<form>

		<div class="container mt-5">
                     <%-- <%=session.getAttribute("username") %> --%>
                      <%=request.getAttribute("email")%>525252525555555555555

			<div class="main">
				<h4 class="bg-secondary text-white p-3">
					<i class="fas fa-users ml-2 mr-2"></i>Employee Details
				</h4>

				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>Employee Code</th>
							<th>Name</th>
							<th>Email</th>
							<th>Mobile Number</th>
							<th>Address</th>
							<th colspan="2">Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
						ArrayList<Employee> employees = (ArrayList<Employee>) request.getAttribute("employees");
						%>
						<%
						for (Employee emp : employees) {
						%>
						<tr>

							<td><%=emp.getCode()%></td>
							<td><%=emp.getName()%>
							<td><%=emp.getEmail()%>
							<td><%=emp.getMobileNumber()%>
							<td><%=emp.getAddress()%></td>
							<td><button type="button" class="btn btn-danger"
									onclick="onDelete('<%=emp.getCode()%>')" id="empCode">
									<i class="fas fa-trash-alt"></i>
								</button></td>

							<td><button type="button" class="btn btn-success"
									data-toggle="modal" data-target="#exampleModalLong"
									onclick="onUpdate('<%=emp.getCode()%>')">
									<i class="fas fa-edit"></i>
								</button></td>


						</tr>
						<%
						}
						%>
					</tbody>

				</table>

			</div>

			<a href="index.jsp"><i class="fas fa-user-plus"></i></a>

		</div>





		<!-- Modal -->

		<div class="modal fade" id="exampleModalLong" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalLongTitle"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text-white text-center p-2 bg-secondary"
							id="exampleModalLongTitle" style="width: 496px">UPDATE
							PROFILE</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<label for="email">Email</label> <input type="email"
								placeholder="email" id="email" class="form-control">

						</div>

						<div class="form-group">
							<label for="mobileNumber">Mobile Number</label> <input
								type="number" placeholder="mobileNumber" id="mobileNumber"
								class="form-control">

						</div>

						<div class="form-group">
							<label for="address">Address</label> <input type="text"
								placeholder="address" id="address" class="form-control">

						</div>



					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">
							<i class="fas fa-window-close mr-2"></i>Close
						</button>
						<button type="button" class="btn btn-primary"   onclick="onUpdateData()">
							<i class="fas fa-pen-square mr-2"></i>Update
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>