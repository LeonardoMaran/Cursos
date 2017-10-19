01
import java.util.Arrays;
02
import org.apache.commons.lang3.ArrayUtils;
03
 
04
// Basic class definition
05
// public means this class can be used by other classes
06
// Class names should begin with a capital letter
07
// A file can't contain two public classes. It can contain classes that are not public
08
// If you place class files in the same folder the java compiler will be able to find them
09
 
10
/* The Goal of this tutorial is to make a game like this
11
------------------------------
12
|*||*||*||*||*||*||*||*||*||*|
13
|*||*||*||*||*||*||*||*||*||*|
14
|*||*||*||*||*||*||*||*||*||*|
15
|*||M||F||*||*||*||*||*||*||*|
16
|*||*||*||*||*||*||*||*||*||*|
17
|*||*||*||*||*||*||*||*||*||*|
18
|*||*||*||*||*||*||*||*||*||*|
19
|P||*||*||*||*||*||*||*||*||*|
20
|*||*||*||*||D||*||*||*||*||*|
21
|*||*||*||*||*||*||*||*||*||*|
22
------------------------------
23
[9,9]
24
 
25
 */
26
 
27
public class LessonEight {
28
     
29
    public static void main(String[] args)
30
    {
31
         
32
        MonsterTwo.buildBattleBoard();
33
         
34
        char[][] tempBattleBoard = new char[10][10];
35
         
36
        // ObjectName[] ArrayName = new ObjectName[4];
37
         
38
        MonsterTwo[] Monsters = new MonsterTwo[4];
39
         
40
        // MonsterTwo(int health, int attack, int movement, String name)
41
         
42
        Monsters[0] = new MonsterTwo(1000, 20, 1, "Frank");
43
        Monsters[1] = new MonsterTwo(500, 40, 2, "Drac");
44
        Monsters[2] = new MonsterTwo(1000, 20, 1, "Paul");
45
        Monsters[3] = new MonsterTwo(1000, 20, 1, "George");
46
         
47
        MonsterTwo.redrawBoard();
48
         
49
    }
50
     
51
     
52
}
MonsterTwo.java

001
import java.util.Arrays;
002
 
003
// Basic class definition
004
// public means this class can be used by other classes
005
// Class names should begin with a capital letter
006
// A file can't contain two public classes. It can contain classes that are not public
007
// If you place class files in the same folder the java compiler will be able to find them
008
 
009
public class MonsterTwo{
010
     
011
    static char[][] battleBoard = new char[10][10];
012
     
013
    public static void buildBattleBoard(){
014
         
015
        for(char[] row : battleBoard)
016
        {
017
             
018
            Arrays.fill(row, '*');
019
             
020
        }
021
         
022
    }
023
     
024
    public static void redrawBoard()
025
    {
026
         
027
        int k = 1;
028
        while(k <= 30){ System.out.print('-'); k++; }
029
        System.out.println();
030
         
031
        for (int i = 0; i < battleBoard.length; i++)
032
        {
033
             
034
            for(int j = 0; j < battleBoard[i].length; j++)
035
            {
036
                 
037
                System.out.print("|" + battleBoard[i][j] + "|");
038
                 
039
            }
040
            System.out.println();
041
             
042
        }
043
        k = 1;
044
        while(k <= 30){ System.out.print('-'); k++; }
045
        System.out.println();
046
         
047
         
048
    }
049
     
050
    // Class Variables or Fields
051
    // You declare constants with final
052
     
053
    public final String TOMBSTONE = "Here Lies a Dead monster";
054
     
055
    // private fields are not visible outside of the class
056
    private int health = 500;
057
    private int attack = 20;
058
    private int movement = 2;
059
     
060
    private boolean alive = true;
061
     
062
    // public variables are visible outside of the class
063
    // You should have as few as possible public fields
064
    public String name = "Big Monster";
065
    public char nameChar1 = 'B';
066
    public int xPosition = 0;
067
    public int yPosition = 0;
068
    public static int numOfMonsters = 0;
069
     
070
    // Class Methods
071
    // Accessor Methods are used to get and set the values of private fields
072
     
073
    public int getAttack()
074
    {
075
        return attack;
076
    }
077
     
078
    public int getMovement()
079
    {
080
        return movement;
081
    }
082
     
083
    public int getHealth()
084
    {
085
        return health;
086
    }
087
     
088
    public boolean getAlive()
089
    {
090
        return alive;
091
    }
092
     
093
    // You can create multiple versions using the same method name
094
    // Now setHealth can except an attack that contains decimals
095
    // When overloading a method you can't just change the return type
096
    // Focus on creating methods that except different parameters
097
     
098
    public void setHealth(int decreaseHealth)
099
    {
100
        health = health - decreaseHealth;
101
        if (health < 0)
102
        {
103
            alive = false;
104
        }
105
    }
106
     
107
    public void setHealth(double decreaseHealth)
108
    {
109
        int intDecreaseHealth = (int) decreaseHealth;
110
        health = health - intDecreaseHealth;
111
        if (health < 0)
112
        {
113
            alive = false;
114
        }
115
    }
116
     
117
    /* The Constructor
118
     * Code that is executed when an object is created from this class definition
119
     * The method name is the same as the class
120
     * The constructor is only executed once per object
121
     * The constructor can't return a value
122
     */
123
     
124
    public MonsterTwo(int health, int attack, int movement, String name)
125
    {
126
        this.health = health;
127
        this.attack = attack;
128
        this.movement = movement;
129
        this.name = name;
130
        /* If the attributes had the same names as the class health, attack, movement
131
         * You could refer to the objects fields by proceeding them with this
132
         * this.health = health;
133
         * this.attack = attack;
134
         * objectFieldName = attributeFieldName;
135
         */
136
         
137
        int maxXBoardSpace = battleBoard.length - 1;
138
        int maxYBoardSpace = battleBoard[0].length - 1;
139
         
140
        int randNumX, randNumY;
141
         
142
        do {
143
             
144
            randNumX = (int) (Math.random() * maxXBoardSpace);
145
            randNumY = (int) (Math.random() * maxYBoardSpace);
146
             
147
        } while(battleBoard[randNumX][randNumY] != '*');
148
         
149
        this.xPosition = randNumX;
150
        this.yPosition = randNumY;
151
         
152
        this.nameChar1 = name.charAt(0);
153
         
154
        battleBoard[this.yPosition][this.xPosition] = this.nameChar1;
155
         
156
        numOfMonsters++;
157
         
158
    }
159
     
160
    // You can overload constructors like any other method
161
    // The following constructor is the one provided by default if you don't create any other constructors
162
    // Default Constructor
163
     
164
    public MonsterTwo()
165
    {
166
        numOfMonsters++;
167
    }
168
     
169
public static void main(String[] args)
170
{
171
     
172
     
173
}
174
     
175
}
