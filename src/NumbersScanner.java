import java.util.Scanner;

public class NumbersScanner {
	private int firstNumber;
	private int secondNumber;
	private Scanner input;

	public NumbersScanner() {
		
	}

	public int getFirstNumber() {
		return this.firstNumber;
	}

	public int getSecondNumber() {
		return this.secondNumber;
	}

	public void scanTheNumbers() {

		System.out.print("Enter the first number between [0-1000000000] : ");
		this.firstNumber = validNumber(getFirstNumber());

		System.out.print("Enter the second number between [0-1000000000] : ");
		this.secondNumber = validNumber(getSecondNumber());

	}

	public int validNumber(int number) {
		input = new Scanner(System.in);
		boolean numberIsValid = false;

		while (numberIsValid == false) {

			number = input.nextInt();
			numberIsValid = checkIfTheNumberIsCorrect(number);
		}
		
		return number;

	}

	public boolean checkIfTheNumberIsCorrect(int number) {

		if (number < 0 || number > 1000000000) {
			System.out.println("Error Number must be between [0-1000000000] ");
			System.out.println("Enter anther number : ");
			return false;
		} else {
			return true;
		}

	}

}
