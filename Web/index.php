<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="style.css" media="screen" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel System Login</title>
</head>

<?php
    include_once "sqlconfig.php";
?>

<body>
    <div class="box-parent">
        <div class="headBox">
            <h1 id="onlyHeader">Hotel Management System</h1>
        </div>
        <div class="backgroundNoise"></div>
        <div class="box">
            <form name="form1" class="loginForm" action="session.php" method="POST" onsubmit="return validation()">
                <div class="inputWrapper">
                    E-mail: <input class="loginInput" type="text" name="email" />
                </div>
                <div class="inputWrapper">
                    Password: <input class="loginInput" type="password" name="password" />
                </div>
                <button class="loginButton" type="submit" > Login </button>
            </form>
        </div>
    </div>
</body>
<script>
    function validation(){
        var id=document.form1.email.value;
        var password=document.form1.password.value;
        if(id.length==""&&password.length==""){
            alert("Email and password is empty.");
            return false;
        }
        else{
            if(id.length==""){
                alert("Email is empty.");
                return false;
            }
            if(password.length==""){
                alert("Password is empty.");
                return false;
            }
        }
    }
</script>
</html>