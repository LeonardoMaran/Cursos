01
// In the last tutorial I coordinated threads using
02
// a timing method. Here I show you how to execute code based
03
// on a predefined time schedule and much more
04
 
05
// Used to schedule when certain events should be triggered
06
import java.util.concurrent.ScheduledThreadPoolExecutor;
07
 
08
// Used to tell Java what unit of time I want to use
09
import static java.util.concurrent.TimeUnit.*;
10
 
11
public class LessonEighteen{
12
     
13
    public static void main(String[] args){
14
         
15
        addThreadsToPool();
16
         
17
    }
18
     
19
    public static void addThreadsToPool(){
20
         
21
        // Allows you to schedule code execution at some time in the future
22
        // You can also have code execute repetitively based on a time period
23
        // It must be big enough to hold all potential Threads
24
                 
25
        ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(5);
26
                 
27
        // Adds a Thread to the pool. Tells that thread to start executing
28
        // after 0 seconds (immediately) and then execute every 2 seconds
29
                 
30
        eventPool.scheduleAtFixedRate(new CheckSystemTime(), 0, 2, SECONDS);
31
                 
32
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Mail"), 5, 5, SECONDS);
33
                 
34
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Calendar"), 10,10, SECONDS);
35
         
36
        // Thread.activeCount returns the number of threads running
37
         
38
        System.out.println("Number of Threads: " +Thread.activeCount());
39
         
40
        // Quiz: Why does it say there are 4 threads when we expect 3?
41
         
42
        // Create an array of threads with enough spaces for all active threads
43
         
44
        Thread[] listOfThreads = new Thread[Thread.activeCount()];
45
         
46
        // enumerate fills the Thread array with all active threads
47
         
48
        Thread.enumerate(listOfThreads);
49
         
50
        // Cycle through all the active threads and print out their names
51
         
52
        for(Thread i : listOfThreads){
53
            System.out.println(i.getName());
54
        }
55
         
56
        // Get priority of all the threads (Priority is equal to the thread
57
        // that created the new thread. Top priority is 10, lowest priority is 1
58
         
59
        for(Thread i : listOfThreads){
60
            System.out.println(i.getPriority());
61
        }
62
         
63
        // threadName.setPriority can be used to set the priority
64
         
65
        // This allows the above threads to run for approximately 20 seconds
66
         
67
        try{
68
            Thread.sleep(20000);
69
        }
70
        catch(InterruptedException e)
71
        {}
72
         
73
        // Shuts down all threads in the pool
74
         
75
        // eventPool.shutdown();
76
         
77
    }
78
     
79
}
CHECKSYSTEMTIME.JAVA

01
import java.text.DateFormat;
02
import java.util.*;
03
 
04
public class CheckSystemTime implements Runnable{
05
     
06
    public void run(){
07
         
08
        Date rightNow;
09
        Locale currentLocale;
10
        DateFormat timeFormatter;
11
        String timeOutput;
12
         
13
        rightNow = new Date();
14
        currentLocale = new Locale("en");
15
         
16
        timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
17
        timeOutput = timeFormatter.format(rightNow);
18
         
19
        System.out.println("Time: " + timeOutput);
20
         
21
         
22
    }
23
     
24
}
PERFORMSYSTEMCHECK.JAVA

01
// You could also lock down a method and then unlock it
02
// when you are finished with it. This library does that
03
 
04
import java.util.concurrent.locks.ReentrantLock;
05
 
06
public class PerformSystemCheck implements Runnable{
07
     
08
    private String checkWhat;
09
     
10
    // Creates a lock for your method
11
     
12
    ReentrantLock lock = new ReentrantLock();
13
     
14
    public PerformSystemCheck(String checkWhat){
15
         
16
        this.checkWhat = checkWhat;
17
         
18
    }
19
     
20
    // By putting synchronized before a method, you make
21
    // sure only one thread at a time can execute it.
22
    // Synchronizing slows down Java, so it should only
23
    // be used when necessary.
24
     
25
    /* synchronized */ public void run(){
26
         
27
        // this locks down the method just like synchronized
28
        // You can't use synchronized and lock, that's why
29
        // synchronized is commented out above
30
             
31
        lock.lock();
32
         
33
        System.out.println("Checking " + this.checkWhat);
34
         
35
        // this unlocks the method just like synchronized
36
         
37
        lock.unlock();
38
         
39
    }
40
     
41
}
