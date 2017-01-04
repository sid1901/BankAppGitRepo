<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<script>
function myFunction() {
    document.getElementById("fname").removeAttribute('disabled');
    document.getElementById("lname").removeAttribute('disabled');
    document.getElementById("email").removeAttribute('disabled');
    document.getElementById("age").removeAttribute('disabled');
    document.getElementById("mob").removeAttribute('disabled');
    document.getElementById("save").removeAttribute('disabled');
    document.getElementById("update").disabled="disabled";
    
}
</script>
</head>

<body>
<form action="SaveProfile.html" method="post">
<h4>Name: <input type = text name="fname" id="fname" value =${fname}  disabled="disabled"></input></h4>
<h4>LastName: <input type = text name="lname" id="lname" value =${lname} disabled="disabled"></input></h4>
<h4>Email:<input type = text id="email" value =${email} disabled="disabled"></input></h4>
<h4>Age:<input type = text id="age" value =${age} disabled="disabled"></input></h4>
<h4>Mobile:<input type = text id="mob" value =${mob} disabled="disabled"></input></h4>
<input type="button" id="update" value="Update Profile"  onclick="myFunction()">
<input type="submit" id="save" value="Save Profile" disabled="disabled">
</form>
<input type="button" id="b2" value = "Home" onclick="location.href='/BankApplication/Validate.html'"></input>
</body>
</html>