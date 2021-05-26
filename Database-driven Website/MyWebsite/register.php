<!--    * Title: Recall the structure of what TA was coding in lab
        * Author: TA
        * Date: 2021
        * Code version: N/A
        * Availability: Lab 7, 8, 9
-->
<?php
    require_once "connectdb.php";

    //filter inputs
    $username = htmlentities($_POST['username']);
    $firstname = htmlentities($_POST['firstname']);
    $lastname = htmlentities($_POST['lastname']);
    $phone = htmlentities($_POST['phone']);
    $email = htmlentities($_POST['email']);
    $password = htmlentities($_POST['psw']);
    $password2 = strip_tags($_POST['psw2']);

    //escape outputs
    $username = mysqli_real_escape_string($db, $username);
    $firstname = mysqli_real_escape_string($db, $firstname);
    $lastname = mysqli_real_escape_string($db, $lastname);
    $phone = mysqli_real_escape_string($db, $phone);
    $email = mysqli_real_escape_string($db, $email);
    $password = mysqli_real_escape_string($db, $password);
    $password2 = mysqli_real_escape_string($db, $password2);
    
    //encrypt password
    $hashed_password = password_hash($password, PASSWORD_DEFAULT);
    $hashed_password2 = password_hash($password2, PASSWORD_DEFAULT);

    //sanitise and validate email
    $email = filter_var($email, FILTER_SANITIZE_EMAIL);
    if (!filter_var($email, FILTER_VALIDATE_EMAIL) === false) {
    } else {
        echo"<script type='text/javascript'>
        alert('Please enter a valid email.');
        </script>";
    }

    //insert user inputs into the database table
    $stm = mysqli_prepare($db, "INSERT INTO UserDetails VALUES (?,?,?,?,?,?,?)");
    
    //select username from the database table
    $query = "SELECT Username FROM UserDetails WHERE Username='$username'";
    $result = mysqli_query($db, $query);

    //select email from the database table
    $query2 = "SELECT Email FROM UserDetails WHERE Email='$email'";
    $result2 = mysqli_query($db, $query2);

    //check that the username and email has not been registered before allowing register
    if (mysqli_num_rows($result)==1){
        echo "<script type='text/javascript'>
                alert('Username taken - please enter a different username.');
                window.location.href = 'https://smcse.city.ac.uk/student/adbt269/MyWebsite/register.html';
                </script>";
    } else if (mysqli_num_rows($result2)==1) {
        echo "<script type='text/javascript'>
                alert('Email taken - please enter a different email.');
                window.location.href = 'https://smcse.city.ac.uk/student/adbt269/MyWebsite/register.html';
                </script>";
    } else {
        mysqli_stmt_bind_param($stm, "sssssss", $username, $firstname, $lastname, $email, $phone, $hashed_password, $hashed_password2);
        mysqli_stmt_execute($stm);
        echo "<script language='javascript'>
                alert('Registered successfully! Please log in here.');
                window.location.href = 'https://smcse.city.ac.uk/student/adbt269/MyWebsite/login.html';
                </script>";
    }
?>