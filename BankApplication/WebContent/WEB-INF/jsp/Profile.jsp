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
               				<div class="ad-block">welcome</div>							                			</div>
					</div>
						<script>
							function myFunction() {
							    document.getElementById("fname").removeAttribute('disabled');
							    document.getElementById("lname").removeAttribute('disabled');
							    document.getElementById("add1").removeAttribute('disabled');
							    document.getElementById("add2").removeAttribute('disabled');
							    document.getElementById("mob").removeAttribute('disabled');
							    document.getElementById("age").removeAttribute('disabled');
							    document.getElementById("email").removeAttribute('disabled');
							    document.getElementById("save").removeAttribute('disabled');
							    document.getElementById("update").disabled="disabled";
							    
							}
							</script>
						
							
							
							<form action="SaveProfile.html" method="post">
							<table>

									  <tr>
									    <td><h4>Name:</h4></td>
									    <td><input type = "text" name="fname" id="fname" value =${fname}  disabled="disabled"></input></h4></td>
									   
									  </tr>
									  <tr>
									    <td><h4>LastName:  </h4></td>
									    <td><input type = "text" name="lname" id="lname" value =${lname} disabled="disabled"></input></h4></td>
									
									  </tr>
									  
									  <tr>
									    <td><h4>Address Line1:  </h4></td>
									    <td><input type = "text" id="add1" name="add1" value =${add1} disabled="disabled"></input></h4></td>
									
									  </tr>
									  <tr>
									    <td><h4>Address Line2:     </h4></td>
									    <td><input type = "text" id="add2" name="add2" value =${add2} disabled="disabled"></input></h4></td>
									
									  </tr>
									  <tr>
									    <td><h4>Mobile:       </h4></td>
									    <td><input type = "text" id="mob" name="mob" value =${mob} disabled="disabled"></input></h4></td>
									
									  </tr>
									 <tr>
									    <td><h4>Email:    </h4></td>
									    <td><input type = "text" id="email" name="email" value =${email} disabled="disabled"></input></h4></td>
									
									  </tr>
									 
									  <tr>
									    <td><h4>Age:  </h4></td>
									    <td><input type = "text" id="age" name="age" value =${age} disabled="disabled"></input></td>
									
									  </tr>
							
									  <tr>
									    <td><input type="button" id="update" value="Update Profile"  onclick="myFunction()"></input>   </td>
									    <td><input type="submit" id="save" value="Save Profile" disabled="disabled"></input></td>
									   
									  </tr>
									  <tr>
									    <td><br></br><input type="button" id="b2" value = "Home" onclick="location.href='/BankApplication/Validate.html'"></input></td>
									    <td></td>
									   
									  </tr>
							</table>
						</form>
								</div>	
											             			
                        </div>
                       </div>
                    </div>
           
           

    <!--footer start-->
    <div class="row">
    	<div class="col-sm-12">
        	<div class="footer bg-white">
            	<div class="copyright">
                	<p>Copyright &copy; ExoticTheme 2015, Downloaded from <a href="http://localhost:8083/BankApplication/" target="_blank">SSA.com</a></p>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
