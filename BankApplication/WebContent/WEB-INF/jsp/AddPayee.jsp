<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Add payee</title> 
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="container">
	<!--header start-->
	<div class="row">
    	<div class="col-sm-12">
        	<div class="header bg-white">            		
            			<div class="logo"><a href="http://www.exotictheme.com" target="_blank">SSA BANK</a></div>
                		<div class="ad-block"></div>            	
            </div>
        </div>
    </div>


<%-- <h2>${UserName}</h2><br/> --%>  
    
    <!--sidebar and content-->

  	
    	<!--left sidebar-->
		<div class="col-sm-3">
		
				        <div class="left-sidebar bg-white">
				        				<div class="row">
				            		<div class="col-sm-12">
				                		<div class="ad-block"><h3>Shortcuts</h3></div>
				                	</div>
				        </div>
				        <a href="Profile.html" > Profile </a><br></br>
				        <a href="Profile.html" > Passbook </a><br></br>
				        <a href="Services.html"> Services </a><br></br>
						<a href="multiAcc.html">Create Multiple Account</a><br></br>
						<a href="FundTransfer.html">Fund Transfer</a><br></br>
						<a href="AddPayee.html">Add Payee</a><br></br>
						
						<% 
						String uid = (String) session.getAttribute("uid");
						%>
						
						
						<br/>
						
						   
						<form action="Logout.html" method="post">
						<input type="submit" value="Logout" style="text-align: center;" ></input>
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
                				<div class="ad-block"><h3>welcome</h3></div>
                			</div>
                		</div>
                		
<h2>${message}</h2><h2>${message1}</h2><h2>${message2}</h2>  
                		
 
<f:view>

<h>Confirm Payee/Biller</h>
</br>

<h>DETAILS>CONFIRMATION</h> </br></br>
<h></br></h>
<h>Add Bank Payee</h></br>
<h></br></h>
<form action="verifyPayee.html" method = "post">

<h>Payee Account Name*</h> <input type="text" name="PayeeFullName">  </input> </br> 
<h>Payee Nickname*</h> <input type="text" name="PayeeNickName">  </input> </br>
<h>Payee Account Number*</h> <input type="text" name="PayeeAccNo">  </input> </br>
<h>Confirm Payee Account Number*</h> <input type="text" name="PayeeAccNo2">  </input> </br>

<b>Ensure that the payee account number entered is correct so that money is transferred to the intended payee.
<h3>Please Note : Once payee is added, You can initiate funds transfer only after two minutes.</h3></b>
  
<input type="submit" value = "Confirm"></input>  
<input type="button" id="b2" value = "Home" onclick="location.href='/BankApplication/Validate.html'"></input>

</form>
</f:view>


                    </div>
                </div>
            </div>
            
</div>
    <!--footer start-->
    <div class="row">
    	<div class="col-sm-12">
        	<div class="footer bg-white">
            	<div class="copyright">
                	<p>Copyright &copy; ExoticTheme 2015, Downloaded from <a href="http://localhost:8083/BankApplication/" target="_blank">ExoticTheme.com</a></p>
                </div>
            </div>
        </div>
    </div>

</div>


</body>
</html>
