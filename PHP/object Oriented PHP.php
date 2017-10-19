<html>
002
<head>
003
    <title><?php echo "PHP Object Oriented Programming";?></title>
004
</head>
005
<body>
006
<?php
007
/*
008
    Object Oriented Programming allows you to model real
009
    world objects. Every object has attributes and things
010
    it can do (Operations / Functions / Methods) You define those
011
    things in a class which is a blueprint for creating
012
    objects.
013
*/
014
class Animal implements Singable{
015
 
016
    /*
017
        You define attributes like this. The private means
018
        that only methods in the class can access this data
019
        public would mean that any code could directly access
020
        and change the values for these attributes.
021
         
022
        Attributes that are private won't be inherited as you'll see
023
        but those that are public or protected are
024
         
025
        By making sure our data can only be changed by the class
026
        operations we are inencapsulating or protecting it.
027
    */
028
     
029
    protected $name;
030
    protected $favorite_food;
031
    protected $sound;
032
    protected $id;
033
     
034
    // A static attribute is shared by every object. If its
035
    // value changes for one it changes for all
036
     
037
    public static $number_of_animals = 0;
038
     
039
    // A constant is also shared
040
     
041
    const PI = "3.14159";
042
     
043
    // You define methods just like you define functions in a class
044
     
045
    function getName(){
046
     
047
        // To refer to data stored in an object you proceed the name
048
        // of the attribute with $this->yourAttribute
049
     
050
        return $this->name;
051
     
052
    }
053
     
054
    // A Construtor is used to initialize objects when they are
055
    // created or instantiated
056
     
057
    function __construct(){
058
     
059
        // Generate a random id between 1 and 1000000
060
         
061
        $this->id = rand(100, 1000000);
062
         
063
        echo $this->id . " has been assigned<br />";
064
         
065
        // You access static attributes with Class::$static_att
066
         
067
        Animal::$number_of_animals++;
068
     
069
    }
070
     
071
    // A Destructor is called when all references to the object have
072
    // been unset. It cannot receive attributes
073
     
074
    public function __destruct(){
075
     
076
        echo $this->name . " is being destroyed :(";
077
     
078
    }
079
     
080
    // You can also use magic setters and getters which are called
081
    // when an attribute is set, or if its value is asked for
082
     
083
    function __get($name){
084
         
085
        echo "Asked for " . $name . "<br />";
086
     
087
        return $this->$name;
088
         
089
    }
090
     
091
     
092
    // If you want to check for a valid attribute you could use switch
093
     
094
    function __set($name, $value){
095
     
096
        switch($name){
097
         
098
            case "name":
099
                $this->name = $value;
100
                break;
101
                 
102
            case "favorite_food":
103
                $this->favorite_food = $value;
104
                break;
105
                 
106
            case "sound":
107
                $this->sound = $value;
108
                break;
109
                 
110
            default :
111
                echo $name . "Not Found";
112
         
113
        }
114
         
115
        echo "Set " . $name . " to " . $value . "<br />";
116
     
117
    }
118
     
119
    // 2. We will override this method in the subclass
120
    function run(){
121
         
122
         
123
        echo $this->name . " runs<br />";
124
         
125
    }
126
     
127
    // 3. To keep a method from being overridden use final
128
    // You can use final on a class to keep classes from
129
    // being overridden as well
130
     
131
    final function what_is_good(){
132
         
133
        echo "Running is Good<br />";
134
         
135
    }
136
     
137
    // 4. You can use __toString to define what prints when
138
    // the object is called to print
139
     
140
    function __toString(){
141
         
142
        return $this->name . " says " . $this->sound .
143
        " give me some ". $this->favorite_food . " my id is " .
144
        $this->id . " total animals = " . Animal::$number_of_animals .
145
        "<br /><br />";
146
         
147
    }
148
     
149
    // 5. You must define any function defined in an interface
150
     
151
    public function sing(){
152
         
153
        echo $this->name . " sings 'Grrrr grr grrr grrrrrrrrr'<br />";
154
         
155
    }
156
     
157
    // 7. static methods can be called without the need for instantiation
158
     
159
    static function add_these($num1, $num2){
160
         
161
        return ($num1 + $num2) . "<br />";
162
         
163
    }
164
     
165
}
166
 
