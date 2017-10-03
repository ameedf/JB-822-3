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

package hw2arrays;

import java.util.Scanner;

public class Grades {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter number of students:");
		String outMessage;
		byte numOfStud = in.nextByte();
		byte[] grades = new byte[numOfStud]; 
		
		for (byte i = 0; i < grades.length; i++) {
			System.out.print("Enter grade for student #" + i + ":");
			byte tmpGrade = in.nextByte();
			if(tmpGrade >= 0 && tmpGrade <= 100) {
				grades[i] = tmpGrade;
			} else {
				System.out.println("Error, please enter number between 0 and 100!");
				i--;
			}
		}
	
		byte maxGrade = grades[0];
		byte maxGradeIndex = 0;
		
		byte minGrade = grades[0];
		byte minGradeIndex = 0;
		
		short sum = grades[0];
		
		for (byte i = 1; i < grades.length; i++) {
			if(grades[i] > maxGrade) {
				maxGrade = grades[i];
				maxGradeIndex = i;
			}
			if(grades[i] < minGrade) {
				minGrade = grades[i];
				minGradeIndex = i;
			}
			sum += grades[i];
		}
		outMessage = "The student #" + maxGradeIndex + " got the highest grade and it's " + maxGrade + ".\n";
		outMessage += "The student #" + minGradeIndex + " got the lowest grade and it's " + minGrade + ".\n";
		outMessage += "The average of the grades it's " + (float)(sum/grades.length) + ".\n";
		System.out.println(outMessage);
	}
}
