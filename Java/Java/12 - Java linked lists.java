01
// The LinkedList class is a collection based on a Linked List
002
// instead of an array. They are particularly good when you
003
// expect to perform many additions and deletions with a
004
// collection. When using a linked list you don't have to
005
// move items around when you add or delete an item. They
006
// aren't particularly suited to providing access based off
007
// of index searches like an array though. Each object in a
008
// linked list contains a pointer to the objects that proceed
009
// and follow it.
010
// When you change an ArrayList a new array is created by it.
011
 
012
import java.util.Arrays;
013
import java.util.LinkedList; // LinkedList Library methods
014
 
015
public class LessonTwelve {
016
     
017
    public static void main(String[] args){
018
         
019
        // Creates a LinkedList object
020
        LinkedList linkedListOne = new LinkedList();
021
         
022
        // Creates a LinkedList that contains Strings
023
        LinkedList<String> names = new LinkedList<String>();
024
         
025
        // You use add to add items to the Linked List
026
        names.add("Ahmed Bennani");
027
        names.add("Ali Syed");
028
         
029
        // addLast places the object last in the list
030
        names.addLast("Nathan Martin");
031
         
032
        // addLast places the object first in the list
033
        names.addFirst("Joshua Smith");
034
         
035
        // You can define what position to place the object in
036
        names.add(0, "Noah Peeters");
037
         
038
        // You replace a value in an index with set()
039
        names.set(2, "Paul Newman");
040
         
041
        // You remove items either by providing the index, or
042
        // the value
043
        names.remove(4);
044
        names.remove("Joshua Smith");
045
         
046
        // removeFirst() removes the first element
047
        // removeLast() removes the last element
048
        // removeFirstOccurrence(Object) removes the 
049
        // first Object that matches what you passed
050
         
051
        // You can use the enhanced for to print them out
052
        for(String name : names)
053
        {
054
            System.out.println(name);
055
        }
056
         
057
        /* OUTPUT
058
         * Noah Peeters
059
         * Paul Newman
060
         * Ali Syed
061
         */
062
         
063
        // You can retrieve values with get()
064
        System.out.println("\nFirst Index: " + names.get(0));
065
         
066
        /* OUTPUT
067
         * First Index: Noah Peeters
068
         */
069
         
070
        // Retrieve the first value with getFirst()
071
        System.out.println("\nFirst Index: " + names.getFirst());
072
         
073
        /* OUTPUT
074
         * First Index: Noah Peeters
075
         */
076
         
077
        // Retrieve the first value with getFirst()
078
        System.out.println("\nLast Index: " + names.getLast());
079
         
080
        /* OUTPUT
081
         * Last Index: Ali Syed
082
         */
083
         
084
        LinkedList<String> nameCopy = new LinkedList<String>(names);
085
         
086
        // When you print out the LinkedList itself the toString
087
        // method is called
088
        System.out.println("\nnameCopy: " + nameCopy);
089
         
090
        /* OUTPUT
091
         * nameCopy: [Noah Peeters, Paul Newman, Ali Syed]
092
         */
093
         
094
        // You can check if an object is in the list with contains()
095
        if(names.contains("Noah Peeters"))
096
        {
097
            System.out.println("\nNoahs Here");
098
        }
099
         
100
        /* OUTPUT
101
         * Noahs Here
102
         */
103
         
104
        // You can check if everything in one list is in another
105
        if(names.containsAll(nameCopy))
106
        {
107
            System.out.println("\nCollections are the same");
108
        }
109
         
110
        /* OUTPUT
111
         * Collections are the same
112
         */
113
         
114
        // Return the index for an object with indexOf
115
        System.out.println("\nIndex of Ali is: " + names.indexOf("Ali Syed"));
116
         
117
        /* OUTPUT
118
         * Index of Ali is: 2
119
         */
120
         
121
        // Check if a list is empty with isEmpty()
122
        System.out.println("List Empty: " + names.isEmpty());
123
         
124
        /* OUTPUT
125
         * List Empty: false
126
         */
127
         
128
        // Get the number of items in the list with size
129
        System.out.println("How many values: " + names.size());
130
         
131
        /* OUTPUT
132
         * How many values: 3
133
         */
134
         
135
        // peek() retrieves the first element, but doesn't throw an error
136
        // if there is no element to retrieve
137
        System.out.println("Look without error: " + names.peek());
138
         
139
        /* OUTPUT
140
         * Look without error: Noah Peeters
141
         */
142
         
143
        // poll() returns the first value and deletes it from the list
144
        System.out.println("Remove first element: " + nameCopy.poll());
145
         
146
        /* OUTPUT
147
         * Remove first element: Noah Peeters
148
         */
149
         
150
        // poll() returns the last value and deletes it from the list
151
        System.out.println("Remove last element: " + nameCopy.pollLast());
152
         
153
        /* OUTPUT
154
         * Remove last element: Ali Syed
155
         */
156
         
157
        // push puts a new element on the front of the list
158
        nameCopy.push("Noah Peeters");
159
         
160
        // pop removes an element on the front of the list
161
        nameCopy.pop();
162
         
163
        System.out.println("\nnameCopy: " + nameCopy);
164
         
165
        /* OUTPUT
166
         * nameCopy: [Paul Newman]
167
         */
168
         
169
        // Create a new array to hold values from the Linked List
170
        Object[] nameArray = new Object[4];
171
         
172
        // toArray converts the LinkedList into an array of objects
173
        nameArray = names.toArray();
174
         
175
        // toString converts items in the array into a String
176
        System.out.println(Arrays.toString(nameArray));
177
         
178
        /* OUTPUT
179
         * [Noah Peeters, Paul Newman, Ali Syed]
180
         */
181
         
182
        // clear() deletes everything in the Linked List
183
        names.clear();
184
         
185
         
186
    }
187
     
188
}
