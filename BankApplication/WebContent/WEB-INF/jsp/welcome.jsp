<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Spring MVC login example.</title> 
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

<h2>${message}</h2>
<h2>${message1}</h2> 
<h2>${message2}</h2>  
<%-- <h2>${UserName}</h2><br/> --%>  
    
    <!--sidebar and content-->

  	
    	<!--left sidebar-->
		<div class="col-sm-3">
		
				        <div class="left-sidebar bg-white">
				        				<div class="row">
				            		<div class="col-sm-12">
				                		<div class="ad-block">Shortcuts</div>
				                	</div>
				        </div>
				        <a href="Profile.html" > Profile </a></br></br>
				        <a href="Profile.html" > Passbook </a></br></br>
				        <a href="Services.html"> Services </a></br></br>
						<a herf="multiAcc.html">Create Multiple Account</a></br></br>
						<a herf="FundTransfer.html">Fund Transfer</a></br></br>
						<a herf="AddPayee.html">Add Payee</a></br></br>
						
						<% 
						String uid = (String) session.getAttribute("uid");
						%>
						
						
						<br/>
						
						   
						<form action="Logout.html" method="post">
						<input type="submit" value="Logout" >
						</form>
						 	
						<%
						response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
						response.setHeader("Pragma","no-cache");
						response.setDateHeader("Expires", 0);
						
						%>
						        	


              
        <div class="col-sm-5">
        
        	
            <!--main content-->           
            <div class="row">
            	<div class="col-sm-12">
                	<div class="main-content bg-white">
                    	<div class="row">
            				<div class="col-sm-12">
                				<div class="ad-block">welcome</div>
                			</div>
                		</div>
                		
                		<div class="row">
            				<div class="col-sm-12">
                				<div class="ad-block">welcome</div>
                			</div>
                		</div>
                
                    </div>
                </div>
            </div>
            
       
  		</div>
         
  
    
    
    
    
    <!--footer start-->
    <div class="row">
    	<div class="col-sm-12">
        	<div class="footer bg-white">
            	<div class="copyright">
                	<p>Copyright &copy; ExoticTheme 2015, Downloaded from <a href="http://www.exotictheme.com" target="_blank">ExoticTheme.com</a></p>
                </div>
            </div>
        </div>
    </div>

</div>
</div>
</div>


</body>
</html>
