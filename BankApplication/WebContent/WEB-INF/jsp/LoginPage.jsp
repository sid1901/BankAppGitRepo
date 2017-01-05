<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 

<!-- <script>
function preventBackButton(){window.history.forward();}
setTimeout("preventBackButton()", 0);
window.onunload=function(){null};
</script> -->

<head> 
<title>Spring MVC login example.</title> 
</head> 
<body> 
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);
session.invalidate();
%>
<h4>${message}</h4>
<h4>${message1}</h4>
<h4>${message2}</h4> 
<h4>${message3}</h4>
<h4>${message4}</h4> 
 
<jsp:include page="/index.jsp"></jsp:include>
</body> 
</html>