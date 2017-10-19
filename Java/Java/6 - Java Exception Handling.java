     /* An exception object is created when an error occurs
002
         * It tells you what error occurred
003
         * Here are many of the java exceptions
004
         *
005
         * java.lang.RuntimeException : exceptions that can be thrown during the normal
006
         * operation of the Java Virtual Machine. These exceptions are your responsibility
007
         * as a programmer
008
         *
009
         * ArithmeticException, ArrayStoreException, BufferOverflowException,
010
         * BufferUnderflowException, CannotRedoException, CannotUndoException,
011
         * ClassCastException, CMMException, ConcurrentModificationException,
012
         * DOMException, EmptyStackException, IllegalArgumentException,
013
         * IllegalMonitorStateException, IllegalPathStateException,
014
         * IllegalStateException, ImagingOpException, IndexOutOfBoundsException,
015
         * MissingResourceException, NegativeArraySizeException, NoSuchElementException,
016
         * NullPointerException, ProfileDataException, ProviderException,
017
         * RasterFormatException, SecurityException, SystemException,
018
         * UndeclaredThrowableException, UnmodifiableSetException,
019
         * UnsupportedOperationException
020
         *
021
         * java.lang.Exception : exceptions that are checked for by the java compiler
022
         *
023
         * AclNotFoundException, ActivationException, AlreadyBoundException,
024
         * ApplicationException, AWTException, BackingStoreException,
025
         * BadAttributeValueExpException, BadBinaryOpValueExpException,
026
         * BadLocationException, BadStringOperationException,
027
         * BrokenBarrierException, CertificateException, ClassNotFoundException,
028
         * CloneNotSupportedException, DataFormatException,
029
         * DatatypeConfigurationException, DestroyFailedException,
030
         * ExecutionException, ExpandVetoException, FontFormatException,
031
         * GeneralSecurityException, GSSException, IllegalAccessException,
032
         * IllegalClassFormatException, InstantiationException,
033
         * InterruptedException, IntrospectionException,
034
         * InvalidApplicationException, InvalidMidiDataException,
035
         * InvalidPreferencesFormatException, InvalidTargetObjectTypeException,
036
         * InvocationTargetException, IOException, JAXBException, JMException,
037
         * KeySelectorException, LastOwnerException, LineUnavailableException,
038
         * MarshalException, MidiUnavailableException, MimeTypeParseException,
039
         * MimeTypeParseException, NamingException, NoninvertibleTransformException,
040
         * NoSuchFieldException, NoSuchMethodException, NotBoundException,
041
         * NotOwnerException, ParseException, ParserConfigurationException,
042
         * PrinterException, PrintException, PrivilegedActionException,
043
         * PropertyVetoException, RefreshFailedException, RemarshalException,
044
         * RuntimeException, SAXException, ScriptException, ServerNotActiveException,
045
         * SOAPException, SQLException, TimeoutException, TooManyListenersException,
046
         * TransformerException, TransformException, UnmodifiableClassException,
047
         * UnsupportedAudioFileException, UnsupportedCallbackException,
048
         * UnsupportedFlavorException, UnsupportedLookAndFeelException,
049
         * URIReferenceException, URISyntaxException, UserException, XAException,
050
         * XMLParseException, XMLSignatureException, XMLStreamException, XPathException
051
         */
052
 
053
        /* Common Exceptions
054
         * ArithmeticException: An arithmetic operation occurs with no answer
055
         * (Division by Zero)
056
         *
057
         * ClassNotFoundException: A class is called for that doesn't exist
058
         *
059
         * IllegalArgumentException: A method has been passed an illegal argument
060
         *
061
         * IndexOutOfBoundsException: Thrown when an index for an array, string is
062
         * called for, but doesn't exist
063
         *
064
         * InputMismatchException: (Part of NoSuchElementException) User enters the
065
         * wrong data type into a Scanner method
066
         *
067
         * IOException: An I/O operation failed
068
         */
