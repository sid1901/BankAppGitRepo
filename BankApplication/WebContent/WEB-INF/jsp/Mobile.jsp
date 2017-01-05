<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobile Recharge</title>
</head>
<body>
<h2>${message}</h2> 
<input type="text" name="mob"><br>
<br>
<form action ="Mobile.html" method="post">
<input type="radio" name="pre" value="Prepaid"  > Pre-paid
<input type="radio" name="pre" value="Postpaid"> Post paid<br>
<br>
<h>Select your Operator</h>
  <select name="operator">
    <option value="bsnl">BSNL</option>
    <option value="Airtel">Airtel</option>
    <option value="Docomo">Docomo</option>
    <option value="Idea">Idea</option>
  </select><br>
  <br>
 <h>Enter Your Amount</h>
 <input type="text" name="amt"> <br>
 <br>
 <input type ="submit" name="Submit" value="proceed to pay"/>
 <input type="button" id="s1" value = "back" onclick="location.href='/BankApplication/Services.html'"></input>
 <input type="button" id="b2" value = "Home" onclick="location.href='/BankApplication/Validate.html'"></input>
 
</form>
</body>
</html>