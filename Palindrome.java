
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
		int PalindromeNum, PalindromeLen = 0;
		Scanner in = new Scanner(System.in);

		do {
			System.out.print("Enter number from 0 to 1,000,000,000:");
			PalindromeNum = in.nextInt();
		} while (PalindromeNum < 0 || PalindromeNum > 1000000000);

		int num, remainder, plen = 0;
		int reversedPalindromeNum = 0;
		num = PalindromeNum;

		String outMessage = "";
		String fPart = "";
		String sPart = "";

		while (num > 0) {
			remainder = num % 10;
			reversedPalindromeNum = reversedPalindromeNum * 10 + remainder;
			num = num / 10;
			plen++;
		}

		if (PalindromeNum == reversedPalindromeNum) {
			num = PalindromeNum;
			int i = plen;
			while (i > 0) {
				remainder = num % 10;
				if (i > (plen / 2)) {
					fPart += " " + remainder;
					if ((plen % 2 != 0) && (i == plen / 2 + 1)) {
						sPart += " " + remainder;
					}
				} else {
					sPart += " " + remainder;
				}
				num = num / 10;
				i--;
			}

			outMessage += "\n Given number " + PalindromeNum + " is a Palindrome!";
			outMessage += "\n Output: size =  " + plen;
			outMessage += "\n First part = " + fPart;
			outMessage += "\n Second part = " + sPart;
			System.out.println(outMessage);

		} else {
			System.out.println("\n Given number " + PalindromeNum + "is NOT a Palindrome!");
		}
	}
}