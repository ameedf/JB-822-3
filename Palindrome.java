
import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inputNumber;
		int upperLimit = 1000000000;
		int arraySize = 0;
		int[] numbersArray;
		boolean numberValid = true;
		
		System.out.print("Enter your number: ");
		inputNumber = input.nextInt();
		while (inputNumber < 0 || inputNumber > upperLimit) {
			System.out.println("You can only enter value from 0 to " + upperLimit);
			inputNumber = input.nextInt();
		}
		
		for (int divisor = upperLimit; divisor > 1; divisor /= 10) {
			int currentNumber = (int) ((inputNumber % divisor) / (divisor / 10));
			if (currentNumber != 0) {
				arraySize++;
			} else {
				upperLimit /= 10;
			}
		}
		
		numbersArray = new int[arraySize];
		
		int currentDivisor = upperLimit;
		for (int i = 0; i < numbersArray.length; i++) {
			int currentNumber = (int) ((inputNumber % currentDivisor) / (currentDivisor / 10));
			numbersArray[i] = currentNumber;
			currentDivisor /= 10;
		}
		
		int middle = numbersArray.length / 2 + (1 * (numbersArray.length % 2));
		int maxIndex = numbersArray.length - 1;
		int[] leftSide = new int[middle];
		int[] rightSide = new int[middle];

		for (int minIndex = 0; minIndex <= maxIndex; minIndex++) {
			if (numbersArray[minIndex] == numbersArray[maxIndex]) {
				leftSide[minIndex] = numbersArray[minIndex];
				rightSide[minIndex] = numbersArray[middle + minIndex - (1 * (numbersArray.length % 2))];
			} else {
				System.out.println("This is not a Palindosomething. Please be more accurate. Next time.");
				numberValid = false;
				break;
			}
			maxIndex--;
		}
		
		if (numberValid) {
			System.out.print("Input: " + inputNumber + "\n" + "Output \n" + "Size: " + numbersArray.length + "\n");
			
			System.out.print("First part: ");
			for (int num : leftSide) {
				System.out.print(num + " ");
			};
			System.out.println("");
			System.out.print("Second part: ");
			for (int num : rightSide) {
				System.out.print(num + " ");
			};			
		}
		
	}
}