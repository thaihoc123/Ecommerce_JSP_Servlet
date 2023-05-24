<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.preview-thumbnail.nav-tabs li img{
		height: 80px;
	}
	.card{
		padding: 9em;
	}
	
</style>
</head>
<body>
	<!DOCTYPE html>
<html lang="en">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>eCommerce Product Detail</title>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700"
	rel="stylesheet">
<link href="css/product.css" rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<body>
	<div class="container" style="position: relative;">
		<a style="font-size: 25px; position: absolute; top:10px; left:15px;" href="SanPhamServlet">Back To Home</a>
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						<div class="preview-pic tab-content">
							<div class="tab-pane active" id="pic-1">
								<img src="${p.img }" />
							</div>
						</div>
						<ul class="preview-thumbnail nav nav-tabs">
							<c:forEach items="${pd}" var="x">
							<li class="active"><a data-target="#pic-1" data-toggle="tab"><img
									src="${x.img }" /></a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${p.name }</h3>
						<p class="product-description">${p.description }</p>
						<h4 class="price">
							current price: <span>$${p.price }</span>
						</h4>
						<c:if test="${sessionScope.account.isAdmin==0}">
						<div class="action">
							<a href="AddToCartServlet?id=${p.id}" class="add-to-cart btn btn-default" type="button">add
								to cart</a>
						
							<button class="like btn btn-default" type="button">
								<span class="fa fa-heart"></span>
							</button>
						</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
</body>
</html>