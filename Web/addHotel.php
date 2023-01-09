<?php
include_once("sqlconfig.php");

$ID = $_POST['HotelID'];
$name = $_POST['HotelName'];
$rNo = $_POST['RoomNumber'];

$sql = "INSERT INTO Hotel VALUES ('$name','$rNo','$ID')";
$conn->query($sql);

header("Location: Hotels.php");
?>