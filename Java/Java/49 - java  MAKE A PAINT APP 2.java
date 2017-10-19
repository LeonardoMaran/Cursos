import javax.swing.*;
002
import javax.swing.event.ChangeEvent;
003
import javax.swing.event.ChangeListener;
004
 
005
import java.awt.event.*;
006
import java.awt.*;
007
import java.awt.geom.*;
008
import java.text.DecimalFormat;
009
import java.util.*;
010
 
011
@SuppressWarnings("serial")
012
public class Lesson49 extends JFrame
013
{
014
     
015
        JButton brushBut, lineBut, ellipseBut, rectBut, strokeBut, fillBut;
016
         
017
        // Slider used to change the transparency
018
         
019
        JSlider transSlider;
020
         
021
        JLabel transLabel;
022
         
023
        // Makes sure the float for transparency only shows 2 digits
024
         
025
        DecimalFormat dec = new DecimalFormat("#.##");
026
         
027
        // Contains all of the rules for drawing
028
         
029
        Graphics2D graphSettings;
030
         
031
        // Homework use graphSettings.setStroke(new BasicStroke(5F));
032
        // To change the stroke dynamically with a component
033
         
034
        // Going to be used to monitor what shape to draw next
035
         
036
        int currentAction = 1;
037
         
038
        // Transparency of the shape
039
         
040
        float transparentVal = 1.0f;
041
         
042
        // Default stroke and fill colors
043
         
044
        Color strokeColor=Color.BLACK, fillColor=Color.BLACK;
045
     
046
        public static void main(String [] args)
047
        {
048
                new Lesson49();
049
        }
050
 
051
        public Lesson49()
052
        {
053
            // Define the defaults for the JFrame
054
             
055
            this.setSize(800, 600);
056
            this.setTitle("Java Paint");
057
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
058
             
059
            JPanel buttonPanel = new JPanel();
060
             
061
            // Swing box that will hold all the buttons
062
             
063
            Box theBox = Box.createHorizontalBox();
064
             
065
            // Make all the buttons in makeMeButtons by passing the
066
            // button icon.
067
             
068
            brushBut = makeMeButtons("./src/brush.png", 1);
069
            lineBut = makeMeButtons("./src/Line.png", 2);
070
            ellipseBut = makeMeButtons("./src/Ellipse.png", 3);
071
            rectBut = makeMeButtons("./src/Rectangle.png", 4);
072
             
073
            // Make all the buttons in makeMeColorButton by passing the
074
            // button icon and true for stroke color or false for fill
075
             
076
            strokeBut = makeMeColorButton("./src/Stroke.png", 5, true);
077
            fillBut = makeMeColorButton("./src/Fill.png", 6, false);
078
             
079
            // Add the buttons to the box
080
             
081
            theBox.add(brushBut);
082
            theBox.add(lineBut);
083
            theBox.add(ellipseBut);
084
            theBox.add(rectBut);
085
            theBox.add(strokeBut);
086
            theBox.add(fillBut);
087
             
088
            // Add the transparent label and slider
089
             
090
            transLabel = new JLabel("Transparent: 1");
091
             
092
            // Min value, Max value and starting value for slider
093
             
094
            transSlider = new JSlider(1, 99, 99);
095
             
096
            // Create an instance of ListenForEvents to handle events
097
             
098
            ListenForSlider lForSlider = new ListenForSlider();
099
             
100
            // Tell Java that you want to be alerted when an event
101
            // occurs on the slider
102
            
103
            transSlider.addChangeListener(lForSlider);
104
 
105
            theBox.add(transLabel);
106
            theBox.add(transSlider);
107
             
108
            // Add the box of buttons to the panel
109
             
110
            buttonPanel.add(theBox);
111
 
112
            // Position the buttons in the bottom of the frame
113
             
114
            this.add(buttonPanel, BorderLayout.SOUTH);
115
             
116
            // Make the drawing area take up the rest of the frame
117
             
118
            this.add(new DrawingBoard(), BorderLayout.CENTER);
119
             
120
            // Show the frame
121
             
122
            this.setVisible(true);
123
        }
124
         
125
        // Spits out buttons based on the image supplied
126
        // actionNum represents each shape to be drawn
127
         
128
        public JButton makeMeButtons(String iconFile, final int actionNum){
129
            JButton theBut = new JButton();
130
            Icon butIcon = new ImageIcon(iconFile);
131
            theBut.setIcon(butIcon);
132
             
133
            // Make the proper actionPerformed method execute when the
134
            // specific button is pressed
135
             
136
            theBut.addActionListener(new ActionListener() {
137
 
138
                public void actionPerformed(ActionEvent e) {
139
                    currentAction = actionNum;
140
                     
141
                }
142
            });
143
             
144
            return theBut; 
145
        }
146
         
147
        // Spits out buttons based on the image supplied and
148
        // whether a stroke or fill is to be defined
149
         
150
        public JButton makeMeColorButton(String iconFile, final int actionNum, final boolean stroke){
151
            JButton theBut = new JButton();
152
            Icon butIcon = new ImageIcon(iconFile);
153
            theBut.setIcon(butIcon);
154
             
155
            theBut.addActionListener(new ActionListener() {
156
 
157
                public void actionPerformed(ActionEvent e) {
158
                     
159
                    if(stroke){
160
                         
161
                        // JColorChooser is a popup that lets you pick a color
162
                         
163
                        strokeColor = JColorChooser.showDialog(null,  "Pick a Stroke", Color.BLACK);
164
                    } else {
165
                        fillColor = JColorChooser.showDialog(null,  "Pick a Fill", Color.BLACK);
166
                    }
167
                     
168
                }
169
            });
170
             
171
            return theBut; 
172
        }
173
 
174
        private class DrawingBoard extends JComponent
175
        {
176
             
177
            // ArrayLists that contain each shape drawn along with
178
            // that shapes stroke and fill
179
             
180
                ArrayList<Shape> shapes = new ArrayList<Shape>();
181
                ArrayList<Color> shapeFill = new ArrayList<Color>();
182
                ArrayList<Color> shapeStroke = new ArrayList<Color>();
183
                ArrayList<Float> transPercent = new ArrayList<Float>();
184
                 
185
                Point drawStart, drawEnd;
186
 
187
                // Monitors events on the drawing area of the frame
188
                 
189
                public DrawingBoard()
190
                {
191
                     
192
                        this.addMouseListener(new MouseAdapter()
193
                          {
194
                             
195
                            public void mousePressed(MouseEvent e)
196
                            {
197
                                 
198
                                if(currentAction != 1){
199
                                 
200
                                // When the mouse is pressed get x & y position
201
                                 
202
                                drawStart = new Point(e.getX(), e.getY());
203
                                drawEnd = drawStart;
204
                                repaint();
205
                                 
206
                                }
207
                                 
208
                                 
209
                                }
210
 
211
                            public void mouseReleased(MouseEvent e)
212
                                {
213
                                 
214
                                if(currentAction != 1){
215
                                 
216
                                  // Create a shape using the starting x & y
217
                                  // and finishing x & y positions
218
                                 
219
                                Shape aShape = null;
220
                                 
221
                                if (currentAction == 2){
222
                                    aShape = drawLine(drawStart.x, drawStart.y,
223
                                            e.getX(), e.getY());
224
                                } else
225
                                 
226
                                if (currentAction == 3){
227
                                    aShape = drawEllipse(drawStart.x, drawStart.y,
228
                                            e.getX(), e.getY());
229
                                } else
230
                                 
231
                                if (currentAction == 4) {
232
                                     
233
                                    // Create a new rectangle using x & y coordinates
234
                                     
235
                                    aShape = drawRectangle(drawStart.x, drawStart.y,
236
                                            e.getX(), e.getY());
237
                                }
238
                                 
239
                                   
240
                                  // Add shapes, fills and colors to there ArrayLists
241
                                   
242
                                  shapes.add(aShape);
243
                                  shapeFill.add(fillColor);
244
                                  shapeStroke.add(strokeColor);
245
                                   
246
                                  // Add transparency value to ArrayList
247
                                   
248
                                  transPercent.add(transparentVal);
249
                                   
250
                                  drawStart = null;
251
                                  drawEnd = null;
252
                                   
253
                                  // repaint the drawing area
254
                                   
255
                                  repaint();
256
                                   
257
                                }
258
                                   
259
                                }
260
                          } );
261
 
262
                        this.addMouseMotionListener(new MouseMotionAdapter()
263
                        {
264
                             
265
                          public void mouseDragged(MouseEvent e)
266
                          {
267
                               
268
                              // If this is a brush have shapes go on the screen quickly
269
                               
270
                              if(currentAction == 1){
271
                                 
272
                                int x = e.getX();
273
                                int y = e.getY();
274
                                 
275
                                Shape aShape = null;
276
                                 
277
                                // Make stroke and fill equal to eliminate the fact that this is an ellipse
278
                                 
279
                                strokeColor = fillColor;
280
                                 
281
                                aShape = drawBrush(x,y,5,5);
282
                                 
283
                                shapes.add(aShape);
284
                                  shapeFill.add(fillColor);
285
                                  shapeStroke.add(strokeColor);
286
                                   
287
                                  // Add the transparency value
288
                                   
289
                                  transPercent.add(transparentVal);
290
                            }
291
                               
292
                            // Get the final x & y position after the mouse is dragged
293
                               
294
                            drawEnd = new Point(e.getX(), e.getY());
295
                            repaint();
296
                          }
297
                        } );
298
                }
299
                 
300
 
301
                public void paint(Graphics g)
302
                {
303
                        // Class used to define the shapes to be drawn
304
                     
305
                        graphSettings = (Graphics2D)g;
306
 
307
                        // Antialiasing cleans up the jagged lines and defines rendering rules
308
                         
309
                        graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
310
                                RenderingHints.VALUE_ANTIALIAS_ON);
311
                         
312
                        // Defines the line width of the stroke
313
                         
314
                        graphSettings.setStroke(new BasicStroke(4));
315
 
316
                        // Iterators created to cycle through strokes and fills
317
                        Iterator<Color> strokeCounter = shapeStroke.iterator();
318
                        Iterator<Color> fillCounter = shapeFill.iterator();
319
                         
320
                        // Iterator for transparency
321
                         
322
                        Iterator<Float> transCounter = transPercent.iterator();
323
                         
324
                        for (Shape s : shapes)
325
                        {
326
                             
327
                            // Sets the shapes transparency value
328
                             
329
                            graphSettings.setComposite(AlphaComposite.getInstance(
330
                                    AlphaComposite.SRC_OVER, transCounter.next()));
331
                             
332
                            // Grabs the next stroke from the color arraylist
333
                            graphSettings.setPaint(strokeCounter.next());
334
                             
335
                            graphSettings.draw(s);
336
                             
337
                            // Grabs the next fill from the color arraylist
338
                            graphSettings.setPaint(fillCounter.next());
339
                             
340
                            graphSettings.fill(s);
341
                        }
342
 
343
                        // Guide shape used for drawing
344
                        if (drawStart != null && drawEnd != null)
345
                        {
346
                            // Makes the guide shape transparent
347
                             
348
                            graphSettings.setComposite(AlphaComposite.getInstance(
349
                                    AlphaComposite.SRC_OVER, 0.40f));
350
                             
351
                            // Make guide shape gray for professional look
352
                             
353
                            graphSettings.setPaint(Color.LIGHT_GRAY);
354
                             
355
                            Shape aShape = null;
356
                             
357
                            if (currentAction == 2){
358
                                aShape = drawLine(drawStart.x, drawStart.y,
359
                                        drawEnd.x, drawEnd.y);
360
                            } else
361
                             
362
                            if (currentAction == 3){
363
                                aShape = drawEllipse(drawStart.x, drawStart.y,
364
                                        drawEnd.x, drawEnd.y);
365
                            } else
366
                             
367
                            if (currentAction == 4) {
368
                                 
369
                                // Create a new rectangle using x & y coordinates
370
                                 
371
                                aShape = drawRectangle(drawStart.x, drawStart.y,
372
                                        drawEnd.x, drawEnd.y);
373
                            }
374
                                 
375
                                 
376
                                graphSettings.draw(aShape);
377
                        }
378
                }
379
 
380
                private Rectangle2D.Float drawRectangle(
381
                        int x1, int y1, int x2, int y2)
382
                {
383
                    // Get the top left hand corner for the shape
384
                    // Math.min returns the points closest to 0
385
                     
386
                        int x = Math.min(x1, x2);
387
                        int y = Math.min(y1, y2);
388
                         
389
                        // Gets the difference between the coordinates and
390
                         
391
                        int width = Math.abs(x1 - x2);
392
                        int height = Math.abs(y1 - y2);
393
 
394
                        return new Rectangle2D.Float(
395
                                x, y, width, height);
396
                }
397
                 
398
                // The other shapes will work similarly
399
                // More on this in the next tutorial
400
                 
401
                private Ellipse2D.Float drawEllipse(
402
                        int x1, int y1, int x2, int y2)
403
                {
404
                        int x = Math.min(x1, x2);
405
                        int y = Math.min(y1, y2);
406
                        int width = Math.abs(x1 - x2);
407
                        int height = Math.abs(y1 - y2);
408
 
409
                        return new Ellipse2D.Float(
410
                                x, y, width, height);
411
                }
412
                 
413
                private Line2D.Float drawLine(
414
                        int x1, int y1, int x2, int y2)
415
                {
416
 
417
                        return new Line2D.Float(
418
                                x1, y1, x2, y2);
419
                }
420
                 
421
                private Ellipse2D.Float drawBrush(
422
                        int x1, int y1, int brushStrokeWidth, int brushStrokeHeight)
423
                {
424
                     
425
                    return new Ellipse2D.Float(
426
                            x1, y1, brushStrokeWidth, brushStrokeHeight);
427
                     
428
                }
429
 
430
        }
431
         
432
     // Implements ActionListener so it can react to events on components
433
         
434
        private class ListenForSlider implements ChangeListener{
435
             
436
            // Called when the spinner is changed
437
             
438
            public void stateChanged(ChangeEvent e) {
439
             
440
                // Check if the source of the event was the button
441
             
442
                if(e.getSource() == transSlider){
443
             
444
                    // Change the value for the label next to the spinner
445
                    // Use decimal format to make sure only 2 decimals are ever displayed
446
             
447
                    transLabel.setText("Transparent: " + dec.format(transSlider.getValue() * .01) );
448
                     
449
                    // Set the value for transparency for every shape drawn after
450
                     
451
                    transparentVal = (float) (transSlider.getValue() * .01);
452
                     
453
                }
454
             
455
            }
456
             
457
        }
