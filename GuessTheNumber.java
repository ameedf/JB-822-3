
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
import java.util.Scanner;

public class GuessTheNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter number of digits for the game (2 to 10): ");
		int targetNumberSize = input.nextInt();
		while (targetNumberSize < 2 || targetNumberSize > 10) {
			System.out.println("You can only enter value from 2 to 10. Please try again.");
			targetNumberSize = input.nextInt();
		}

		int[] userGuessArray = new int[targetNumberSize];
		int[] targetNumber = new int[targetNumberSize];
		for (int i = 0; i < targetNumberSize; i++) {
			targetNumber[i] = 10;
		}

		// Generate target number
		for (int i = 0; i < targetNumberSize; i++) {
			int digitToAdd = (int) (Math.random() * 10);
			for (int j = 0; j < targetNumberSize; j++) {
				if (digitToAdd == targetNumber[j]) {
					digitToAdd = (int) (Math.random() * 10);
					j = -1;
				}
			}
			targetNumber[i] = digitToAdd;
		}

		// Start of game loop
		boolean guessed = false;
		int[] trials = new int[100];
		int[] trialsCorrectPlaces = new int[100];
		int[] trialsCorrectNumbers = new int[100];
		int trialIndex = 0;

		while (!guessed) {
			if (trialIndex != 0) {
				System.out.println("Before new guess, here are your previous trials: ");
				for (int i = 0; i < trialIndex; i++) {
					System.out.print("Trial number " + (i + 1) + ": " + trials[i] + ". ");
					System.out.println(trialsCorrectNumbers[i] + " correct numbers, " + trialsCorrectPlaces[i]
							+ " of them at the right place!");
				}
			}

			// Get user guess and validate its size
			int inputGuessSize = 0;
			int inputGuess;
			int userGuess = 0;

			while (inputGuessSize != targetNumberSize) {
				System.out.print("Enter your guess (" + targetNumberSize + " numbers): ");
				inputGuess = input.nextInt();
				userGuess = inputGuess;

				while (inputGuess > 0) {
					inputGuessSize++;
					inputGuess /= 10;
				}
				if (inputGuessSize != targetNumberSize) {
					System.out
							.println("Your guess should consist of " + targetNumberSize + " digits! Please try again.");
					inputGuessSize = 0;
				}
			}
			trials[trialIndex] = userGuess;

			// Convert user input into array
			int j = targetNumber.length - 1;
			while (j > -1) {
				userGuessArray[j] = userGuess % 10;
				userGuess /= 10;
				j--;
			}

			// Check user guess
			int correctPlace = 0;
			int correctNumber = 0;
			for (int i = 0; i < targetNumber.length; i++) {
				if (targetNumber[i] == userGuessArray[i]) {
					correctPlace++;
					trialsCorrectPlaces[trialIndex] = correctPlace;
				}
				for (int num : targetNumber) {
					if (num == userGuessArray[i]) {
						correctNumber++;
						trialsCorrectNumbers[trialIndex] = correctNumber;
					}
				}
			}
			if (correctPlace == targetNumberSize) {
				System.out.println(
						"This is correct number! Congratulations! It took you " + (trialIndex + 1) + " trials to guess!");
				guessed = true;
			} else {
				System.out.println("You have guessed " + correctNumber + " numbers, " + correctPlace
						+ " of them at the right place!");
				trialIndex++;
			}
		} // End of game loop
	}
}
