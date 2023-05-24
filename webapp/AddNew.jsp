<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<a style="font-size: 20px" href="SanPhamServlet">Back To Home</a> <br>
	<form action="AddServlet" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<!-- <label for="exampleInputEmail1"> ID </label> <input type="text" name="id" 
				class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Enter ID"> -->
			<label for="exampleInputPassword1"> Name </label> <input type="text" name="name"
				class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Enter Name">
			<label for="exampleInputEmail1"> Price </label> <input type="text" name="price" 
				class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Enter Price">
			<label for="exampleInputEmail1"> Image </label> <input type="file" name="img" 
				class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Enter Image">
				<label for="exampleInputEmail1"> Description </label> <input type="text" name="des" 
				class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Enter Description">
		</div>
		<input type="submit" class="btn btn-primary">ADD</button>
	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous">
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous">
	</script>
</body>
</html>