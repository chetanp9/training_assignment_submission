
//Implement inheritance to create a "GraduateStudent" class that extends the "Student" class with additional features.

class Student{
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
}
class GraduateStudent extends Student {
    private String thesisTitle;
    private String researchArea;

    public GraduateStudent(String name, int rollNumber, double marks, String thesisTitle, String researchArea) {
        super(name, rollNumber, marks);
        this.thesisTitle = thesisTitle;
        this.researchArea = researchArea;
    }

    public void displayGraduateStudentInfo() {
        super.displayStudentInfo();
        System.out.println("Thesis Title: " + thesisTitle);
        System.out.println("Research Area: " + researchArea);
    }
}

public class Question2 {
    public static void main(String[] args) {
        GraduateStudent gs=new GraduateStudent("Chetan Pal",1,85,"Thermal Detection using Ai","Machine learning");
        gs.displayGraduateStudentInfo();
    }
    
}
