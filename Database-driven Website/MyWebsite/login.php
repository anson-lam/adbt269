<!--    * Title: Recall the structure of what TA was coding in lab
        * Author: TA
        * Date: 2021
        * Code version: N/A
        * Availability: Lab 7, 8, 9
-->
<?php
    if (!isset($_SESSION)){
        session_start();
    }
    require_once('connectdb.php');

    //filter inputs
    $login_username = htmlentities($_POST['login_username']);
    $login_pwd = htmlentities($_POST['login_pwd']);

    //escape outputs
    $login_username = mysqli_real_escape_string($db, $login_username);
    $login_pwd = mysqli_real_escape_string($db, $login_pwd);

    //select username from the database table
    $query = "SELECT Username, Password FROM UserDetails WHERE Username='$login_username'";
    $result = mysqli_query($db, $query);
    
    //fetch the specific row
    $row = mysqli_fetch_row($result);

    //allow login if the username and password are correct, not allow otherwise
    if (isset($row[0]) && password_verify($login_pwd, $row[1])){
        $_SESSION['username'] = $login_username;
        echo "<script type='text/javascript'>
                window.location.href = 'https://smcse.city.ac.uk/student/adbt269/MyWebsite/booking.php';
                </script>";
    } else {
        echo "<script type='text/javascript'>
                alert('Unable to log in - check your username & password.');
                window.location.href = 'https://smcse.city.ac.uk/student/adbt269/MyWebsite/login.html';
                </script>";
    }
?>