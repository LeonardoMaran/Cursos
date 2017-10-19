public class ArrayStructures {
002
     
003
    private int[] theArray = new int[50]; // Creates an array with 50 indexes
004
     
005
    private int arraySize = 10; // Elements in theArray
006
     
007
     
008
    // Fills the Array with random values
009
     
010
    public void generateRandomArray(){
011
         
012
        for(int i = 0; i < arraySize; i++){
013
             
014
            // Random number 10 through 19
015
             
016
            theArray[i] = (int)(Math.random()*10)+10;
017
             
018
        }
019
         
020
    }
021
     
022
    public int[] getTheArray(){
023
         
024
        return theArray;
025
         
026
    }
027
     
028
    public int getArraySize(){
029
         
030
        return arraySize;
031
         
032
    }
033
     
034
    // Prints the Array on the screen in a grid
035
     
036
    public void printArray(){
037
         
038
        System.out.println("----------");
039
         
040
        for(int i = 0; i < arraySize; i++){
041
             
042
            System.out.print("| " + i + " | ");
043
             
044
            System.out.println(theArray[i] + " |");
045
             
046
            System.out.println("----------");
047
             
048
        }
049
         
050
    }
051
     
052
    // Gets value at provided index
053
     
054
    public int getValueAtIndex(int index){
055
         
056
        if(index < arraySize) return theArray[index];
057
         
058
        return 0;
059
         
060
    }
061
     
062
    // Returns true or false if a value is in the Array
063
     
064
    public boolean doesArrayContainThisValue(int searchValue){
065
         
066
        boolean valueInArray = false;
067
         
068
        for(int i = 0; i < arraySize; i++){
069
             
070
            if(theArray[i] == searchValue){
071
                 
072
                valueInArray = true;
073
                 
074
            }
075
             
076
        }
077
         
078
        return valueInArray;
079
         
080
    }
081
     
082
     
083
    // Delete Array row for the index and move elements up
084
     
085
    public void deleteIndex(int index){
086
         
087
        if(index < arraySize){
088
             
089
            // Overwrite the value for the supplied index
090
            // and then keep overwriting every index that follows
091
            // until you get to the last index in the array
092
             
093
            for(int i = index; i < (arraySize - 1); i++){
094
                 
095
                theArray[i] = theArray[i+1];
096
         
097
            }
098
             
099
            arraySize--;
100
             
101
        }
102
         
103
    }
104
     
105
    public void insertValue(int value){
106
         
107
        if(arraySize < 50){
108
             
109
            theArray[arraySize] = value;
110
             
111
            arraySize++;
112
             
113
        }
114
         
115
    }
116
     
117
    // Linear Search : Every index must be looked at
118
     
119
    public String linearSearchForValue(int value){
120
         
121
        boolean valueInArray = false;
122
         
123
        String indexsWithValue = "";
124
             
125
        System.out.print("The Value was Found in the Following Indexes: ");
126
         
127
        for(int i = 0; i < arraySize; i++){
128
             
129
            if(theArray[i] == value) {
130
                valueInArray = true;
131
                 
132
                System.out.print(i + " ");
133
                 
134
                indexsWithValue+= i + " ";
135
            }
136
             
137
        }
138
         
139
        if(!valueInArray){
140
            indexsWithValue = "None";
141
             
142
            System.out.print(indexsWithValue);
143
        }
144
             
145
        System.out.println();
146
         
147
        return indexsWithValue;
148
             
149
    }
150
     
151
    // This bubble sort will sort everything from
152
    // smallest to largest
153
     
154
    public void bubbleSort(){
155
         
156
        // i starts at the end of the Array
157
        // As it is decremented all indexes greater
158
        // then it are sorted
159
         
160
        for(int i = arraySize - 1; i > 1; i--){
161
             
162
            // The inner loop starts at the beginning of
163
            // the array and compares each value next to each
164
            // other. If the value is greater then they are
165
            // swapped
166
             
167
            for(int j = 0; j < i; j++){
168
                 
169
                if(theArray[j] > theArray[j + 1]){
170
                     
171
                    swapValues(j, j+1);
172
                     
173
                }
174
                 
175
            }
176
             
177
        }
178
         
179
    }
180
     
181
    public static void main(String[] args){
182
         
183
        ArrayStructures newArray = new ArrayStructures();
184
         
185
        newArray.generateRandomArray();
186
         
187
        newArray.printArray();
188
         
189
        System.out.println(newArray.getValueAtIndex(3));
190
         
191
        System.out.println(newArray.doesArrayContainThisValue(18));
192
         
193
        newArray.deleteIndex(4);
194
         
195
        newArray.printArray();
196
         
197
        newArray.insertValue(55);
198
         
199
        newArray.printArray();
200
         
201
        newArray.linearSearchForValue(17);
202
    }
203
 
204
}
 The MVC Version of the Above Program

