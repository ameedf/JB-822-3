import java.util.Scanner;

/**
 * A Palindrome is a sequence of characters which reads the same backward as forward.
 * Examples: anna, civic, kayak, level, madam,...
 * We will consider only numbers that can be called Palindrome. For example: 1001, 242, 99988999,...
 * The program will ask the user to enter a number (int), between 0 and 1,000,000,000.
 * It will check the input and proceed only when the input is finally correct.
 * If the input is NOT a Palindrome it will print a suitable message and finish.
 * Else, it will print the following (see examples next):
 * 1: the length of the number
 * 2: the first part of the Palindrome with spaces between the characters
 * 3: the second part of the Palindrome with spaces between the characters
 * NOTES:
 * 1. You must use ONLY things we learned (don't depend on string manipulations for example)
 * 2. Leading zeros don't count. For example, 00100 is NOT a Palindrome because the real number is 100
 *
 * Examples:
 * 1. Input: 13531
 *    Output: size = 5
 *    First part = 1 3 5      (with a space between each 2 characters)
 *    Second part = 5 3 1     (with a space between each 2 characters)
 * 2. Input: 98433489
 *    Output: size = 8
 *    First part = 9 8 4 3      (with a space between each 2 characters)
 *    Second part = 3 4 8 9     (with a space between each 2 characters)
 */
public class Palindrome {
    public static void main(String[] args) {

        Scanner input  = new Scanner(System.in);
        byte palindromeSize;

        System.out.printf("Please enter a number(int), between 0 and 1,000,000,000: ");
        long inputNum = input.nextInt();

        while (inputNum <= 0 || inputNum > 1000000000) {
            System.out.printf("Please enter a valid number: ");
            inputNum = input.nextLong();
        }
        input.close();

        palindromeSize = checkIfPalindrome(inputNum);
        if (palindromeSize == 0) { return; }

        byte[] palindromeArr = new byte[palindromeSize];
        enterPalindromeIntoArray(palindromeArr, inputNum);

        printPalindrome(palindromeArr, "First", 0, palindromeArr.length/2);
        System.out.println();
        printPalindrome(palindromeArr, "Second", palindromeArr.length/2, palindromeArr.length-1);
    }

    private static byte checkIfPalindrome (long inputNum) {
        int reversedNum = 0;
        byte numDigits = 0;
        int num = (int)inputNum;

        while (num != 0 ) {
            reversedNum = reversedNum * 10 +  (num % 10);
            num = num / 10;
            numDigits++;
        }

        if (inputNum != reversedNum) {
            System.out.println("Your number is NOT a palindrome!");
            return 0;
        }
        else {
            System.out.println("Your number is a palindrome!");
            return numDigits;
        }
    }

    private static void enterPalindromeIntoArray (byte[] palindromeArr, long inputNum) {
        for (int i = 0 ; i < palindromeArr.length ; i++) {
            palindromeArr[i] = (byte)(inputNum % 10);
            inputNum = inputNum / 10;
        }
    }

    private static void printPalindrome(byte[] palindromeArr, String partToPrint, int startPoint, int endPoint) {
        System.out.printf(partToPrint + "part = ");

        while (startPoint <= endPoint) {
            System.out.printf(palindromeArr[startPoint] + " ");
            startPoint++;
        }
    }
}
