<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style1.css">
<title>Login/Register Form</title>
<script>
		var check = function () {
		    if (document.getElementById('password').value ==
		        document.getElementById('confirm_password').value) {
		        document.getElementById('message').style.color = 'green';
		        document.getElementById('message').innerHTML = 'Password Matching';
		    } else {
		        document.getElementById('message').style.color = 'red';
		        document.getElementById('message').innerHTML = 'Password is Not Matching';
		    }
		} 
		function validateForm() {
	        var userField = document.getElementById('user');
	        var passField = document.getElementById('password');
	        var repeatPassField = document.getElementById('confirm_password');

	        if (userField.value.length < 6 || userField.value.length > 25) {
	            alert('User must be between 6 and 25 characters long');
	            return false;
	        }
	        if (passField.value.length < 8) {
	            alert('Password must be at least 8 characters long');
	            return false;
	        }
	        if (passField.value !== repeatPassField.value) {
	            alert('Password does not match the confirmation password');
	            return false;
	        }
	        return true;
	    }
	</script>
</head>
<body>
	<div id="logreg-forms">
		<form class="form-signin" action="LoginServlet" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">SIGN IN</h1>
			<p class="alert-danger" role="alert" style="text-align: center">${mess}</p>
			<input type="email" name="user" class="form-control"
				placeholder="User" required="" autofocus=""> 
			<input type="password" name="pass" class="form-control" minlength="8"
				placeholder="Password" required="">
			<button class="btn btn-success btn-block" type="submit">
				<i class="fas fa-sign-in-alt"></i> Sign in
			</button>
			<p class="alert-success" role="alert" style="text-align: center">${signinsuccess}</p>
			<a href="#" id="forgot_pswd">Forgot password?</a>
			<hr>
			<!-- <p>Don't have an account!</p>  -->
			<button class="btn btn-primary btn-block" type="button"
				id="btn-signup">
				<i class="fas fa-user-plus"></i> Sign up New Account
			</button>
		</form>
		<form action="EmailServlet" method ="get" class="form-reset">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">INSERT YOUR EMAIL</h1>
			<input type="email" id="resetUser" class="form-control" name="reset"
				placeholder="Enter your email" required="" autofocus="">
			<button class="btn btn-primary btn-block" type="submit">Send OTP</button>
			<a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i>
				Back</a>
		</form>

		<form action="SignUpServlet" method="post" class="form-signup" onsubmit="return validateForm();">
		<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">SIGN UP ACCOUNT</h1>
		<p class="alert-danger" role="alert" style="text-align: center">${mess1}</p>
			<input type="email" name="user" 
				class="form-control" placeholder="User" minlength="6" maxlength="25" required autofocus=""> 
			<input type="password" name="pass" id="password" onkeyup='check();' value =""
				class="form-control" placeholder="Password" minlength="8" required autofocus="">
			<input type="password" name="repeatpass" id="confirm_password" onkeyup='check();' value =""
				class="form-control" placeholder="Repeat Password" required autofocus="">
			<span id='message'></span>
			<button class="btn btn-primary btn-block" type="submit">
				<i class="fas fa-user-plus"></i> Sign Up
			</button>
			<a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i>
				Back</a>
		</form>
		<br>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="js\script.js"></script>
</body>
</html>