069
import java.util.Scanner; // Library that allows us to capture user input
070
import java.util.*; // Allows me to check for InputMismatchException
071
import java.io.*; // Allows for system input and output through data streams, serialization and the file system
072
 
073
public class LessonSix {
074
     
075
    // Creates a Scanner object that monitors keyboard input
076
    static Scanner userInput = new Scanner(System.in);
077
     
078
    public static void main(String[] args){
079
         
080
        divideByZero(2);
081
         
082
        System.out.print("How old are you? ");
083
        int age = checkValidAge();
084
         
085
        if (age != 0){
086
        System.out.println("You are " + age + " years old");
087
        }
088
         
089
        getAFile("./somestuff.txt");
090
         
091
    }
092
     
093
    public static void divideByZero(int a)
094
    {
095
         
096
        try
097
        {
098
            // The following throws an error because you can't divide by zero
099
            // Exception in thread "main" java.lang.ArithmeticException
100
            System.out.println(a/0);
101
        }
102
         
103
        // If the exception ArithmeticException is thrown the following execute
104
        catch (ArithmeticException e)
105
        {
106
            // Your custom error message
107
            System.out.println("You can't divide by zero");
108
             
109
            // Java's error message for this exception
110
            System.out.println(e.getMessage());
111
             
112
            // Prints the exception name and error message
113
            System.out.println(e.toString());
114
             
115
            // Prints the standard error stack trace
116
            e.printStackTrace();
117
        }
118
         
119
    }
120
     
121
    public static int checkValidAge()
122
    {
123
         
124
        try
125
        {
126
            return userInput.nextInt(); // nextInt() receives the user input
127
        }
128
         
129
        catch (InputMismatchException e)
130
        {
131
            userInput.next(); // Skips the last user input and waits for the next
132
            System.out.print("That isn't a whole number");
133
            return 0;
134
        }
135
         
136
    }
137
     
138
    /* If you prefer to throw an exception to the calling method you use throw
139
     * public static void getAFile(String fileName) throws IOException, FileNotFoundException
140
     * {
141
     *      FileInputStream file = new FileInputStream(fileName);
142
     * }
143
     *
144
     * If main called this method, main would have to handle the exception
145
     *
146
     * public static void main(String[] args) {
147
     *      try {
148
     *          getAFile("./somestuff.txt");
149
     *      }
150
     *      catch(IOException e) {
151
     *          System.out.println("An unknown IO Error Occured");
152
     *      }
153
     */
154
     
155
    public static void getAFile(String fileName)
156
    {
157
        try
158
        {
159
        /* If I tried to do this without providing for an exception
160
        * I'd get the error Unhandled Exception Type FileNotFoundException
161
        * A checked exception is an exception the compiler forces you to protect against
162
        */
163
        FileInputStream file = new FileInputStream(fileName);
164
        }
165
         
166
        catch (FileNotFoundException e)
167
        {
168
            System.out.println("Sorry I couldn't find that file");
169
        }
170
         
171
        // You can catch numerous exceptions (List most specific first
172
        catch (IOException e) // Catches any IO Exception
173
        {
174
            System.out.println("An unknown IO Error Occured");
175
        }
176
         
177
        /* To ignore an exception do this
178
         * catch (ClassNotFoundException e)
179
         * {}
180
         */
181
         
182
        /* Java 7 allows you to catch multiple exceptions at once
183
         * catch (FileNotFoundException | IOException e)
184
         * {}
185
         */
186
         
187
        // This will catch any exception (This should always be last)
188
        catch (Exception e)
189
        {
190
            System.out.println("I catch every exception");
191
        }
192
         
193
        // If used finally is always executed whether there was an exception or not
194
        // It is used for clean up work like closing files and database connections
195
        finally
196
        {
197
            System.out.println("");
198
        }
199
         
200
    }
201
     
202
}
