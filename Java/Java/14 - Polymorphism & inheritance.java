ANIMAL.JAVA

01
// Animal will act as a Super class for other Animals
02
public class Animal {
03
     
04
    private String name = "Animal";
05
    public String favFood = "Food";
06
     
07
    // You use protected when you want to allow subclasses
08
    // To be able to access methods or fields
09
    // If you would have used private their would be no
10
    // way for subclasses to call this method
11
    // This is a final method which means it can't be overwritten
12
     
13
    protected final void changeName(String newName){
14
         
15
        // this is a reference to the object you're creating
16
         
17
        this.name = newName;
18
         
19
    }
20
     
21
    protected final String getName(){
22
         
23
        return this.name;
24
         
25
    }
26
     
27
    public void eatStuff(){
28
         
29
        System.out.println("Yum " + favFood);
30
         
31
    }
32
     
33
    public void walkAround(){
34
         
35
        System.out.println(this.name + " walks around");
36
         
37
    }
38
     
39
    public Animal(){
40
         
41
    }
42
     
43
    public Animal(String name, String favFood){
44
         
45
        this.changeName(name);
46
        this.favFood = favFood;
47
         
48
    }
49
     
50
}
CAT.JAVA

01
// Cat is a Subclass of Animal
02
// You create subclasses with the extends keyword
03
// Now Cat has all the Methods and Fields that Animal defined
04
// This is known as inheritance because Cat inherits all
05
// the methods and fields defined in Animal
06
 
07
public class Cat extends Animal{
08
     
09
    // You can add new fields to the subclass
10
    public String favToy = "Yarn";
11
     
12
    // You can add new methods
13
    public void playWith(){
14
         
15
        System.out.println("Yeah " + favToy);
16
         
17
    }
18
     
19
    // Here I overrode the Animal walkAround method
20
    public void walkAround(){
21
         
22
        // this refers to a specific object created of type Cat
23
         
24
        System.out.println(this.getName() + " stalks around and then sleeps");
25
         
26
    }
27
     
28
    public String getToy(){
29
         
30
        return this.favToy;
31
         
32
    }
33
     
34
    public Cat(){
35
         
36
    }
37
     
38
    public Cat(String name, String favFood, String favToy){
39
         
40
        // super calls the constructor for the super class Animal
41
         
42
        super(name, favFood);
43
         
44
        // We set the favToy value in Cat because it doesn't
45
        // exist in the Animal class
46
         
47
        this.favToy = favToy;
48
         
49
    }
50
     
51
}
LESSONFOURTEEN.JAVA

01
public class LessonFourteen{
02
     
03
public static void main(String[] args){
04
         
05
        // I create a Animal object named genericAnimal
06
     
07
        Animal genericAnimal = new Animal();
08
        System.out.println(genericAnimal.getName());
09
        System.out.println(genericAnimal.favFood);
10
         
11
     
12
        // I create a Cat class like any other
13
        Cat morris = new Cat("Morris", "Tuna", "Rubber Mouse");
14
         
15
        // Print out the name, favFood and favToy
16
        System.out.println(morris.getName());
17
        System.out.println(morris.favFood);
18
        System.out.println(morris.favToy);
19
         
20
        // You can also create classes based on the super class
21
         
22
        Animal tabby = new Cat("Tabby", "Salmon", "Ball");
23
         
24
        // You pass objects like any other field
25
        acceptAnimal(tabby);
26
         
27
    }
28
     
29
    public static void acceptAnimal(Animal randAnimal){
30
         
31
        // Gets the name and favFood for the Animal passed
32
        System.out.println(randAnimal.getName());
33
        System.out.println(randAnimal.favFood);
34
         
35
        // This is Polymorphism
36
        // The interpreter automatically figures out what type
37
        // of Animal it's dealing with and checks to make sure
38
        // if methods were overwritten that they are called
39
        // instead
40
        randAnimal.walkAround();
41
         
42
        // The interpreter won't find anything that doesn't
43
        // originally exist in the Animal class however
44
        // System.out.println(randAnimal.favToy); Throws an ERROR
45
         
46
        // If you want access to fields or methods only found
47
        // in the Cat class you have to cast the object to
48
        // that specific class first
49
        Cat tempCat = (Cat) randAnimal;
50
         
51
        System.out.println(tempCat.favToy);
52
         
53
        // You could also cast the object directly like this
54
        System.out.println(((Cat) randAnimal).favToy);
55
         
56
        // You can use instanceof to check what type of object
57
        // you have. This results in a positive for Animal
58
        // and for Cat
59
        if (randAnimal instanceof Cat)
60
        {
61
            System.out.println(randAnimal.getName() + " is a Cat");
62
        }
63
         
64
    }
65
     
66
}
