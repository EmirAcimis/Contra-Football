<?php
   session_start();
   
   if(session_destroy()) {
      header("Location: http://dijkstra2.ug.bcc.bilkent.edu.tr/~emir.acimis/login.php");
   }
?>


