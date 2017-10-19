import java.util.Arrays;
002
 
003
import org.apache.commons.lang3.ArrayUtils;
004
 
005
// Basic class definition
006
// public means this class can be used by other classes
007
// Class names should begin with a capital letter
008
// A file can't contain two public classes. It can contain classes that are not public
009
// If you place class files in the same folder the java compiler will be able to find them
010
 
011
public class MonsterTwo{
012
    // Creates a multidimensional array of chars
013
    static char[][] battleBoard = new char[10][10];
014
     
015
    // This static method builds an empty battle board
016
    public static void buildBattleBoard(){
017
         
018
        // Cycles through the array and gives a default value of * to everything
019
         
020
        for(char[] row : battleBoard)
021
            Arrays.fill(row, '*');
022
    }
023
     
024
    // Redraws the board
025
    public static void redrawBoard()
026
    {
027
         
028
        int k = 1;
029
        while(k <= 30){ System.out.print('-'); k++; }
030
        System.out.println();
031
         
032
        for(int i = 0; i < battleBoard.length; i++)
033
        {
034
            for(int j = 0; j < battleBoard[i].length; j++)
035
            {
036
                System.out.print("|" + battleBoard[i][j] + "|");
037
            }
038
            System.out.println();
039
             
040
        }
041
        k = 1;
042
        while(k <= 30){ System.out.print('-'); k++; }
043
        System.out.println();
044
    }
045
     
046
    // Class Variables or Fields
047
    // You declare constants with final
048
     
049
    public final String TOMBSTONE = "Here Lies a Dead monster";
050
     
051
    // private fields are not visible outside of the class
052
    private int health = 500;
053
    private int attack = 20;
054
    private int movement = 2;
055
     
056
    // Monitors whether the monster is alive or dead
057
    private boolean alive = true;
058
     
059
    // public variables are visible outside of the class
060
    // You should have as few as possible public fields
061
    public String name = "Big Monster";
062
    public int xPosition = 0;
063
    public int yPosition = 0;
064
    public char nameChar1 = 'B';
065
    public static int numOfMonsters = 0;
066
     
067
     
068
    // Class Methods
069
    // Accessor Methods are used to get and set the values of private fields
070
     
071
    public int getAttack()
072
    {
073
        return attack;
074
    }
075
     
076
    public int getMovement()
077
    {
078
        return movement;
079
    }
080
     
081
    public int getHealth()
082
    {
083
        return health;
084
    }
085
     
086
    public boolean getAlive()
087
    {
088
        return alive;
089
    }
090
     
091
    // You can create multiple versions using the same method name
092
    // Now setHealth can except an attack that contains decimals
093
    // When overloading a method you can't just change the return type
094
    // Focus on creating methods that except different parameters
095
     
096
    public void setHealth(int decreaseHealth)
097
    {
098
        health = health - decreaseHealth;
099
        if (health < 0)
100
        {
101
            alive = false;
102
        }
103
    }
104
     
105
    public void setHealth(double decreaseHealth)
106
    {
107
        int intDecreaseHealth = (int) decreaseHealth;
108
        health = health - intDecreaseHealth;
109
        if (health < 0)
110
        {
111
            alive = false;
112
        }
113
    }
114
     
115
    public void moveMonster(MonsterTwo[] monster, int arrayItemIndex)
116
    {
117
        // isSpaceOpen will be used to track whether the space the
118
        // monster plans to move into is occupied
119
        boolean isSpaceOpen = true;
120
         
121
        // Define the maximum x and y for the battle board
122
        // It's 1 less because the array index starts at 0
123
        int maxXBoardSpace = battleBoard.length - 1;
124
        int maxYBoardSpace = battleBoard[0].length - 1;
125
         
126
         
127
        // while loop used to make sure I don't move a monster
128
        // into an occupied space
129
        while(isSpaceOpen)
130
        {
131
         
132
        // Randomly generate move direction N, S, E, or W
133
        int randMoveDirection = (int) (Math.random() * 4);
134
         
135
        // Randomly generate move distance based on max move distance
136
        int randMoveDistance = (int) (Math.random() * (this.getMovement() + 1));
137
         
138
        // Prints move distance and move direction
139
        System.out.println(randMoveDistance + " " + randMoveDirection);
140
         
141
        // Erase monsters character on the board by replacing it with a *
142
         
143
        battleBoard[this.yPosition][this.xPosition] = '*';
144
         
145
 
146
             
147
        if(randMoveDirection == 0)
148
        {
149
            // Find new xPosition & yPosition based on the current position on the board
150
            // If statements won't allow monster to move off the board
151
             
152
            if((this.yPosition - randMoveDistance) < 0)
153
            {
154
                this.yPosition = 0;
155
            } else {
156
                this.yPosition = this.yPosition - randMoveDistance;
157
            }
158
        } else if (randMoveDirection == 1) {
159
            if((this.xPosition + randMoveDistance) > maxXBoardSpace)
160
            {
161
                this.xPosition = maxXBoardSpace;
162
            } else {
163
                this.xPosition = this.xPosition + randMoveDistance;
164
            }
165
        } else if (randMoveDirection == 2) {
166
            if((this.yPosition + randMoveDistance) > maxYBoardSpace)
167
            {
168
                this.yPosition = maxYBoardSpace;
169
            } else {
170
                this.yPosition = this.yPosition + randMoveDistance;
171
            }
172
        } else {
173
            if((this.xPosition - randMoveDistance) < 0)
174
            {
175
                this.xPosition = 0;
176
            } else {
177
                this.xPosition = this.xPosition - randMoveDistance;
178
            }
179
        }
180
         
181
        // monster.length returns the number of items in the array monster
182
        for (int i = 0; i < monster.length; i++)
183
        {
184
            // if statement skips checking the same monster position against itself
185
             
186
            if (i == arrayItemIndex)
187
            {
188
                continue;
189
            }
190
             
191
            // onMySpace receives the monster array, index for the object I'm
192
            // checking currently, and the index for the monster sent to
193
            // this function
194
             
195
            if(onMySpace(monster, i, arrayItemIndex))
196
            {
197
                // If a monster tries to move to an occupied space the
198
                // while loop repeats after I break out of the for loop
199
                 
200
                isSpaceOpen = true;
201
                break;
202
            } else {
203
                // There was no monster in the space so end the while loop
204
                isSpaceOpen = false;
205
                 
206
            }
207
             
208
        }
209
         
210
        } // End of while loop
211
         
212
        // Set the value in the array to the first letter of the monster
213
        battleBoard[this.yPosition][this.xPosition] = this.nameChar1;  
214
    }
215
     
216
    // Checks if one monster is trying to move into the same x/y position as
217
    // another monster
218
    public boolean onMySpace(MonsterTwo[] monster, int indexToChk1, int indexToChk2)
219
    {
220
        // Checks if the 2 monsters have the same x/y position
221
        if((monster[indexToChk1].xPosition)==(monster[indexToChk2].xPosition)&&(monster[indexToChk1].yPosition)==(monster[indexToChk2].yPosition))
222
        {
223
            // If they are equal return true so a new x/y position is calculated
224
             
225
            return true;
226
             
227
        } else {
228
             
229
            // If false I know the x/y position isn't occupied
230
            return false;
231
        }
232
    }
233
     
234
     
235
    /* The Constructor
236
     * Code that is executed when an object is created from this class definition
237
     * The method name is the same as the class
238
     * The constructor is only executed once per object
239
     * The constructor can't return a value
240
     */
241
     
242
    public MonsterTwo(int health, int attack, int movement, String name)
243
    {
244
        this.health = health;
245
        this.attack = attack;
246
        this.movement = movement;
247
        this.name = name;
248
        /* If the attributes had the same names as the class health, attack, movement
249
         * You could refer to the objects fields by proceeding them with this
250
         * this.health = health;
251
         * this.attack = attack;
252
         * objectFieldName = attributeFieldName;
253
         */
254
         
255
        // Define the maximum x and y for the battle board
256
        // It's 1 less because the array index starts at 0
257
        int maxXBoardSpace = battleBoard.length - 1;
258
        int maxYBoardSpace = battleBoard[0].length - 1;
259
         
260
        // The random starting position for a monster
261
        int randNumX, randNumY;
262
         
263
        // We use a do loop because we always want to define a start
264
        // position for each monster
265
         
266
        do {
267
        // Calculate start position based on max board space
268
        randNumX = (int) (Math.random() * maxXBoardSpace);
269
        randNumY = (int) (Math.random() * maxYBoardSpace);
270
        } while(battleBoard[randNumY][randNumX] != '*');
271
        // Only allow monster to start on a space with a * on it
272
         
273
        // Assign x and y position to the object that called this method
274
        this.xPosition = randNumX;
275
        this.yPosition = randNumY;
276
         
277
        // Assign character in the array based on the first initial
278
        // of the monsters name charAt(0) returns first letter of name
279
        this.nameChar1 = this.name.charAt(0);
280
         
281
        // Put first character of monster in the array
282
        battleBoard[this.yPosition][this.xPosition] = this.nameChar1;
283
         
284
        numOfMonsters++; // Adds 1 to the number of monsters on the board
285
    }
286
     
287
    // You can overload constructors like any other method
288
    // The following constructor is the one provided by default if you don't create any other constructors
289
    // Default Constructor
290
     
291
    public MonsterTwo()
292
    {
293
        numOfMonsters++; // Adds 1 to the number of monsters on the board
294
    }
295
     
296
public static void main(String[] args)
297
{
298
     
299
     
300
     
301
}
302
     
303
}
LESSONTEN.JAVA

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
public class LessonTen {
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
        // char[][] tempBattleBoard = new char[10][10];
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
     
50
    for (MonsterTwo m : Monsters)
51
    {
52
         
53
        if(m.getAlive())
54
        {
55
            int arrayItemIndex = ArrayUtils.indexOf(Monsters, m);
56
            m.moveMonster(Monsters, arrayItemIndex);
57
        }
58
         
59
    }
60
     
61
    MonsterTwo.redrawBoard();
62
     
63
     
64
}
65
}
