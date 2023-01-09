<?php
include("sqlconfig.php");
$id = $_POST['CustomerID'];

// Build the DELETE statement
$sql = "DELETE FROM Customer WHERE CustomerID = $id";

// Execute the DELETE statement
$conn->query($sql);
$conn->close();
header("Location: Customer.php")
?>