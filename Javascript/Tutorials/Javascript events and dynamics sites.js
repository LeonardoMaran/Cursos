!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
002
 
003
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
004
 
005
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
006
 
007
  <head>
008
 
009
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
010
 
011
    <title>JavaScript Tutorial</title>
012
     
013
    <style>
014
        #h3style {
015
            color: gray;
016
        }
017
    </style>
018
     
019
     </head>
020
   
021
    <body onResize="changeImage();" onLoad="alert('Website Loaded');">
022
     
023
    <script language="javascript" type="text/javascript">
024
        <!-- Hide JavaScript
025
             
026
        function alertme()
027
        {
028
            alertmsg = document.littlebrain.src + "\nHeight: " + document.littlebrain.height + "\nWidth: " + document.littlebrain.width;
029
            alert(alertmsg);
030
            return true;
031
        }
032
         
033
        function changeColor()
034
        {
035
            document.getElementById("h3style").style.color="red";
036
            document.getElementById("h3style").firstChild.nodeValue="Excited";
037
            return true;
038
        }
039
         
040
        function changeAgain()
041
        {
042
            document.getElementById("h3style").style.color="gray";
043
            document.getElementById("h3style").firstChild.nodeValue="Bored";
044
            return true;
045
        }
046
         
047
        function showPara()
048
        {
049
            document.getElementById("first").style.visibility=(document.formex.firstpara.checked) ? "visible" : "hidden";
050
            document.getElementById("second").style.visibility=(document.formex.secondpara.checked) ? "visible" : "hidden";
051
            document.getElementById("third").style.visibility=(document.formex.thirdpara.checked) ? "visible" : "hidden";
052
            return true;
053
        }
054
         
055
        function changeImage()
056
        {
057
            document.getElementById("littlebrain").style.height="35%";
058
            document.getElementById("littlebrain").style.width="35%";
059
            return true;
060
        }
061
             
062
        -->
063
    </script>
064
    <noscript>
065
        <h3>This site requires JavaScript</h3>
066
    </noscript>
067
     
068
    <img src="LittleBrain.png" id="littlebrain" onClick="alertme();" onDblClick="alert('You Double Clicked');"/>
069
     
070
    <h3 id="h3style" onMouseOver="changeColor();" onMouseOut="changeAgain();">Rollover</h3>
071
     
072
    <p id="first">This is the first paragraph</p>
073
    <p id="second">This is the second paragraph</p>
074
    <p id="third">This is the third paragraph</p>
075
     
076
    <form name="formex">
077
        <input type="checkbox" name="firstpara" onClick="showPara();" />First Paragraph<br />
078
        <input type="checkbox" name="secondpara" onClick="showPara();" />Second Paragraph<br />
079
        <input type="checkbox" name="thirdpara" onClick="showPara();" />Third Paragraph<br />
080
        <p><b>Text Input</b><br />
081
        <input type="text" name="textinput" onBlur="alert('onBlur Triggered');" onChange="alert('onChange Triggered');" onFocus="alert('onFocus Triggered');"/></p><br />
082
        <input type="text" name="mousex"/>Mouse X Position<br />
083
        <input type="text" name="mousey"/>Mouse Y Position<br />
084
        <input type="text" name="keypress"/>Key Pressed<br />
085
        <input type="text" name="mousebutton"/>Mouse Button Pressed<br />
086
         
087
    </form>
088
     
089
    <script language="javascript" type="text/javascript">
090
        <!-- Hide JavaScript
091
         
092
        var mie = (navigator.appName == "Microsoft Internet Explorer")?true:false;
093
         
094
        if (!mie)
095
        {
096
            document.captureEvents(Event.MOUSEMOVE); // Specifies that you want all mouse movement events passed to the document
097
            document.captureEvents(Event.MOUSEDOWN);
098
        }
099
         
100
        document.onkeypress = keyPressed;
101
        document.onmousemove = mousePos;
102
        document.onmousedown = mouseClicked;
103
        var mouseClick = 0;
104
        var keyClicked = 0;
105
        var mouseX = 0;
106
        var mouseY = 0;
107
         
108
        function mousePos(e)
109
        {
110
            if (!mie)
111
            {
112
                mouseX = e.pageX;
113
                mouseY = e.pageY;
114
            }
115
            else
116
            {
117
                mouseX = event.clientX + document.body.scrollLeft;
118
                mouseY = event.clientY + document.body.scrollTop;
119
            }
120
             
121
            document.formex.mousex.value = mouseX;
122
            document.formex.mousey.value = mouseY;
123
            return true;
124
        }
125
         
126
        function keyPressed(e)
127
        {
128
            if (mie)
129
            {
130
                e = window.event;
131
                keyClicked = e.keyCode;
132
            }
133
            else
134
            {
135
                keyClicked = String.fromCharCode(e.charCode); // Converts char code to character
136
            }
137
             
138
            if (!keyClicked)
139
            {
140
                return false;
141
            }
142
            document.formex.keypress.value = keyClicked;
143
            return true;
144
        }
145
         
146
        function mouseClicked(e)
147
        {
148
            if (mie)
149
            {
150
                switch(event.button)
151
                {
152
                    case 0:
153
                     document.formex.mousebutton.value = "Left";
154
                     break;
155
                     case 1:
156
                     document.formex.mousebutton.value = "Middle";
157
                     break;
158
                     default:
159
                      document.formex.mousebutton.value = "Right";
160
                      break;
161
                }
162
                return false;
163
                 
164
            }
165
            else
166
            {
167
                switch(e.which)
168
                {
169
                    case 1:
170
                     document.formex.mousebutton.value = "Left";
171
                     break;
172
                     case 2:
173
                     document.formex.mousebutton.value = "Middle";
174
                     break;
175
                     default:
176
                      document.formex.mousebutton.value = "Right";
177
                      break;
178
                }
179
                return true;
180
            }
181
        }
182
         
183
        /* The other JavaScript Events
184
        OnAbort - Called when a page load is interrupted
185
        OnError - Called when an error occurs during page load
186
        OnKeyDown - When key is pressed but not released
187
        OnKeyUp - When key is released
188
        OnMouseUp - When mouse button is released
189
        OnReset - When reset button is clicked
190
        OnSelect - When text is selected
191
        OnSubmit - When submit button is clicked
192
        OnUnload - When user leaves a page
193
         
194
         
195
        */
196
                      
197
         
198
        -->
199
    </script>
200
     
201
    </body>
202
</html>
