
// Demonstrate polymorphism by creating methods with the same name but different parameters in a parent and child class.
class Parent {
    
    void show() {
        System.out.println("Parent: Show method with no parameters.");
    }

    void show(String message) {
        System.out.println("Parent: " + message);
    }
}


class Child extends Parent {
    
    @Override
    void show() {
        System.out.println("Child: Overridden show method.");
    }
}

public class Question3 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.show(); 
        parent.show("Hello from Parent!"); 

        Child child = new Child();
        child.show();

        Parent poly = new Child();
        poly.show(); 
        
    }
}
