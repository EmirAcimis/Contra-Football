<?php
   include("config.php");
   session_start();
   
   if($_SERVER["REQUEST_METHOD"] == "POST") {
      // username and password sent from form 
      
      $myusername = mysqli_real_escape_string($db,$_POST['username']);
      $mypassword = mysqli_real_escape_string($db,$_POST['password']); 
      
      $sql = "SELECT * FROM User WHERE user_id = '$myusername' and password = '$mypassword'";
      $result = mysqli_query($db,$sql);
      $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
      $active = $row['active'];
      
      $count = mysqli_num_rows($result);
      
      // If result matched $myusername and $mypassword, table row must be 1 row
		
      if($count == 1) {
         session_register("myusername");
         $_SESSION['login_user'] = $myusername;
         
         header("location: Main.php");
      }else {
         $error = "Your Login Name or Password is invalid";
      }
   }
?>
<html>
	<head>
		<title>Login Page</title>
			
			<style type = "text/css">
				.log{
					margin: 0 auto 0 auto;
					width: 210px;
					height: 214px;
					background-color: #FFFFFF;
				}
				body {
					font-family:Arial, Helvetica, sans-serif;
					font-size:14px;
				}
				tr{
					z-index: -1;
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
<title>CF - Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body bgcolor="#FFFFFF" background="images/login_background.png" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<!-- Save for Web Slices (Login.psd) -->
<table width="970" height="540" border="0" align="center" cellpadding="0" cellspacing="0" id="Table_01">
	<tr>
		<td colspan="3">
			<img src="images/login_01.png" width="970" height="281" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/login_02.png" width="715" height="214" alt=""></td>
		<td><div class = "log" align = "center">
			<div style = "width:210px; height:214px; border: solid 0px #333333; " align = "left">
				<div style = "background-color:#333333; color:#FFFFFF; padding:3px;"><b>Login</b></div>
				<div style = "margin:30px">
					<form action = "" method = "post">
						<p><input id="username" name="username" type="text" placeholder="UserID"></p>
						<p><input id="password" name="password" type="password" placeholder="Password">
						<input name="action" type="hidden" value="signup" /></p>
						<input type = "submit" value = " Submit "/><br />
					</form>
					<h2><a href = "http://dijkstra2.ug.bcc.bilkent.edu.tr/~emir.acimis/createAccount.php"><input type="submit" value="Create Account"></a>
					
					<div style = "font-size:11px; color:#cc0000; margin-top:10px"><?php echo $error; ?></div>
				</div>
			</div>
		</div>
			</td>
		<td>
			<img src="images/login_03.png" width="45" height="214" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/login_04.png" width="970" height="45" alt=""></td>
	</tr>
</table>
<!-- End Save for Web Slices -->
</body>

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</html>