<?php
include("sqlconfig.php");
        $orderid = $_GET['orderid'];
        $roomid = $_GET['roomid'];
        $customerid = $_GET['customerid'];
        $date = urldecode($_GET['date']);
        $orderid = stripcslashes($orderid);
        $roomid = stripcslashes($roomid);
        $customerid = stripcslashes($customerid);
        $date = stripcslashes($date);
        $orderid = mysqli_real_escape_string($conn,$orderid);
        $roomid = mysqli_real_escape_string($conn,$roomid);
        $customerid = mysqli_real_escape_string($conn,$customerid);
        $date = mysqli_real_escape_string($conn,$date);
        $orderid = (int) $orderid;
        $roomid = (int) $roomid;
        $customerid = (int) $customerid;
        $statement = $conn->prepare("UPDATE Orders
        SET OrderID=?, RoomNumber = ?, CustomerID = ? , OrderDate = ?
        WHERE OrderID = ?");
        $statement->bind_param("iiisi", $orderid, $roomid, $customerid, $date, $orderid);
        $statement->execute();
        header("Location: Orders.php");
        mysqli_close($conn);
?>