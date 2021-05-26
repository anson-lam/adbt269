/* 
* Title: Recall the structure of what TA was coding in lab
* Author: TA
* Date: 2021
* Code version: N/A
* Availability: Lab 6
*/

var allowBook = false;

function checkBook() {
    
    const from = document.getElementById('from').value;
    const to = document.getElementById('to').value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    
    var validFrom = false;
    var validTo = false;
    var validDate = false;
    var validTime = false;
    
    //check if the origin is selected
    if (from === '') {
        document.getElementById('from').style.border = "2px solid red";
        document.getElementById('invalid_from')
            .style.display = "inline";
        document.getElementById('invalid_from')
            .innerHTML = '<span style= "color:red; ">Please choose the origin.</span>';
    } else {
        document.getElementById('from').style.border = "none";
        document.getElementById('invalid_from')
            .innerHTML = '';
        validFrom = true;
    }
    
    //check if the destination is selected
    if (to === '') {
        document.getElementById('to').style.border = "2px solid red";
        document.getElementById('invalid_to')
            .style.display = "inline";
        document.getElementById('invalid_to')
            .innerHTML = '<span style= "color:red; ">Please choose your destination.</span>';
    } else {
        document.getElementById('to').style.border = "none";
        document.getElementById('invalid_to')
            .innerHTML = '';
        validTo = true;
    }
    
    //check if the date is selected
    if (date === '') {
        document.getElementById('date').style.border = "2px solid red";
        document.getElementById('invalid_date')
            .style.display = "inline";
        document.getElementById('invalid_date')
            .innerHTML = '<span style= "color:red; ">Please enter your departure date.</span>';
    } else if (date === '0000-00-00') {
        document.getElementById('date').style.border = "2px solid red";
        document.getElementById('invalid_date')
            .style.display = "inline";
        document.getElementById('invalid_date')
            .innerHTML = '<span style= "color:red; ">Please enter your departure date.</span>';
    } else {
        document.getElementById('date').style.border = "none";
        document.getElementById('invalid_date')
            .innerHTML = '';
        validDate = true;
    }
    
    //check if the time is selected
    if (time === '') {
        document.getElementById('time').style.border = "2px solid red";
        document.getElementById('invalid_time')
            .style.display = "inline";
        document.getElementById('invalid_time')
            .innerHTML = '<span style= "color:red; ">Please enter your departure time.</span>';
    } else {
        document.getElementById('time').style.border = "none";
        document.getElementById('invalid_time')
            .innerHTML = '';
        validTime = true;
    }
    
    //check if allow book
    if (validFrom && validTo && validDate && validTime) {
        allowBook = true;
    }
}

//check if allow form submission
if (document.getElementById('booking')) {
    document.getElementById('booking').addEventListener('submit', (e) => {
        console.log('in event handler')
        e.preventDefault();
        checkBook();
        if (allowBook) {
            document.getElementById('booking').submit();
        }
    });
}