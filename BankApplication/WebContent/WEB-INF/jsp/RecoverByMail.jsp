<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

	<script>
		function otpPopUP() {
		    document.getElementById("confirm").disabled="disabled";
		    document.getElementById("otpdiv").style.display="block";
		    document.getElementById("msg").style.display="none";
		    }
	</script>

<title>Insert title here</title>
</head>
<body>

<div id="msg">Password Recovery mail will be sent to </br>
<label name="l1"> ${email}</label></br>
</div>
<form action = SendMail.html method="post">
<input type="hidden" name ="email" value="${email}"> 
<div id="otpdiv" style="display:none;">
<label name="l2"> OTP is sent to your registered email id.</label> 
<input type="text" name="otp"> Enter OTP </br> 
<input type="submit" value="Verify"></br>
</div>
<input type="button" id="confirm" value="Confirm"  onclick="otpPopUP()"></input>
<input type="button" id="b2" value = "Cancel" onclick="location.href='/BankApplication/index.jsp'"></input></br>

</form>
</body>
</html>