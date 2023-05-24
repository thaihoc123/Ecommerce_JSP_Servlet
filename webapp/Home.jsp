<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="#!">SHOP WATCH</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#!">Home</a></li>
					<c:if test="${sessionScope.account.isAdmin==1}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">Manager</a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="OderAdmin">Oder</a></li></ul>
					</c:if>
				 <c:if test="${sessionScope.account==null}">
							<li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a></li>
						</c:if> 
						
						<c:if test="${sessionScope.account.isAdmin==1}">
							<li class="nav-item"><a class="nav-link" href="AddNew.jsp">AddNew</a></li>
							<li class="nav-item"><a class="nav-link" href="DeleteServlet">Edit</a></li>
						</c:if>
						<c:if test="${sessionScope.account!=null}">
							<li class="nav-item"><a class="nav-link"
								href="LogOutServlet">Logout</a></li>
						</c:if> 
				</ul>
				<form action="SearchServlet" method="post" class="form-inline my-3">
    				<div class="input-group">
        				<input type="text" class="form-control" name="txtSearchValue" value="${param.txtSearchValue}" placeholder="Search value" />
        				<button type="submit" class="btn btn-primary">Search</button>
    				</div>
				</form>
				&ensp;
				<c:if test="${sessionScope.account.isAdmin==0}">
				<form class="d-flex">
					<a href="CartServlet" class="btn btn-outline-dark" type="submit">
						<i class="bi-cart-fill me-1"></i> Cart <span
							class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.carts.size() }</span>
					</a>
				</form>
				</c:if>
			</div>
		</div>
	</nav>
	<!-- Header-->
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<h1 class="display-4 fw-bolder">Hello ${sessionScope.account.user}</h1>
				<p class="lead fw-normal text-white-50 mb-0">Vietnam's No.1 Watch Brand</p>
			</div>
		</div>
	</header>
	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:if test="${empty DSSP}">
					 <div class="col-12 text-center">
                    <h5>No product match!</h5>
                </div>
				</c:if>
				<c:forEach items="${DSSP}" var="x">
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<img class="card-img-top" style="height:50%;" src="${x.img} " alt="..." />
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">${x.name }</h5>
									<!-- Product price-->
									$${x.price }
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto" href="ProductServlet?id=${x.id}">information
									</a>
									
								</div>
							</div>
						</div>
					</div>
					
				</c:forEach>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright by DONG HO THAI HOC &copy; Your Website 2023</p>
			<p class="m-0 text-center text-white">Chu so huu Website: NGUYEN THAI HOC - So: 41A8034825 - Ngay Cap: 11/12/2002</p>
			<p class="m-0 text-center text-white">Lien he SDT: 0896.200.798</p>
			<p class="m-0 text-center text-white">Gmail: thaihoc2le2@gmail.com</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js\script.js"></script>
</body>
</html>
