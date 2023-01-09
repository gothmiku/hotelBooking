<?php
include("sqlconfig.php");
        $hotelid = $_GET['hotelid'];
        $roomid = $_GET['roomid'];
        $single = $_GET['single'];
        $double = $_GET['double'];
        $hotelid = stripcslashes($hotelid);
        $roomid = stripcslashes($roomid);
        $single = stripcslashes($single);
        $double = stripcslashes($double);
        $hotelid = mysqli_real_escape_string($conn,$hotelid);
        $roomid = mysqli_real_escape_string($conn,$roomid);
        $single = mysqli_real_escape_string($conn,$single);
        $double = mysqli_real_escape_string($conn,$double);
        $hotelid = (int) $hotelid;
        $roomid = (int) $roomid;
        $single = (int) $single;
        $double = (int) $double;
        $statement = $conn->prepare("UPDATE rooms
        SET HotelID=?, RoomID = ?, SingleBedNo = ? , DoubleBedNo = ?
        WHERE RoomID = ?");
        $statement->bind_param("iiiii", $hotelid, $roomid, $single, $double, $roomid);
        $statement->execute();
        header("Location: Rooms.php");
        mysqli_close($conn);
?>