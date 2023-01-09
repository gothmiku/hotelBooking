<?php
include("sqlconfig.php");
        $name = urldecode($_GET['name']);
        $gender = $_GET['gender'];
        $address = $_GET['address'];
        $customerid = $_GET['id'];
        $name = stripcslashes($name);
        $gender = stripcslashes($gender);
        $address = stripcslashes($address);
        $customerid = stripcslashes($customerid);
        $name = mysqli_real_escape_string($conn,$name);
        $gender = mysqli_real_escape_string($conn,$gender);
        $address = mysqli_real_escape_string($conn,$address);
        $customerid = mysqli_real_escape_string($conn,$customerid);
        $customerid = (int) $customerid;
$gender = (int) $gender;
        $statement = $conn->prepare("UPDATE customer
        SET CustomerID=?, FullName = ?, Gender = ? , Address = ?
        WHERE CustomerID = ?");
$statement->bind_param("isisi", $customerid, $name, $gender, $address, $customerid);
$statement->execute();
header("Location: Customer.php");
        mysqli_close($conn);
?>