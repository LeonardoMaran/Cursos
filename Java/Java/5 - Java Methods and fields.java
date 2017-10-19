01
import java.util.Scanner; // Scanner is a class that contains a bunch of methods
002
 
003
public class LessonFive {
004
    // main is a method that contains all of the code to be executed when a program runs
005
     
006
    // This is a class variable that is available to every method
007
    // If you declare a variable in a method it is only accessible in that method (local variable)
008
     
009
    static double myPI = 3.14159265;
010
     
011
    // Any changes made to randomNumber in any functions will effect its global value
012
     
013
    static int randomNumber;
014
     
015
    // Creates a Scanner object that monitors keyboard input
016
     
017
    static Scanner userInput = new Scanner(System.in);
018
     
019
    public static void main(String[] args)
020
    {
021
         
022
        /* Basic Method
023
         * accessModifier static returnDataType methodName (parameters)
024
         * { Statements }
025
         * Access Modifier: Determines who can execute a method
026
         * static: Used when you want to be able to execute a method that isn't part of a class definition
027
         * Return Data Type: The data type of value returned after a method executes (void if no values are returned)
028
         * Method Name: Must start with a letter, but can include letters, numbers, $, or _
029
         * Parameters / Arguments: Values passed to a method
030
         */
031
         
032
        System.out.println(addThem(1,2)); // addThem(1,2) will be replaced with the value that method returns
033
         
034
        // Demonstrating passing by value
035
        int d = 5;
036
         
037
        // Changes to the variable d in tryToChange don't effect its value globally
038
        // We are passing the value of d to tryToChange and not the variable
039
         
040
        tryToChange(d);
041
        System.out.println("Static Variable d = "+ d);
042
         
043
        // Guessing a random number
044
        System.out.println("\n");
045
         
046
        System.out.println(getRandomNum()); // Both prints and generates the value for randomNumber
047
         
048
        int guessResult = 1;
049
        int randomGuess = 0;
050
         
051
        while(guessResult != -1)
052
        {
053
        System.out.print("Guess a number between 0 and 50: ");
054
         
055
        // Accepts an integer input from the user
056
        // You can't declare this variable inside the while loop if you want to access it outside the while loop
057
         
058
        randomGuess = userInput.nextInt();
059
         
060
        guessResult = checkGuess(randomGuess);
061
        }
062
         
063
        System.out.println("Yes the random number is " + randomGuess);
064
         
065
        System.out.println(randomNumber); // Random value was changed globally by getRandomNum
066
         
067
    }
068
     
069
    // Adds the two numbers sent and returns the solution
070
    // public is the access modifier and means anyone can execute this method
071
    // Java Methods can return any primitive data type, or reference to an object (More on that later)
072
     
073
    public static int addThem(int a, int b)
074
    {
075
        double smallPI = 3.140; // This variable is local to the addThem function
076
         
077
        // compare returns 0 if equal | -1 if smallPI is less than myPI | 1 if smallPI is greater than myPI
078
         
079
        System.out.println(Double.compare(smallPI, myPI));
080
         
081
        int c = a + b;
082
         
083
        // return returns a value that replaces the call to this method
084
        // It must be an int since you defined this method returns ints above
085
         
086
        return c;
087
    }
088
     
089
    // When you define an attribute / parameter you must define its type
090
    // That's why you can't type tryToChange(d)
091
    // Because this function doesn't return a value return type is void
092
     
093
    public static void tryToChange(int d)
094
    {
095
        d = d + 1;
096
        System.out.println("tryToChange d = " + d);
097
    }
098
     
099
    public static int getRandomNum()
100
    {
101
        // Creates a random number between 0 and 50
102
        // Since randomNumber is a class variable you don't have to declare, or define its type
103
        // If int randomNumber was declared in this method it wouldn't effect the global variable named randomNumber
104
         
105
        randomNumber = (int) (Math.random() * 51);
106
        return randomNumber;
107
    }
108
     
109
    public static int checkGuess(int guess)
110
    {
111
        if(guess == randomNumber)
112
        {
113
            return -1;
114
        } else {
115
            return guess; // Must return a value of type int
116
        }
117
    }
118
     
119
}
