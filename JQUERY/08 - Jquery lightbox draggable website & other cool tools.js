Code From the Video

<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Strict//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd”>

<html xmlns=”http://www.w3.org/1999/xhtml” xml:lang=”en” lang=”en”>

<head>

<meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />

<title>JQuery Tutorial</title>

<link href=”http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css” rel=”stylesheet” type=”text/css”/>

<script type=”text/javascript” src=”http://code.jquery.com/jquery-latest.js”></script>

<script type=”text/javascript” src=”https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js”></script>

<script type=”text/javascript” src=”fancybox/fancybox/jquery.mousewheel-3.0.4.pack.js”></script>

<script type=”text/javascript” src=”fancybox/fancybox/jquery.fancybox-1.3.4.pack.js”></script>

<link rel=”stylesheet” type=”text/css” href=”fancybox/fancybox/jquery.fancybox-1.3.4.css” media=”screen” />

<link rel=”stylesheet” href=”style.css” />

<script type=”text/javascript”>

$(“document”).ready(function() {

$(“#tabs”).tabs(); // Creates the tab layout

$(“#tabs”).css({‘width’: ‘500’}); // Makes the tab div 500px

$(“#tabs”).draggable(); // Makes he tab div draggable

$(“#tabs”).resizable(); // Makes he tab div resizable

$(“#sortMe”).sortable(); // Makes he tab div sortable

$(“#datepicker”).datepicker(); // Sets up the datepicker

$(“a[rel=example_group]”).fancybox({

‘transitionIn’	: ‘elastic’, // elastic, fade, or none

‘transitionOut’	: ‘elastic’,

‘titlePosition’ : ‘over’, // outside, inside or over

‘titleFormat’	: function(title, currentArray, currentIndex, currentOpts) {

return ‘<span id=”fancybox-title-over”>Image ‘ + (currentIndex + 1) + ‘ / ‘ + currentArray.length + (title.length ? ‘ &nbsp; ‘ + title : ”) + ‘</span>’;

}

});

});

</script>

</head>

<body>

<div>

<h2>JQuery UI & More</h2>

<span><a rel=”example_group” href=”images/PC100_0852.jpg”><img src=”images/Thumb_0852.jpg” title=”Fish Sculpture”></a></span>

<span><a rel=”example_group” href=”images/PC100_0857.jpg”><img src=”images/Thumb_0857.jpg” title=”Gargoyle One”></a></span>

<span><a rel=”example_group” href=”images/PC100_0859.jpg”><img src=”images/Thumb_0859.jpg” title=”Gargoyle Two”></a></span>

<span><a rel=”example_group” href=”images/PC100_0875.jpg”><img src=”images/Thumb_0875.jpg” title=”Gargoyle Three”></a></span>

</div>

<div id=”tabs”>

<ul id=”sortMe”>

<li><a href=”#fragment-1″><span>Dieting</span></a></li>

<li><a href=”#fragment-2″><span>Sales</span></a></li>

<li><a href=”#fragment-3″><span>NLP</span></a></li>

</ul>

<div id=”fragment-1″>

I got on the scale on October 20th and was shocked to see that I weighed almost 250 lbs. I weighed 248 lbs to be exact and I decided I was ready to lose weight now.<br /><br />

All the diet books I read were either too vague or proposed I go on a diet that was either very expensive, time consuming, or disgusting. I had lost weight in the past, but I knew I had done it in unhealthy ways. I decided to look at how my diet in college differed from my current diet first off.

</div>

<div id=”fragment-2″>

This presentation contains tips that will dramatically increase your success on the phone. Some of the topics covered include:<br />

<ul>

<li>If you have the best product, why are you afraid to ask people to buy it?</li>

<li>The 3 Principles of The Phone</li>

<li>Acknowledge & Move On</li>

<li>Everyone Just Hangs Up, What Do I Do</li>

</ul>

</div>

<div id=”fragment-3″>

Here I’ll explain how our minds process information. This can be used as an Introduction to Neurolinguistic Programming. If you understand everything here you will understand the more advanced technique’s used in Indirect Hypnosis.<br /><br />

Representational Systems<br /><br />

I’ve written about Representational Systems in the past, but here I’ll cover them in detail.

</div>

</div><br /><br />

<div><input type=”text” name=”data” id=”datepicker”></input></div>

</body>

</html>