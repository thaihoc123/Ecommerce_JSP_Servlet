<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style1.css">
<title>Repassword Form</title>
<script>
  document.addEventListener("DOMContentLoaded", function() {
    var otpForm = document.getElementById("otp-form");
    var otpInput = document.getElementById("otp");
    var messageElement = document.getElementById("message");
    var otpString = '<%= session.getAttribute("otp") %>'; 

    otpForm.addEventListener("submit", function(event) {
      event.preventDefault(); 
      var enteredOTP = otpInput.value;
      if (enteredOTP === otpString) {
        otpForm.submit(); 
      } else {
        messageElement.innerHTML = "OTP is incorrect! Please try again.";
        messageElement.style.color ="red";
      }
    });
  });
</script>

</head>
<body>
	<div id="logreg-forms">
  		<form id="otp-form" class="form-signin" action="EmailServlet" method="post">
    	<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">INSERT THE OTP</h1>
    	<input type="text" name="otp" id="otp" value=""
      class="form-control" placeholder="Insert the OTP" required autofocus="">
    	<span id="message"></span>
    	<button class="btn btn-success btn-block" type="submit">
      <i class="fas fa-sign-in-alt"></i> Submit
    	</button>
  		</form>
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