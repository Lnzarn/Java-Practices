import java.util.*;

class InvalidInputException extends Exception{
    public InvalidInputException(String errorMessage){
        super(errorMessage);
    }
}

public class ENRIQUE_MP3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;
        
        while(continueProgram){
            try {
                displayMenu();
                int choice = getIntChoice(scanner);
                
                if(choice < 1 || choice > 10){
                    throw new InvalidInputException("Error: Choice input must be within 1 to 10.");
                }
                
                String firstString;
                String secondString = "";
                
                if(choice == 3 || choice == 6){
                    firstString = getString(scanner, 1);
                    secondString = getString(scanner, 2);
                } else {
                    firstString = getString(scanner, 1);
                }
                    
                executeChoice(choice, firstString, secondString);
                
                continueProgram = askToContinue(scanner);
                
            } catch (InvalidInputException e){
                System.out.println("\n" + e.getMessage() + "\n");
            } catch (InputMismatchException e) {
                System.out.println("\nError: Please enter a valid number.\n");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage() + "\n");
            }
        }
        
        System.out.println("\nThank you for using String Toolkit!");
        scanner.close();
    }
    
    public static void displayMenu(){
        System.out.println("--- String Toolkit ---");
        System.out.println("[1] String Reversal");
        System.out.println("[2] Palindrome Checker");
        System.out.println("[3] Anagram Checker");
        System.out.println("[4] Word Count");
        System.out.println("[5] Character Count");
        System.out.println("[6] Substring Finder");
        System.out.println("[7] Lower Case Converter");
        System.out.println("[8] Upper Case Converter");
        System.out.println("[9] Vowel Remover");
        System.out.println("[10] Consonant Remover");
        System.out.println("----------------------");
        System.out.print("Select an option (1-10): ");
    }
    
    public static void executeChoice(int choice, String strFirst, String strSecond){
        switch (choice){
            case 1:
                printOutput("Original: " + strFirst + "\n\nReversed: " + reverseString(strFirst));
                break;
            case 2:
                printOutput(strFirst + (strFirst.trim().replaceAll("[.!?, ]", "").equals(reverseString(strFirst).trim().replaceAll("[.!?, ]", "")) 
                ? " is a Palindrome" : " is not a Palindrome"));
                break;
            case 3:
                anagramString(strFirst, strSecond);
                break;
            case 4:
                wordCount(strFirst);
                break;
            case 5:
                printOutput("Characters (excluding spaces): " + String.valueOf(strFirst.replaceAll("\\s","").length()));
                break;
            case 6:
                findSubString(strFirst, strSecond);
                break;
            case 7:
                printOutput("Lowercase: " + strFirst.toLowerCase());
                break;
            case 8:
                printOutput("Uppercase: " + strFirst.toUpperCase());
                break;
            case 9:
                printOutput("Vowels removed: " + strFirst.replaceAll("[aeiouAEIOU]", ""));
                break;
            case 10:
                printOutput("Consonants removed: " + strFirst.replaceAll("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]", ""));
                break;
            default:
                break;
        }
    }

    public static String getString(Scanner scanner, int inputNo) throws InvalidInputException{
        while(true){
            try {
                System.out.println("\nEnter your " + (inputNo == 1 ? "string" : "another string") + " input:");
                System.out.print("> ");
                String tempString = scanner.nextLine().trim();
                
                if (tempString.isEmpty()){
                    throw new InvalidInputException("String input cannot be empty.");
                }
                
                String[] sentences = tempString.split("[.!?]+\\s*");
                int sentencesCount = 0;
                for (String s : sentences) {
                    if (!s.trim().isEmpty()) {
                        sentencesCount++;
                    }
                }
                
                if (sentencesCount < 3){
                    throw new InvalidInputException("String input must contain at least 3 sentences.");
                }
                
                return tempString.toLowerCase();
                
            } catch (InvalidInputException e) {
                System.out.println("\n" + e.getMessage() + " Please try again.");
            }
        }
    }

    public static int getIntChoice(Scanner scanner) throws InputMismatchException{
        int tempChoice = scanner.nextInt();
        scanner.nextLine();
        return tempChoice;
    }

    public static void findSubString(String strFirst, String strSecond) {
        try {
            int count = 0;
            int lastIndex = 0;
            String indexOfSubstring = "";
            
            while(lastIndex != -1){
                lastIndex = strFirst.indexOf(strSecond, lastIndex);

                if(lastIndex != -1){
                    indexOfSubstring += String.valueOf(lastIndex)+" ";
                    count++;
                    lastIndex += strSecond.length();
                }
            }

            if(count == 0){
                printOutput("Found no \"" + strSecond + "\" in the first string.");
            } else {
                printOutput("Found " + count + " occurrence(s) of \"" + strSecond + "\" in the first string.\n" +
                           "Index position(s): " + indexOfSubstring.trim());
            }
        } catch (Exception e) {
            System.out.println("\nError finding substring: " + e.getMessage());
        }
    }

    public static void wordCount(String str){
        String[] words = str.trim().split("\\s+");
        printOutput("Number of words: " + words.length);
    }
    
    public static String reverseString(String str){
        String tempString = "";
        try{
            for(int i = 0; i < str.length(); i++){
                tempString = str.charAt(i) + tempString;
            }
            return tempString;
        } catch (Exception e){
            System.out.println("\nError reversing string: " + e.getMessage());
        }
        return tempString;
    }
    
    public static void anagramString(String strFirst, String strSecond){
        String cleanFirst = strFirst.replaceAll("\\s", "");
        String cleanSecond = strSecond.replaceAll("\\s", "");
        
        char[] arrChar1 = cleanFirst.toCharArray();
        char[] arrChar2 = cleanSecond.toCharArray();
        Arrays.sort(arrChar1);
        Arrays.sort(arrChar2);
        
        printOutput("\"" + strFirst + "\" and \"" + strSecond + "\"" + 
                   (Arrays.equals(arrChar1, arrChar2) ? " are Anagrams" : " are not Anagrams"));
    }
    
    public static boolean askToContinue(Scanner scanner){
        System.out.println("\n----------------------");
        System.out.print("Would you like to perform another operation? (Y/N): ");
        String response = scanner.nextLine().trim().toLowerCase();
        
        while(!response.equals("y") && !response.equals("n") && 
              !response.equals("yes") && !response.equals("no")){
            System.out.print("Please enter Y or N: ");
            response = scanner.nextLine().trim().toLowerCase();
        }
        
        System.out.println();
        return response.equals("y") || response.equals("yes");
    }
    
    public static void printOutput(String str){
        System.out.println("\n--- Output ---");
        System.out.println(str);
    }
}