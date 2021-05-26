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
    require_once "connectbookdb.php";

    //filter inputs
    $username = htmlentities($_SESSION['username']);
    $from = htmlentities($_POST['from']);
    $to = htmlentities($_POST['to']);
    $date = htmlentities($_POST['date']);
    $time = htmlentities($_POST['time']);

    //escape outputs
    $username = mysqli_real_escape_string($bookdb, $username);
    $from = mysqli_real_escape_string($bookdb, $from);
    $to = mysqli_real_escape_string($bookdb, $to);
    $date = mysqli_real_escape_string($bookdb, $date);
    $time = mysqli_real_escape_string($bookdb, $time);

    //insert user inputs into the database table
    $stm = mysqli_prepare($bookdb, "INSERT INTO Booking VALUES (?,?,?,?,?)");

    mysqli_stmt_bind_param($stm, "sssss", $username, $from, $to, $date, $time);

    mysqli_stmt_execute($stm);

    echo "<script language='javascript'>
                alert('Booked successfully!');
                window.location.href = 'https://smcse.city.ac.uk/student/adbt269/MyWebsite/booking.php';
                </script>";
?>