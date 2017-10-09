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
        System.out.printf("Please enter the number of students (up to 127 allowed): ");
        byte numOfStudents = input.nextByte();

        if (numOfStudents <= 0) {
            System.out.println("The number of students must be positive.");
            return;
        }

        byte studentsArray[] = new byte[numOfStudents];
        byte indexHighest = 0;
        byte indexLowest = 0;

        byte highest = 0;
        byte lowest = 100;
        float sum = 0;

        System.out.println("Please enter the grades (each in a new line) - ");

        for (byte i=0 ; i < studentsArray.length ; i++) {

            System.out.printf("Enter grade: ");
            short grade = input.nextShort();

            while (grade < 0 || grade > 100) {
                System.out.printf("Please enter a valid grade between 0 - 100: ");
                grade = input.nextShort();
            }

                if (highest < grade) {
                    highest = (byte)grade;
                    indexHighest = i;
                }
                if (lowest > grade) {
                    lowest = (byte)grade;
                    indexLowest = i;
                }
                studentsArray[i] = (byte)grade;
                sum += grade;
            }

        input.close();

        indexHighest++;
        indexLowest++;

        System.out.println("Student #" + indexHighest + " got the highest grade of " + highest);
        System.out.println("Student #" + indexLowest + " got the lowest grade of " + lowest);
        System.out.println("Average of all grades is: " + sum/numOfStudents);
    }
}
