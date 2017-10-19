001
// Basic class definition
002
// public means this class can be used by other classes
003
// Class names should begin with a capital letter
004
// A file can't contain two public classes. It can contain classes that are not public
005
// If you place class files in the same folder the java compiler will be able to find them
006
 
007
public class Monster{
008
     
009
    // Class Variables or Fields
010
    // You declare constants with final
011
     
012
    public final String TOMBSTONE = "Here Lies a Dead monster";
013
     
014
    // private fields are not visible outside of the class
015
    private int health = 500;
016
    private int attack = 20;
017
    private int movement = 2;
018
    private int xPosition = 0;
019
    private int yPosition = 0;
020
    private boolean alive = true;
021
     
022
    // public variables are visible outside of the class
023
    // You should have as few as possible public fields
024
    public String name = "Big Monster";
025
     
026
    // Class Methods
027
    // Accessor Methods are used to get and set the values of private fields
028
     
029
    public int getAttack()
030
    {
031
        return attack;
032
    }
033
     
034
    public int getMovement()
035
    {
036
        return movement;
037
    }
038
     
039
    public int getHealth()
040
    {
041
        return health;
042
    }
043
     
044
    // You can create multiple versions using the same method name
045
    // Now setHealth can except an attack that contains decimals
046
    // When overloading a method you can't just change the return type
047
    // Focus on creating methods that except different parameters
048
     
049
    public void setHealth(int decreaseHealth)
050
    {
051
        health = health - decreaseHealth;
052
        if (health < 0)
053
        {
054
            alive = false;
055
        }
056
    }
057
     
058
    public void setHealth(double decreaseHealth)
059
    {
060
        int intDecreaseHealth = (int) decreaseHealth;
061
        health = health - intDecreaseHealth;
062
        if (health < 0)
063
        {
064
            alive = false;
065
        }
066
    }
067
     
068
    /* The Constructor
069
     * Code that is executed when an object is created from this class definition
070
     * The method name is the same as the class
071
     * The constructor is only executed once per object
072
     * The constructor can't return a value
073
     */
074
     
075
    public Monster(int health, int attack, int movement)
076
    {
077
        this.health = health;
078
        this.attack = attack;
079
        this.movement = movement;
080
        /* If the attributes had the same names as the class health, attack, movement
081
         * You could refer to the objects fields by proceeding them with this
082
         * this.health = health;
083
         * this.attack = attack;
084
         * objectFieldName = attributeFieldName;
085
         */
086
         
087
    }
088
     
089
    // You can overload constructors like any other method
090
    // The following constructor is the one provided by default if you don't create any other constructors
091
    // Default Constructor
092
     
093
    public Monster()
094
    {
095
         
096
    }
097
     
098
    /* You can use the this keyword to call other constructors
099
     * public LessonSeven(int newHealth)
100
     * {
101
     *      health = newHealth;
102
     * }
103
     *
104
     * public LessonSeven(int newHealth, int newAttack)
105
     * {
106
     *      this(newHealth); // Any calls to another constructor must occur on the first line
107
     *      attack = newAttack;
108
     * }
109
     */
110
     
111
}
01
public class JavaLessonSeven {
02
     
03
    public static void main(String[] args){
04
         
05
        // You create an object using the blueprint of this class as follows
06
        // className objectName = new className();
07
         
08
        Monster Frank = new Monster();
09
         
10
        // Since the objects name is public you can change it directly
11
         
12
        Frank.name = "Frank";
13
         
14
        // You retrieve class field values by listing the objectName.fieldName
15
        // You execute class methods by listing objectName.methodName()
16
         
17
        System.out.println(Frank.name + " has an attack value of " + Frank.getAttack());
18
     
19
    }
20
}
