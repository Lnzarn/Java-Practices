/*
 * ==========================================================
 *  Machine Problem 1 - Workspace for Group 09
 * ==========================================================
 *
 * Instructions:
 * - This file is your workspace for solving Machine Problem 1.
 * - You will practice the Programming Core Concepts discussed in class,
 *   such as variables, data types, operators, and basic string operations.
 * - Do NOT create additional classes or advanced features (like arrays)
 *   unless instructed.
 * ==========================================================
 */

public class Palindrome {
    public static void main(String[] args) {
        int intHardcodedNumber = 12321;
        int intReversedNumber = reverseNumber(intHardcodedNumber);
        System.out.println(checkPalindrome(intHardcodedNumber, intReversedNumber) 
        ? intHardcodedNumber + " is a Palindrome" 
        : intHardcodedNumber + " is not Palindrome"); 
        
        //Going now for Challenge 1 - 500 Palindrome. Ill use the same variables for less storage.
        System.out.println("\n-- Palindromes from 1 to 500 --");
        intHardcodedNumber = 1;
        while (intHardcodedNumber <= 500){
            intReversedNumber = reverseNumber(intHardcodedNumber);
            if(checkPalindrome(intHardcodedNumber, intReversedNumber)){
                System.out.println(intHardcodedNumber + " is a Palindrome");
            }
            intHardcodedNumber += 1;
        }
        
    }
    public static Boolean checkPalindrome(int origNumber, int revNumber){
        return origNumber == revNumber;
    }
    public static int reverseNumber(int intNumber){
        String strReversedNumber = "";
        while(intNumber > 0){
            int intLeastNumber = intNumber % 10;
            strReversedNumber += intLeastNumber;
            intNumber /= 10;
        }
        return Integer.parseInt(strReversedNumber);
    }
}