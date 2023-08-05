import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class TASK2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        
        while (playAgain) {
            System.out.println("Welcome to Word Count Program!");
            System.out.println("1. Enter 'T' to input text");
            System.out.println("2. Enter 'F' to input a file");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine().toUpperCase();
            
            String inputText = "";
            
            switch (option) {
                case "T":
                    System.out.print("Enter your text: ");
                    inputText = scanner.nextLine();
                    break;
                case "F":
                    System.out.print("Enter the path of the file: ");
                    String filePath = scanner.nextLine();
                    try {
                        inputText = readFile(filePath);
                    } catch (IOException e) {
                        System.out.println("Error reading the file.");
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }
            
            int wordCount = countWords(inputText);
            System.out.println("Total word count: " + wordCount);
            
            System.out.print("Do you want to play again? (Y/N): ");
            String playAgainOption = scanner.nextLine().toUpperCase();
            playAgain = playAgainOption.equals("Y");
        }
        
        System.out.println("Thank you for using Word Count Program!");
        scanner.close();
    }
    
    public static String readFile(String filePath) throws IOException {
        Scanner fileScanner = new Scanner(new File(filePath));
        StringBuilder text = new StringBuilder();
        
        while (fileScanner.hasNextLine()) {
            text.append(fileScanner.nextLine()).append("\n");
        }
        
        fileScanner.close();
        return text.toString();
    }
    
    public static int countWords(String text) {
        String[] words = text.split("[\\p{Space}\\p{Punct}]+");
        return words.length;
    }
}

