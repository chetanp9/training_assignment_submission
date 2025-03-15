
class Car {
    String model;
    int year;

    Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    void display() {
        System.out.println("Car Model: " + model + ", Year: " + year);
    }
}

public class Question3 {
    public static void main(String[] args) {
        // Primitive Data Types
        int number = 10;
        double price = 99.99;
        char letter = 'A';
        boolean isJavaFun = true;

        System.out.println("Primitive Data Types:");
        System.out.println("Number: " + number);
        System.out.println("Price: " + price);
        System.out.println("Letter: " + letter);
        System.out.println("Is Java Fun? " + isJavaFun);

        // Reference Data Types
        Car myCar = new Car("Tesla", 2024); // Object creation
        String text = "Hello, Java!"; // String is a reference type

        System.out.println("\nReference Data Types:");
        myCar.display();
        System.out.println("Text: " + text);
    }
}
