import java.util.regex.*;
002
 
003
public class LessonNineteen{
004
     
005
    public static void main(String[] args){
006
         
007
        String longString = " Derek Banas CA 12345 PA (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234 ";
008
        String strangeString = " 1Z aaa **** *** {{{ {{ { ";
009
         
010
        /*
011
        [ ]  Insert characters that are valid
012
        [^ ]  Insert characters that are not valid
013
        \\s  Any white space
014
        \\S  Any non white space
015
        {n,m}  Whatever proceeds must occur between n and m times
016
        */
017
         
018
        // Word must contain letters that are 2 to 20 characters in length
019
        // [A-Za-z]{2,20} 0r \w{2,20}
020
         
021
        regexChecker("\\s[A-Za-z]{2,20}\\s", longString);
022
         
023
        /*
024
        \\d  Any digits 0-9
025
        \\D  Anything not a number
026
        {n}  Whatever proceeds must occur n times
027
        */
028
         
029
        // Only 5 digits
030
        // \\s[0-9]{5}\\s or \\d{5}
031
         
032
        regexChecker("\\s\\d{5}\\s", longString);
033
         
034
        /*
035
        |  Is used for OR clause situations
036
        */
037
         
038
        // Must start with a A or C, followed by 1 letter in brackets
039
        // Must be a maximum of 2 characters in length
040
        // A[KLRZ]|C[AOT]
041
         
042
        regexChecker("A[KLRZ]|C[AOT]", longString);
043
         
044
        /*
045
        {n,}  Whatever proceeds must occur at least n times
046
        +  Whatever proceeds must occur one or more times
047
        . ^ * + ? { } [ ] \ | ( )  Characters that must be escaped or backslashed
048
        */
049
         
050
        // Grab any string that contains 1 or more !
051
         
052
        regexChecker("(\\{{1,})", strangeString);
053
        regexChecker("(\\{+)", strangeString);
054
         
055
        // Get anything that occurs 3 times except newline
056
        // .  Anything but newline
057
         
058
        regexChecker(".{3}", strangeString);
059
         
060
        /*
061
        \\w  Any word type character A-Z, a-z, 0-9, _
062
        \\W  Any non word character
063
        *  Occurs zero or more times
064
        */
065
         
066
        regexChecker("\\w*", strangeString);
067
         
068
        regexChecker("[A-Za-z0-9._\\%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", longString);
069
         
070
         
071
        // ?  0 or 1 of what proceeds it
072
         
073
        regexChecker("([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4}|[a-zA-Z0-9]{7})", longString);
074
         
075
        regexReplace(longString);
076
         
077
    }
078
     
079
    public static void regexChecker(String theRegex, String str2Check){
080
         
081
        // You define your regular expression (REGEX) using Pattern
082
         
083
        Pattern checkRegex = Pattern.compile(theRegex);
084
         
085
        // Creates a Matcher object that searches the String for
086
        // anything that matches the REGEX
087
         
088
        Matcher regexMatcher = checkRegex.matcher( str2Check );
089
         
090
        // Cycle through the positive matches and print them to screen
091
        // Make sure string isn't empty and trim off any whitespace
092
         
093
        while ( regexMatcher.find() ){
094
            if (regexMatcher.group().length() != 0){
095
                System.out.println( regexMatcher.group().trim() );
096
                 
097
                // You can get the starting and ending indexs
098
                 
099
                System.out.println( "Start Index: " + regexMatcher.start());
100
                System.out.println( "Start Index: " + regexMatcher.end());
101
            }
102
        }
103
         
104
        System.out.println();
105
    }
106
     
107
    public static void regexReplace(String str2Replace){
108
         
109
        // REGEX that matches 1 or more white space
110
         
111
        Pattern replace = Pattern.compile("\\s+");
112
         
113
        // This doesn't really apply, but this is how you ignore case
114
        // Pattern replace = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
115
         
116
        // trim the string t prepare it for a replace
117
         
118
        Matcher regexMatcher = replace.matcher(str2Replace.trim());
119
         
120
        // replaceAll replaces all white space with commas
121
         
122
        System.out.println(regexMatcher.replaceAll(", "));
123
         
124
    }
125
     
126
}
