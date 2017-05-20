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
         
         header("location: welcome.php");
      }else {
         $error = "Your Login Name or Password is invalid";
      }
   }
?>
<html>
   
	<head>
		<title>Login Page</title>
      
			<style type = "text/css">
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
					border:#666666 solid 1px;
				}
			</style>
      
   </head>
   
	<body bgcolor = "#FFFFFF">
		<div align = "center">
			<div style = "width:300px; border: solid 1px #333333; " align = "left">
				<div style = "background-color:#333333; color:#FFFFFF; padding:3px;"><b>Login</b></div>
				<div style = "margin:30px">
					<form action = "" method = "post">
						<p><input id="username" name="username" type="text" placeholder="Username"></p>
						<p><input id="password" name="password" type="password" placeholder="Password">
						<input name="action" type="hidden" value="signup" /></p>
						<input type = "submit" value = " Submit "/><br />
					</form>
					<h2><a href = "http://dijkstra2.ug.bcc.bilkent.edu.tr/~emir.acimis/createAccount.php"><input type="submit" value="Create Account"></a>
					
					<div style = "font-size:11px; color:#cc0000; margin-top:10px"><?php echo $error; ?></div>
				</div>
			</div>
		</div>
	</body>
</html>