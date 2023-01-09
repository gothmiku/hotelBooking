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
            <form class="updateForm" action='updateRoomSession.php'>
                <div class="inputWrapper">
                    Hotel ID <input class="loginInput" type="text" name="hotelid" value="<?php if (isset($_GET['hotelid'])) {
                        echo $_GET['hotelid'];
                    } else {
                        echo "";
                    } ?>" />
                </div>
                <div class="inputWrapper">
                    Room ID <input class="loginInput" type="text" name="roomid"
                        value="<?php if (isset($_GET['roomid'])) {
                            echo $_GET['roomid'];
                        } ?>" />
                </div>
                <div class="inputWrapper">
                    Single Bed Number <input class="loginInput" type="text" name="single" value="<?php if (isset($_GET['single'])) {
                        echo $_GET['single'];
                    } else {
                        echo "";
                    } ?>" />
                </div>
                <div class="inputWrapper">
                    Double Bed No <input class="loginInput" type="text" name="double" value="<?php if (isset($_GET['double'])) {
                        echo $_GET['double'];
                    } else {
                        echo "";
                    } ?>" />
                </div>
                <button class='loginButton' method='POST' type='submit' formaction='updateRoomSession.php'> Update
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