// To import an external class you use import
002
// You can import whole libraries of classes like this import java.util.*;
003
import java.util.Scanner;
004
 
005
public class LessonTwo
006
{
007
    /* static means that only a class can call for this function to execute
008
    * Creates a new scanner object named userInput
009
    * You create the Scanner object by calling new and passing the Scanner constructor
010
    * the input stream to look at (System.in = keyboard input)
011
    */
012
    static Scanner userInput = new Scanner(System.in);
013
     
014
    public static void main(String[] args)
015
    {
016
        System.out.print("Your favorite number: "); // Same as println without a newline
017
         
018
        /* The if statement will only execute the code that lies between {} if the value inside () is true
019
         * userInput.hasNextDouble() returns true if the next value entered is a Double
020
         * There are similar methods for the other data types
021
         * hasNextInt() : Integer input
022
         * hasNextFloat() : Float input
023
         * There are others for Boolean, Byte, Long, and Short
024
         */
025
         
026
        if (userInput.hasNextInt())
027
        {
028
         
029
            int numberEntered = userInput.nextInt();
030
            /* userInput.nextDouble() receives user input and stores it in the variable numberEntered
031
             * You have to use a different method based on the type of input
032
             * nextInt() : Works for Integers
033
             * nextDouble() : Works for Doubles
034
             * nextFloat() : Works for Floats
035
             * nextLine() : Works for Strings
036
             * There are others for Boolean, Byte, Long, and Short
037
             * If the user enters a value of the wrong type the program crashes
038
             */
039
         
040
            System.out.println("You entered " + numberEntered);
041
             
042
            // Here I perform basic mathematics calculations
043
            int numEnteredTimes2 = numberEntered + numberEntered;
044
            System.out.println(numberEntered + " + " + numberEntered + " = " + numEnteredTimes2);
045
             
046
            int numEnteredMinus2 = numberEntered - 2;
047
            System.out.println(numberEntered + " - 2 " + " = " + numEnteredMinus2);
048
             
049
            int numEnteredTimesSelf = numberEntered * numberEntered;
050
            System.out.println(numberEntered + " * " + numberEntered + " = " + numEnteredTimesSelf);
051
             
052
            // Without the cast the value wouldn't consider fractions
053
            double numEnteredDivide2 = (double)numberEntered / 2;
054
            System.out.println(numberEntered + " / 2 " + " = " + numEnteredDivide2);
055
             
056
            // % Modulus returns the remainder of a division
057
            int numEnteredRemainder = numberEntered % 2;
058
            System.out.println(numberEntered + " % 2 " + " = " + numEnteredRemainder);
059
             
060
            // Shorthand way to add to 2 to a variable and assign the result to self
061
            numberEntered += 2; // *=   /=  %=  Also work
062
            numberEntered -= 2;
063
             
064
            // Shorthand way to add 1 to a variable
065
            numberEntered++;
066
             
067
            // Shorthand way to subtract 1 from a variable
068
            numberEntered--;
069
             
070
            int numEnteredABS = Math.abs(numberEntered); // Returns the absolute value
071
             
072
            // Returns the larger of the two arguments (They must be of the same type)
073
            int whichIsBigger = Math.max(5, 7);
074
             
075
            // Returns the smaller of the two arguments (They must be of the same type)
076
            int whichIsSmaller = Math.min(5, 7);
077
             
078
            // Returns the square root argument
079
            double numSqrt = Math.sqrt(5.23);
080
             
081
            // Rounds the number provided up
082
            int numCeiling = (int) Math.ceil(5.23);
083
            System.out.println("Ceiling: " + numCeiling);
084
             
085
            // Rounds the number provided down
086
            int numFloor = (int) Math.floor(5.23);
087
            System.out.println("Floor: " + numFloor);
088
             
089
            // Rounds the number based on the fraction
090
            int numRound = (int) Math.round(5.23);
091
            System.out.println("Rounded: " + numRound);
092
             
093
            // Generates random numbers between 0 to 9
094
            int randomNumber = (int) (Math.random() * 10);
095
            System.out.println("A random number " + randomNumber);
096
             
097
        // If the above condition is false, the code following else is executed
098
        } else {
099
            System.out.println("Sorry you must enter an integer");
100
        }
101
         
102
         
103
    }
104
     
105
}
