
public class RotationCheck {
	public static void main(String[] args) {
		System.out.print("welcome...");
		System.out.println("Rotation Check");
		NumbersScanner input = new NumbersScanner();
		input.scanTheNumbers();
		CheckTheRotation check = new CheckTheRotation(input.getFirstNumber(), input.getSecondNumber());	
		check.rotationCheck();
	}

}
