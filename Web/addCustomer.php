<?php
include_once("sqlconfig.php");

$ID = $_POST['CustomerID'];
$name = $_POST['FullName'];
$gender = $_POST['Gender'];
$address = $_POST['Address'];

$sql = "INSERT INTO Customer VALUES ('$ID','$name','$gender','$address')";
$conn->query($sql);

header("Location: Customer.php");
?>