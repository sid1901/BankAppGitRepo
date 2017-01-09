<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<f:view>
Initiate Fund Transfer
<h>From which of your accounts* :</h>
<form action="NEFT.html" method="post">
<select name="AccType">
    <option value="Savings" ${savings}> Savings - ${S_AccNo} </option>
    <option value="Current" ${current}> Current - ${C_AccNo} </option>
</select></br>




<select name="department">
          <c:forEach var="item" items="${dept}">
            <option value="${item.key}">${item.value}</option>
          </c:forEach>
        </select>






<input type="text" name="PayeeAccNo"> Enter Payee Acc No </input> </br>
<input type="text" name="PayeeFullName"> Enter Payee Full Name </input> </br>
<input type="text" name="Amount"> Enter Amount to transfer </input> </br>
<input type="submit" value = "Confirm">
</form>
<input type="button" id="b2" value = "Home" onclick="location.href='/BankApplication/Validate.html'"></input>
<input type="button" id="b3" value = "Add Payee" onclick="location.href='/BankApplication/AddPayee.html'"></input>
</f:view>
</body>
</html>