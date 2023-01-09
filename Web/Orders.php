<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel System Dashboard</title>
    <link rel="stylesheet" href="dashboardStyle.css" media="screen" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <div>
        <div class="popup">
    <div>
        <form name="customerForm" class="addSection" action="addOrder.php" method="POST" onsubmit="return validation()">
                <div class="inputWrapper">
                    Order ID <input class="loginInput" type="text" name="OrderID" />
                    Room Number <input class="loginInput" type="text" name="RoomNumber" />
                    Customer ID <input class="loginInput" type="text" name="CustomerID" />
                    Date <input class="loginInput" type="text" name="OrderDate" />
                </div>
                <button class="btn btn-primary btn-sm" id="addButton" type="submit" > Add </button>
            </form>
        </div>
        <div class="dashboardBox">
                <div class="dashboardItems">
                <br><a class="items" href="Customer.php">Customer</a></br>
                <br><a class="items" href="Hotels.php">Hotels</a></br>
                <br><a class="items" href="Rooms.php">Rooms</a></br>
                <br><a class="items" href="Orders.php">Orders</a></br>
            </div>
        </div>
        <div class="contentBox">
            <table class="table">
            <thead>
                <tr>
                <th>Order ID</th>
                <th>Room Number</th>
                <th>Customer ID</th>
                <th>Date</th>
                <th>Action</th>
</tr>
            </thead>
            <tbody>
                <tr>
            <?php
                include("sqlconfig.php");
            $sqlquery = "select * from Orders";
            $result = $conn->query($sqlquery);
            if(!$result){
                die("Invalid query: ". $conn->error);
            }
            while($row=$result->fetch_assoc()){
                $encodedName = urlencode($row['OrderDate']);
                echo "<tr><td>" . $row["OrderID"] . "</td>
                <td>" . $row["RoomNumber"] . "</td>
                <td>" . $row["CustomerID"] . "</td>
                <td>" . $row["OrderDate"] . "</td>
                <td>
                <a href='updateOrder.php?orderid=".$row['OrderID']."&roomid=".$row['RoomNumber']."&customerid=".$row['CustomerID']."&date=".$encodedName."' class='updateButton' >Update</a>
                <form action='deleteOrder.php' method='POST'>
            <input type='hidden' name='OrderID' value=".$row['OrderID'].">
        <input type='submit' value='Delete'>
      </form>
                </tr>
                ";
            }
            ?>
            </tr>
            </tbody>
            </table>
        </div>
        </div>
    </div>
</body>
</html>