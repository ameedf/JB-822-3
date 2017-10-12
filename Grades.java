import java.util.Scanner;
import java.util.Arrays;

public class Grades {

    public static void main(String[] args) {
    

		// ask for number of grades
		Scanner in = new Scanner(System.in);
		System.out.println("How many grades would you like to enter?");
		// user input how many grades user would like to enter
		int n = in.nextInt();

		int[] grades = new int[n];

		System.out.println("Please enter the grades. Each between 0 an 100");

		// checks grades' validity
		int c = 0;
		while (c < n) {

			byte g = in.nextByte();

			if (g >= 0 && g <= 100) {

				grades[c] = g;
				c++;

			} else {

				System.out.println("Please enter a valid grade");

			}
		}

		in.close();
		

		int a = 0;
		int lwst = grades[0];
		int lwstPos = 0;
		int hst = 0;
		int hstPos = 0;
		int sum = 0;
		int avg = 0;

		while (a < n) {

			// Finds lowest grade
			if (lwst > grades[a]) {
				lwst = grades[a];
				lwstPos = a;
			}

			// Finds highest grade
			sum = sum + grades[a];

			if (hst < grades[a]) {

				hst = grades[a];
				hstPos = a;
				a++;

			} else {
				a++;
			}

		}
		//Callculates Average
		avg = sum / n;
		
		System.out.println("The highest grade is " + hst + " and it's position in the array is " + hstPos);
		System.out.println("The lowest grade is " + lwst + ", and it's position in the array is " + lwstPos);
		System.out.println("The total avarage is " + avg + ".");

	}
   
}
