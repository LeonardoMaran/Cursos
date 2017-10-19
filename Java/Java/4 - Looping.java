	import java.util.Scanner; // Library that allows us to capture user input
002
 
003
public class LessonFour {
004
     
005
    // Creates a Scanner object that monitors keyboard input
006
    static Scanner userInput = new Scanner(System.in);
007
     
008
    public static void main(String[] args)
009
    {
010
        /*
011
         * The while loop : A while loop executes the code between {} until the
012
         * condition is no longer true
013
         */
014
        // while loops create a loop iterator before the loop begins
015
        int i = 1;
016
         
017
        while(i < 20)
018
        {
019
            // Use continue to skip over printing 3
020
            if(i == 3)
021
            {
022
                i+=2; // When using continue, don't forget to change the iterator
023
                continue; // continue skips a loop iteration, but not the loop
024
            }
025
             
026
            System.out.println(i);
027
            i++;
028
             
029
            // Just print odd numbers
030
            if((i%2) == 0)
031
            {
032
                i++;
033
            }
034
             
035
            // i is greater than 10 jump out of the loop
036
            if(i > 10)
037
            {
038
                break; // Forces the program to leave the loop prematurely
039
            }
040
        }
041
         
042
        /*
043
         * Code that calculates the value for PI
044
         */
045
        double myPi = 4.0; // My starting value for pi
046
         
047
        // Starting value for my loop iterator in the loop
048
        double j = 3.0;
049
         
050
        // The while loop
051
        while(j<11)
052
        {
053
            // I calculate pi with this formula
054
            // PI = 4 - 4/3 + 4/5 - 4/7...
055
            myPi = myPi - (4/j) + (4/(j+2));
056
            j += 4;
057
            System.out.println(myPi);
058
        }
059
         
060
        System.out.println("Value of PI: " + Math.PI);
061
         
062
        /*
063
         * Execute while loop until the user quits it
064
         */
065
        String contYorN = "Y";
066
        int h = 1;
067
         
068
        // equalsIgnoreCase checks if the input string is equal to y or Y
069
        while (contYorN.equalsIgnoreCase("y"))
070
        {
071
            System.out.println(h);
072
            System.out.print("Continue y or n?");
073
            contYorN = userInput.nextLine(); // Accepts a string input from the user
074
            h++;
075
             
076
        }
077
         
078
        /*
079
         * The do while loop : Used when you want to guarantee the code
080
         * between {} will execute at least once. The code is executed and
081
         * then java checks if it should execute again
082
         */
083
        // loop iterator for the do while loop
084
        // It must be created before the expression is evaluated below
085
        int k = 1;
086
         
087
        do
088
        {
089
            System.out.println(k);
090
            k++;
091
        } while (k <= 10); // Counts from 1 to 10
092
         
093
        /*
094
         * The for loop : Another looping tool in Java
095
         * for( declare iterator; conditional statement; change iterator value)
096
         */
097
         
098
        for (int l=10; l >= 1; l--)
099
        {
100
            System.out.println(l);
101
        }
102
         
103
        // System.out.println(l); The variable l is not callable outside of for
104
 
105
        int m, n; // You don't have to declare variables in the for loop
106
        // You can use multiple variables in the for loop
107
        for (m=1, n=2; m <= 9; m+=2, n+=2)
108
        {
109
            System.out.println(m + "\n" + n);
110
        }
111
         
112
        // You can have for loops inside of for loops, but I'll save
113
        // that topic until I talk about arrays
114
         
115
    }
116
     
117
}
