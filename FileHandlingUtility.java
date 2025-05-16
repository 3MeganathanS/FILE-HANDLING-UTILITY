//import statements
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * FileHandlingUtility
 * A simple Java utility to perform read, write, and modify operations on text files.
 * Developed for CODTECH Internship Task - 1.
 */
public class FileHandlingUtility {

    static Scanner scanner = new Scanner(System.in);
    static final String FILE_PATH = "data.txt";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- File Handling Utility ---");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify File Content");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: 
                    writeFile(); 
                    break;
                case 2: 
                    readFile(); 
                    break;
                case 3: 
                    modifyFile(); 
                    break;
                case 4: 
                    System.out.println("Exiting program."); 
                    return;
                default: 
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Write text to a file
    private static void writeFile() {
        try {
            System.out.print("Enter text to write: ");
            String content = scanner.nextLine();
            FileWriter writer = new FileWriter(FILE_PATH);
            writer.write(content);
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Read and display file content
    private static void readFile() {
        try {
            FileReader fr=new FileReader(FILE_PATH);
            BufferedReader reader = new BufferedReader(fr);
            String line=reader.readLine();
            System.out.println("\n--- File Content ---");
            while (line!= null) {
                System.out.println(line);
                line=reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Write content first.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Modify existing file content
    private static void modifyFile() {
        try {
            System.out.print("Enter new content to replace existing file content: ");
            String newContent = scanner.nextLine();
            FileWriter writer = new FileWriter(FILE_PATH, false); // overwrite
            writer.write(newContent);
            writer.close();
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}