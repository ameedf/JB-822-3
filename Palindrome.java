import java.util.Scanner;
import java.util.Arrays;

public class Palindrome {
	public static void main(String[] args) {

		//Asks for a number
		Scanner in = new Scanner(System.in);
		System.out.println("please enter a number between 0 and 1,000,000,000");
		int n = in.nextInt();

		//Checks numer's validity
		while (n < 0 || n > 1000000000) {
			System.out.println("please enter a valid number");
			n = in.nextInt();

		}

		in.close();

		//Calculates array's length
		int arrLength;

		if (n < 100000) {
			if (n < 100) {
				if (n < 10)
					arrLength = 1;
				else
					arrLength = 2;
			} else {
				if (n < 1000)
					arrLength = 3;
				else {
					if (n < 10000)
						arrLength = 4;
					else
						arrLength = 5;
				}
			}
		} else {
			if (n < 10000000) {
				if (n < 1000000)
					arrLength = 6;
				else
					arrLength = 7;
			} else {
				if (n < 100000000)
					arrLength = 8;
				else {
					if (n < 1000000000)
						arrLength = 9;
					else
						arrLength = 10;
				}
			}
		}


		//Separates the digits of the number into a new array
		int[] digits = new int[arrLength];

		digits[0] = n / (int) Math.pow(10, arrLength - 1);

		int pos = 1;

		while (pos < (arrLength)) {
			digits[pos] = ((n / (int) Math.pow(10, arrLength - 1 - pos)) % 10);

			pos++;
		}

		int c = 0;
		int tmp = arrLength;
		
		//Checks if the number is palindrome
		while (c < tmp){
			if( digits[c] == digits[tmp-1] ){
				c++;
				tmp--;
				} else {
				
					System.out.println("The number is not a Palindrome. Thank you.");
					System.exit(0);
			
			}
		}
		//Shows results
		System.out.println("Input: " + n);
		System.out.println("Size: " + arrLength);
		System.out.print("First Part: ");
		
		for (int i = 0; i <= (arrLength-1) /2; i++) {
			System.out.print(digits[i] + " ");
		}
		
		System.out.println(" ");
		
		System.out.print("Second Part: ");
		
		for (int z = (arrLength)/2 ; z < arrLength; z++) {
			System.out.print(digits[z] + " ");
			
		}
	}
}
