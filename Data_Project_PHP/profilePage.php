<html>
<head>
<title>CF - Profile</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
</head>

<link rel="stylesheet" type="text/css" href="popup.css">

<body bgcolor="#FFFFFF" background="images/main_background.png" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('images/profile_home_on.png','images/profile_profile_on.png','images/profile_signout_on.png')">
<!-- Save for Web Slices (profile.psd) -->
<table width="970" height="540" border="0" align="center" cellpadding="0" cellspacing="0" id="Table_01">
	<tr>
		<td colspan="5">
			<img src="images/profile_01.png" width="970" height="221" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/profile_02.png" width="32" height="40" alt=""></td>
		<td>
			<a href="Main.php" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Home','','images/profile_home_on.png',1)"><img src="images/profile_home_off.png" alt="Home" width="114" height="40" id="Home"></a></td>
		<td>
			<img src="images/profile_03.png" width="214" height="40" alt=""></td>
		<td rowspan="5">
		<div class="profilechild" style="overflow-y:scroll; width: 250px; height:144px">
		<?php
						include 'session.php';
						define('DB_SERVER', 'dijkstra2.ug.bcc.bilkent.edu.tr');
						define('DB_USERNAME', 'emir.acimis');
						define('DB_PASSWORD', 'xcqjgigkp');
						define('DB_DATABASE', 'emir_acimis');
						$db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);
			
						// Check connection
						if (mysqli_connect_errno())
						{
							echo "Failed to connect to MySQL: " . mysqli_connect_error();
						}

						$result = mysqli_query($db,"SELECT user_id, name, birth_date FROM User WHERE user_id = '$login_session'");

						echo "<table border='1'>
						<tr>
						<th>Profile</th>
						</tr>";

						while($row = mysqli_fetch_array($result))
						{
							echo "<tr>";
							echo "<td>" . $row['user_id'] . "<br><br/>".$row['name'] . "<br><br/>" . $row['birth_date'] . "<br><br/></td>";
							echo "</tr>";
						}
						echo "</table>";

						mysqli_close($db);
					?>
			</div>
		</td>
		<td>
			<img src="images/profile_04.png" width="360" height="40" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/profile_05.png" width="360" height="11" alt=""></td>
		<td>
			<img src="images/profile_06.png" width="360" height="11" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/profile_07.png" width="32" height="40" alt=""></td>
		<td>
			<a href="profilePage.php" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Profile','','images/profile_profile_on.png',1)"><img src="images/profile_profile_off.png" alt="Profile" width="114" height="40" id="Profile"></a></td>
		<td>
			<img src="images/profile_08.png" width="214" height="40" alt=""></td>
		<td>
			<img src="images/profile_09.png" width="360" height="40" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/profile_10.png" width="360" height="13" alt=""></td>
		<td>
			<img src="images/profile_11.png" width="360" height="13" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/profile_12.png" width="32" height="40" alt=""></td>
		<td>
			<a href="login.php" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Sign-out','','images/profile_signout_on.png',1)"><img src="images/profile_signout_off.png" alt="Just Don't!" width="114" height="40" id="Sign-out"></a></td>
		<td>
			<img src="images/profile_13.png" width="214" height="40" alt=""></td>
		<td>
			<img src="images/profile_14.png" width="360" height="40" alt=""></td>
	</tr>
	<tr>
		<td colspan="5">
			<img src="images/profile_15.png" width="970" height="175" alt=""></td>
	</tr>
</table>
<!-- End Save for Web Slices -->
</body>
</html>








	