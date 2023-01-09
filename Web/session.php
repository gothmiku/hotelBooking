<?php
include('sqlconfig.php');
$email = $_POST['email'];
$password = $_POST['password'];


$email = stripcslashes($email);
$password = stripcslashes($password);
$email = mysqli_real_escape_string($conn,$email);
$password = mysqli_real_escape_string($conn,$password);

$sql = "select * from accountinfo where email='$email' and password='$password'";
$result = $conn->query($sql);

if(mysqli_num_rows($result)===1){
   header("Location: dashboard.php");
}
else{
   echo "Login failed";
}
?>