<?php
$host = "localhost";
$user="root";
$password = "";
$db_name = "hotelchart";

$conn = mysqli_connect($host, $user, $password, $db_name);
if(mysqli_connect_errno()){
   die("Failed to connect" . mysqli_connect_error());
}
?>