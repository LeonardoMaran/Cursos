Code From the Video

First Program

<html>

<head>

<title>JQuery Animations</title>

<script type=”text/javascript” src=”http://code.jquery.com/jquery-latest.js”></script>

 

<script type=”text/javascript”>

$(“document”).ready(function() {

 

// Bind function calls to the buttons on the page

 

$(‘#replaceWHtml’).bind(‘click’, replaceWHtml);

$(‘#replaceWText’).bind(‘click’, replaceWText);

$(‘#addAPara’).bind(‘click’, addAPara);

$(‘#removeAPara’).bind(‘click’, removeAPara);

$(‘#lastIsFirst’).bind(‘click’, lastIsFirst);

$(‘#addBefore’).bind(‘click’, addBefore);

$(‘#addAfter’).bind(‘click’, addAfter);

$(‘#addToTextBox’).bind(‘click’, addToTextBox);

 

});

 

// You use html when you want to replace tags

 

function replaceWHtml() {

$(‘#h3Tag’).html(‘<h6>Now I\’m an h6 tag</h6>’);

}

 

// You use text when you want to replace only the text

 

function replaceWText() {

$(‘#h3Tag’).text(‘<h6>Didn\’t replace text</h6>’);

}

 

// You can append anything

 

function addAPara() {

$(‘#randPara’).append(‘<p>Another Paragraph</p>’);

}

 

// Remove deletes an html element

 

function removeAPara() {

$(‘#randPara p:last’).remove();

}

 

// Here I use append to move the last p to the first position

 

function lastIsFirst() {

$(‘#randPara p:last’).append($(‘#randPara p:first’));

}

 

// You use before to place elements before another

 

function addBefore() {

$(‘#randPara p:first’).before(‘I go before anything’);

}

 

// You use after to place elements after another

 

function addAfter() {

$(‘#randPara p:last’).after(‘I go after everything’);

}

 

// Use val to change form element values

 

function addToTextBox() {

$(‘#randText’).val(‘Random Text’);

}

 

 

 

</script>

</head>

 

<body>

<div><h3>Playing With Text</h3></div>

 

<div>

<h3 id=”h3Tag”>H3 Tag</h3>

</div>

<br />

 

<div id=”randPara”>

<p id=”firstP”>The first paragraph<p>

</div>

 

<br />

 

<form action=””>

<input type=”text” id=”randText”></input>

<button type=”button” id=”replaceWHtml”>Replace w/ HTML</button>

<button type=”button” id=”replaceWText”>Replace w/ Text</button>

<button type=”button” id=”addAPara”>Add Text</button>

<button type=”button” id=”removeAPara”>Remove Text</button>

<button type=”button” id=”lastIsFirst”>Last to First</button>

<button type=”button” id=”addBefore”>Add Before</button>

<button type=”button” id=”addAfter”>Add After</button>

<button type=”button” id=”addToTextBox”>Add To Text Box</button>

</form>

</body>

</html>

Second Program

<html>

<head>

<title>JQuery Animations</title>

<script type=”text/javascript” src=”http://code.jquery.com/jquery-latest.js”></script>

 

<script type=”text/javascript”>

$(“document”).ready(function() {

 

$(‘#deleteSpan’).bind(‘click’, deleteSpan);

 

// before places the new element before the paragraph

$(‘#randPara’).before(‘<span>Before Paragraph</span>’);

 

// insertBefore places the new element as a sibling

$(‘<span> Insert Before Paragraph</span>’).insertBefore(‘#randPara’);

 

// prependTo places the new element as the first child of the element

$(‘<span>Prepend To Paragraph</span>’).prependTo(‘#randPara’);

 

// appendTo places the new element as a child

$(‘<span>Append To Paragraph</span>’).appendTo(‘#randPara’);

 

// append places the new element as the last child of the element

$(‘#randPara’).append(‘<span> Append Paragraph</span>’);

 

// insertAfter places the new element as a sibling

$(‘<span> Insert After Paragraph</span>’).insertAfter(‘#randPara’);

 

// after places the new element after the paragraph

$(‘#randPara’).after(‘<span> After Paragraph</span>’);

 

function deleteSpan()

{

$(‘span’).remove(‘:contains(“Append”)’);

}

 

 

 

});

</script>

</head>

 

<body>

<div><h3>Playing With Text</h3></div>

 

<div>

<h3 id=”h3Tag”>H3 Tag</h3>

</div>

<br />

 

<div id=”randPara”>

<p id=”firstP”>The First Paragraph<p>

</div>

 

<br /><br />

 

<form action=””>

<button type=”button” id=”deleteSpan”>Delete Spans</button>

</form>

 

<br />

 

</body>

</html>