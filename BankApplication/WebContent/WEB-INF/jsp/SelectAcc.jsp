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
<h>Select Your Account :</h>
<form action="NEFT.html" method="post">
<select name="AccType">
    <option value="Savings" ${savings}> Savings - ${S_AccNo} </option>
    <option value="Current" ${current}> Current - ${C_AccNo} </option>
</select></br>
<input type="button" id="b2" value = "Home" onclick="location.href='/BankApplication/Validate.html'"></input>
</f:view>
</body>
</html>