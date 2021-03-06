<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN”

“http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>

<html xmlns=”http://www.w3.org/1999/xhtml”>

<head>

<meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />

<title>JQuery Ex 1</title>

<style>

table, th, td {

border: 1px solid black;

}

tr.nice td {

background: #FAFAD2;

}

tr.mouseon td {

background: #1E90FF;

}

</style>

<script type=”text/javascript” src=”http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js”></script>

<script type=”text/javascript”>

$(“document”).ready(function() {

$(“td”).css(“padding”, “6px 10px”);

$(“.hero”).css(“color”, “red”);

$(“ul li.villian”).css(“background-color”, “yellow”);

$(“h3, th”).css(“background-color”, “orange”);

$(“p + h3”).css(“background-color”, “purple”);

$(“#randstuff ~ h4,h5”).css(“background-color”, “purple”);

$(“#superhumans > *”).css(“font-style”, “italic”);

$(“div:has(h4)”).css(“text-decoration”, “underline”);

$(“div[id]”).css(“border”, “3px solid black”);

$(“li[class=’hero’]”).css(“border”, “2px solid blue”);

$(“li[class^=’v’]”).css(“border”, “2px solid purple”);

$(“li[class$=’wn’]”).css(“border”, “2px solid orange”);

$(“li:contains(‘Richards’)”).css(“background-color”, “cyan”);

$(“#numbers tr:odd”).addClass(“nice”);

$(“#numbers tr”).mouseover(function() { $(this).addClass(“mouseon”); });

$(“#numbers tr”).mouseout(function() { $(this).removeClass(“mouseon”); });

});

</script>

<noscript>

<h3>This site requires JavaScript</h3>

</noscript>

</head>

<body>

<div id=”numbers”>

<p>

<h3>The Most Important Numbers</h3>

<table>

<tr>

<th>Number</th>

<th>Why I Care</th>

</tr>

<tr>

<td>2012</td>

<td>Year We All Die</td>

</tr>

<tr>

<td>12-21-12</td>

<td>My Next Birthday</td>

</tr>

<tr>

<td>12-21-12</td>

<td>The Day We All Die</td>

</tr>

</table>

</p>

</div>

<div>

<h3>The Most Powerful Superhumans</h3>

<ul id=”superhumans”>

<li class=”unknown”>Beyonder</li>

<li class=”villian”>Galactus</li>

<li class=”hero”>Franklin Richards</li>

<li class=”hero”>Reed Richards</li>

</ul>

<p><h4>Who Do You Think is Most Powerful?</h4></p>

<h6>Very Small</h6>

</div>

<div>

<h3 id=”randstuff”>Stuff 1</h3>

<h4>Stuff 2</h4>

<h5>Stuff 3</h5>

</div>

</body>

</html>