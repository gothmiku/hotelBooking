<?php
include("sqlconfig.php");
$id = $_POST['RoomID'];

// Build the DELETE statement
$sql = "DELETE FROM Rooms WHERE RoomID = $id";

// Execute the DELETE statement
$conn->query($sql);
$conn->close();
header("Location: Rooms.php")
?>