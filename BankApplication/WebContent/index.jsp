<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banking App</title>
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
</script>

<body>
		<header  style="text-align: center;">SSA BANK</header> </br>
 	<h1  style="text-align: center;">Welcome to Web based banking application</h1> </br>
<div class="container">
	<section id="content">
		
	
	<form action="Validate.html" method="POST">
			<h1>Login Form</h1></br></br>
			
		<input type="text" name="uid" required="" id="username" placeholder="Username"/> </br></br>
		<input type="password" name="pwd" required="" id="password" placeholder="password " /></br> 
	<a href="Forgot.html" > Forgot Password? </a>	</br></br>	<a href="Register.html">  New user</a></br>
	<%--<jsp:forward page="/WEB-INF/jsp/ForgotPWDPage.jsp"></jsp:forward> --%>
		<input type="submit" value="Submit" /></br>
</br>
</br>
</br></br></br></br>
	</form>

			
		
	</section><!-- content -->
</div><!-- container -->

</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
</body>
  <footer>Copyright &copy; ssa.com</footer>
    <script src="js/index.js"></script>


</head>

</html>