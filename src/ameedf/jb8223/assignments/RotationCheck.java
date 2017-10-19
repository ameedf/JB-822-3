package src.ameedf.jb8223.assignments;

import java.util.Scanner;

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
 * Example #3: if the first number is 312 and the second number is 321, the program will print
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

        Scanner input = new Scanner(System.in);

        // get the numbers, validate input
        System.out.println("Please enter 2 numbers (not identical, in the range of 0..1,000,000,000)");
        System.out.printf("First number: ");
        long firstNum = input.nextLong();

        while (firstNum < 0 || firstNum > 1000000000) {
            System.out.printf("Enter a valid first number: ");
            firstNum = input.nextLong();
        }

        System.out.printf("Second number: ");
        long secondNum = input.nextLong();

        while (secondNum == firstNum || secondNum < 0 || secondNum > 1000000000) {
            System.out.printf("Enter a valid & different second number: ");
            secondNum = input.nextLong();
        }

        input.close();

        // if any of the numbers is zero, print & exit
        if (firstNum == 0 || secondNum == 0) {
            System.out.println("We cannot get from " + firstNum + " to " + secondNum +
                    " by performing any number of rotations");
            return;
        }

        // if not, find out the first number's num of digits
        long firstNumHolder = firstNum;
        byte numOfDigits = 0;

        while (firstNumHolder > 0) {
            firstNumHolder /= 10;
            numOfDigits++;
        }

        // enter the first number into firstNumArray
        byte[] firstNumArray = new byte[numOfDigits];
        firstNumHolder = firstNum;
        for (int i = firstNumArray.length-1 ; i >= 0 ; i--) {
            firstNumArray[i] = (byte)(firstNumHolder % 10);
            firstNumHolder /= 10;
        }

        // enter the first num into another helper shiftedNumArray, shift the numbers in it, count rotations
        byte[] shiftedNumArray = new byte[numOfDigits];
        byte numOfRotations = 0;

        /* we will stop shifting digits when we're back to normal 1st number, or when we have numbers parity
           in each rotation we'll move the last digit to be the first and re-build the shifted number
           firstNumArray will now be used to remember the state of shiftedNumArray after each rotation */

        while (numOfRotations < numOfDigits && firstNumHolder != secondNum){
            numOfRotations++;
            shiftedNumArray[0] = firstNumArray[firstNumArray.length - 1];
            firstNumHolder = shiftedNumArray[0];

            for (int i = 1; i < firstNumArray.length; i++) {
                shiftedNumArray[i] = firstNumArray[i - 1];
                firstNumHolder = firstNumHolder * 10 + shiftedNumArray[i];
            }
            firstNumArray = shiftedNumArray.clone();
        }

        //if the numbers match => print number of rotations, if not => print failure to match
        if (firstNumHolder == secondNum) {
            System.out.println("The number " + firstNum + " can be rotated " +
                    numOfRotations + " time(s) to get the number " + secondNum);
        }
        else {
            System.out.println("We cannot get from " + firstNum + " to " + secondNum +
                    " by performing any number of rotations");
        }
    }
}
