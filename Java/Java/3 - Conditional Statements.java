public class LessonThree {
002
     
003
    public static void main(String[] args)
004
    {
005
        // Creates a random number between 0 and 50
006
        int randomNumber = (int) (Math.random() * 50);
007
         
008
        /* Relational Operators:
009
         * Java has 6 relational operators
010
         * > : Greater Than
011
         * < : Less Than
012
         * == : Equal To
013
         * != : Not Equal To
014
         * >= : Greater Than Or Equal To
015
         * <= : Less Than Or Equal To
016
         */
017
         
018
        // If randomNumber is less than 25, execute the code between {} and then stop checking
019
        if (randomNumber < 25)
020
        {
021
            System.out.println("The random number is less than 25");
022
        }
023
         
024
        // If randomNumber wasn't less than 25, then check if it's greater than it. If so, execute the code between {} and then stop checking
025
        else if (randomNumber > 25)
026
        {
027
            System.out.println("The random number is greater than 25");
028
        }
029
         
030
        // Checks if randomNumber equals 25
031
        else if (randomNumber == 25)
032
        {
033
            System.out.println("The random number is equal to 25");
034
        }
035
         
036
        // Checks if randomNumber is not equal to 25
037
        else if (randomNumber != 15)
038
        {
039
            System.out.println("The random number is not equal to 15");
040
        }
041
         
042
        // Checks if randomNumber is less than or equal to 25
043
        else if (randomNumber <= 25)
044
        {
045
            System.out.println("The random number is less than or equal to 25");
046
        }
047
         
048
        // Checks if randomNumber is greater than or equal to 25
049
        else if (randomNumber >= 25)
050
        {
051
            System.out.println("The random number is greater than or equal to 25");
052
        }
053
         
054
        // If none of the above were correct print out the random number
055
        else
056
        {
057
            System.out.println("The random number is " + randomNumber);
058
        }
059
         
060
        // Prints out the random number
061
        System.out.println("The random number is " + randomNumber);
062
         
063
        /* Logical Operators:
064
         * Java has 6 logical operators
065
         * ! : Converts the boolean value to its right to its opposite form ie. true to false
066
         * & : Returns true if boolean value on the right and left are both true (Always evaluates both boolean values)
067
         * && : Returns true if boolean value on the right and left are both true (Stops evaluating after first false)
068
         * | : Returns true if either boolean value on the right or left are true (Always evaluates both boolean values)
069
         * || : Returns true if either boolean value on the right or left are true (Stops evaluating after first true)
070
         * ^ : Returns true if there is 1 true and 1 false boolean value on the right or left
071
         */
072
         
073
        if (!(false))
074
        {
075
            System.out.println("I turned false into true");
076
        }
077
         
078
         
079
        if ((false) && (true))
080
        {
081
            System.out.println("\nBoth are true");
082
        }
083
         
084
        // There is also a & logical operator it checks the second boolean result even if the first comes back false
085
         
086
        if ((true) || (true))
087
        {
088
            System.out.println("\nAt least 1 are true");
089
        }
090
         
091
        // There is also a | logical operator it checks the second boolean result even if the first comes back true
092
         
093
        if ((true) ^ (false))
094
        {
095
            System.out.println("\n1 is true and the other false");
096
        }
097
         
098
        int valueOne = 1;
099
        int valueTwo = 2;
100
         
101
        // The Conditional or Ternary Operator assigns one or another value based on a condition
102
        // If true valueOne is assigned to biggestValue. If not valueTwo is assigned
103
        int biggestValue = (valueOne > valueTwo) ? valueOne : valueTwo;
104
         
105
        System.out.println(biggestValue + " is the biggest\n");
106
         
107
        char theGrade = 'B';
108
         
109
        /* When you have a limited number of possible values a switch statement makes sense
110
         * The switch statement checks the value of theGrade to the values that follow case
111
         * If it matches it executes the code between {} and then break ends the switch statement
112
         * default code is executed if there are no matches
113
         * You are not required to use the break or default statements
114
         * The expression must be an int, short, byte, or char
115
         */
116
        switch (theGrade)
117
        {
118
        case 'A':
119
            System.out.println("Great Job");
120
            break; // Ends the switch statement
121
        case 'b': // You can use multiple case statements in a row
122
        case 'B':
123
            System.out.println("Good Job, get an A next time");
124
            break;
125
        case 'C':
126
            System.out.println("OK, but you can do better");
127
            break;
128
        case 'D':
129
            System.out.println("You must work harder");
130
            break;
131
        default:
132
            System.out.println("You failed");
133
            break;
134
        }
135
         
136
    }
137
     
138
}
