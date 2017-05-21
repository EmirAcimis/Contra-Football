<html>
<head>
<title>CF - News Feed</title>
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

<body bgcolor="#FFFFFF" background="images/main_background.png" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('images/main_home_on.png','images/main_profile_on.png','images/main_signout_on.png','images/main_createPost_on.png')">
<!-- Save for Web Slices (Main.psd) -->
<table width="970" height="541" border="0" align="center" cellpadding="0" cellspacing="0" id="Table_01">
	<tr>
		<td colspan="9">
			<img src="images/main_01.png" width="970" height="79" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/main_02.png" width="259" height="142" alt=""></td>
		<td colspan="2" rowspan="7">
            <div class="newsfeedchild" style="overflow-y:scroll; width: 327px; height:321px">
			
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

						$result = mysqli_query($db,"SELECT * FROM Post");

						echo "<table border='1'>
						<tr>
						<th>News</th>
						</tr>";

						while($row = mysqli_fetch_array($result))
						{
							echo "<tr>";
							echo "<td>" . $row['topic'] ."<br><br/>" . $row['text'] . "<br><br/></td>";
							echo "</tr>";
						}
						echo "</table>";

						mysqli_close($db);
					?>
			
            </div></td>
		<td colspan="2" rowspan="7">
			<img src="images/main_12.png" width="95" height="321" alt=""></td>
		<td>
            <div class="topscorerchild" style="overflow-y:scroll;width:257px;height:142px">
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

						$result = mysqli_query($db,"SELECT name, no_of_goals FROM Statistics NATURAL JOIN Player GROUP BY name ORDER BY no_of_goals DESC LIMIT 5");

						echo "<table border='1'>
						<tr>
						<th>News</th>
						</tr>";

						while($row = mysqli_fetch_array($result))
						{
							echo "<tr>";
							echo "<td>" . $row['name'] . "<br><br/>" .$row['no_of_goals'] . "<br><br/></td>";
							echo "</tr>";
						}
						echo "</table>";

						mysqli_close($db);
			?>
           	</div></td>
		<td rowspan="7">
			<img src="images/main_14.png" width="32" height="321" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/main_03.png" width="32" height="40" alt=""></td>
		<td>
			<a href="Main.php" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Home','','images/main_home_on.png',1)"><img src="images/main_home_off.png" alt="Home" width="114" height="40" id="Home"></a></td>
		<td>
			<img src="images/main_04.png" width="113" height="40" alt=""></td>
		<td rowspan="2">
			<img src="images/main_13.png" width="257" height="51" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/main_05.png" width="259" height="11" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/main_06.png" width="32" height="40" alt=""></td>
		<td>
			<a href="profilePage.php" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Profile','','images/main_profile_on.png',1)"><img src="images/main_profile_off.png" alt="Profile" width="114" height="40" id="Profile"></a></td>
		<td>
			<img src="images/main_07.png" width="113" height="40" alt=""></td>
		<td rowspan="4">
            <div class="mvpchild" style="overflow-y:scroll;width:257px;height:128px">
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

						$result = mysqli_query($db,"SELECT name, value FROM Player GROUP BY name ORDER BY value DESC LIMIT 5");

						echo "<table border='1'>
						<tr>
						<th>News</th>
						</tr>";

						while($row = mysqli_fetch_array($result))
						{
							echo "<tr>";
							echo "<td>" . $row['name'] . "<br><br/>" .$row['value'] . "<br><br/></td>";
							echo "</tr>";
						}
						echo "</table>";

						mysqli_close($db);
			?>
   			</div></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/main_08.png" width="259" height="13" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/main_09.png" width="32" height="40" alt=""></td>
		<td>
			<a href="login.php" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Sign-Out','','images/main_signout_on.png',1)"><img src="images/main_signout_off.png" alt="Just Don't!" width="114" height="40" id="Sign-Out"></a></td>
		<td>
			<img src="images/main_10.png" width="113" height="40" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/main_11.png" width="259" height="35" alt=""></td>
	</tr>
	<tr>
		<td colspan="9">
			<img src="images/main_15.png" width="970" height="86" alt=""></td>
	</tr>
	<tr>
		<td colspan="4">
			<img src="images/main_16.png" width="385" height="36" alt=""></td>
		<td colspan="2">
			<a href="createPost.php" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Create Post','','images/main_createPost_on.png',1)"><img src="images/main_createPost_off.png" alt="Create New Post" width="202" height="36" id="Create Post"></a></td>
		<td colspan="3">
			<img src="images/main_17.png" width="383" height="36" alt=""></td>
	</tr>
	<tr>
		<td colspan="9">
			<img src="images/main_18.png" width="970" height="18" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/spacer.gif" width="32" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="114" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="113" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="126" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="201" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="1" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="94" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="257" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="32" height="1" alt=""></td>
	</tr>
</table>
<!-- End Save for Web Slices -->
</body>

</html>