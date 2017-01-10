<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Banking Services</title>
  <link rel="stylesheet" href="css/main.css">
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
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

<!--right sidebar-->  


 <br>
<form action="sumbitservice.html" method="post">
<select name="Service11">
    <option value= "MB">Mobile Recharge</option>
    <option value="EB">Electricity Bill</option>
    <option value="DTH">DTH</option>
  </select>
  <br><br>

<input type="submit" value="Submit" >
<input type="button" id="s1" value = "back" onclick="location.href='/BankApplication/Validate.html'"></input>

</form>

   
<%-- <%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);
session.invalidate();
%> 
 --%>
 <footer>Copyright &copy; ssa.com</footer>
 </body>
</html>