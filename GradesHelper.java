import java.util.ArrayList;
import java.util.Collections;
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
	
	public ArrayList<Student> sortStudents (ArrayList<Student> students) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getGrade() < students.get(0).getGrade()) {
				Collections.swap(students, i, 0);
			} else if (students.get(i).getGrade() > students.get((students.size() - 1)).getGrade()) {
				Collections.swap(students, i, (students.size() - 1));
			}
		}
		return students;
	}

	public int getAvgGrade (ArrayList<Student> students) {
		int sum = 0;
		for (Student student : students) {
			sum += student.getGrade();
		}
		return sum / students.size();
	}
}
