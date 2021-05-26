/* 
* Title: Recall the structure of what TA was coding in lab
* Author: TA
* Date: 2021
* Code version: N/A
* Availability: Lab 6
*/

var allowLogin = false;

function checkLogin() {
    
    const login_username = document.getElementById('login_username').value;
    const login_pwd = document.getElementById('login_pwd').value;
    
    var validLoginUsername = false;
    var validLoginPwd = false;
    
    //check login username
    if (login_username === '') {
        document.getElementById('login_username').style.border = "2px solid red";
        document.getElementById('invalid_login_username')
            .style.display = "inline";
        document.getElementById('invalid_login_username')
            .innerHTML = '<span style= "color:red; ">Please enter your username.</span>';
    } else {
        document.getElementById('login_username').style.border = "none";
        document.getElementById('invalid_login_username')
            .innerHTML = '';
        validLoginUsername = true;
    }
    
    //check login password
    if (login_pwd === '') {
        document.getElementById('login_pwd').style.border = "2px solid red";
        document.getElementById('invalid_login_pwd')
            .style.display = "inline";
        document.getElementById('invalid_login_pwd')
            .innerHTML = '<span style= "color:red; ">Please enter your password.</span>';
    } else {
        document.getElementById('login_pwd').style.border = "none";
        document.getElementById('invalid_login_pwd')
            .innerHTML = '';
        validLoginPwd = true;
    }  
    
    //decide if allow login
    if (validLoginUsername && validLoginPwd) {
        allowLogin = true;
    }
}

//decide if allow form submission
if (document.getElementById('login')) {
    document.getElementById('login').addEventListener('submit', (e) => {
        console.log('in event handler')
        e.preventDefault();
        checkLogin();
        if (allowLogin) {
            document.getElementById('login').submit();
        }
    });
}

var allowRegister = false;