001
public class ArrayStructure {
002
     
003
    private int[] theArray = new int[50]; // Creates an array with 50 indexes
004
     
005
    private int arraySize = 10; // Elements in theArray
006
     
007
     
008
    // Fills the Array with random values
009
     
010
    public void generateRandomArray(){
011
         
012
        for(int i = 0; i < arraySize; i++){
013
             
014
            theArray[i] = (int)(Math.random()*9)+10;
015
             
016
        }
017
         
018
    }
019
     
020
    public int[] getTheArray(){
021
         
022
        return theArray;
023
         
024
    }
025
     
026
    public int getArraySize(){
027
         
028
        return arraySize;
029
         
030
    }
031
     
032
     
033
     
034
    // Used to slow down calculations
035
     
036
    public void pauseAndUpdate(){
037
         
038
        try {
039
            Thread.sleep(700);
040
        } catch (InterruptedException e) {
041
            // TODO Auto-generated catch block
042
            e.printStackTrace();
043
        }
044
         
045
    }
046
     
047
    // Prints the Array on the screen in a grid
048
     
049
    public void printArray(){
050
         
051
        System.out.println("----------");
052
         
053
        for(int i = 0; i < arraySize; i++){
054
             
055
            System.out.print("| " + i + " | ");
056
             
057
            System.out.println(theArray[i] + " |");
058
             
059
            System.out.println("----------");
060
             
061
        }
062
         
063
    }
064
     
065
    // Gets value at provided index
066
     
067
    public int getValueAtIndex(int index){
068
         
069
        if(index < arraySize) return theArray[index];
070
         
071
        return 0;
072
         
073
    }
074
     
075
    // Returns true or false if a value is in the Array
076
     
077
    public boolean doesArrayContainThisValue(int searchValue){
078
         
079
        boolean valueInArray = false;
080
         
081
        for(int i = 0; i < arraySize; i++){
082
             
083
            if(theArray[i] == searchValue){
084
                 
085
                valueInArray = true;
086
                 
087
            }
088
             
089
        }
090
         
091
        return valueInArray;
092
         
093
    }
094
     
095
     
096
    // Delete Array row for the index and move elements up
097
     
098
    public void deleteIndex(int index){
099
         
100
        if(index < arraySize){
101
             
102
            // Overwrite the value for the supplied index
103
            // and then keep overwriting every index that follows
104
            // until you get to the last index in the array
105
             
106
            for(int i = index; i < (arraySize - 1); i++){
107
                 
108
                pauseAndUpdate();
109
                 
110
                theArray[i] = theArray[i+1];
111
         
112
            }
113
             
114
            arraySize--;
115
             
116
        }
117
         
118
    }
119
     
120
    public void insertValue(int value){
121
         
122
        if(arraySize < 50){
123
             
124
            pauseAndUpdate();
125
             
126
            theArray[arraySize] = value;
127
             
128
            arraySize++;
129
             
130
        }
131
         
132
    }
133
     
134
    // Linear Search : Every index must be looked at
135
     
136
    public String linearSearchForValue(int value){
137
         
138
        boolean valueInArray = false;
139
         
140
        String indexsWithValue = "";
141
             
142
        System.out.print("The Value was Found in the Following Indexes: ");
143
         
144
        for(int i = 0; i < arraySize; i++){
145
             
146
            if(theArray[i] == value) {
147
                valueInArray = true;
148
                 
149
                System.out.print(i + " ");
150
                 
151
                indexsWithValue+= i + " ";
152
            }
153
             
154
        }
155
         
156
        if(!valueInArray){
157
            indexsWithValue = "None";
158
             
159
            System.out.print(indexsWithValue);
160
        }
161
             
162
        System.out.println();
163
         
164
        return indexsWithValue;
165
             
166
    }
167
     
168
    // This bubble sort will sort everything from
169
    // smallest to largest
170
     
171
    public void bubbleSort(){
172
         
173
        // i starts at the end of the Array
174
        // As it is decremented all indexes greater
175
        // then it are sorted
176
         
177
        for(int i = arraySize - 1; i > 1; i--){
178
             
179
            // The inner loop starts at the beginning of
180
            // the array and compares each value next to each
181
            // other. If the value is greater then they are
182
            // swapped
183
             
184
            for(int j = 0; j < i; j++){
185
                 
186
                if(theArray[j] > theArray[j + 1]){
187
                     
188
                    swapValues(j, j+1);
189
                     
190
                }
191
                 
192
            }
193
             
194
        }
195
         
196
    }
197
     
198
    // This bubble sort will sort everything from
199
    // largest to smallest
200
     
201
    public void bubbleSortDescending(){
202
         
203
        // i starts at the beginning of the array
204
         
205
        for(int i = 0; i < arraySize; i++){
206
             
207
            // The inner loop starts at the beginning of
208
            // the array 1 index in more than i.
209
             
210
            for(int j = 1; j < (arraySize - i); j++){
211
                 
212
                // Here we check if the 1st index is less
213
                // than the next during the first run through
214
                // Then we just increase the indexes until
215
                // they have all been checked
216
                 
217
                if(theArray[j-1] < theArray[j]){
218
                     
219
                    swapValues(j-1, j);
220
                     
221
                }
222
                 
223
            }
224
             
225
        }
226
         
227
    }
228
     
229
    public void swapValues(int indexOne, int indexTwo){
230
         
231
        int temp = theArray[indexOne];
232
        theArray[indexOne] = theArray[indexTwo];
233
        theArray[indexTwo] = temp;
234
         
235
    }
236
     
237
    // The Binary Search is quicker than the linear search
238
    // because all the values are sorted. Because everything
239
    // is sorted once you get to a number larger than what
240
    // you are looking for you can stop the search. Also
241
    // you be able to start searching from the middle
242
    // which speeds the search. It also works best when
243
    // there are no duplicates
244
     
245
    public void binarySearchForValue(int value){
246
         
247
        int lowIndex = 0;
248
        int highIndex = arraySize - 1;
249
         
250
        while(lowIndex <= highIndex){
251
             
252
            int middleIndex = (highIndex + lowIndex) / 2;
253
             
254
            if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
255
             
256
            else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
257
             
258
            else {
259
                 
260
                System.out.println("Found a Match for " + value + " at Index " + middleIndex);
261
                 
262
                lowIndex = highIndex + 1;
263
                 
264
            }
265
             
266
        }
267
         
268
    }
269
     
270
    public static void main(String[] args){
271
         
272
        /*
273
         
274
        ArrayStructure newArray = new ArrayStructure();
275
         
276
        newArray.generateRandomArray();
277
         
278
        newArray.printArray();
279
         
280
        System.out.println(newArray.getValueAtIndex(9));
281
         
282
        System.out.println(newArray.doesArrayContainThisValue(11));
283
         
284
        newArray.deleteIndex(3);
285
         
286
        newArray.insertValue(100);
287
         
288
        newArray.bubbleSort();
289
         
290
        newArray.printArray();
291
         
292
        newArray.linearSearchForValue(11);
293
         
294
        newArray.binarySearchForValue(12);
295
         
296
        newArray.bubbleSortDescending();
297
         
298
        newArray.printArray();
299
         
300
        */
301
         
302
    }
303
 
304
}
001
import javax.swing.*;
002
import javax.swing.border.EmptyBorder;
003
import javax.swing.table.DefaultTableModel;
004
import javax.swing.GroupLayout;
005
import javax.swing.GroupLayout.Alignment;
006
import javax.swing.LayoutStyle.ComponentPlacement;
007
 
