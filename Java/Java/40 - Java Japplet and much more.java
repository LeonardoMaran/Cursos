Execute the JApplet in a Browser

In the tutorial, I was executing the Java Applet in the Applet viewer. To execute it in a browser you must do the following in a terminal javac JavaLesson40.java

That creates a Java class file. Then use the html code below to load the applet in a browser. You may have to enable Java in your browser of choice.

Code from the Video

001
import javax.swing.*;
002
import javax.swing.border.Border;
003
 
004
import java.awt.Dimension;
005
import java.awt.FlowLayout;
006
import java.awt.LayoutManager;
007
import java.awt.event.*;
008
 
009
// In swing you use a JFrame, to make the program
010
// work online you use JApplet
011
 
012
public class Lesson40 extends JApplet{
013
     
014
    // The main panel that holds everything
015
     
016
    JPanel thePanel;
017
     
018
    // The panels that hold the radio buttons
019
     
020
    JPanel ques1Panel, ques2Panel, ques3Panel, ques4Panel;
021
     
022
    // When clicked the personality report is displayed
023
     
024
    JButton getResultBut;
025
     
026
    // The radio buttons for each personality quirk
027
     
028
    JRadioButton extravertRadio, introvertRadio,
029
        sensorRadio, intuitiveRadio, feelerRadio,
030
        thinkerRadio, judgingRadio, perceivingRadio;
031
     
032
    // Holds the personality report
033
     
034
    JEditorPane yourReport;
035
     
036
    // You use init() instead of main() with Applets
037
     
038
    public void init(){
039
         
040
        // Sets the size of the frame
041
         
042
        this.setSize(675, 870);
043
         
044
        // Creates the main panel and makes everything justify left
045
         
046
        thePanel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
047
         
048
        // The panels for the radio buttons
049
         
050
        ques1Panel = new JPanel();
051
        ques2Panel = new JPanel();
052
        ques3Panel = new JPanel();
053
        ques4Panel = new JPanel();
054
         
055
        // Creates borders that surround the radio buttons
056
         
057
        Border border1 = BorderFactory.createTitledBorder("Do you prefer to work");
058
        Border border2 = BorderFactory.createTitledBorder("Which is most important");
059
        Border border3 = BorderFactory.createTitledBorder("Do you act on");
060
        Border border4 = BorderFactory.createTitledBorder("Which do you prefer");
061
         
062
        // Attaches the border to the right panels
063
         
064
        ques1Panel.setBorder(border1);
065
        ques2Panel.setBorder(border2);
066
        ques3Panel.setBorder(border3);
067
        ques4Panel.setBorder(border4);
068
         
069
        // Makes are only one radio button can be selected
070
         
071
        ButtonGroup group1 = new ButtonGroup();
072
        ButtonGroup group2 = new ButtonGroup();
073
        ButtonGroup group3 = new ButtonGroup();
074
        ButtonGroup group4 = new ButtonGroup();
075
         
076
        // Creates and sets text for radio buttons
077
         
078
        extravertRadio = new JRadioButton("In groups");
079
        introvertRadio = new JRadioButton("On your own");
080
        sensorRadio = new JRadioButton("The specifics");
081
        intuitiveRadio = new JRadioButton("The big picture");
082
        feelerRadio = new JRadioButton("What feels right");
083
        thinkerRadio = new JRadioButton("List of facts");
084
        judgingRadio = new JRadioButton("To plan");
085
        perceivingRadio = new JRadioButton("To adapt");
086
         
087
        // Sets some radio buttons to true by default
088
         
089
        extravertRadio.setSelected(true);
090
        sensorRadio.setSelected(true);
091
        feelerRadio.setSelected(true);
092
        judgingRadio.setSelected(true);
093
         
094
        // Adds radio buttons to their panels
095
         
096
        ques1Panel.add(extravertRadio);
097
        ques1Panel.add(introvertRadio);
098
        ques2Panel.add(sensorRadio);
099
        ques2Panel.add(intuitiveRadio);
100
        ques3Panel.add(feelerRadio);
101
        ques3Panel.add(thinkerRadio);
102
        ques4Panel.add(judgingRadio);
103
        ques4Panel.add(perceivingRadio);
104
         
105
        // Assigns radio buttons to be in groups together
106
         
107
        group1.add(extravertRadio);
108
        group1.add(introvertRadio);
109
        group2.add(sensorRadio);
110
        group2.add(intuitiveRadio);
111
        group3.add(feelerRadio);
112
        group3.add(thinkerRadio);
113
        group4.add(judgingRadio);
114
        group4.add(perceivingRadio);
115
         
116
        // Adds the radio button panels to the main panel
117
         
118
        thePanel.add(ques1Panel);
119
        thePanel.add(ques2Panel);
120
        thePanel.add(ques3Panel);
121
        thePanel.add(ques4Panel);
122
         
123
        // Creates a button
124
         
125
        getResultBut = new JButton("Get Result");
126
         
127
        // Creates an object that will monitor button clicks
128
         
129
        GetResultsListener butListener = new GetResultsListener();
130
         
131
        // Assigns an object that will monitor this buttons clicks
132
        // When clicked a method will execute
133
         
134
        getResultBut.addActionListener(butListener);
135
         
136
        // Add the button & panel to the frame and show the frame
137
         
138
        thePanel.add(getResultBut);
139
         
140
        this.add(thePanel);
141
         
142
        this.setVisible(true);
143
         
144
         
145
         
146
    }
147
     
148
    class GetResultsListener implements ActionListener{
149
 
150
        // Called when the button is clicked
151
         
152
        public void actionPerformed(ActionEvent e) {
153
             
154
            // Define strings that will make the html that the
155
            // JEditorPane will display
156
             
157
            String pageToOpen = "",
158
                    directoryLoc = "file:///Users/derekbanas/Documents/workspace3/Java Code/src/";
159
             
160
            String textToDisplay ="<html><div><img src=\"" + directoryLoc;
161
             
162
            // Check if the result button was clicked
163
             
164
            if (e.getSource() == getResultBut){
165
                 
166
                // Add to the string based on selected radio button
167
                 
168
                if (extravertRadio.isSelected()) pageToOpen += "E";
169
                if (introvertRadio.isSelected()) pageToOpen += "I";
170
                 
171
                if (sensorRadio.isSelected()) pageToOpen += "S";
172
                if (intuitiveRadio.isSelected()) pageToOpen += "N";
173
                 
174
                if (feelerRadio.isSelected()) pageToOpen += "F";
175
                if (thinkerRadio.isSelected()) pageToOpen += "T";
176
                 
177
                if (judgingRadio.isSelected()) pageToOpen += "J";
178
                if (perceivingRadio.isSelected()) pageToOpen += "P";
179
                 
180
                // Remove panels to make way for a report
181
                 
182
                thePanel.remove(ques1Panel);
183
                thePanel.remove(ques2Panel);
184
                thePanel.remove(ques3Panel);
185
                thePanel.remove(ques4Panel);
186
                 
187
                // Finish the html file that JEditorPane will display
188
                     
189
                textToDisplay += pageToOpen + ".png" + "\" /></html>";
190
                     
191
                // Define what JEditorPane will display
192
                     
193
                yourReport = new JEditorPane("text/html", textToDisplay);
194
                     
195
                // Shut off editing and size the JEditorPane
196
                 
197
                yourReport.setEditable(false);
198
                 
199
                yourReport.setSize(650, 825);
200
                 
201
                // Add the JEditorPane to a scroller and define how
202
                // to handle scrollbars
203
                 
204
                JScrollPane scroller = new JScrollPane(yourReport,
205
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
206
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
207
                 
208
                // Size the scroll pane
209
                 
210
                scroller.setPreferredSize(new Dimension(650, 825));
211
                 
212
                // Add Scroll pane and JEditorPane to the frame
213
                 
214
                thePanel.add(scroller);
215
                 
216
                getResultBut.setVisible(false);
217
                 
218
                // Redraw the frame after the changes are made
219
                 
220
                thePanel.revalidate();
221
                thePanel.repaint();
222
                 
223
                 
224
            }
225
             
226
        }
227
         
228
    }
229
     
230
}
01
<html>
02
<head>
03
<title>Personality Test</title>
04
</head>
05
<body>
06
<APPLET code="JavaLesson40.class" width="675" height="870">
07
Sorry you can't run Java
08
</APPLET>
09
</body>
10
</html>
