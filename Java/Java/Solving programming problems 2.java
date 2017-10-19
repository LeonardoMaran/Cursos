import java.util.Arrays;
002
 
003
public class Heap2 {
004
 
005
    private Data3[] theHeap;
006
 
007
    private int itemsInArray = 0;
008
 
009
    private int maxSize;
010
 
011
    public Heap2(int maxSize) {
012
 
013
        this.maxSize = maxSize;
014
 
015
        theHeap = new Data3[maxSize];
016
 
017
    }
018
 
019
    public void insert(int index, Data3 newData) {
020
 
021
        theHeap[index] = newData;
022
 
023
        itemsInArray++;
024
 
025
    }
026
 
027
    // Old Tree Generation Code
028
 
029
    public void printTree(int rows) {
030
 
031
        int spaces = 0;
032
 
033
        int iteration = 1;
034
 
035
        while (iteration <= rows) {
036
 
037
            int indent = (int) Math
038
                    .abs(((Math.pow(-2, -iteration)) * (-16 + (Math.pow(2,
039
                            iteration)))));
040
 
041
            int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));
042
 
043
            int itemsPerRow = (int) (Math.pow(2, iteration - 1));
044
 
045
            int maxIndexToPrint = indexToPrint + itemsPerRow;
046
 
047
            for (int j = 0; j < indent; j++)
048
                System.out.print(" ");
049
 
050
            for (int l = indexToPrint; l < maxIndexToPrint; l++) {
051
 
052
                System.out.print(theHeap[l].key);
053
 
054
                for (int k = 0; k < spaces; k++)
055
                    System.out.print(" ");
056
 
057
            }
058
 
059
            spaces = indent;
060
 
061
            iteration++;
062
 
063
            System.out.println();
064
 
065
        }
066
 
067
    }
068
 
069
    public void printTree2(int rows) {
070
 
071
        // Number of spaces between items in tree
072
 
073
        int spaces = 0;
074
 
075
        int iteration = 1;
076
 
077
        // Generate all of the indents that are
078
        // needed depending on the number of rows
079
        // to print
080
 
081
        int[] indent = getIndentArray(rows);
082
 
083
        while (iteration <= rows) {
084
 
085
            // Find first Index : .5 * (-2 + 2^n)
086
 
087
            int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));
088
 
089
            // Number of Items per Row : 2^(n - 1)
090
 
091
            int itemsPerRow = (int) (Math.pow(2, iteration - 1));
092
 
093
            int maxIndexToPrint = indexToPrint + itemsPerRow;
094
 
095
            /*
096
             * System.out.println("Indent: " + indent[iteration - 1]);
097
             * System.out.println("indexToPrint: " + indexToPrint);
098
             * System.out.println("itemsPerRow: " + itemsPerRow);
099
             * System.out.println("maxIndexToPrint: " + maxIndexToPrint);
100
             */
101
 
102
            // Print the indents needed
103
 
104
            for (int j = 0; j < indent[iteration - 1]; j++)
105
                System.out.print(" ");
106
 
107
            // Print all of the index values for each row
108
            // indexToPrint represents the first index in the
109
            // row, while maxIndexToPrint equals the last
110
 
111
            for (int l = indexToPrint; l < maxIndexToPrint; l++) {
112
 
113
                // If the array isn't full don't try to print
114
                // indexes that don't exist
115
 
116
                if (l < itemsInArray) {
117
 
118
                    System.out.print(String.format("%02d", theHeap[l].key));
119
 
120
                    for (int k = 0; k < spaces; k++)
121
                        System.out.print(" ");
122
 
123
                }
124
 
125
            }
126
 
127
            // In a tree the spaces get bigger in the
128
            // same way that indents get smaller
129
 
130
            spaces = indent[iteration - 1];
131
 
132
            iteration++;
133
 
134
            System.out.println();
135
 
136
        }
137
 
138
    }
139
 
140
    // Calculate each indent per row for the tree
141
    // then reverse their order to go from biggest
142
    // to smallest
143
 
144
    public int[] getIndentArray(int rows) {
145
 
146
        int[] indentArray = new int[rows];
147
 
148
        for (int i = 0; i < rows; i++) {
149
 
150
            indentArray[i] = (int) Math.abs((-2 + (Math.pow(2, i + 1))));
151
 
152
        }
153
 
154
        Arrays.sort(indentArray);
155
 
156
        indentArray = reverseArray(indentArray);
157
 
158
        return indentArray;
159
 
160
    }
161
 
162
    // Reverse the indent values in the array
163
    // so that they go from biggest to smallest
164
 
165
    public int[] reverseArray(int[] theArray) {
166
 
167
        // Index of the first element
168
        int leftIndex = 0;
169
 
170
        // Index of last element
171
        int rightIndex = theArray.length - 1;
172
 
173
        while (leftIndex < rightIndex) {
174
            // Exchange the left and right elements
175
            int temp = theArray[leftIndex];
176
            theArray[leftIndex] = theArray[rightIndex];
177
            theArray[rightIndex] = temp;
178
 
179
            // Move the indexes to check towards the middle
180
            leftIndex++;
181
            rightIndex--;
182
        }
183
 
184
        return theArray;
185
    }
186
 
187
    // Fill the heap with random numbers based on
188
    // the number that is passed in
189
 
190
    public void generateFilledArray(int randNum) {
191
 
192
        Data3 randomData1;
193
 
194
        for (int i = 0; i < this.maxSize; i++) {
195
 
196
            randomData1 = new Data3((int) (Math.random() * randNum) + 1);
197
 
198
            this.insert(i, randomData1);
199
 
200
        }
201
 
202
    }
203
 
204
    public static void main(String args[]) {
205
 
206
        System.out.println("OLD TREE");
207
 
208
        Heap2 newHeap = new Heap2(70);
209
 
210
        // If I generate 2 digit numbers nothing lines up
211
 
212
        // newHeap.generateFilledArray(90);
213
 
214
        newHeap.generateFilledArray(9);
215
 
216
        // If I increase to over 4 rows the spaces are lost in the last row
217
 
218
        // newHeap.printTree(5);
219
 
220
        // newHeap.printTree(6);
221
 
222
        System.out.println("\nNEW TREE\n");
223
 
224
        newHeap.printTree2(6);
225
 
226
    }
227
 
228
}
229
 
230
class Data3 {
231
 
232
    public int key;
233
 
234
    public Data3(int key) {
235
 
236
        this.key = key;
237
 
238
    }
239
 
240
}