008
import java.awt.Font;
009
import java.awt.event.*;
010
 
011
public class JavaAlgorithms extends JFrame {
012
 
013
    private JPanel contentPane;
014
 
015
    private JTextField arrayValueTextField;
016
    private JTable table;
017
    private JTextField arrayIndexTextField;
018
    private JButton insertButton, deleteButton, findButton, sortButton;
019
    JRadioButton linearSearchRadioButton, binarySearchRadioButton;
020
    JRadioButton descendingRadioButton, ascendingRadioButton;
021
     
022
    int cellToMark = -1;
023
     
024
    // Holds the array that goes in JTable
025
     
026
    Object[][] data = {
027
            {new Integer(0), new Integer(0), ""},
028
            {new Integer(1), new Integer(0), ""},
029
            {new Integer(2), new Integer(0), ""},
030
            {new Integer(3), new Integer(0), ""},
031
            {new Integer(4), new Integer(0), ""},
032
            {new Integer(5), new Integer(0), ""},
033
            {new Integer(6), new Integer(0), ""},
034
            {new Integer(7), new Integer(0), ""},
035
            {new Integer(8), new Integer(0), ""},
036
            {new Integer(9), new Integer(0), ""},
037
        };
038
     
039
    String[] columnNames = {"Index",
040
            "Value",
041
            "Selected"};
042
     
043
     
044
    DefaultTableModel dTableModel = new DefaultTableModel(data, columnNames);
045
 
046
    /**
047
     * Create the frame.
048
     */
049
    public JavaAlgorithms() {
050
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
051
        setBounds(100, 100, 970, 800);
052
        contentPane = new JPanel();
053
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
054
        setContentPane(contentPane);
055
         
056
        JLabel valueLabel = new JLabel("Value");
057
        valueLabel.setFont(new Font("Dialog", Font.BOLD, 30));
058
         
059
        arrayValueTextField = new JTextField();
060
        arrayValueTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
061
        arrayValueTextField.setColumns(10);
062
         
063
        JLabel indexLabel = new JLabel("Index");
064
        indexLabel.setFont(new Font("Dialog", Font.BOLD, 30));
065
         
066
        arrayIndexTextField = new JTextField();
067
        arrayIndexTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
068
        arrayIndexTextField.setColumns(10);
069
         
070
        insertButton = new JButton("Insert");
071
        insertButton.setFont(new Font("Dialog", Font.BOLD, 30));
072
         
073
        deleteButton = new JButton("Delete");
074
        deleteButton.setFont(new Font("Dialog", Font.BOLD, 30));
075
         
076
        findButton = new JButton("Find");
077
        findButton.setFont(new Font("Dialog", Font.BOLD, 30));
078
         
079
        JScrollPane scrollPane = new JScrollPane();
080
         
081
        ascendingRadioButton = new JRadioButton("Ascending");
082
        ascendingRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));
