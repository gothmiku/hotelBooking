<?php
include_once("sqlconfig.php");

$ID = $_POST['HotelID'];
$name = $_POST['RoomID'];
$gender = $_POST['SingleBedNo'];
$address = $_POST['DoubleBedNo'];

$sql = "INSERT INTO Rooms VALUES ('$ID','$name','$gender','$address')";
$conn->query($sql);

header("Location: Rooms.php");
?>