167
// Inheritance occurs when you create a new class by extending another
168
// You will inherit all of the Attributes and Methods defined in the first
169
// You don't have to do anything in the class and it will still work
170
 
171
class Dog extends Animal implements Singable{
172
     
173
    // 2. You can override functions defined in the superclass
174
    function run(){
175
         
176
         
177
        echo $this->name . " runs like crazy<br />";
178
         
179
    }
180
     
181
    // 5. You must define any function defined in an interface
182
     
183
    public function sing(){
184
         
185
        echo $this->name . " sings 'Bow wow, woooow, woooooooooow'<br />";
186
         
187
    }
188
     
189
     
190
}
191
 
192
// 5. PHP doesn't allow muliple inheritance
193
// You need to use interfaces to get similar results
194
// Interfaces allow you to define functions that must be implemented
195
 
196
interface Singable{
197
     
198
    public function sing();
199
     
200
}
201
 
202
 
203
$animal_one = new Animal();
204
 
205
// These call __set
206
 
207
$animal_one->name = "Spot";
208
$animal_one->favorite_food = "Meat";
209
$animal_one->sound = "Ruff";
210
 
211
// The statements $animal_one->att_name call __get
212
// We call static attributes like this Class::$static_var
213
 
214
echo $animal_one->name . " says " . $animal_one->sound .
215
    " give me some ". $animal_one->favorite_food . " my id is " .
216
    $animal_one->id . " total animals = " . Animal::$number_of_animals .
217
    "<br /><br />";
218
     
219
// If we defined a constant in the class we would get its
220
// value like this Class::CONTANT
221
     
222
echo "Favorite Number " . Animal::PI . "<br />";
223
     
224
$animal_two = new Dog();
225
 
226
$animal_two->name = "Grover";
227
$animal_two->favorite_food = "Mushrooms";
228
$animal_two->sound = "Grrrrrrr";
229
 
230
// Even though we are referring to the Dog $number_of_animals it
231
// still increases even with subclasses
232
 
233
echo $animal_two->name . " says " . $animal_two->sound .
234
    " give me some ". $animal_two->favorite_food . " my id is " .
235
    $animal_two->id . " total animals = " . Dog::$number_of_animals .
236
    "<br /><br />";
237
     
238
// 2. Because of method overriding we get different results
239
$animal_one->run();
240
$animal_two->run();
241
 
242
// 3. final methods can't be overriden
243
$animal_one->what_is_good();
244
 
245
// 4. Example using __toString()
246
 
247
echo $animal_two;
248
 
249
// 5. You call a method defined in an interface like all others
250
 
251
$animal_two->sing();
252
 
253
// 6. You can also define functions that will except classes
254
// extending a secific class or interface
255
 
256
function make_them_sing(Singable $singing_animal){
257
     
258
    $singing_animal->sing();
259
     
260
}
261
 
262
// 6. Polymorphism states that different classes can have different
263
// behaviors for the same function. The compiler is smart enough to
264
// just figure out which function to execute
265
 
266
make_them_sing($animal_one);
267
make_them_sing($animal_two);
268
 
269
echo "<br />";
270
 
271
function sing_animal(Animal $singing_animal){
272
     
273
    $singing_animal->sing();
274
     
275
}
276
 
277
sing_animal($animal_one);
278
sing_animal($animal_two);
279
 
280
// 7. Calling a static method
281
 
282
echo "3+5= " . Animal::add_these(3,5);
283
 
284
// 8. You can check the class type with instanceof
285
 
286
$is_it_an_animal = ($animal_two instanceof Animal) ? "True" : "False";
287
 
288
echo "It is " . $is_it_an_animal . ' that $animal_one is an Animal<br />';
289
 
290
// 9. You can clone objects and even define just what you want available
291
// to clone in __clone() if it is in the class definition
292
 
293
$animal_clone = clone $animal_one;
294
 
295
// 10. You can define abstract classes and methods
296
// An abstract class can't be instantiated, but instead forces classes
297
// that implement it to override every abstract method in it
298
 
299
/*
300
    abstract class RandomClass{
301
         
302
        abstract function RandomFunction($attrib1);
303
         
304
    }
305
 */
306
 
307
 // 11. __call() if defined in a class can provide method overloading
308
 // but since PHP isn't strongly typed I see no reason to use it
309
 
310
 
311
?>
312
</body>
313
</html>