083
         
084
        descendingRadioButton = new JRadioButton("Descending");
085
        descendingRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));
086
         
087
        // Stores the radio buttons so when one is selected the other is deselected
088
         
089
        ButtonGroup sortDirection = new ButtonGroup();
090
         
091
        sortDirection.add(ascendingRadioButton);
092
         
093
        sortDirection.add(descendingRadioButton);
094
         
095
        sortButton = new JButton("Sort");
096
        sortButton.setFont(new Font("Dialog", Font.BOLD, 30));
097
         
098
        // Sets up the radio buttons for the search type
099
         
100
        linearSearchRadioButton = new JRadioButton("Linear");
101
        linearSearchRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));
102
         
103
        binarySearchRadioButton = new JRadioButton("Binary");
104
        binarySearchRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));
105
         
106
        ButtonGroup searchType = new ButtonGroup();
107
         
108
        searchType.add(linearSearchRadioButton);
109
        searchType.add(binarySearchRadioButton);
110
         
111
        JTextArea textArea = new JTextArea("Output");
112
        textArea.setFont(new Font("Dialog", Font.PLAIN, 30));
113
         
114
        // ------------------------
115
         
116
        GroupLayout groupLayout = new GroupLayout(contentPane);
117
         
118
        groupLayout.setHorizontalGroup(
119
                groupLayout.createParallelGroup(Alignment.LEADING)
120
                    .addGroup(groupLayout.createSequentialGroup()
121
                        .addGap(30)
122
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
123
                            .addGroup(groupLayout.createSequentialGroup()
124
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
125
                                .addGap(18)
126
                                .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
127
                            .addGroup(groupLayout.createSequentialGroup()
128
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
129
                                    .addGroup(groupLayout.createSequentialGroup()
130
                                        .addComponent(ascendingRadioButton)
131
                                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
132
                                        .addComponent(descendingRadioButton))
133
                                    .addGroup(groupLayout.createSequentialGroup()
134
                                        .addComponent(valueLabel)
135
                                        .addPreferredGap(ComponentPlacement.UNRELATED)
136
                                        .addComponent(arrayValueTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
137
                                        .addGap(34)
138
                                        .addComponent(indexLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
139
                                        .addPreferredGap(ComponentPlacement.UNRELATED)
140
                                        .addComponent(arrayIndexTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
141
                                .addGap(18)
142
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
143
                                    .addGroup(groupLayout.createSequentialGroup()
144
                                        .addComponent(insertButton)
145
                                        .addGap(26)
146
                                        .addComponent(deleteButton)
147
                                        .addGap(26)
148
                                        .addComponent(findButton))
149
                                    .addGroup(groupLayout.createSequentialGroup()
150
                                        .addComponent(sortButton)
151
                                        .addGap(18)
152
                                        .addComponent(linearSearchRadioButton)
153
                                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
154
                                        .addComponent(binarySearchRadioButton)))))
155
                        .addContainerGap(75, Short.MAX_VALUE))
156
            );
157
            groupLayout.setVerticalGroup(
158
                groupLayout.createParallelGroup(Alignment.LEADING)
159
                    .addGroup(groupLayout.createSequentialGroup()
160
                        .addContainerGap()
161
                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
162
                            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
163
                                .addComponent(valueLabel)
164
                                .addComponent(insertButton)
165
                                .addComponent(deleteButton)
166
                                .addComponent(findButton)
167
                                .addComponent(arrayValueTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
168
                            .addGroup(groupLayout.createSequentialGroup()
169
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
170
                                    .addComponent(indexLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
171
                                    .addComponent(arrayIndexTextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
172
                                .addGap(2)))
173
                        .addGap(35)
174
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
175
                            .addComponent(ascendingRadioButton)
176
                            .addComponent(descendingRadioButton)
177
                            .addComponent(sortButton)
178
                            .addComponent(linearSearchRadioButton)
179
                            .addComponent(binarySearchRadioButton))
180
                        .addGap(42)
181
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
182
                            .addComponent(textArea)
183
                            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
184
                        .addContainerGap(94, Short.MAX_VALUE))
185
            );
186
             
187
            table = new JTable(dTableModel);
188
             
189
            // Set the font for the table column titles
190
             
191
            table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 30));
192
             
193
            // Set the font for the data in the columns
194
             
195
            table.setFont(new Font("Dialog", Font.BOLD, 30));
196
             
197
            // Increase the row height so that the larger font fits
198
             
199
            table.setRowHeight(table.getRowHeight()+30);
200
             
201
            scrollPane.setViewportView(table);
202
         
203
         
204
        contentPane.setLayout(groupLayout);
205
    }
206
     
207
    // Set up all the listeners
208
     
209
    void addInsertButtonListener(ActionListener listenerForInsertButton){
210
         
211
        insertButton.addActionListener(listenerForInsertButton);
212
         
213
    }
214
     
215
    void addDeleteButtonListener(ActionListener listenerForDeleteButton){
216
         
217
        deleteButton.addActionListener(listenerForDeleteButton);
218
         
219
    }
220
     
221
    void addFindButtonListener(ActionListener listenerForFindButton){
222
         
223
        findButton.addActionListener(listenerForFindButton);
224
         
225
    }
226
     
227
    void addSortButtonListener(ActionListener listenerForSortButton){
228
         
229
        sortButton.addActionListener(listenerForSortButton);
230
         
231
    }
232
     
233
    // Other Random Methods Needed
234
     
235
    void sendMessageToUser(String errorMessage){
236
         
237
        JOptionPane.showMessageDialog(this, errorMessage);
238
         
239
    }
240
     
241
    public int getTheValue(){
242
         
243
        return Integer.parseInt(arrayValueTextField.getText());
244
         
245
    }
246
     
247
    public int getTheIndex(){
248
         
249
        return Integer.parseInt(arrayIndexTextField.getText());
250
         
251
    }
252
     
253
    public void updateTheTable(int[] newArray, int rows){
254
         
255
        Object[] tempRow;
256
         
257
        dTableModel.setRowCount(0); // Clear JTable
258
         
259
        for(int i = 0; i < rows; i++){
260
             
261
            if(i == this.cellToMark)tempRow = new Object[]{i, newArray[i], "XXXXX"};
262
             
263
            else tempRow = new Object[]{i, newArray[i], ""};
264
             
265
            dTableModel.addRow(tempRow);
266
             
267
        }
268
         
269
    }
270
     
271
}
272
 
