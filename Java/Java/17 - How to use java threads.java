public class LessonSeventeen{
02
     
03
    public static void main(String[] args){
04
         
05
        // Create a new Thread that executes the code in GetTime20
06
         
07
        Thread getTime = new GetTime20();
08
         
09
        // Create a new Thread created using the Runnable interface
10
        // Execute the code in run after 10 seconds
11
         
12
        Runnable getMail = new GetTheMail(10);
13
         
14
        Runnable getMailAgain = new GetTheMail(20);
15
         
16
        // Call for the code in the method run to execute
17
         
18
        getTime.start();
19
         
20
        new Thread(getMail).start();
21
        new Thread(getMailAgain).start();
22
         
23
    }
24
     
25
}
GETTIME20.JAVA

01
// By using threads you can execute multiple blocks
02
// of code at the same time. This program will output
03
// the current time and then at a specific time execute
04
// other code without stopping the time output
05
 
06
// Need this for Date and Locale classes
07
import java.util.*;
08
 
09
// Need this to format the dates
10
import java.text.DateFormat;
11
 
12
// By extending the Thread class you can run your code
13
// concurrently with other threads
14
public class GetTime20 extends Thread{
15
     
16
    // All of the code that the thread executes must be
17
    // in the run method, or be in a method called for
18
    // from inside of the run method
19
    public void run(){
20
         
21
        // Creating fields that will contain date info
22
        Date rightNow;
23
        Locale currentLocale;
24
        DateFormat timeFormatter;
25
        DateFormat dateFormatter;
26
        String timeOutput;
27
        String dateOutput;
28
         
29
        // Output the current date and time 20 times
30
        for(int i = 1; i <= 20; i++){
31
         
32
            // A Date object contains date and time data
33
            rightNow = new Date();
34
             
35
            // Locale defines time formats depending on location
36
            currentLocale = new Locale("en", "US");
37
             
38
            // DateFormat allows you to define dates / times using predefined
39
            // styles DEFAULT, SHORT, MEDIUM, LONG, or FULL
40
            // getTimeInstance only outputs time information
41
            timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
42
             
43
            // getDateInstance only outputs time information
44
            dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);
45
             
46
            // Convert the time and date into Strings
47
            timeOutput = timeFormatter.format(rightNow);
48
            dateOutput = dateFormatter.format(rightNow);
49
             
50
            System.out.println(timeOutput);
51
            System.out.println(dateOutput);
52
            System.out.println();
53
         
54
            // You must wrap the sleep method in error handling
55
            // code to catch the InterruptedException exception
56
            // sleep pauses thread execution for 2 seconds below
57
             
58
            try {
59
                Thread.sleep(2000);
60
            }
61
            catch(InterruptedException e)
62
            {}
63
        }
64
         
65
    }
66
     
67
}
GETTHEMAIL.JAVA

01
// You can use the Runnable interface instead of
02
// wasting your 1 class extension.
03
 
04
public class GetTheMail implements Runnable {
05
     
06
    // Stores the number of seconds before the code
07
    // will be executed
08
    private int startTime;
09
     
10
    // Constructor that sets the wait time for each
11
    // new Thread
12
    public GetTheMail(int startTime){
13
        this.startTime = startTime;
14
    }
15
     
16
    // All of the code that the thread executes must be
17
    // in the run method, or be in a method called for
18
    // from inside of the run method
19
    public void run(){
20
         
21
        try
22
        {
23
            // Don't execute until 10 seconds has passed if
24
            // startTime equals 10
25
            Thread.sleep(startTime * 1000);
26
        }
27
         
28
        catch(InterruptedException e)
29
        {}
30
        System.out.println("Checking for Mail");
31
    }
32
     
33
}
