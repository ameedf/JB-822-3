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

import java.util.Scanner;

public class Grades {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		byte numOfStudents;
		byte[] grades;
		short gradesSum = 0;
		byte maxIndex = 0;
		byte minIndex = 0;

		System.out.print("Enter number of students: ");
		numOfStudents = input.nextByte();
		while (numOfStudents < 1 || numOfStudents > 100) {
			System.out.println("Only 1 to 100 students allowed. Please try again.");
			numOfStudents = input.nextByte();
		}
		grades = new byte[numOfStudents];

		for (byte i = 0; i < numOfStudents; i++) {
			System.out.print("Enter grade for student number " + (i+1) + ": ");
			byte currentGrade = input.nextByte();
			while (currentGrade < 1 || currentGrade > 100) {
				System.out.print("Grade can be only from 1 to 100. Please try again.");
				currentGrade = input.nextByte();
			}
			grades[i] = currentGrade;
			gradesSum += currentGrade;
		}

		for (byte i = 0; i < grades.length; i++) {
			if (grades[i] > grades[maxIndex]) {
				maxIndex = i;
			} else if (grades[i] < grades[minIndex]) {
				minIndex = i;
			}
		}

		System.out.println("The winner is student number " + (maxIndex + 1) + " and his grade is " + grades[maxIndex]);
		System.out.println("The loser is student number " + (minIndex + 1) + " and his grade is " + grades[minIndex]);
		System.out.println("Average class grade is " + (float) (gradesSum) / numOfStudents);
	}
}