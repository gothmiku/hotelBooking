<?php
include("sqlconfig.php");
$id = $_POST['HotelID'];

// Build the DELETE statement
$sql = "DELETE FROM Hotel WHERE HotelID = $id";

// Execute the DELETE statement
$conn->query($sql);
$conn->close();
header("Location: Hotels.php")
?>