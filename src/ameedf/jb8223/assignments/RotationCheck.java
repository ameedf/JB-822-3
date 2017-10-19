package ameedf.jb8223.assignments;

/**
 * INTRODUCTION:
 * Take a look at this number which is composed from 4 digits
 * +----+----+----+----+
 * | x1 | x2 | x3 | x4 |
 * +----+----+----+----+
 * Performing a rotation means moving the last digit (x4) to be the first one:
 * +----+----+----+----+
 * | x4 | x1 | x2 | x3 |
 * +----+----+----+----+
 * For example, the result of performing a rotation on 269 is 926, because "6" is the last digit
 * and it will move to be the first digit, so we put it before the first digit (2).
 * The result of performing a rotation on 926 is 692.
 * Performing a rotation for the third time will get us back to the original number: 269.
 * Another example: if we take the number 1218:
 * Rotation 1: 8121 ("8" is now the first digit, and the other digits moved to the right by one place)
 * Rotation 2: 1812
 * Rotation 3: 2181
 * Rotation 4: 1218 -- back to the original number
 *
 * YOUR MISSION:
 * You will write a program that will ask the user for 2 numbers.
 * It will then check if we can perform several rotations to get from the first number to the second number.
 * Example #1: if the first number is 1439 and the second number is 3914, the program will print
 * 'The number 1439 can be rotated 2 time(s) to get the number 3914'.
 * Example #2: if the first number is 41412 and the second number is 14124, the program will print
 * 'The number 41412 can be rotated 4 time(s) to get the number 14124'.
 * Example #2: if the first number is 312 and the second number is 321, the program will print
 * 'We cannot get from 312 to 321 by performing any number of rotations'.
 *
 * 1. The only mathematical operations allowed are "/" and "%"
 * 2. You should use arrays
 * 3. The user can't insert 2 identical numbers as an input
 * 4. The range of the input is 0..1,000,000,000
 * 5. The program should input the lowest number of rotations that will get us from one number to the other.
 *     For example, you can get from 1212 to 2121 by performing 1 or 3 rotations. The program should print
 *    'The number 1212 can be rotated 1 time(s) to get the number 2121'.
 *
 * Good luck !
 */
public class RotationCheck {
    public static void main(String[] args) {
        // TODO: enter your code here :)
    Scanner input = new Scanner(System.in);
		int maxvalue = 1_000_000_000;
		System.out.println("Pls enter 2 numbers in range of 0 - " + maxvalue + " - ");
		System.out.print("Enter Number #1 : ");

		// Checking if number #1 is in range -
		int Num1 = input.nextInt();
		while (Num1 < 0 || Num1 > maxvalue) {
			System.out.println("Number is out of range ! (0  " + maxvalue + " )");
			System.out.print("Enter Number #1 : ");
			Num1 = input.nextInt();
		}
		System.out.print("Enter Number #2 : ");
		int Num2 = input.nextInt();
		// Checking if number #2 is in range -
		while (Num2 < 0 || Num2 > maxvalue) {
			System.out.println("Number is out of range ! (0 - " + maxvalue + " )");
			System.out.print("Enter Number #2 : ");
			Num2 = input.nextInt();
		}
		// Checking if number #1 and number #2 are identical + if number #2 is in range
		// -
		// is there a better way to write this condition ??
		while (Num1 == Num2) {
			System.out.println("The Numbers cannot be identical");
			System.out.print("Enter Number #2 : ");
			Num2 = input.nextInt();
			while (Num2 < 0 || Num2 > maxvalue) {
				System.out.println("Number is out of range ! (0 - " + maxvalue + " )");
				System.out.print("Enter Number #2 : ");
				Num2 = input.nextInt();
			}

		}
		// Length of number #1
		int tempNum1, LengthNum1 = 0;
		tempNum1 = Num1;
		while (tempNum1 > 0) {
			tempNum1 /= 10;
			LengthNum1++;
		}
		// Length of number #2
		int tempNum2, LengthNum2 = 0;
		tempNum2 = Num2;
		while (tempNum2 > 0) {
			tempNum2 /= 10;
			LengthNum2++;
		}
		// Create an Array for Number#1 + putting each digit in the array#1
		int LengthTemp1 = LengthNum1;
		int DigitsNum1 = 0;
		int[] arraynum1 = new int[LengthNum1];
		for (int i = 0; i < LengthNum1; i++) {
			DigitsNum1 = Num1 % 10;
			arraynum1[LengthTemp1 - 1] = DigitsNum1;
			LengthTemp1--;
			Num1 /= 10;
		}
		// Create an Array for Number#2 + putting each digit in the array#2
		int LengthTemp2 = LengthNum2;
		int DigitsNum2 = 0;
		int[] arraynum2 = new int[LengthNum2];
		for (int i = 0; i < LengthNum2; i++) {
			DigitsNum2 = Num2 % 10;
			arraynum2[LengthTemp2 - 1] = DigitsNum2;
			LengthTemp2--;
			Num2 /= 10;
		}
		// Checking if the length of the number is equal
		if (LengthNum1 != LengthNum2) {
			System.out.println("The length of the numbet isn't equal - don't need to rotate & check the numbers !");
		}
		// Checking if the number are equal after rotating
		else {
			while (Num1 != Num2) {
				for (int i = 0; i < LengthNum1 - 1; i++) {
					int LengthNum1Temp = LengthNum1;
					arraynum1[LengthNum1Temp - 1] = arraynum1[i];
					LengthNum1Temp--;
		// I Got Stuck !

				}
			}
		}
    }
}
