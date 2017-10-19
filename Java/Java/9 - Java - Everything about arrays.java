001
import java.util.Arrays;
002
 
003
public class LessonNine {
004
     
005
    public static void main(String[] args){
006
         
007
        // An array is a variable that can hold a bunch of values
008
        // Think of an array as a big box filled with other boxes
009
        // Each box has a number on it called an index that you use
010
        // to access its specific value
011
         
012
        /* Array Rules
013
         * An array can contain only values of the same type
014
         * An arrays size can't be changed once it is set
015
         * An array is an object
016
         */
017
         
018
        // You declare an array with the dataType[] arrayName
019
        int[] randomArray;
020
         
021
        // You create an array with
022
        // dataType[] arrayName = new dataType[sizeOfArray];
023
         
024
        int[] numberArray = new int[10];
025
         
026
        // You can add values to the array in many ways
027
        // Individually
028
         
029
        // Most create array and define size first
030
        randomArray = new int[20];
031
        randomArray[1] = 2;
032
         
033
        // You can also create the array and its values from the start
034
        String[] stringArray = {"Just", "Random", "Words"};
035
         
036
        // You can add values with a loop
037
        // arrayName.length returns the number of elements in the array
038
        for(int i = 0; i < numberArray.length; i++)
039
        {
040
             
041
            numberArray[i] = i;
042
             
043
        }
044
         
045
        // Draws 41 lines on the screen
046
        int k = 1;
047
        while(k <= 41){ System.out.print('-'); k++; }
048
        System.out.println();
049
         
050
        // Cycles through all of the boxes in the array and prints them
051
        for(int j = 0; j < numberArray.length; j++)
052
        {
053
            System.out.print("| " + j + " ");
054
        }
055
        System.out.println("|");
056
         
057
        // Draws 41 lines on the screen
058
        k = 1;
059
        while(k <= 41){ System.out.print('-'); k++; }
060
        System.out.println();
061
         
062
        // Multidimensional Array
063
        // To but arrays in an array just add another []
064
         
065
        String[][] multiDArray = new String[10][10];
066
         
067
        // Adding values to a multidimensional array
068
         
069
        for(int i = 0; i < multiDArray.length; i++)
070
        {
071
             
072
            // To get the length for the array in the array you must follow it
073
            // with brackets with the index between them like [i]
074
             
075
            for(int j = 0; j < multiDArray[i].length; j++)
076
            {
077
                 
078
                multiDArray[i][j] = i + " " + j;
079
                 
080
            }
081
             
082
        }
083
         
084
        // Draws 61 lines on the screen
085
        k = 1;
086
        while(k <= 61){ System.out.print('-'); k++; }
087
        System.out.println();
088
         
089
        // Prints out a multidimensional array with the values being the indexes
090
         
091
        for(int i = 0; i < multiDArray.length; i++)
092
        {
093
             
094
            for(int j = 0; j < multiDArray[i].length; j++)
095
            {
096
                 
097
                System.out.print("| " + multiDArray[i][j] + " ");
098
                 
099
            }
100
            System.out.println("|");
101
             
102
        }
103
         
104
        // Draws 61 lines on the screen
105
        k = 1;
106
        while(k <= 61){ System.out.print('-'); k++; }
107
        System.out.println();
108
         
109
        // You can use the enhanced for loop to print out array values
110
        // for(itemDataType tempVariable : arrayName)
111
         
112
        for(int row : numberArray)
113
        {
114
            System.out.print(row);
115
        }
116
        System.out.println("\n");
117
         
118
        // To use enhanced for for a multidimensional array you follow this formula
119
        // for(dataType[] varForRow : arrayName)
120
         
121
        for(String[] rows : multiDArray)
122
        {
123
            // for(elementDataType varForColumn : varForRow)
124
            for(String column : rows)
125
            {
126
                System.out.print("| " + column + " ");
127
            }
128
                System.out.println("|");
129
        }
130
         
131
        // You can copy an array in a couple of ways
132
        // Arrays.copyOf(arrayToCopy, numberToCopyFromBeginning);
133
         
134
        int[] numberCopy = Arrays.copyOf(numberArray, 5);
135
        for(int num : numberCopy)
136
        {
137
            System.out.print(num);
138
        }
139
        System.out.println("\n");
140
         
141
        // You can copy an array from one index to another with copyOfRange
142
        // int[] numberCopy = Arrays.copyOf(numberArray, 1, 5);
143
         
144
        // You can print out the whole array with toString
145
        System.out.println(Arrays.toString(numberCopy));
146
         
147
         
148
        // Do define a default value for an array use fill
149
        // Arrays.fill(arrayName, valueToFill);
150
        // valueToFill must be the same for each element in the array
151
         
152
        int[] moreNumbers = new int[100];
153
        Arrays.fill(moreNumbers, 2);
154
         
155
        // Filling a multidimensional array
156
        char[][] boardGame = new char[10][10];
157
        for(char[] row : boardGame)
158
        {
159
            Arrays.fill(row, '*');
160
        }
161
         
162
        // You can sort an array using sort()
163
        int[] numsToSort = new int[10];
164
         
165
        // Generate array full of random numbers
166
        for(int i = 0; i < 10; i++)
167
        {
168
            numsToSort[i] = (int) (Math.random() * 100);
169
        }
170
         
171
        // Sort the array in ascending order
172
        Arrays.sort(numsToSort);
173
         
174
        System.out.println(Arrays.toString(numsToSort));
175
         
176
        // binarySearch returns the index for the searched for value
177
        // If it doesn't find it it returns a negative number
178
         
179
        int whereIs50 = Arrays.binarySearch(numsToSort, 50);
180
         
181
        System.out.println(whereIs50);
182
    }
183
     
184
}
