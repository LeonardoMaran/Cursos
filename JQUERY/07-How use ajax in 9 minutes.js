Code From the Video

JQueryEx12.html

<!DOCTYPE HTML PUBLIC “-//W3C//DTD HTML 4.01 Transitional//EN”

“http://www.w3.org/TR/html4/loose.dtd”>

<head>

<title>JQuery Example</title>

<script type=”text/javascript” src=”http://code.jquery.com/jquery-latest.js”></script>

<script type=”text/javascript”>

$(“document”).ready(function() {

// Bind click events on buttons to trigger specified functions

$(‘#oneButton’).bind(‘click’,getInfoFromServer);

$(‘#twoButton’).bind(‘click’,getDblFromServer);

$(‘#threeButton’).bind(‘click’,getXmlFromServer);

});

// Pull text from a text file on the server

// Type defines the type of request to make being GET or POST

// Success defines the function to call if the request succeeds

// Error could be defined to specify the function to call if an error happens

function getInfoFromServer() {

$.ajax({

type: “GET”,

url: “textFromServer.txt”,

success: postToPage});

}

// Function called to display the message from the server

// Receives the text and the server status

function postToPage(data, status) {

$(‘#first’).text(data);

}

// Load a value into a span

// I define that the program getDouble.php should be executed

// getDouble is sent the information in the form and then it stores the returned // info in the span

function getDblFromServer() {

$(“span”).load(“getDouble.php”,

$(“#theForm”).serializeArray());

}

// Here I define that I’m receiving xml data from the server

function getXmlFromServer() {

$.ajax({

type: “GET”,

url: “customers.xml”,

datatype: “xml”,

success: postToPageTwo});

}

// I use the find method to search through the xml data

// When I match for any of these attributes I append them to the div named

// customers

function postToPageTwo(data) {

$(data).find(‘customer’).each(function(){

var id = $(this).attr(‘id’);

var firstName = $(this).find(‘firstName’).text();

var lastName = $(this).find(‘lastName’).text();

var street = $(this).find(‘street’).text();

var city = $(this).find(‘city’).text();

var zip = $(this).find(‘zip’).text();

$(‘<div class=”firstname”></div>’).html(firstName).appendTo(‘#customers’);

$(‘<div class=”lastname”></div>’).html(lastName).appendTo(‘#customers’);

$(‘<div class=”street”></div>’).html(street).appendTo(‘#customers’);

$(‘<div class=”city”></div>’).html(city).appendTo(‘#customers’);

$(‘<div class=”zip”></div><br />’).html(zip).appendTo(‘#customers’);

}

);

}

</script>

</head>

<body id=”theBody”>

<div><h3>Playing with Server Data</h3></div>

<div>

<h4><strong>Message from the Server:</strong></h4>

<p id=”first”>Waiting for Message</p>

</div>

<form id=”theForm”>

<button type=”button” id=”oneButton”>Get Text</button><br />

<div>

<h4>Double Number on the Server:</h4>

<span></span><br />

</div>

<input type=”text” name=”data” id=”data”></input>

<button type=”button” id=”twoButton”>Double Number</button><br /><br />

<button type=”button” id=”threeButton”>Get XML Data</button>

</form>

<div>

<h4><strong>XML Data from the Server:</strong></h4>

</div>

<div id=”customers”>Customer Information</div>

</body>

</html>

GetDouble.php

<?php

$numberToDbl = $_POST[“data”];

echo $_POST[“data”] . ” Times 2 Equals “;

$doubleUp = $numberToDbl * 2;

echo $doubleUp;

?>

customers.xml

<?xml version=”1.0″ encoding=”iso-8859-1″?>

<customers>

<customer id=”0″>

<firstName>Paul</firstName>

<lastName>Jones</lastName>

<street>123 Main St</street>

<city>Anywhere</city>

<zip>15235</zip>

</customer>

<customer id=”1″>

<firstName>Sally</firstName>

<lastName>Jones</lastName>

<street>123 Main St</street>

<city>Anywhere</city>

<zip>15235</zip>

</customer>

</customers>