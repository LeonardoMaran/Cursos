Code From the Video

First Program

<html>

<head>

<title>JQuery Animations</title>

<script type=”text/javascript” src=”http://code.jquery.com/jquery-latest.js”></script>

 

<script type=”text/javascript” src=”https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js”></script>

 

 

<style>

h4 {

background-color:DarkSlateGray;

color:white;

padding:10px;

}

div {

background-color:LightCyan;

width:200px;

overflow:hidden;

}

</style>

 

<script type=”text/javascript”>

$(“document”).ready(function() {

 

$(‘#superHumans > div’).hide();

 

$(‘#superHumans h4’).click(function() {

$(this).siblings(‘div:visible’).slideUp(‘2000’);

$(this).next().animate({‘height’:’toggle’}, ‘2000’, ‘easeInOutExpo’

);

});

 

 

});

 

</script>

</head>

 

<body>

 

<div id=”superHumans”>

<h4>Beyonder</h4>

<div>

He had the power to achieve what ever he pleased. He has vast power to alter reality on a planetary scale.

</div>

<h4>Thanos</h4>

<div>

Gifted with immortality and unaffected by attacks of any kind.

</div>

<h4>Galactus</h4>

<div>

He can levitate; restructure molecules; convert matter into energy and vice-versa; project energy with enormous concussive force; teleport himself, others, and objects across space, dimensions, and time; erect virtually impenetrable fields; restore others from any injury, even total disintegration; and endow or enhance powers within others.

</div>

<h4>Franklin Richards</h4>

<div>

He has vast telepathic powers, tremendous telekinetic powers, the ability to fire enormously powerful energy blasts, and the ability to rearrange the molecular structure of matter, even up to a cosmic scale.

</div>

<h4>Doctor Manhattan</h4>

<div>

Mastery over the manipulation of all matter and energy. Knowledge of all that has occurred in the past and present.

</div>

</div>

 

</body>

</html>

Second Program

<html>

<head>

<title>JQuery Animations</title>

 

<link type=”text/css” href=”css/cupertino/jquery-ui-1.8.10.custom.css” rel=”Stylesheet” />

 

<script type=”text/javascript” src=”http://code.jquery.com/jquery-latest.js”></script>

 

<script type=”text/javascript” src=”https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js”></script>

 

<style>

div {

width:300px;

overflow:hidden;

}

 

#flipPix {

position:relative;

height:150px;

width:150px;

}

 

#flipPix div{

position:absolute;

z-index:0;

}

 

#flipPix div.prev {

z-index:1;

}

 

#flipPix div.active {

z-index:2;

}

 

</style>

 

<script type=”text/javascript”>

$(“document”).ready(function() {

 

$(“#superHumans”).accordion({ header: “h4” });

 

setInterval(“slidePix()”, 2000);

 

});

 

function slidePix() {

var curPic = $(‘#flipPix div.active’);

var nextPic = curPic.next();

if (nextPic.length == 0){	// Tests to see if their are more pics

nextPic = $(‘#flipPix div:first’); // If not start at beginning

}

 

curPic.removeClass(‘active’).addClass(‘prev’); // Change the class

nextPic.css({opacity:0.0}).addClass(‘active’).animate({opacity:1.0}, 1000,

function() {

curPic.removeClass(‘prev’);

});

}

 

</script>

</head>

 

<body>

 

<div id=”superHumans”>

<h4>Beyonder</h4>

<p id=’info’>He had the power to achieve what ever he pleased. He has vast power to alter reality on a planetary scale.</p>

<h4>Thanos</h4>

<p id=’info’>Gifted with immortality and unaffected by attacks of any kind.</p>

<h4>Galactus</h4>

<p id=’info’>He can levitate; restructure molecules; convert matter into energy and vice-versa; project energy with enormous concussive force; teleport himself, others, and objects across space, dimensions, and time; erect virtually impenetrable fields; restore others from any injury, even total disintegration; and endow or enhance powers within others.</p>

<h4>Franklin Richards</h4>

<p id=’info’>He has vast telepathic powers, tremendous telekinetic powers, the ability to fire enormously powerful energy blasts, and the ability to rearrange the molecular structure of matter, even up to a cosmic scale.</p>

<h4>Doctor Manhattan</h4>

<p id=’info’>Mastery over the manipulation of all matter and energy. Knowledge of all that has occurred in the past and present.</p>

</div>

 

<br />

 

<div id=”flipPix”>

<div class=”active”>

<img src=”images/Pic_1.jpg” alt=”Picture” width=”150″ height=”150″ />

</div>

<div>

<img src=”images/Pic_2.jpg” alt=”Picture” width=”150″ height=”150″ />

</div>

<div>

<img src=”images/Pic_3.jpg” alt=”Picture” width=”150″ height=”150″ />

</div>

</div>

</body>

</html>