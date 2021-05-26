<?php
//base address of your webspace (change abcd123 for your username):
//http://smcse.city.ac.uk/student/abcd123/

    //change localhost to smcse-stuproj00.city.ac.uk
    //change charlie to your username 'abcd123'
    //change password to your mysql password (not your normal password, but your 9 digit reg no)
    //change abcd123 to your username 'abcd123'
    //change 8889 to 3306
    $db = new mysqli('smcse-stuproj00.city.ac.uk', 'adbt269', '200054829', 'adbt269', '3306');
    if ($db->connect_error) {
      printf("Connection failed: %s\n", $db->connect_error);
      exit();
    } 
?>