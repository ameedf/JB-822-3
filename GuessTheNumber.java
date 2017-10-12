
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
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
	public static void main(String[] args) {
		int numberOfSteps = 0, userId, theNumber, theNumberLength, userNumber = 0;
		int[] highScoreTable = new int[100];
		int[] highScoreTableSorted = new int[3];
		int choise = 0;
		Scanner in = new Scanner(System.in);

		do {
			numberOfSteps = 0;
			theNumber = 0;
			do {
				System.out.print("Enter Your ID from 1 to 100:");
				userId = in.nextInt();
			} while (userId < 1 || userId > 100);

			do {
				System.out.print("Enter the number of digits to guess, from 2 to 9:");
				theNumberLength = in.nextInt();
			} while (theNumberLength < 2 || theNumberLength > 9);

			// generate theNumber
			for (int i = 0; i < theNumberLength; i++) {
				Random rn = new Random();
				int randomNum;
				if (i == 0) {
					// first number can't be 0
					randomNum = rn.nextInt(9) + 1;
				} else {
					
					// Number must be with an unique digits.
					boolean flag = false;
					do {
						flag = false;
						randomNum = rn.nextInt(10);
						
						//Check if the generated random digit already exist in the prev. digits in the number.
						int tmpNum = 0, tmptheNumber = theNumber;
						for (int j = (theNumberLength - 1); (j > (theNumberLength - 1 - i) && flag == false); j--) {
							tmpNum = (int) (tmptheNumber / Math.pow(10, j));
							tmptheNumber = (int) (tmptheNumber % Math.pow(10, j));
							if (randomNum == tmpNum) {
								flag = true;
							}
						}
					} while (flag);
				}
				
				//Assign new unique digit to number.
				theNumber += randomNum * Math.pow(10, (theNumberLength - 1) - i);
			}
			
			// comment this line
			System.out.println("TheNumber:" + theNumber);
			
			// The game logic
			do {
				//For second+ steps generate information message.
				if (numberOfSteps > 0) {
					int tmptheNumberDigit, tmptheNumber = theNumber;
					int tmpuserNumberIndx = 0, tmpuserNumberDigit, tmpuserNumber = userNumber;

					int counterSamePosition = 0;
					int counterDifferentPosition = 0;
					
					//Count the guessed numbers for player notifications
					for (int j = 0; j < theNumberLength; j++) {
						tmpuserNumberDigit = (int) (tmpuserNumber / Math.pow(10, theNumberLength - 1 - j));
						tmpuserNumber = (int) (tmpuserNumber % Math.pow(10, theNumberLength - 1 - j));

						tmptheNumber = theNumber;
						for (int i = 0; i < theNumberLength; i++) {
							tmptheNumberDigit = (int) (tmptheNumber / Math.pow(10, theNumberLength - 1 - i));
							tmptheNumber = (int) (tmptheNumber % Math.pow(10, theNumberLength - 1 - i));
							if (tmpuserNumberDigit == tmptheNumberDigit) {
								if (i == j) {
									counterSamePosition++;
								} else {
									counterDifferentPosition++;
								}
							}
						}
					}
					System.out.println("\nYou entered: " + userNumber + ". You guessed: on the same position:"
							+ counterSamePosition + ", on the different position:" + counterDifferentPosition);
				}

				numberOfSteps++;

				// Check user input for same length as generated number.
				int counterUserNumberLenght = 0;
				do {
					System.out.print("Try to guess! Try #:" + numberOfSteps + ". Enter the " + theNumberLength
							+ "-digits number:");
					userNumber = in.nextInt();

					int tmpun = userNumber;
					counterUserNumberLenght = 0;
					while (tmpun > 0) {
						tmpun = tmpun / 10;
						counterUserNumberLenght++;
					}
				} while (theNumberLength != counterUserNumberLenght);

			} while (theNumber != userNumber);

			// Update highScoreTable
			highScoreTable[userId - 1] = numberOfSteps;
			
			System.out.print("Congratulations user number: " + userId + "! You win from " + numberOfSteps + " trays!");
			System.out.println("\n---- High-Scores Table -----");
			
			//Prepare player notifications from highScoreTable. 
			int topPlayersCounter = 0;
			for (int i = 0; i < highScoreTable.length; i++) {
				if (highScoreTable[i] > 0) {
					System.out.println("User #" + (i + 1) + " score: " + highScoreTable[i] + " trays!");
				}
				if (highScoreTable[i] < highScoreTable[userId - 1] && highScoreTable[i] > 0) {
					topPlayersCounter++;
				}

			}
			
			if (topPlayersCounter > 0) {
				System.out.print("\nThere are " + topPlayersCounter + " players with better scores!");
			} else {
				System.out.print("\nYou are at the top of the table!");
			}
			System.out.print("\nOne more game? Press 1 to game again or other digit for exit. ");
			choise = in.nextInt();

		} while (choise == 1);
		System.out.print("\nBy-By!");
	}
}
