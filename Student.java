import java.util.Scanner;

public class Student {
	Scanner input = new Scanner(System.in);
	
	private byte number;
	private byte grade;
	
	public void setNumber(byte num) {
		number = num;
	}
	
	public void setGrade(int gr) {
		while (gr < 1 || gr > 100) {
			System.out.print("You can only set grade from 1 to 100. Please try again: ");
			gr = input.nextInt();
		}
		
		grade = (byte) gr;
	}
	
	public byte getNumber() {
		return number;
	}
	
	public int getGrade() {
		return grade;
	}
	
}