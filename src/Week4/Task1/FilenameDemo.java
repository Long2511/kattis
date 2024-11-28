package Week4.Task1;

import java.io.File;

public class FilenameDemo {
    public static void main(String[] args) {
        File file = new File("src/Week4/Exercises/example.txt");
        if (file.exists()) {
            System.out.println("File exists: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
        } else {
            System.out.println("File does not exist.");
        }
    }
}