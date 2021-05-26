<!--    * Title: Recall the structure of what TA was coding in lab
        * Author: TA
        * Date: 2021
        * Code version: N/A
        * Availability: Lab 7, 8, 9
-->
<?php
    //terminate the session when log out

    session_start();
    unset($_SESSION['username']);

    session_destroy();
    echo "<script type='text/javascript'>
                alert('Log out succesfully!');
                window.location.href = 'https://smcse.city.ac.uk/student/adbt269/MyWebsite/login.html';
                </script>";
?>