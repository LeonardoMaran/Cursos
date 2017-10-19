// Here I introduce the String class
002
// A String is an object unlike the other primitive data types
003
 
004
import java.util.Arrays;
005
 
006
public class LessonThirteen {
007
     
008
    public static void main(String[] args){
009
         
010
        // You create a String like this
011
        String randomString = "I'm just a random string";
012
         
013
        // If you want to use quotes in a string escape it with \
014
        // Always surround Strings with quotes " " and not Apostrophes ' '
015
        String gotToQuote ="He said, \"I'm here\"";
016
         
017
        /* Other common Escape Codes
018
         * \n : Newline
019
         * \b : Backspace
020
         * \' : Apostrophe
021
         * \" : Quote
022
         * \\ : Backslash
023
         */
024
         
025
        // You combine Strings with a +
026
        System.out.println(randomString + " " + gotToQuote);
027
         
028
        // You can add other data type to the string with a +
029
        int numTwo = 2;
030
        System.out.println(randomString + " " + numTwo);
031
         
032
        /* You convert primitive types to a string with toString
033
         * String byteString = Byte.toString(bigByte);
034
         * String shortString = Short.toString(bigByte);
035
         * String intString = Integer.toString(bigInt);
036
         * String longString = Long.toString(bigByte);
037
         * String floatString = Float.toString(bigByte);
038
         * String doubleString = Double.toString(bigByte);
039
         * String booleanString = Boolean.toString(bigByte);
040
         *
041
         * You convert from String to primitives with parse
042
         * int stringToInt = Integer.parseInt(intString);
043
         * parseSort, parseLong, parseByte, parseDouble,
044
         * parseBoolean, parseFloat
045
         */
046
         
047
        // You compare strings with equals or equalsIgnoreCase
048
        String uppercaseStr = "BIG";
049
        String lowercaseStr = "big";
050
         
051
        if(uppercaseStr.equals(lowercaseStr))
052
        {
053
            System.out.println("They're equal");
054
        }
055
         
056
        if(uppercaseStr.equalsIgnoreCase(lowercaseStr))
057
        {
058
            System.out.println("Same letters");
059
        }
060
         
061
        String letters = "abcde";
062
        String moreLetters = "fghijk";
063
         
064
        // charAt returns the character in a string
065
        System.out.println("2nd Character: " + letters.charAt(1));
066
         
067
        // compareTo returns 0 if strings are equal
068
        // Returns a negative number if letters comes before moreLetters
069
        // Returns a positive number if letters comes after moreLetters
070
        // There is also a compareToIgnoreCase()
071
        System.out.println(letters.compareTo(moreLetters));
072
         
073
        // contains() returns a boolean depending on whether the
074
        // String contains the String you pass it
075
        System.out.println(letters.contains("abc"));
076
         
077
        // endsWith() checks if the String ends with the String you pass
078
        System.out.println(letters.endsWith("de"));
079
         
080
        // startsWith() works similar to endsWith()
081
         
082
        // indexOf() returns the 1st index that matches the String passed
083
        System.out.println(letters.indexOf("cd"));
084
         
085
        // You can also specify the index to start searching from
086
        // indexOf(StringToLookFor, IndexStartPosition)
087
         
088
        // lastIndexOf() works like indexOf except it starts from the
089
        // end of the String you are searching
090
         
091
        // length() returns the number of characters in a String
092
        System.out.println("Length of string: " + letters.length());
093
         
094
        // replace() replaces every occurrence of the first String with
095
        // the second String you provide
096
        System.out.println(letters.replace("abc", "xy"));
097
         
098
        // You can create an array of Strings with split()
099
        // You define how to break up the String using a delimiter
100
        // If you had 123,456 and used the delimiter "," you would
101
        // create the array [123,456]
102
        String[] letterArray = letters.split("");
103
         
104
        // toString() converts the array into a String to print it
105
        System.out.println(Arrays.toString(letterArray));
106
         
107
        // toCharArray() inserts every character in the string into
108
        // separate indexes in an array
109
        char[] charArray = letters.toCharArray();
110
         
111
        System.out.println(Arrays.toString(charArray));
112
         
113
        // substring() returns a String starting at the first index
114
        // through the last index provided
115
        System.out.println(letters.substring(1,4));
116
         
117
        // toUpperCase() converts all letters into uppercase
118
        // toLowerCase() does the opposite
119
        System.out.println(letters.toUpperCase());
120
         
121
        String randString = "   abc   ";
122
         
123
        // trim() gets rid of leading and trailing white space
124
        System.out.println(randString.trim());
125
         
126
        // A String is immutable, which means every time you change
127
        // a String a new version is created in memory.
128
        // If you manipulate Strings allot use a StringBuilder
129
         
130
        // How to create a StringBuilder
131
        // It has a fixed space in memory
132
        StringBuilder randSB = new StringBuilder("A random string");
133
         
134
        // append() adds anything to the end of a SB
135
        System.out.println(randSB.append(" again"));
136
         
137
        // append() permanently effected the StringBuilder
138
        System.out.println(randSB);
139
         
140
        // delete() removes part of the SB from first index to the last
141
        System.out.println(randSB.delete(15, 21));
142
         
143
        // deleteCharAt(index) is used to delete individual chars
144
         
145
        // capacity() returns the number of indexs for the SB
146
        System.out.println(randSB.capacity());
147
         
148
        // ensureCapacity() increases the capacity for the SB
149
        randSB.ensureCapacity(60);
150
        System.out.println(randSB.capacity());
151
         
152
        // length() returns the number of characters in the SB
153
        System.out.println(randSB.length());
154
         
155
        // trimToSize() forces capacity to equal length
156
        randSB.trimToSize();
157
         
158
        // insert() inserts at the index you provide anything
159
        System.out.println(randSB.insert(1, "nother"));
160
         
161
        // toString converts a SB into a String
162
        String oldSB = randSB.toString();
163
         
164
        /* StringBuilders also have the same methods as Strings
165
         * charAt(), indexOf(), lastIndexOf(), subString()
166
         */
167
    }
168
     
169
}
