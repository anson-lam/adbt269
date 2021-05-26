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

    $username = $_SESSION['username'];

    require_once "connectdb.php";
    require_once "connectbookdb.php";
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>FlyUK | Home</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!--    * Title: CSS Framework/Library
                * Author: w3schools, cloudflare
                * Date: 2021
                * Code version: N/A
                * Availability: following links
        -->
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="style.css">
    </head>
    
    <body id="myPage">

        <!-- Sidebar --><!-- Simplify the original version -->
        <!--    * Title: Marketing / Website Template
                * Author: w3schools
                * Date: 2021
                * Code version: N/A
                * Availability: https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_templates_website&stacked=h
        -->
        <nav class="w3-sidebar w3-bar-block w3-white w3-card w3-animate-left w3-xxlarge" style="display:none;z-index:2" id="mySidebar">
            <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-display-topright w3-text-teal">Close
            <i class="fa fa-remove"></i>
            </a>
            <a href="about.html" class="w3-bar-item w3-button">Link 1</a>
            <a href="contact.html" class="w3-bar-item w3-button">Link 2</a>
            <a href="register.html" class="w3-bar-item w3-button">Link 3</a>
            <a href="login.html" class="w3-bar-item w3-button">Link 4</a>
            <a href="#" class="w3-bar-item w3-button">Link 5</a>
        </nav>

        <!-- Navbar --><!-- Simplify the original version -->
        <!--    * Title: Marketing / Website Template
                * Author: w3schools
                * Date: 2021
                * Code version: N/A
                * Availability: https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_templates_website&stacked=h
        -->
        <div class="w3-top">
            <!-- Navbar on large screens -->
            <div class="w3-bar w3-theme-d2 w3-left-align">
                <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
                <a href="index.html" class="w3-bar-item w3-button w3-teal"><i class="fa fa-home w3-margin-right"></i>Home</a>
                <a href="about.html" class="w3-bar-item w3-button w3-hide-small w3-hover-white">About</a>
                <a href="contact.html" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contact</a>
                <!--<a href="register.html" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Register</a>-->
                <!--<a href="login.html" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Logout</a>-->
                <?php
                    if (isset($_SESSION['username'])) {
                        $_SESSION['logout'] = 
                            '<a href="logout.php" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Log Out</a>';
                        echo $_SESSION['logout'];
                    }
                ?>
                <a href="#" class="w3-bar-item w3-button w3-hide-small w3-right w3-hover-teal" title="Search"><i class="fa fa-search"></i></a>
            </div>
            <a href="#" class="w3-bar-item w3-button w3-hide-small w3-right w3-hover-teal" title="Search"><i class="fa fa-search"></i></a>

            <!-- Navbar on small screens -->
            <div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium">
                <a href="about.html" class="w3-bar-item w3-button">About</a>
                <a href="contact.html" class="w3-bar-item w3-button">Contact</a>
                <!--<a href="register.html" class="w3-bar-item w3-button">Register</a>-->
                <!--<a href="login.html" class="w3-bar-item w3-button">Logout</a>-->
                <?php
                    if (isset($_SESSION['username'])) {
                        $_SESSION['logout'] = 
                            '<a href="logout.php" class="w3-bar-item w3-button">Log Out</a>';
                        echo $_SESSION['logout'];
                    }
                ?>
                <a href="#" class="w3-bar-item w3-button">Search</a>
            </div>
        </div>
        
        <!-- display the username -->
        <h1 id="booking_h1">Welcome, <?php echo $_SESSION['username'];?>!</h1>
        
        <h2>Your booking</h2>
            <!-- display all booking of the user -->
            <?php
                $query = "SELECT * FROM Booking WHERE Username = '$username' ";
                //Username= "$_SESSION['username']"
                $result = $bookdb->query($query);
        
                if (mysqli_num_rows($result) == 0) {
                    echo "You have no booking. Please use the form below to book a flight";
                } else {
                    //echo $_SESSION['username'];
                    echo "<table>";
                    echo "<tr><th>From</th><th>To</th><th>Date</th><th>Time</th></tr>";
                    while ($row = $result->fetch_assoc()) {
                        echo "<tr>";
                        echo "<td>".$row['From']."</td>";
                        echo "<td>".$row['To']."</td>";
                        echo "<td>".$row['Date']."</td>";
                        echo "<td>".$row['Time']."</td>";
                        echo "</tr>";
                    }
                    echo "<table>";
                }
            ?>
        
        <h2 id="booking_h1">When and where to fly?</h2>
            <form id="booking" method="post" action="bookform.php">
                <fieldset>
                    <legend>Book a flight now!</legend>
                    
                    <label for="from">From:</label>
                    <select id="from" name="from">
                        <option></option>
                        <option>London</option>
                        <option>Paris</option>
                        <option>Hong Kong</option>
                        <option>New York</option>
                    </select>
                    <div id="invalid_from"></div><br>
                    
                    <label for="to">To:</label>
                    <select id="to" name="to">
                        <option></option>
                        <option>London</option>
                        <option>Paris</option>
                        <option>Hong Kong</option>
                        <option>New York</option>
                    </select>
                    <div id="invalid_to"></div><br>
                    
                    <label for="date">Departure date:</label>
                    <input type="date" name="date" id="date" />
                    <div id="invalid_date"></div><br>
                    
                    <label for="time">Departure time:</label>
                    <input type="time" name="time" id="time" />
                    <div id="invalid_time"></div><br>
                    
                    <input type="submit" value="Book now" id="booknow" />
                </fieldset>
            </form>

        <!-- Footer --> <!-- Add links and content --> 
        <!--    * Title: Marketing / Website Template
                * Author: w3schools
                * Date: 2021
                * Code version: N/A
                * Availability: https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_templates_website&stacked=h
        -->
        <footer class="w3-container w3-padding-32 w3-theme-d1 w3-center">
            <p><a href="index.html">Home</a> | <a href="about.html">About</a> | <a href="contact.html">Contact</a> | 
                <?php
                    if (isset($_SESSION['username'])) {
                        $_SESSION['logout'] = 
                            '<a href="logout.php">Log Out</a>';
                        echo $_SESSION['logout'];
                    }
                ?> <!--<a href="login.html">Logout</a></p>-->
            
            <div>
                <p id="follow">Follow us on Social Media</p>
                <a class="w3-button w3-large w3-teal" href="https://www.facebook.com" title="Facebook"><i class="fa fa-facebook"></i></a>
                <a class="w3-button w3-large w3-teal" href="https://www.twitter.com" title="Twitter"><i class="fa fa-twitter"></i></a>
                <a class="w3-button w3-large w3-teal" href="https://www.instagram.com" title="Google +"><i class="fa fa-instagram"></i></a>
                <a class="w3-button w3-large w3-teal w3-hide-small" href="https://www.linkedin.com" title="Linkedin"><i class="fa fa-linkedin"></i></a>
            </div>
            
            <p id="copyright">Copyright &copy; FlyUK - All Rights Reserved</p>
        
            <!-- Disclaimer -->
            <p id="disclaimer-title">disclaimer:</p>
            <p id="disclaimer-content">FlyUK is a fictitious brand created solely for the purpose of the assessment of IN1010 module at City, University of London, UK. All products and people associated with FlyUK are also fictitious. Any resemblance to real brands, products, or people is purely coincidental. Information provided about the product is also fictitious and should not be construed to be representative of actual products on the market in a similar product category.</p>
        
            <div style="position:relative;bottom:100px;z-index:1;" class="w3-tooltip w3-right">
                <span class="w3-text w3-padding w3-teal w3-hide-small">Go To Top</span>   
                <a class="w3-button w3-theme" href="#myPage"><span class="w3-xlarge">
                <i class="fa fa-chevron-circle-up"></i></span></a>
            </div>
        </footer>
        
        <script type="text/javascript" src="navigation.js"></script>
        <script type="text/javascript" src="booking.js"></script>
</body>
</html>