function checkRegister() {
    
    const username = document.getElementById('username').value;
    const firstname = document.getElementById('firstname').value;
    const lastname = document.getElementById('lastname').value;
    const phone = document.getElementById('phone').value;
    const email = document.getElementById('email').value;
    const psw = document.getElementById('psw').value;
    const psw2 = document.getElementById('psw2').value;
    
    var validUserName = false;
    var validFirstName = false;
    var validLastName = false;
    var validPhone = false;
    var validEmail = false;
    var validPsw = false;
    var validPsw2 = false;
    
    //check register username
    var invalid_username = document.getElementById('invalid_username');
    if (username === '') {
        document.getElementById('username').style.border = "2px solid red";
        invalid_username
            .style.display = "inline";
        invalid_username
            .innerHTML = '<span style=" color:red; ">Please enter to set your username.</span>';
    } else {
        document.getElementById('username').style.border = "none";
        invalid_username
            .innerHTML = '';
        validUserName = true;
    }
    
    //check register first name
    var invalid_firstname = document.getElementById('invalid_firstname');
    if (firstname === '') {
        document.getElementById('firstname').style.border = "2px solid red";
        invalid_firstname
            .style.display = "inline";
        invalid_firstname
            .innerHTML = '<span style=" color:red; ">Please enter your first name.</span>';
    } else if (!firstname.match('^[A-Za-z]+$')) {
        document.getElementById('firstname').style.border = "2px solid red";
        invalid_firstname
            .style.display = "inline";
        invalid_firstname
            .innerHTML = '<span style=" color:red; ">Please only enter letters.</span>';
    } else {
        document.getElementById('firstname').style.border = "none";
        invalid_firstname
            .innerHTML = '';
        validFirstName = true;
    }
    
    //check register last name
    var invalid_lastname = document.getElementById('invalid_lastname');
    if (lastname === '') {
        document.getElementById('lastname').style.border = "2px solid red";
        invalid_lastname
            .style.display = "inline";
        invalid_lastname
            .innerHTML = '<span style=" color:red; ">Please enter your last name.</span>';
    } else if (!lastname.match('^[A-Za-z]+$')) {
        document.getElementById('lastname').style.border = "2px solid red";
        invalid_lastname
            .style.display = "inline";
        invalid_lastname
            .innerHTML = '<span style=" color:red; ">Please only enter letters.</span>';
    } else {
        document.getElementById('lastname').style.border = "none";
        invalid_lastname
            .innerHTML = '';
        validLastName = true;
    }
    
    //check register mobile phone number
    var invalid_phone = document.getElementById('invalid_phone');
    if (phone === '') {
        document.getElementById('phone').style.border = "2px solid red";
        invalid_phone
            .style.display = "inline";
        invalid_phone
            .innerHTML = '<span style=" color:red; ">Please enter your mobile phone number.</span>';
    } else if (!phone.match('^[0-9]+$')) {
        document.getElementById('phone').style.border = "2px solid red";
        invalid_phone
            .style.display = "inline";
        invalid_phone
            .innerHTML = '<span style=" color:red; ">Please only enter numbers.</span>';
    } else if (phone.length != 11) {
        document.getElementById('phone').style.border = "2px solid red";
        invalid_phone
            .style.display = "inline";
        invalid_phone
            .innerHTML = '<span style=" color:red; ">Please enter exactly 11 digits.</span>';
    } else {
        document.getElementById('phone').style.border = "none";
        invalid_phone
            .innerHTML = '';
        validPhone = true;
    }
    
    //check register email
    var invalid_email = document.getElementById('invalid_email');
    if (email === '') {
        document.getElementById('email').style.border = "2px solid red";
        invalid_email
            .style.display = "inline";
        invalid_email
            .innerHTML = '<span style=" color:red; ">Please enter your email.</span>';
    } else if (!email.match('^(.+)@([^\.].*)\.([a-z]{2,})$')) {
        document.getElementById('email').style.border = "2px solid red";
        invalid_email
            .style.display = "inline";
        invalid_email
            .innerHTML = '<span style=" color:red; ">Please enter a valid email.</span>';
    } else {
        document.getElementById('email').style.border = "none";
        invalid_email
            .innerHTML = '';
        validEmail = true;
    }
    
    //check register password
    var invalid_psw = document.getElementById('invalid_psw');
    if (psw === '') {
        document.getElementById('psw').style.border = "2px solid red";
        invalid_psw
            .style.display = "inline";
        invalid_psw
            .innerHTML = '<span style=" color:red; ">Please enter to set your password.</span>';
    } else if (psw.length < 6) {
        document.getElementById('psw').style.border = "2px solid red";
        invalid_psw
            .style.display = "inline";
        invalid_psw
            .innerHTML = '<span style=" color:red; ">Please enter at least 6 characters.</span>';
    } else if (!psw.match(/[A-Z]/g)) {
        document.getElementById('psw').style.border = "2px solid red";
        invalid_psw
            .style.display = "inline";
        invalid_psw
            .innerHTML = '<span style=" color:red; ">Please enter at least 1 upper-case letter.</span>';
    } else if (!psw.match(/[a-z]/g)) {
        document.getElementById('psw').style.border = "2px solid red";
        invalid_psw
            .style.display = "inline";
        invalid_psw
            .innerHTML = '<span style=" color:red; ">Please enter at least 1 lower-case letter.</span>';
    } else if (!psw.match(/[0-9]/g)) {
        document.getElementById('psw').style.border = "2px solid red";
        invalid_psw
            .style.display = "inline";
        invalid_psw
            .innerHTML = '<span style=" color:red; ">Please enter at least 1 number.</span>';
    } else if (!psw.match(/[!@#$%^&*]/g)) {
        document.getElementById('psw').style.border = "2px solid red";
        invalid_psw
            .style.display = "inline";
        invalid_psw
            .innerHTML = '<span style=" color:red; ">Please enter at least 1 symbol in " !@#$%^&* ".</span>';
    } else {
        document.getElementById('psw').style.border = "none";
        invalid_psw
            .innerHTML = '';
        validPsw = true;
    }
    
    //check register confirming password
    var invalid_psw2 = document.getElementById('invalid_psw2');
    if (psw2 === '') {
        document.getElementById('psw2').style.border = "2px solid red";
        invalid_psw2
            .style.display = "inline";
        invalid_psw2
            .innerHTML = '<span style=" color:red; ">Please enter to confirm your password.</span>';
    } else if (psw2 !== psw) {
        document.getElementById('psw2').style.border = "2px solid red";
        invalid_psw2
            .style.display = "inline";
        invalid_psw2
            .innerHTML = '<span style=" color:red; ">Please confirm with the same password.</span>';
    } else {
        document.getElementById('psw2').style.border = "none";
        invalid_psw2
            .innerHTML = '';
        validPsw2 = true;
    }
    
    //decide if allow register
    if (validUserName && validFirstName && validLastName && validPhone && validEmail && validPsw && validPsw2) {
        allowRegister = true;
    }
}

//decide if allow form submission
if (document.getElementById('register')) {
    document.getElementById('register').addEventListener('submit', (e) => {
        console.log('in event handler')
        e.preventDefault();
        checkRegister();
        if (allowRegister) {
            document.getElementById('register').submit();
        }
    });
}