<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 

<script>
function preventBackButton(){window.history.forward();}
setTimeout("preventBackButton()", 0);
window.onunload=function(){null};
</script>

<head> 
<title>Spring MVC login example.</title> 
</head> 
<body> 
 <h2>${message}</h2><br/> 
<jsp:include page="/index.jsp"></jsp:include> 
</body> 
</html>