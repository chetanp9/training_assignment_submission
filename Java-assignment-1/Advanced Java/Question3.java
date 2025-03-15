// a simple file I/O operation to read data from a text file.


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Question3 {
    
    public void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Question3 fileHandler = new Question3();
        fileHandler.readFile("examp.txt");
    }
}
