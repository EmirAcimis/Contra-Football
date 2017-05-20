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
				<div style = "background-color:#333333; color:#FFFFFF; padding:3px;"><b>Create Account</b></div>
				
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

	</body>
</html>
