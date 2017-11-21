package ameedf.jb8223.assignments;

import java.util.Scanner;

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
public class Grades {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of students (1 to " + Integer.MAX_VALUE + "): ");
        int numberOfStudents = input.nextInt();

        while (numberOfStudents < 1) {
            System.out.println("The number of students is not in the range. Please try again");
            numberOfStudents = input.nextInt();
        }

        byte[] grades = new byte[numberOfStudents];
        double gradesSum = 0;
        int highestGradeIndex = 0;
        int lowestGradeIndex = 0;

        for (int index = 0; index < numberOfStudents; index++) {
            // ask the user to enter a grade
            System.out.print("Grade of student #" + (index + 1) + ": ");
            byte grade = input.nextByte();
            while (grade < 0 || grade > 100) {
                System.out.print("Grade can only be in the range [0, 100]. Please try again.");
                grade = input.nextByte();
            }

            // set the grades array, add to the grades total, and set the lowest / highest grades index
            grades[index] = grade;

            gradesSum += grade;

            if (grade < grades[lowestGradeIndex]) {
                lowestGradeIndex = index;
            }

            if (grade > grades[highestGradeIndex]) {
                highestGradeIndex = index;
            }
        }

        // close the resource
        input.close();

        System.out.println("Student #" + (highestGradeIndex + 1) + " has the highest grade : " + grades[highestGradeIndex]);
        System.out.println("Student #" + (lowestGradeIndex + 1) + " has the lowest grade : " + grades[lowestGradeIndex]);
        System.out.println("Average is: " + gradesSum / numberOfStudents);
    }
}
