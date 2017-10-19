import java.util.Scanner;

public class Number {
	Scanner input = new Scanner(System.in);
	
	private int[] value;
	
	public int[] getValue() {
		return this.value;
	}
	
	public int getLength() {
		return this.value.length;
	}
	
	public void getInputFor(String purpose) {
		System.out.print("Please enter " + purpose + " number: ");
		int userInput = input.nextInt();
		while (userInput < 1 || userInput > 1000000000) {
			System.out.print("Number should be from 1 to 1,000,000,000. Please try again.");
			userInput = input.nextInt();
		}
		this.setValue(userInput);
	}
	
	public void setValue(int input) {
		int digitCounter = 0;
		int tempInput = input;
		while (tempInput > 0) {
			tempInput /= 10;
			digitCounter++;
		}
		this.value = new int[digitCounter];
		for (int i = value.length - 1; i >= 0; i--) {
			this.value[i] = input % 10;
			input /= 10;
		}
	}
	
	public void rotate() {
		int lastDigit = this.value[this.value.length - 1];
		for (int i = this.value.length - 1; i > 0; i--) {
			this.value[i] = this.value[i-1];
		}
		this.value[0] = lastDigit;
	}
}