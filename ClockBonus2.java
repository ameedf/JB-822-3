package clock;

/**
 * The same clock where minimum memory is occupied
 */
public class ClockBonus2 {

	private int milliSeconds;

	public ClockBonus2(int hours, int minets, int seconds, int milliSecond) {
		this.milliSeconds += hours * 1000 * 60 * 60;
		this.milliSeconds += minets * 1000 * 60;
		this.milliSeconds += seconds * 1000;
		this.milliSeconds += milliSecond;

	}

	public ClockBonus2() {
		this.milliSeconds += 14 * 1000 * 60 * 60;
		this.milliSeconds += 7 * 1000 * 60;
		this.milliSeconds += 53 * 1000;
		this.milliSeconds += 980;
	}

	public void addHours(int hours) {
		if (theInputIsValid(hours)) {
			add(hours * 1000 * 60 * 60);
		} else {
			System.out.println("error the number you enterd is out of range [-1000000000 - 1000000000]");

		}

	}

	public void addMinutes(int minutes) {
		if (theInputIsValid(minutes)) {
			add(minutes * 1000 * 60);
		} else {
			System.out.println("error the number you enterd is out of range [-1000000000 - 1000000000]");

		}

	}

	public void addSeconds(int seconds) {
		if (theInputIsValid(seconds)) {
			add(seconds * 1000);
		} else {
			System.out.println("error the number you enterd is out of range [-1000000000 - 1000000000]");

		}

	}

	public void addMilliSeconds(int milliSeconds) {
		if (theInputIsValid(milliSeconds)) {
			add(milliSeconds);
		} else {
			System.out.println("error the number you enterd is out of range [-1000000000 - 1000000000]");

		}

	}

	public void print(boolean clockDisplay) {// true == 24 hours display - false == 12 hours display
		if (clockDisplay) {
			printFormat(returnTimeType(1));
			System.out.println();
		} else {
			printFormat((returnTimeType(1)) - 12);
			if ((returnTimeType(1) > 12)) {
				System.out.print(" PM");
			} else {
				System.out.print(" AM");
			}
			System.out.println();
		}

	}

	public boolean theInputIsValid(int number) {
		if (number < -1000000000 || number > 1000000000) {
			return false;
		} else {
			return true;
		}

	}

	public void add(int number) {
		this.milliSeconds += number;
		while (this.milliSeconds > 86399999) {
			this.milliSeconds -= 86400000;
		}
		while (this.milliSeconds < 0) {
			this.milliSeconds += 86400000;
		}

	}

	public void printFormat(int numberOfHours) {

		System.out.print(numberOfHours + ":");
		if (returnTimeType(2) < 10) {
			System.out.print("0" + returnTimeType(2) + ":");
		} else {
			System.out.print(returnTimeType(2) + ":");
		}

		if (returnTimeType(3) < 10) {
			System.out.print("0" + returnTimeType(3) + ".");
		} else {
			System.out.print(returnTimeType(3) + ".");
		}
		if (returnTimeType(4) < 10) {
			System.out.print("00" + returnTimeType(4));
		} else if (returnTimeType(4) < 100 && returnTimeType(4) > 10) {
			System.out.print("0" + returnTimeType(4));
		} else {
			System.out.print(returnTimeType(4));
		}

	}

	public int returnTimeType(int timePosition) {
		if (timePosition == 1) {
			return this.milliSeconds / 1000 / 60 / 60;

		} else if (timePosition == 2) {
			return (this.milliSeconds - (returnTimeType(1) * 1000 * 60 * 60)) / 1000 / 60;
		} else if (timePosition == 3) {
			return (this.milliSeconds - (returnTimeType(1) * 1000 * 60 * 60)
					- (returnTimeType(2) * 1000 * 60)) / 1000;
		} else if (timePosition == 4) {
			return (this.milliSeconds - (returnTimeType(1) * 1000 * 60 * 60) - (returnTimeType(2) * 1000 * 60)
					- (returnTimeType(3) * 1000));
		}
		return -1;
	}
}
