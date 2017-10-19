// Collection classes were created to make it easy to keep track
002
// of groups of objects. An ArrayList differs from an array in
003
// that it automatically resizes itself automatically. ArrayLists
004
// are easy to add to and delete from.
005
 
006
import java.util.ArrayList; // The ArrayList library
007
import java.util.Iterator; // The Iterator Library
008
import java.util.Arrays; // The Arrays Library
009
 
010
public class LessonEleven {
011
     
012
    public static void main(String[] args)
013
    {
014
         
015
        // You can create an ArrayList variable
016
        ArrayList arrayListOne;
017
         
018
        // Then create an ArrayList object
019
        // You don't have to declare the ArrayList size like you
020
        // do with arrays (Default Size of 10)
021
        arrayListOne = new ArrayList();
022
         
023
        // You can create the ArrayList on one line
024
         
025
        ArrayList arrayListTwo = new ArrayList();
026
         
027
        // You can also define the type of elements the ArrayList
028
        // will hold
029
        ArrayList<String> names = new ArrayList<String>();
030
         
031
        // This is how you add elements to an ArrayList
032
        names.add("John Smith");
033
        names.add("Mohamed Alami");
034
        names.add("Oliver Miller");
035
         
036
        // You can also add an element in a specific position
037
        names.add(2, "Jack Ryan");
038
         
039
        // You retrieve values in an ArrayList with get
040
        // arrayListName.size() returns the size of the ArrayList
041
        for( int i = 0; i < names.size(); i++)
042
        {
043
            System.out.println(names.get(i));
044
        }
045
         
046
        // You can replace a value using the set method
047
        names.set(0, "John Adams");
048
         
049
        // You can remove an item with remove
050
        names.remove(3);
051
         
052
        // You can also remove the first and second item with
053
        // the removeRange method
054
        // names.removeRange(0, 1);
055
         
056
        // When you print out the ArrayList itself the toString
057
        // method is called
058
        System.out.println(names);
059
         
060
        // You can also use the enhanced for with an ArrayList
061
        for(String i : names)
062
        {
063
            System.out.println(i);
064
        }
065
        System.out.println(); // Creates a newline
066
         
067
        // Before the enhanced for you had to use an iterator
068
        // to print out values in an ArrayList
069
         
070
        // Creates an iterator object with methods that allow
071
        // you to iterate through the values in the ArrayList
072
        Iterator indivItems = names.iterator();
073
         
074
        // When hasNext is called it returns true or false
075
        // depending on whether there are more items in the list
076
         
077
        while(indivItems.hasNext())
078
        {
079
            // next retrieves the next item in the ArrayList
080
            System.out.println(indivItems.next());
081
             
082
        }
083
         
084
        // I create an ArrayList without stating the type of values
085
        // it contains (Default is Object)
086
        ArrayList nameCopy = new ArrayList();
087
        ArrayList nameBackup = new ArrayList();
088
         
089
        // addAll adds everything in one ArrayList to another
090
        nameCopy.addAll(names);
091
        System.out.println(nameCopy);
092
         
093
        String paulYoung = "Paul Young";
094
         
095
        // You can add variable values to an ArrayList
096
        names.add(paulYoung);
097
         
098
        // contains returns a boolean value based off of whether
099
        // the ArrayList contains the specified object
100
         
101
        if(names.contains(paulYoung))
102
        {
103
            System.out.println("Paul is here");
104
        }
105
         
106
        // containsAll checks if everything in one ArrayList is in
107
        // another ArrayList
108
        if(names.containsAll(nameCopy))
109
        {
110
            System.out.println("Everything in nameCopy is in names");
111
        }
112
         
113
        // Clear deletes everything in the ArrayList
114
        names.clear();
115
         
116
        // isEmpty returns a boolean value based on if the ArrayList
117
        // is empty
118
        if (names.isEmpty())
119
        {
120
             
121
            System.out.println("The ArrayList is empty");
122
             
123
        }
124
         
125
        Object[] moreNames = new Object[4];
126
         
127
        // toArray converts the ArrayList into an array of objects
128
        moreNames = nameCopy.toArray();
129
         
130
        // toString converts items in the array into a String
131
        System.out.println(Arrays.toString(moreNames));
132
         
133
         
134
    }
135
     
136
}
