<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<f:view>

<h></br></h>
Confirm Payee/Biller </br>

DETAILS>CONFIRMATION </br></br>
<h></br></h>
Add Bank Payee </br>
<h></br></h>
<form action="verifyPayee.html" method = "post">

Payee Account Name* <input type="text" name="PayeeFullName">  </input> </br> 
Payee Nickname* <input type="text" name="PayeeNickName">  </input> </br>
Payee Account Number* <input type="text" name="PayeeAccNo">  </input> </br>
Confirm Payee Account Number* <input type="text" name="PayeeAccNo2">  </input> </br>

Ensure that the payee account number entered is correct so that money is transferred to the intended payee.
<h3>Please Note : Once payee is added, You can initiate funds transfer only after two minutes.</h3>
  
<input type="submit" value = "Confirm">  
<input type="button" id="b2" value = "Home" onclick="location.href='/BankApplication/Validate.html'"></input>

</form>
</f:view>
</body>
</html>