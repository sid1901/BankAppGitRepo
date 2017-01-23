<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
</head>
<body>
<f:view>
<h2>${message}</h2> 

<h>From which of your accounts* :</h>
<form action="TxnResult.html" method="post">
<select name="AccType">
    <option value="Savings" ${savings}> Savings - ${S_AccNo} </option>
    <option value="Current" ${current}> Current - ${C_AccNo} </option>
</select><br></br>
<br></br><input type="submit" value="Confirm">
<input type="button" id="s1" value = "back" onclick="location.href='/BankApplication/Services.html'"></input>
<input type="button" id="b2" value = "Home" onclick="location.href='/BankApplication/Validate.html'"></input>
</form>
</f:view>
</body>
</html>