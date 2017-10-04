/**
 * Write a program that will compute some statistics about students grades.

 * It will ask the user to enter the number of students.
 * Then, the program will ask the user to enter the grades one by one.
 * The range of each grade is an integer between 0 and 100.
 * Make sure to use an array where the type is the closest to this range (hint: don't use an array of "int"'s).
 * If the user enters a number which is not in range, the program will ask him to enter a new grade.
 * Once the user entered all the grades, the program will print:
 * 1. The highest grade and its index (something like: the student #10 got the highest grade and it's 98).
 * 2. The lowest grade and its index (something like: the student #3 got the lowest grade and it's 13).
 * 3. The average of the grades
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Grades {
	public static void main(String[] args) {
		// Setting up application
		ArrayList<Student> students = new ArrayList<Student>();
		GradesHelper helper = new GradesHelper();
		Scanner input = new Scanner(System.in);
		
		// Getting number of students from user input
		System.out.print("Enter number of students: ");
		int inputNumber = input.nextInt();
		byte numOfStudents = helper.validateNumber(inputNumber);

		// Assigning student grades from user input
		for (byte i = 0; i < numOfStudents; i++) {	
			Student currentStudent = new Student();
			currentStudent.setNumber((byte) (i+1));
			
			System.out.print("Enter grade for student number " + currentStudent.getNumber() + ": ");
			int inputGrade = input.nextInt();
			byte currentGrade = helper.validateGrade(inputGrade);
			currentStudent.setGrade(currentGrade);
			
			students.add(currentStudent);
		}
		
		// Print results
		Student minGradeStudent = helper.getMinGradeStudent(students);
		Student maxGradeStudent = helper.getMaxGradeStudent(students);
		
		System.out.println("Minimum grade " + minGradeStudent.getGrade() + " has student number " + minGradeStudent.getNumber());
		System.out.println("Maximum grade " + maxGradeStudent.getGrade() + " has student number " + maxGradeStudent.getNumber());
		System.out.println("Avarage class grade is " + helper.getAvgGrade(students));
	}
}