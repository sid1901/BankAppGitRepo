<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Electricity paytment</title>
</head>
<body>
<h2>${message}</h2> 

<form action ="Elebill.html" method="post">
<br>
<h>Select your Board</h>
  <select name="board">
    <option value="MP">Madhya Pradesh(MPEB)</option>
    <option value="AP">Ardhra(APEPB)</option>
    <option value="MH">Maharashtra(MEB)</option>
    <option value="CG">CGEB</option>
  </select><br>
  <br>
 <h>Enter Your Amount</h>
 <input type="text" name="amt"> <br>
 <br>
 <input type ="submit" name="Submit" value="Proceed to pay"/>
<input type="button" id="s1" value = "back" onclick="location.href='/BankApplication/Services.html'"></input>
 
</form>
</body>
</html>