//the concept of interfaces and abstract classes with examples.

//an interface defines a contract that classes can implement. An abstract class can provide a common base with both abstract methods

interface Vehicle {
    void start();
}

abstract class Car implements Vehicle {
    abstract void accelerate();
    
    public void stop() {
        System.out.println("Car is stopping...");
    }
}

class Sedan extends Car {
    public void start() {
        System.out.println("Sedan is starting...");
    }
    
    public void accelerate() {
        System.out.println("Sedan is accelerating...");
    }
}
public class Question1 {

    public static void main(String[] args) {
        Sedan myCar = new Sedan();
        myCar.start();
        myCar.accelerate();
        myCar.stop();
    }
}