<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 

<title>Welcome</title> 
</head> 
<body> 



<%-- <h2>${ModalName}</h2> --%> 

<%
//allow access only if session exists
//out.println("asdasd");
String user = null;
if(session.getAttribute("user") == null){
	response.sendRedirect("index.html");


}else {
	user = (String) session.getAttribute("user");
	 out.print("welcome " + user); 
}
%>

<h1>Select your Service</h1>
<form action="Service.html" method="post">
<select name="Option">
    <option value="Sr">Service</option>
    <option value="PB">Pass book</option>
 </select>
<input type="Submit" value="Submit" >
</form>

</body> 
</html>