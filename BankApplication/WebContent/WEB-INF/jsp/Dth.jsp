<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DTH Recharge</title>
</head>
<body>
<h2>${message}</h2> 

<form action ="Dth.html" method="post">

<h>Select your Operator</h>
  <select name="operator">
    <option value="TATA">TATASKY</option>
    <option value="Airtel">Airtel Digital TV</option>
    <option value="Dish">Dish TV</option>
    <option value="Sun">Sun TV</option>
  </select><br>
  <br>
 <h>Enter Your Amount</h>
 <input type="text" name="amt"> <br>
 <br>
 <input type ="submit" name="Submit" value="Proceed to pay"/>
 <input type="button" id="b2" value = "Cancel" onclick="location.href='/BankApplication/sumbitservice.html'"></input>
 
</form>
</body>
</html>