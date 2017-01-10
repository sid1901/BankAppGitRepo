<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 

<title>Spring MVC login example.</title> 
</head> 
  <link rel="stylesheet" href="css/main.css">
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<body> 
<header  style="text-align: center;">SSA BANK</header> </br>

<h2>${message}</h2>
<h2>${message1}</h2> 
<h2>${message2}</h2>  
<%-- <h2>${UserName}</h2><br/> --%>  

<<<<<<< HEAD



<!--right sidebar-->   
        <div class="col-sm-4">
        
        	<div class="right-sidebar bg-white">
        	
<div class="ad-block"><h1>Categories</h1></div>
<input type="button"  id="services" value = "Services" onclick="location.href='/BankApplication/Services.html'" ></input></br></br>
<input type="button" id="profile" value = "Profile" onclick="location.href='/BankApplication/Profile.html'" ></input></br></br>
<input type="button" id="services" value = "Passbook" onclick="location.href='/BankApplication/passbook.html'" ></input></br></br>
<input type="button" id="services" value = "Create multiple Account" onclick="location.href='/BankApplication/multiAcc.html'" ></input></br></br>
=======
<input type="button" id="services" value = "Services" onclick="location.href='/BankApplication/Services.html'" ></input></br>
<input type="button" id="profile" value = "Profile" onclick="location.href='/BankApplication/Profile.html'" ></input></br>
<input type="button" id="services" value = "Passbook" onclick="location.href='/BankApplication/passbook.html'" ></input></br>
<input type="button" id="services" value = "Open multiple Account" onclick="location.href='/BankApplication/multiAcc.html'" ></input></br>
<input type="button" id="services" value = "Funds Transfer" onclick="location.href='/BankApplication/FundsTransfer.html'" ></input></br>
<input type="button" id="b3" value = "Add Payee" onclick="location.href='/BankApplication/AddPayee.html'"></input>
<br/>
<br/>
	
>>>>>>> branch 'master' of https://github.com/sid1901/BankAppGitRepo.git

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

           
           <div class="col-sm-5">

            <!--main content-->           
            <div class="row">
            	<div class="col-sm-12">
                	<div class="main-content bg-white">
                    	<div class="row">
            				<div class="col-sm-12">
                				<div class="ad-block">kasdghgasdggasdkgkfjd</div>
                			</div>
                		</div>
                    </div>
                </div>
            </div>
           
        </div>
   
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
</br></br></br>
 
</body> 
</br></br></br></br></br></br></br></br></br></br></br></br>
<footer>Copyright &copy; ssa.com</footer>
</html>