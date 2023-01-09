<?php
include("sqlconfig.php");
$id = $_POST['OrderID'];

// Build the DELETE statement
$sql = "DELETE FROM Orders WHERE OrderID = $id";

// Execute the DELETE statement
$conn->query($sql);
$conn->close();
header("Location: Orders.php")
?>