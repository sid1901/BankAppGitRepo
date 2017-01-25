<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Spring MVC login example.</title> 


</head>

<body>               		
<h2>${message}</h2><h2>${message1}</h2><h2>${message2}</h2>  
<f:view>

<h>Initiate Fund Transfer</h>
<h>From which of your accounts* :</h>

<form action="NEFT.html" method="post">
<select name="AccType">
    <option value="Savings" ${savings}> Savings - ${S_AccNo} </option>
    <option value="Current" ${current}> Current - ${C_AccNo} </option>
</select></br>

<h>Select your Payee account* :</h>
<select name="Payee">
          <c:forEach var="item" items="${payees}">
            <option value="${item.key}">${item.value}</option>
          </c:forEach>
        </select>
        <h></br></h>
<h>Enter Amount to transfer <input type="text" name="Amount"></h> <br></br>

<!-- <input type="text" name="PayeeAccNo"> Enter Payee Acc No </input> </br>
<input type="text" name="PayeeFullName"> Enter Payee Full Name </input> </br>
<input type="text" name="Amount"> Enter Amount to transfer </input> </br> -->
<input type="submit" value = "Confirm"></input>

<input type="button" id="b2" value = "Home" onclick="location.href='/BankApplication/Validate.html'"></input>
<input type="button" id="b3" value = "Add Payee" onclick="location.href='/BankApplication/AddPayee.html'"></input>
</form>
</f:view>
</body>


</html>
