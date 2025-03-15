
//Create a class to represent a student with attributes like name, roll number, and marks.


class Student {
    // Attributes (Instance Variables)
    private String name;
    private int rollNumber;
    private double marks;

    
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getMarks() {
        return marks;
    }

   
    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    
    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }

   
    public static void main(String[] args) {
       
        Student student1 = new Student("Chetan pal", 1, 85.4);

        // Displaying student details
        student1.displayStudentInfo();
    }
}
