<?php
define('DB_SERVER', 'dijkstra2.ug.bcc.bilkent.edu.tr');
define('DB_USERNAME', 'emir.acimis');
define('DB_PASSWORD', 'xcqjgigkp');
define('DB_DATABASE', 'emir_acimis');
$db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);

if(isset($_POST['action']))
{          
    if($_POST['action']=="signup")
    {
		$myusername   = mysqli_real_escape_string($db,$_POST['username']);
        $myname       = mysqli_real_escape_string($db,$_POST['name']);
        $mybirthdate  = mysqli_real_escape_string($db,$_POST['birthdate']);
        $mypassword   = mysqli_real_escape_string($db,$_POST['password']);
       
        $sql = "INSERT INTO User(user_id,name,birth_date,password) VALUES('$myusername','$myname','$mybirthdate','$mypassword ')";
		$result = mysqli_query($db,$sql);
		$row = mysqli_fetch_array($result,MYSQLI_ASSOC);
		$active = $row['active'];
		if($result == TRUE){
			header("location: accountCreateComplete.php");
		}
        
    }
	if(session_destroy()) {
      header("Location: http://dijkstra2.ug.bcc.bilkent.edu.tr/~emir.acimis/login.php");
   }
}
 
?>
<!-- Login and Signup forms -->
<html>
   
	<head>
		<title>Create Account Page</title>
      
			<style type = "text/css">
				.reg{
					margin: 0 auto 0 auto;
					width: 210px;
					height: 278px;
					background-color: #FFFFFF;
				}
				body {
					font-family:Arial, Helvetica, sans-serif;
					font-size:14px;
				}
         
				label {
					font-weight:bold;
					width:100px;
					font-size:14px;
				}
         
				.box {
					border:#666666 solid 0px;
				}
				
			</style>
      
   </head>
   <head>
<title>CF - Register</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body bgcolor="#FFFFFF" background="images/login_background.png" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<!-- Save for Web Slices (Register.psd) -->
<table width="970" height="540" border="0" align="center" cellpadding="0" cellspacing="0" id="Table_01">
	<tr>
		<td colspan="3">
			<img src="images/register_01.png" width="970" height="217" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/register_02.png" width="715" height="278" alt=""></td>
			
		<td><div class = "reg" align = "center">
			<div style = "width:210px; height:278px; border: solid 0px #333333; " align = "left">
				<div style = "background-color:#333333; color:#FFFFFF; padding:3px;"><b>Enter Information</b></div>
				
				<div style = "margin:30px">
					<div id="tabs-2">
						<form action="" method="post">
							<p><input id="username" name="username" type="text" placeholder="Username"></p>
							<p><input id="name" name="name" type="text" placeholder="Name"></p>
							<p><input id="birthdate" name="birthdate" type="text" placeholder="Birthdate"></p>
							<p><input id="password" name="password" type="password" placeholder="Password">
							<input name="action" type="hidden" value="signup" /></p>
							<h2><a href = "http://dijkstra2.ug.bcc.bilkent.edu.tr/~emir.acimis/createAccount.php"><input type="submit" value="Create Account"></a></h2>
						</form>
					</div>
					<h2><a href = "http://dijkstra2.ug.bcc.bilkent.edu.tr/~emir.acimis/login.php"><input type="submit" value="Back to Login Page"></a></h2>
		
               
					<div style = "font-size:11px; color:#cc0000; margin-top:10px"><?php echo $error; ?></div>
					
				</div>
				
			</div>
			
		</div>

			</td>
		<td>
			<img src="images/register_03.png" width="45" height="278" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/register_04.png" width="970" height="45" alt=""></td>
	</tr>
</table>
<!-- End Save for Web Slices -->
</body>
</html>





