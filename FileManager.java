import java.io.*;
import java.util.Scanner;

public class FileManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();

        while (true) {
            System.out.println("File Management System Menu:");
            System.out.println("1. Create a new file");
            System.out.println("2. Delete a file");
            System.out.println("3. Display file contents");
            System.out.println("4. Append content to a file");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter file name to create: ");
                    String createFileName = scanner.nextLine();
                    fileManager.createFile(createFileName);
                    break;

                case "2":
                    System.out.print("Enter file name to delete: ");
                    String deleteFileName = scanner.nextLine();
                    fileManager.deleteFile(deleteFileName);
                    break;

                case "3":
                    System.out.print("Enter file name to display contents: ");
                    String displayFileName = scanner.nextLine();
                    fileManager.displayFileContents(displayFileName);
                    break;

                case "4":
                    System.out.print("Enter file name to append content: ");
                    String appendFileName = scanner.nextLine();
                    System.out.print("Enter content to append: ");
                    String content = scanner.nextLine();
                    fileManager.appendToFile(appendFileName, content);
                    break;

                case "5":
                    scanner.close();
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }

    public void createFile(String fileName) {
        try {
            File file = new File(fileName + ".txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName) {
        File file = new File(fileName + ".txt");
        if (file.delete()) {
            System.out.println("File deleted: " + file.getName());
        } else {
            System.out.println("File does not exist.");
        }
    }

    public void displayFileContents(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"))) {
            String line;
            System.out.println("File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public void appendToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName + ".txt", true)) {
            writer.write(content + "\n");
            System.out.println("Content appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }
    }
}
