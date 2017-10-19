LESSONSIXTEEN.JAVA

01
public class LessonSixteen{
02
     
03
    public static void main(String[] args){
04
         
05
        // Every object inherits all the methods in the Object class
06
         
07
        Object superCar = new Vehicle();
08
         
09
        // superCar inherits all of the Object methods, but an object
10
        // of class Object can't access the Vehicle methods
11
         
12
        // System.out.println(superCar.getSpeed()); * Throws an error
13
         
14
        // You can cast from type Object to Vehicle to access those methods
15
         
16
        System.out.println(((Vehicle)superCar).getSpeed());
17
         
18
        // The methods of the Object class
19
         
20
        Vehicle superTruck = new Vehicle();
21
         
22
        // equals tells you if two objects are equal
23
        System.out.println(superCar.equals(superTruck));
24
         
25
        // hashCode returns a unique identifier for an object
26
        System.out.println(superCar.hashCode());
27
         
28
        // finalize is called by the java garbage collector when an object
29
        // is no longer of use. If you call it there is no guarantee it will
30
        // do anything though
31
         
32
        // getClass returns the class of the object
33
         
34
        System.out.println(superCar.getClass());
35
         
36
        // THE CLASS OBJECT
37
        // You can use the Class object method getName to get just the class name
38
         
39
        System.out.println(superCar.getClass().getName());
40
         
41
        // You can check if 2 objects are of the same class with getClass()
42
         
43
        if(superCar.getClass() == superTruck.getClass()){
44
            System.out.println("They are in the same class");
45
        }
46
         
47
        // getSuperclass returns the super class of the class
48
         
49
        System.out.println(superCar.getClass().getSuperclass());
50
         
51
        // the toString method is often overwritten for an object
52
         
53
        System.out.println(superCar.toString());
54
         
55
        // toString is often used to convert primitives to strings
56
         
57
        int randNum = 100;
58
        System.out.println(Integer.toString(randNum));
59
         
60
        // THE CLONE METHOD
61
        // clone copies the current values of the object and assigns
62
        // them to another. If changes are made after the clone both
63
        // objects aren't effected though
64
         
65
        superTruck.setWheels(6);
66
         
67
        Vehicle superTruck2 = (Vehicle)superTruck.clone();
68
         
69
        System.out.println(superTruck.getWheels());
70
         
71
        System.out.println(superTruck2.getWheels());
72
         
73
        // They are separate objects and don't have equal hashcodes
74
        System.out.println(superTruck.hashCode());
75
        System.out.println(superTruck2.hashCode());
76
         
77
        // There are subobjects defined in an object clone won't
78
        // also clone them. You'd have to do that manually, but this
79
        // topic will be covered in the future because of complexity
80
         
81
    }
82
     
83
}
VEHICLE.JAVA

01
public class Vehicle extends Crashable implements Drivable, Cloneable{
02
     
03
    int numOfWheels = 2;
04
    double theSpeed = 0;
05
     
06
    int carStrength = 0;
07
     
08
    public int getWheels(){
09
        return this.numOfWheels;
10
    }
11
     
12
    public void setWheels(int numWheels){
13
        this.numOfWheels = numWheels;
14
    }
15
     
16
    public double getSpeed(){
17
        return this.theSpeed;
18
    }
19
     
20
    public void setSpeed(double speed){
21
        this.theSpeed = speed;
22
    }
23
     
24
    public Vehicle(){
25
         
26
    }
27
     
28
    public Vehicle(int wheels, double speed){
29
        this.numOfWheels = wheels;
30
        this.theSpeed = speed;
31
    }
32
     
33
    public void setCarStrength(int carStrength){
34
        this.carStrength = carStrength;
35
    }
36
     
37
    public int getCarStrength(){
38
        return this.carStrength;
39
    }
40
     
41
    public String toString(){
42
        return "Num of Wheels: " + this.numOfWheels;
43
    }
44
     
45
    public Object clone(){
46
        Vehicle car;
47
         
48
        try{
49
            car = (Vehicle) super.clone();
50
        }
51
         
52
        catch(CloneNotSupportedException e){
53
            return null;
54
        }
55
        return car;
56
    }
57
     
58
}
