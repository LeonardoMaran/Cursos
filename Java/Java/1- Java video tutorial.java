001
// Here I'm defining a new class (Blueprint) named HelloWorld
002
// public tells Java that this should be available to all other classes
003
// classes are blue prints used to design objects that contain attributes (variables) and methods (functions)
004
// HelloWorld is just what you named your program. That allows you to reference it later
005
// { is the opening brace that surrounds the code used by HelloWorld
006
public class HelloWorld
007
{
008
        // public allows other classes to use this function
009
        // static means that only a class can call for this function to execute
010
        // void states that this function doesn't return any values after it is done executing
011
        // main is required in every Java program. This function is always executed first
012
        // Every main function must accept an array of string objects
013
     
014
        // Class variables must start with static if you want to access them with any other methods in the class
015
        static String randomString = "String to print";
016
         
017
        // Constant variables are defined with the word final
018
        static final double PINUM = 3.1415929;
019
     
020
        public static void main(String[] args)
021
        {
022
            // System.out is an object that outputs information
023
            // println is a function that prints to the screen what ever you provide between braces
024
            // "Hello World" is a string of characters. Strings must be surrounded with quotes
025
            // Every statement ends with a semicolon ;
026
            System.out.println("Hello World");
027
             
028
            // Variable names are case sensitive. Age is not the same as age.
029
            // Variables must begin with a letter and contain numbers, _, or $
030
            // You must declare all variables before you can use them with a data type
031
                         
032
            /* You can use any variable name except for
033
             * abstract     continue    for     new     switch  assert  default goto    package     synchronized
034
             * boolean  do  if  private this    break   double  implements  protected   throw
035
             * byte else    import  public  throws  case    enum    instanceof  return  transient
036
             * catch    extends int short   try char    final   interface   static  void
037
             * class    finally long    strictfp    volatile    const   float   native  super   while
038
             */
039
             
040
            // This is a declaration statement
041
            // integerOne is a local variable to the main function. It can only be accessed in main
042
            int integerOne = 22;
043
             
044
            int integerTwo = integerOne + 1; // This is an expression statement
045
             
046
            // White space has no meaning in Java, aside from variables and keywords
047
            integerTwo =
048
                    integerOne
049
                    + 3;
050
             
051
            System.out.println(integerTwo);
052
             
053
            // Javas Primitive Types
054
             
055
            byte bigByte = 127; // Minimum value -128 Maximum value 127
056
            short bigShort = 32767; // Minimum value -32768 Maximum value 32767
057
            int bigInt = 2147483647; // Minimum value -2147483648 Maximum value 2147483647
058
            long bigLong = 9223372036854775807L; // Minimum value -9223372036854775808L
059
             
060
            float bigFloat = 3.14F; // You must end a float with an F
061
            double bigDouble = 3.1234567890D; // The D is not required with doubles
062
            System.out.println(Float.MAX_VALUE); // Float is precise to 6 decimal places
063
            System.out.println(Double.MAX_VALUE); // Double is precise to 15 decimal places
064
             
065
            boolean trueOrFalse = true; // Booleans are True or False, not 1 or 0
066
             
067
            // A char will accept a number or a character surrounded by apostrophes
068
            char randomChar = 65; // Character Code for A is 65 Minimum value 0 Maximum value 65535
069
            char anotherChar = 'A';
070
            System.out.println(randomChar);
071
             
072
            // chars can also contain escaped characters
073
            char backSpace = '\b';
074
            char formFeed = '\f';
075
            char lineFeed = '\n';
076
            char carriageReturn = '\r';
077
            char horizontalTab = '\t';
078
            char doubleQuote = '\"';
079
            char singleQuote = '\'';
080
            char backSlash = '\\';
081
             
082
            // A string contains a series of characters
083
            String randomString = "I'm just a random";
084
            String anotherString = "string";
085
             
086
            // You combine strings with a +
087
            String combinedString = randomString + ' ' + anotherString;
088
            System.out.println(combinedString);
089
             
090
            // How to convert any other type to a string
091
            String byteString = Byte.toString(bigByte);
092
            String shortString = Short.toString(bigShort);
093
            String intString = Integer.toString(bigInt);
094
            String longString = Long.toString(bigLong);
095
            String floatString = Float.toString(bigFloat);
096
            String doubleString = Double.toString(bigDouble);
097
            String booleanString = Boolean.toString(trueOrFalse);
098
            String charString = Character.toString(randomChar); // You don't need to do this
099
             
100
            System.out.println(charString);
101
             
102
            // Can't do this because char is a primitive data type
103
            // System.out.println(randomChar.getClass());
104
             
105
            // You can do this because String is an object
106
            System.out.println(charString.getClass());
107
             
108
            // You use casting to convert from one primitive type to another
109
            // If you convert from a number that is to big the largest possible value will be
110
            // used instead
111
            double aDoubleValue = 3.1456789;
112
            int doubleToInt = (int) aDoubleValue;
113
            System.out.println(doubleToInt);
114
             
115
            /* To cast to other primitive types just proceed with the conversion to type
116
             * ie (byte) (short) (long) (double)
117
             * (float) & (boolean) & (char) don't work.
118
             * (char) stays as a number instead of a character
119
             */
120
             
121
            // Use parseInt to convert a string into an integer
122
            int stringToInt = Integer.parseInt(intString);
123
             
124
            /* Other parse functions
125
             * parseShort, parseLong, parseByte, parseFloat, parseDouble, parseBoolean
126
             * There is no reason to parse a Character
127
             */
128
             
129
        }
130
        // You must provide a closing brace } so Java knows when the function has ended
131
}