273
class AlgorithmsMVC{
274
     
275
    public static void main(String[] args) {
276
         
277
        JavaAlgorithms theView = new JavaAlgorithms();
278
        ArrayStructure theModel = new ArrayStructure();
279
         
280
        AlgorithmsController theController = new AlgorithmsController(theView, theModel);
281
         
282
        theView.setVisible(true);
283
         
284
    }
285
     
286
}
287
 
288
class AlgorithmsController{
289
     
290
    private JavaAlgorithms theView;
291
    private ArrayStructure theModel;
292
     
293
    public AlgorithmsController(JavaAlgorithms theView, ArrayStructure theModel){
294
         
295
        this.theView = theView;
296
        this.theModel = theModel;
297
         
298
        theModel.generateRandomArray();
299
         
300
        // Add button listeners
301
         
302
        this.theView.addInsertButtonListener(new InsertButtonListener());
303
        this.theView.addDeleteButtonListener(new DeleteButtonListener());
304
        this.theView.addFindButtonListener(new FindButtonListener());
305
        this.theView.addSortButtonListener(new SortButtonListener());
306
         
307
        // Put random array data in the table model
308
         
309
        theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());
310
         
311
    }
312
     
313
    // ActionListener for the Insert Button
314
     
315
    class InsertButtonListener implements ActionListener{
316
 
317
        public void actionPerformed(ActionEvent arg0) {
318
             
319
             
320
            try{
321
                 
322
                theModel.insertValue(theView.getTheValue());
323
                 
324
                // Take the array data from the model & move it to the JTable
325
                 
326
                theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());
327
                 
328
            }
329
             
330
            catch(NumberFormatException ex){
331
                 
332
                theView.sendMessageToUser("You Need a Value in the Value Box");
333
                 
334
            }
335
             
336
        }
