<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="css/main.css">
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobile Recharge</title>
</head>
<body>
<header  style="text-align: center;">SSA BANK</header> </br>
<h2>${message}</h2>

<!--right sidebar-->   
        <div class="col-sm-4">
        
        	<div class="right-sidebar bg-white">
        	
<div class="ad-block"><h1>Categories</h1></div>
<input type="button"  id="services" value = "Services" onclick="location.href='/BankApplication/Services.html'" ></input></br></br>
<input type="button" id="profile" value = "Profile" onclick="location.href='/BankApplication/Profile.html'" ></input></br></br>
<input type="button" id="services" value = "Passbook" onclick="location.href='/BankApplication/passbook.html'" ></input></br></br>
<input type="button" id="services" value = "Create multiple Account" onclick="location.href='/BankApplication/multiAcc.html'" ></input></br></br>

<% 
String uid = (String) session.getAttribute("uid");
%>

Logged in id=<%=uid %>
<br/>

   
<form action="Logout.html" method="post">
<input type="submit" value="Logout" >
</form>
 	
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);

%>
        	</div>
           
   </div>
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
</br></br></br>
 
</body> 
</br></br></br></br></br></br></br></br></br></br></br></br>





 
<input type="text" name="mob"><br>
<br>
<form action ="Txn.html" method="post">
<input type="radio" name="pre" value="Prepaid"  autocomplete="on" > Pre-paid
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
 <footer>Copyright &copy; ssa.com</footer>
</body>
</html>