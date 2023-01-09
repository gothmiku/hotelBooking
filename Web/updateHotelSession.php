<?php
include("sqlconfig.php");
        $name = urldecode($_GET['name']);
        $room = $_GET['room'];
        $id = $_GET['id'];
        $name = stripcslashes($name);
        $room = stripcslashes($room);
        $id = stripcslashes($id);
        $name = mysqli_real_escape_string($conn,$name);
        $room = mysqli_real_escape_string($conn,$room);
        $id = mysqli_real_escape_string($conn,$id);
        $id = (int) $id;
        $room = (int) $room;
        $statement = $conn->prepare("UPDATE Hotel
        SET  HotelName = ?, RoomNumber = ?,HotelID=?
        WHERE HotelID = ?");
        $statement->bind_param("siii", $name, $room, $id, $id);
        $statement->execute();
        header("Location: Hotels.php");
        mysqli_close($conn);
?>