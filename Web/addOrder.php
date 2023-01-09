<?php
include_once("sqlconfig.php");

$ID = $_POST['OrderID'];
$RoomNumber = $_POST['RoomNumber'];
$CustomerID = $_POST['CustomerID'];
$Date = $_POST['OrderDate'];

$sql = "INSERT INTO Orders VALUES ('$ID','$RoomNumber','$CustomerID','$Date')";
$conn->query($sql);

header("Location: Orders.php");
?>