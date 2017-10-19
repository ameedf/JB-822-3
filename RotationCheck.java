import java.util.Arrays;

public class RotationCheck {
	public static void main(String[] args) {
		Number originalNumber = new Number();
		Number rotatableNumber = new Number();
		
		originalNumber.getInputFor("original");
		
		boolean rotatableNumberValid = false;
		while (!rotatableNumberValid) {
			rotatableNumber.getInputFor("rotatable");
			if (originalNumber.getLength() == rotatableNumber.getLength()) {
				rotatableNumberValid = true;
			} else {
				System.out.print("The numbers should have equal lengths. Please enter rotatable number again.");
			}
		}
		
		int rotations = 0;
		while (rotations < originalNumber.getLength()) {
			rotatableNumber.rotate();
			rotations++;
			if (Arrays.equals(rotatableNumber.getValue(), originalNumber.getValue())) {
				System.out.println("It took " + rotations + " rotations to get to original number!");
				return;
			}
		}
		
		System.out.println("These numbers are not rotatable!");
	}
}
