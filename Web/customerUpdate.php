<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel System Dashboard</title>
    <link rel="stylesheet" href="dashboardStyle.css" media="screen" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>

<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
    <div>

        <div class="contentBox">
            <form class="updateForm" action='CustomerUpdateSession.php'>
                <div class="inputWrapper">
                    Customer ID: <input class="loginInput" type="text" name="id" value="<?php if (isset($_GET['id'])) {
                        echo $_GET['id'];
                    } else {
                        echo "";
                    } ?>" />
                </div>
                <div class="inputWrapper">
                    Full Name <input class="loginInput" type="text" name="name"
                        value="<?php if (isset($_GET['name'])) {
                            echo urldecode($_GET['name']);
                        } ?>" />
                </div>
                <div class="inputWrapper">
                    Gender <input class="loginInput" type="text" name="gender" value="<?php if (isset($_GET['gender'])) {
                        echo $_GET['gender'];
                    } else {
                        echo "";
                    } ?>" />
                </div>
                <div class="inputWrapper">
                    Address <input class="loginInput" type="text" name="address" value="<?php if (isset($_GET['address'])) {
                        echo $_GET['address'];
                    } else {
                        echo "";
                    } ?>" />
                </div>
                <button class='loginButton' method='POST' type='submit' formaction='CustomerUpdateSession.php'> Update
                </button>
            </form>
            <div class="dashboardBox">
                <div class="dashboardItems">
                    <br><a class="items" href="Customer.php">Customer</a></br>
                    <br><a class="items" href="Hotels.php">Hotels</a></br>
                    <br><a class="items" href="Rooms.php">Rooms</a></br>
                    <br><a class="items" href="Orders.php">Orders</a></br>
                </div>
            </div>
        </div>
    </div>
</body>

</html>