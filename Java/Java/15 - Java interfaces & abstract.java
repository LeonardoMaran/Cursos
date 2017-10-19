1
/* Java doesn't allow you to inherit from more than one
02
 * class. So, what do you do when you want do you do
03
 * when you want to add additional functionality?
04
 * You create an interface. Interfaces are empty
05
 * classes. They provide all of the methods you must
06
 * use, but none of the code.
07
 */
08
 
09
// This is how you define an interface. They normally
10
// have a name that is an adjective. Adjectives modify
11
// nouns. Most objects have noun names
12
public interface Drivable {
13
     
14
    // You can put fields in an interface, but understand
15
    // that their values are final and can't be changed
16
    double PI = 3.14159265;
17
     
18
    // All methods in an interface must be implemented
19
    // They are public and abstract by default
20
    // An abstract method must be defined by any class
21
    // that uses the interface
22
    int getWheels();
23
     
24
    // You can't define a method as final and abstract
25
    // final means the method can't be changed and
26
    // abstract means it must be changed
27
    void setWheels(int numWheels);
28
     
29
    double getSpeed();
30
     
31
    void setSpeed(double speed);
32
     
33
     
34
     
35
}
CRASHABLE.JAVA

01
/* If you want to create a class in which every method
02
 * doesn't have to be implemented use abstract classes.
03
 */
04
 
05
// Create an abstract class with the abstract keyword
06
public abstract class Crashable{
07
     
08
    boolean carDrivable = true;
09
     
10
    public void youCrashed(){
11
        this.carDrivable = false;
12
    }
13
     
14
    public abstract void setCarStrength(int carStrength);
15
     
16
    public abstract int getCarStrength();
17
     
18
}
VEHICLE.JAVA

01
/* You define that you want a class to use an interface
02
 * with the implements keyword. This class must create
03
 * a method for each method defined in Drivable
04
 * You can implement more than 1 interface like this
05
 * public class Vehicle implements Drivable, Crashable
06
 */
07
// You make a class part of an abstract class by using
08
//the extends keyword
09
public class Vehicle extends Crashable implements Drivable {
10
     
11
    int numOfWheels = 2;
12
    double theSpeed = 0;
13
     
14
    int carStrength = 0;
15
     
16
    // All methods must be as visible as those in the
17
    // interface. If they are public in the interface
18
    // they must be public in the subclass
19
    public int getWheels(){
20
        return this.numOfWheels;
21
    }
22
     
23
    public void setWheels(int numWheels){
24
        this.numOfWheels = numWheels;
25
    }
26
     
27
    public double getSpeed(){
28
        return this.theSpeed;
29
    }
30
     
31
    public void setSpeed(double speed){
32
        this.theSpeed = speed;
33
    }
34
     
35
    public Vehicle(int wheels, double speed){
36
        this.numOfWheels = wheels;
37
        this.theSpeed = speed;
38
    }
39
     
40
    public void setCarStrength(int carStrength){
41
        this.carStrength = carStrength;
42
    }
43
     
44
    public int getCarStrength(){
45
        return this.carStrength;
46
    }
47
     
48
}
LESSONFIFTEEN.JAVA

01
public class LessonFifteen {
02
     
03
    public static void main(String[] args){
04
         
05
        Vehicle car = new Vehicle(4, 100.0);
06
         
07
        // Using methods from the interface Drivable
08
        System.out.println("Cars Max Speed: "+car.getSpeed());
09
        System.out.println("Cars Number of Wheels: "+car.getWheels());
10
         
11
        // Using methods from abstract method Crashable
12
        car.setCarStrength(10);
13
        System.out.println("Car Strength: "+car.getCarStrength());
14
         
15
    }
16
     
17
}
