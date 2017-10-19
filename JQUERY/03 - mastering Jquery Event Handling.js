JQuery Event Handlers

blur() : Triggered when you leave an element
change() : Triggered when an element is changed
click() : Triggered when you click an element
dblclick() : Triggered when you double click an element
error() : Triggered when an error occurs
focus() : Triggered when you enter an element
keydown() : Triggered when a key is pressed down
keypress() : Triggered when a key is pressed an released
keyup() : Triggered when a key is released
load() : Triggered when your page loads
mousedown() : Triggered when the mouse button is pressed down
mouseup() :Triggered when the mouse button is released
mousemove() : Triggered when the cursor moves
mouseover() : Triggered when the mouse goes over an element
mouseout() : Triggered when the mouse moves off an element
submit() : Triggered when the submit button is pressed
JQuery Event Object Properties

event.altKey : Has value true if Alt key was pressed
event.ctrlKey : Has value true if Ctrl key was pressed
event.data : Contains value passed to bind() function
event.keyCode : Contains the keycode for the last pressed key
event.pageX : Returns the mouse coordinates on the X access
event.pageY : Returns the mouse coordinates on the Y access
event.screenX : Returns the mouse coordinates on the X access, relative to the page
event.screenY : Returns the mouse coordinates on the Y access, relative to the page
event.shiftKey : Has value true if Shift key was pressed
event.target : Element’s name that issued an event
event.timeStamp : Contains timestamp, that lists when the event occurred
event.type : The type of event that occurred
Code From the Video

<html>

<head>

<title>JQuery Event Handlers</title>

<script type=”text/javascript” src=”http://code.jquery.com/jquery-latest.js”></script>

 

<script type=”text/javascript”>

$(“document”).ready(function() {

 

$(‘#oneButton’).bind(‘click’,alertButtonClick);

 

$(‘#textBox1’).bind(‘blur’,onBlurEvent)

.bind(‘focus’,onFocusEvent)

.bind(‘onmousedown’,onMDownEvent)

.bind(‘onmouseup’,onMUpEvent)

.bind(‘change’,onChangeEvent);

 

$(window).resize(resizedWindow);

 

$(‘#twoButton’).bind(‘dblclick’, dblClickedMe);

$(‘#logo’).bind(‘mouseover’, mouseOverMe).bind(‘mouseout’, mouseOutMe);

 

$(“form”).submit(function() { alert(“Submit button clicked”) });

 

$(‘#threeButton’).bind(‘click’,unbindLogo);

 

$(‘#theBody’).bind(‘keyup’,checkKeyPressed).bind(‘mousemove’,theMouseMoved).click(event, eventTriggered);

});

 

 

function alertButtonClick() {

alert(“There was a button clicked”);

}

 

function onBlurEvent()

{

$(“#second”).html(“You left the text box”);

}

 

function onFocusEvent()

{

$(“#second”).html(“You entered the text box”);

}

 

function onMDownEvent()

{

$(“#second”).html(“You left the text box”);

}

 

function onMUpEvent()

{

$(“#second”).html(“You entered the text box”);

}

 

function onChangeEvent()

{

$(“#third”).html(“You changed the text box”);

}

 

function resizedWindow()

{

$(“#second”).html(“Window was resized W: ” + $(window).width() + ” H: ” + $(window).height());

}

 

function dblClickedMe()

{

$(“#second”).html(“You only have to click once”);

}

 

function mouseOverMe()

{

$(“#second”).html(“You put your cursor on my logo”);

}

 

function mouseOutMe()

{

$(“#second”).html(“You left my logo”);

}

 

function unbindLogo()

{

$(‘#logo’).unbind(‘mouseover’, mouseOverMe).unbind(‘mouseout’, mouseOutMe);

}

 

function checkKeyPressed(event)

{

$(‘#fifth’).text(String.fromCharCode(event.keyCode));

}

 

function theMouseMoved(event)

{

$(“#seventh”).html(event.screenX);

$(“#ninth”).html(event.screenY);

}

 

function eventTriggered(event)

{

$(“#tenth”).text(event.target.nodeName);

$(“#eleventh”).html(event.timeStamp);

}

 

</script>

 

</head>

 

<body id=”theBody”>

<div><h3>JQuery Event Handlers</h3></div>

 

 

<div>

<img src=’http://www.newthinktank.com/favicon.png’ id=’logo’ alt=’Little Brain’ />

</div>

<br />

 

<div>

<p><strong>Events Triggered on the Page:</strong></p>

<p id=”second”>Waiting for Event</p>

<p id=”third”>Waiting for Change</p>

</div>

 

<div>

<p><strong>Key Events Triggered on the Page:</strong></p>

<span id=”fourth”>Key Pressed:</span>

<span id=”fifth”>Waiting for Change</span>

</div><br />

 

<div>

<p><strong>Mouse Movements on the Page:</strong></p>

<span id=”sixth”>Mouse X Coordinate:</span>

<span id=”seventh”>Waiting for Change</span><br />

<span id=”eighth”>Mouse Y Coordinate:</span>

<span id=”ninth”>Waiting for Change</span><br />

<span>Textbox Changed: </span>

<span id=”tenth”>Waiting for Event</span><br />

<span>Element Changed When: </span>

<span id=”eleventh”>Event Occurred When</span>

</div><br />

 

<form action=””>

<button type=”button” id=”oneButton”>Alert on Click</button>

<button type=”button” id=”twoButton”>Click on me Twice</button>

<button type=”button” id=”threeButton”>Unbind the Logo</button>

<input type=’text’ id=”textBox1″ size=40>

<input type=’submit’ value=’Send’>

</form>

 

</body>

</html>