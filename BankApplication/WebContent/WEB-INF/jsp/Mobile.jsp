<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobile Recharge</title>
</head>
<body>
<h2>${message}</h2><br/> 
<form action ="Mobile.html" method="post">
<input type="radio" name="pre" value="Prepaid"  > Pre-paid
<input type="radio" name="pre" value="Postpaid"> Post paid<br>

<h1>Please Enter Your Mobile Number</h1><br>
<input type="text" name="mob" >
<h1>Select your Operator</h1> 
  <select name="operator">
    <option value="bsnl">BSNL</option>
    <option value="Airtel">Airtel</option>
    <option value="Docomo">Docomo</option>
    <option value="Idea">Idea</option>
  </select>
  <br>
 <h1>Enter Your Amount</h1>
 <input type="text" name="amt" > <br><br>
 
 <input type ="submit" name="Submit" value="submit"/>
</form>
</body>
</html>