337
         
338
    }
339
     
340
    // ActionListener for the Insert Button
341
     
342
    class DeleteButtonListener implements ActionListener{
343
 
344
        public void actionPerformed(ActionEvent arg0) {
345
             
346
            try{
347
                 
348
                theModel.deleteIndex(theView.getTheIndex());
349
                 
350
                theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());
351
                 
352
            }
353
             
354
            catch(NumberFormatException ex){
355
                 
356
                theView.sendMessageToUser("You Need a Index in the Index Box");
357
                 
358
            }
359
             
360
        }
361
         
362
    }
363
     
364
    // ActionListener for the Find Button
365
     
366
    class FindButtonListener implements ActionListener{
367
 
368
        public void actionPerformed(ActionEvent arg0) {
369
             
370
            String indexWithValue = "";
371
             
372
            try{
373
                 
374
                if(theView.linearSearchRadioButton.isSelected()){
375
                     
376
                    indexWithValue = theModel.linearSearchForValue(theView.getTheValue());
377
                     
378
                }
379
                 
380
                theView.sendMessageToUser("Found in Index: " + indexWithValue);
381
                 
382
            }
383
             
384
            catch(NumberFormatException ex){
385
                 
386
                theView.sendMessageToUser("You Need a Value in the Value Box");
387
                 
388
            }
389
             
390
        }
391
         
392
    }
393
     
394
    // ActionListener for the Sort Button
395
     
396
    class SortButtonListener implements ActionListener{
397
 
398
        public void actionPerformed(ActionEvent arg0) {
399
             
400
            try{
401
                 
402
                if(theView.ascendingRadioButton.isSelected()){
403
                     
404
                    theModel.bubbleSort();
405
                     
406
                } else {
407
                     
408
                    theModel.bubbleSortDescending();
409
                     
410
                }
411
                 
412
                theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());
413
                 
414
            }
415
             
416
            catch(NumberFormatException ex){
417
                 
418
                theView.sendMessageToUser("Something Went Wrong");
419
                 
420
            }
421
             
422
        }
423
         
424
    }
425
     
426
     
427
     
428
}
