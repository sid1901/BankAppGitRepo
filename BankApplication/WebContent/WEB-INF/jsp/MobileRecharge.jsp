<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Recharge</h1>
<form action ="Mobilerecharge.jsp" method="post">
<input type="radio" name="pre" value="Prepaid" autocomplete="on" > Pre-paid
<input type="radio" name="pre" value="Postpaid"> Post paid<br>

<h1>Please Enter Your Mobile Number</h1><br>
<input type="text" name="mob" placeholder="Please Enter Your Mobile Number">
<h1>Select your Operator</h1> 
  <select name="operator">
    <option value="bsnl">BSNL</option>
    <option value="Airtel">Airtel</option>
    <option value="Docomo">Docomo</option>
    <option value="Idea">Idea</option>
  </select>
  <br>
 <h1>Enter Your Amount</h1>
 <input type="text" name="amt" placeholder="Please Enter Your Amount"> <br><br>
 
 <input type ="submit" name="Submit" value="submit"/>
</form>
</body>
</html>