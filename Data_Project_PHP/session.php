 <?php
   include 'config.php';
   session_start();
   
   $user_check = $_SESSION['login_user'];
   
   $ses_sql = mysqli_query($db,"select user_id from User where user_id = '$user_check' ");
   
   $row = mysqli_fetch_array($ses_sql,MYSQLI_ASSOC);
   
   $login_session = $row['user_id'];
   
   if(!isset($_SESSION['login_user'])){
      header("Location: http://dijkstra2.ug.bcc.bilkent.edu.tr/~emir.acimis/login.php");
   }
?>