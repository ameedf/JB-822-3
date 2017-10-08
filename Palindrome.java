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

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		int PalindromeNum, tmp, ogg, div = 0, PalindromeLen = 0;
		Scanner in = new Scanner(System.in);
		String outMessage;

		do {
			System.out.print("Enter number from 0 to 1,000,000,000:");
			PalindromeNum = in.nextInt();
		} while (PalindromeNum < 0 || PalindromeNum > 1000000000);
		
		//Find length of integer
		tmp = PalindromeNum;
		while (tmp != 0) {
			tmp = tmp / 10;
			PalindromeLen++;
		}
		
		//Allocate an array depending on integer length
		byte[] PalindromeArr = new byte[PalindromeLen];
		
		//Copy integer to array by characters
		tmp = PalindromeNum;
		for (int i = PalindromeArr.length - 1; i >= 0; i--) {
			PalindromeArr[i] = (byte) (tmp % 10);
			tmp /= 10;
		}
		
		//Check if the entered integer is palindrome
		boolean isPalindrome = true;
		for (int i = 0, j = (PalindromeArr.length - 1); i < j && isPalindrome; i++, j--) {
			if (PalindromeArr[i] != PalindromeArr[j]) {
				isPalindrome = false;
			}
		}
		
		//Preparing and print out message 
		if (isPalindrome) {
			int N = PalindromeArr.length;
			String firstPart = "";
			String secondPart = "";
			
			for (int i = 0; i < PalindromeArr.length; i++) {
				if (i < N / 2) {
					firstPart += " " + PalindromeArr[i];
				} else {
					if ((N % 2 != 0) && (i == N / 2)) {
						firstPart += " " + PalindromeArr[i];
					}
					secondPart += " " + PalindromeArr[i];
				}
			}
			outMessage = "\nInput: " + PalindromeNum + "\nOutput: size = " + PalindromeArr.length + "\nFirst part ="
					+ firstPart + "\nSecond part =" + secondPart;
			System.out.println(outMessage);
		} else {
			System.out.println("\nEntered integer: " + PalindromeNum + " is NOT a Palindrome!");
		}
		
		in.close();
	}
}