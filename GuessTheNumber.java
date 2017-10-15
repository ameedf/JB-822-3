import java.util.Random;
import java.util.Scanner;

/**
 * Your assignment is to create the game "Guess The Number". Here's a description of the game:
 * (Taken from "http://www.goobix.com/games/guess-the-number/")
 * Guess The Number is a game where you must use your logic in order to guess a 4-digit secret number
 * selected by the computer at the beginning of the game. The number is formed with digits from 0 to 9;
 * each digit appears once at most. This number is guessed by you via multiple attempts. An attempt
 * consists in a proposed number, selected by you, and the computer's reply. The computer must tell you,
 * in his reply, how many digits have you guessed on the same position, and how many digits have you
 * guessed on a different position. Using information from the computer's reply, you must guess the
 * number using as few moves as possible.
 * <p>
 * 1. Your implementation must be done using ONLY thing we've learned
 * 2. BEFORE entering a new guess by the user, the program will show the previous guesses and their results
 *
 * BONUS: add some more statistics about the users:
 * At the beginning of a new game, the user is asked to enter his unique number (from 1 to 100)
 * The user is given the chance to enter the number of digits to guess (not only 4)
 * When the user finally guesses the digits, the number of steps will be updated in the high-scores table
 * The user will be told about his position in the high-scores table at the end of his game (for example,
 * "There are X players with better scores") or if he's at the top of the table.
 * Before the next game, the top 3 scores (which are greater than 0) will be printed
 */
public class GuessTheNumber {

    private static byte move = 0;
    private static byte samePosition;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        byte[] baseArray = new byte[4];
        byte[] guessArray = new byte[4];
        int guessedNumber;

        System.out.printf("Guess the number: start a new game? Yes / No : ");
        String confirm = input.next();

        if (!confirm.matches("Yes") && (!confirm.matches("yes")) && (!confirm.matches("y"))) {
            return;
        }

        System.out.println("A 4-digit number has been chosen. Only digits 0-9 are allowed without duplicates.\n" +
                "This number is guessed by you via multiple attempts. An attempt consists in a guessed number \n" +
                "and the computer's reply. The computer must tell you how many digits have you guessed\n" +
                "on the same position, and how many digits have you guessed on a different position. \n" +
                "using that reply you must guess the number using as few moves as possible. Good luck! \n");

        baseArray = populateBaseArray(baseArray);

        while (samePosition != 4) {
            guessedNumber = getUserGuess(input);
            guessArray = populateGuessArray(guessArray, guessedNumber);
            samePosition = tryUserGuess(baseArray,guessArray);
        }
        System.out.println("You've guessed the number, Good Job!");
    }

    private static byte[] populateBaseArray(byte[] baseArray) {

        Random randomNum = new Random();
        byte[] numbersUsed = new byte[10];
        int i = 0;
        int nextInt;

        System.out.printf("Computer's num: (");

        while (i < baseArray.length) {
            nextInt = randomNum.nextInt(10);
            if (nextInt != 0 && numbersUsed[nextInt] == 0) {
                baseArray[i] = (byte)nextInt;
                numbersUsed[nextInt] = 1;
                System.out.printf(baseArray[i] + " ");
                i++;
            }
        }
        System.out.printf(")  <== this printout is for debugging purpose only");
        return baseArray;
    }

    private static int getUserGuess(Scanner input) {
        System.out.printf("\nEnter your guess : ");
        int guessedNumber = input.nextInt();
        int isNumberValid = checkInputNumberValidity(guessedNumber);
        while (isNumberValid == 0) {
            System.out.printf("Enter a valid 4-digits guess: ");
            guessedNumber = input.nextInt();
            isNumberValid = checkInputNumberValidity(guessedNumber);
        }
        return guessedNumber;
    }

    private static int checkInputNumberValidity(int guessedNumber) {

        int numDigits = 0;
        byte[] numbersUsed = new byte[10];
        byte numbersUsedIndex;
        boolean duplicatesUsed = false;
        int guessedNumberHolder = guessedNumber;

        while (guessedNumberHolder != 0) {
            numbersUsedIndex = (byte) (guessedNumberHolder % 10);
            guessedNumberHolder = guessedNumberHolder / 10;
            if (numbersUsed[numbersUsedIndex] == 0) {
                numbersUsed[numbersUsedIndex] = 1;
                numDigits++;
            } else {
                duplicatesUsed = true;
            }
        }
        if (numDigits !=4 || duplicatesUsed){
            return 0;
        }
        else {
            return guessedNumber;
        }
    }

    private static byte[] populateGuessArray(byte[] guessArray, int guessedNumber) {

        for (int i = guessArray.length-1; i >= 0 ; i--) {
            guessArray[i] = (byte)(guessedNumber % 10);
            guessedNumber = guessedNumber / 10;
        }
        return guessArray;
    }

    private static byte tryUserGuess(byte[] baseArray, byte[] guessArray) {

        samePosition = 0;
        byte differentPosition = 0;

        for (int i = 0 ; i < baseArray.length ; i++) {
            for (int j = 0 ; j < guessArray.length ; j++) {
                if (guessArray[j] == baseArray[i]) {
                    if (j == i) {
                        samePosition++;
                    }
                    else {
                        differentPosition++;
                    }
                }
            }
        }
        move++;
        System.out.print("Move " + move + ": ");
        System.out.println(samePosition + " in same position  | " + differentPosition + " in different position");
        return samePosition;
    }
}
