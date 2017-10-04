import java.util.ArrayList;
import java.util.Scanner;

public class GradesHelper {
	Scanner input = new Scanner(System.in);
	
	public byte validateNumber(int number) {
		while (number < 1 || number > 100) {
			System.out.print("You can only have from 1 to 100 students. Please try again: ");
			number = input.nextInt();
		}
		return (byte) number;
	}
	
	public byte validateGrade(int grade) {
		while (grade < 1 || grade > 100) {
			System.out.print("You can only set grade from 1 to 100. Please try again: ");
			grade = input.nextByte();
		}
		return (byte) grade;
	}
	
	public Student getMinGradeStudent (ArrayList<Student> students) {
		Student minGradeStudent = students.get(0);
		for (Student student : students) {
			if (student.getGrade() < minGradeStudent.getGrade()) {
				minGradeStudent = student;
			}
		}
		return minGradeStudent;
	}
	
	public Student getMaxGradeStudent (ArrayList<Student> students) {
		Student maxGradeStudent = students.get(0);
		for (Student student : students) {
			if (student.getGrade() > maxGradeStudent.getGrade()) {
				maxGradeStudent = student;
			}
		}
		return maxGradeStudent;
	}
	
	public int getAvgGrade (ArrayList<Student> students) {
		int sum = 0;
		for (Student student : students) {
			sum += student.getGrade();
		}
		return sum / students.size();
	}
}
