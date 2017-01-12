<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Fund Transfer</title> 
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
						<a href="FundsTransfer.html">Fund Transfer</a><br></br>
						<a href="AddPayee.html">Add Payee</a><br></br>
						
						<% 
						String uid = (String) session.getAttribute("uid");
						%>
						
						
						<br/>
						
						   
						<form action="Logout.html" method="post">
						<input type="submit" value="Logout" ></input>
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
                    	
                				<div class="ad-block">
								<h2>Initiate Fund Transfer</h2>
								</div>
<f:view>
<h2><br></br></h2>


<form action="NEFT.html" method="post">
<h2>From which of your accounts* :</h2><select name="AccType">
    <option value="Savings" ${savings}> Savings - ${S_AccNo} </option>
    <option value="Current" ${current}> Current - ${C_AccNo} </option>
</select><br></br>



<h2>Select your Payee account* :</h2>
<select name="Payee">
          <c:forEach var="item" items="${payees}">
            <option value="${item.key}">${item.value}</option>
          </c:forEach>
        </select>
<br></br>
Enter Amount to transfer <input type="text" name="Amount"> </input><br> </br>

<!-- <input type="text" name="PayeeAccNo"> Enter Payee Acc No </input> </br>
<input type="text" name="PayeeFullName"> Enter Payee Full Name </input> </br>
<input type="text" name="Amount"> Enter Amount to transfer </input> </br> -->
<input type="submit" value = "Confirm"></input>

<input type="button" id="b2" value = "Home" onclick="location.href='/BankApplication/Validate.html'"></input>
<input type="button" id="b3" value = "Add Payee" onclick="location.href='/BankApplication/AddPayee.html'"></input>
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
                	<p>Copyright &copy; ExoticTheme 2015, Downloaded from <a href="http://localhost:8083/BankApplication/" target="_blank">SSA.com</a></p>
                </div>
            </div>
        </div>
    </div>


</div>



</body>
</html>
