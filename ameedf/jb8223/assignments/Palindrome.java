package ameedf.jb8223.assignments;

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
        Scanner input = new Scanner(System.in);
        int maximumNumberAllowed = 1_000_000_000;
        System.out.println("Enter a number in the range [0.." + maximumNumberAllowed + "]:");
        int userInput = input.nextInt();
        while (userInput < 0 || userInput > maximumNumberAllowed) {
            System.out.println("Invalid input. Please enter a number in the range [0.." + maximumNumberAllowed + "]:");
            userInput = input.nextInt();
        }

        byte[] digits;
        if (userInput == 0) {
            digits = new byte[1]; // already contains '0'
        } else {
            int numberLength = 0;
            int temp = userInput;
            while (temp != 0) {
                temp = temp / 10;
                numberLength++;
            }

            // split number to digits
            digits = new byte[numberLength];
            temp = userInput;
            for (int i = 0; i < numberLength; i++) {
                digits[i] = (byte)(temp % 10);
                temp /= 10;
            }
        }

        // check if the number is a Palindrome
        for (int i = 0; i < digits.length / 2; i++) {
            if (digits[i] != digits[digits.length - 1 - i]) {
                System.out.println("The number is NOT a Palindrome");
                return;
            }
        }

        System.out.println("Length: " + digits.length);
        System.out.print("First part:");
        for (int i = 0; i < digits.length / 2 + digits.length % 2; i++) {
            System.out.print(" " + digits[i]);
        }
        System.out.println();
        System.out.print("Second part:");
        for (int i = digits.length / 2; i < digits.length ; i++) {
            System.out.print(" " + digits[i]);
        }
    }
}
