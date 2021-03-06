<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN”

“http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>

<html xmlns=”http://www.w3.org/1999/xhtml”>

<head>

<meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />

<title>JQuery Ex 1</title>

 

<script type=”text/javascript” src=”http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js”></script>

 

<script type=”text/javascript”>

 

$(“document”).ready(function() {

 

$(“h4:first”).css(“background-color”, “yellow”);

 

$(“p:last”).css({“background-color”: “purple”, “color”: “white”});

 

$(“p span:first-child”).css(“background-color”, “orange”);

 

$(“div p:last-child”).css(“background-color”, “cyan”);

 

$(“div p:last-child”).css(“background-color”, “cyan”);

 

$(“div:nth-child(1)”).css(“background-color”, “pink”);

 

$(“span:eq(2)”).css(“background-color”, “purple”); // These are 0 based

 

$(“h4:gt(1)”).css(“background-color”, “green”); // All h4 after index 1

 

$(“h4:lt(2)”).css(“background-color”, “olive”); // All h4 before index 2

 

$(‘#clickToHide’).click(function() {

$(‘#clickToHide’).hide(); });

 

$(‘#bringItBack’).click(function() {

if ($(‘#clickToHide’).is(‘:visible’)) {

$(‘#clickToHide’).hide();

$(this).val(‘Bring Back’);

// This changes the value on the button

}

else {

$(‘#clickToHide’).show();

$(this).val(‘Delete Text’);

// This changes the value on the button

}

});

// You can also replace hide & show with fadeIn or fadeOut

// Also you can use slideDown & slideUp

// You can play with the speed by giving values in milliseconds or slow // fast, or normal ex. fadeIn(1000) or fadeOut(slow)

 

 

});

 

</script>

<noscript>

<h3>This site requires JavaScript</h3>

</noscript>

</head>

 

<body>

 

<div id=”firstDiv”>

<h4>First Header</h4>

<p id=”firstPara”>First paragraph in first div<span> First Span</span></p>

<p>Second paragraph in first div</p>

<p>Third paragraph in first div</p>

</div>

 

<div id=”secondDiv”>

<h4>Second Header</h4>

<p>First paragraph in second div<span> Second Span</span></p>

<p>Second paragraph in second div</p>

<p>Third paragraph in first div</p>

</div>

 

<div id=”thirdDiv”>

<h4>Third Header</h4>

<p>First paragraph in third div<span> Third Span</span></p>

<p>Second paragraph in third div</p>

<p>Third paragraph in first div</p>

</div>

 

<span id=”clickToHide”>Click to hide me</span>

 

<input type=”button” id=”bringItBack” value=”Bring Back” />

 

</body>

</html>