package clock;

/**
 * This class will represent a 24-hours clock up to micro-seconds precision
 * (1000 millisecond = 1 second). That means that it will represent hours of the
 * form "HH:MM:SS.mmm", where HH - represents the hours in 24 format. Range:
 * [0-23] MM - represents the minutes. Range: [0-59] SS - represents the
 * seconds. Range: [0-59] sss - represents the micro-seconds. Range: [0-999]
 *
 * It will have 2 constructors: 1. One constructor with 4 parameters: hours,
 * minutes, seconds and milliseconds. Assume the input is always valid for this
 * constructor 2. One constructor with no parameters. This will initialize the
 * clock to 14:07:53.980
 *
 * It will have these methods: 1. addHours - with a single parameter which
 * represents the number of hours to add. It will add the hours only if it's in
 * the range [0..1,000,000,000]. No value is returned 2. addMinutes - with a
 * single parameter which represents the number of minutes to add. It will add
 * the minutes only if it's in the range [0..1,000,000,000]. No value is
 * returned 3. addSeconds - with a single parameter which represents the number
 * of seconds to add. It will add the seconds only if it's in the range
 * [0..1,000,000,000]. No value is returned 4. addMilliseconds - with a single
 * parameter which represents the number of milliseconds to add. It will add the
 * milliseconds only if it's in the range [0..1,000,000,000]. No value is
 * returned
 * 
 * 5. print - with a single boolean parameter which represents if we want to
 * display a 24 hours clock or 12 hours clock. If a 12 hours clock is chosen it
 * will add "AM/PM" at the end of the input. NOTE: the printout should include
 * leading zeros (don't use any formatting methods !!) For example: 12:3:9.56
 * --> 12:03:09.056
 *
 * The implementation must NOT use any external classes (except for the
 * printout) BONUS 1: change the addHours, addMinutes, addSeconds and
 * addMilliseconds methods to accept arguments within the range [-1,000,000,000
 * .. 1,000,000,000]. Meaning: negative values are allowed. For example, adding
 * (-1) seconds to 00:00:00.000 will take the clock back to 23:59:59.000 BONUS
 * 2: the same functionality as in "BONUS 1" while using as few member variables
 * / memory as possible
 */
public class Clock {
	private int hours;
	private int minutes;
	private int seconds;
	private int milliSeconds;

	public Clock(int hours, int minets, int seconds, int milliSecond) {
		this.hours = hours;
		this.minutes = minets;
		this.seconds = seconds;
		this.milliSeconds = milliSecond;

	}

	public Clock() {
		this.hours = 14;
		this.minutes = 7;
		this.seconds = 53;
		this.milliSeconds = 980;
	}

	public void addHours(int hours) {
		if (theInputIsValid(hours)) {
			add(hours, 0, 0, 0);
		} else {
			System.out.println("error the number you enterd is out of range [0 - 1000000000]");

		}

	}

	public void addMinutes(int minutes) {
		if (theInputIsValid(minutes)) {
			add(0, minutes, 0, 0);
		} else {
			System.out.println("error the number you enterd is out of range [0 - 1000000000]");

		}

	}

	public void addSeconds(int seconds) {
		if (theInputIsValid(seconds)) {
			add(0, 0, seconds, 0);
		} else {
			System.out.println("error the number you enterd is out of range [0 - 1000000000]");

		}

	}

	public void addMilliSeconds(int milliSeconds) {
		if (theInputIsValid(milliSeconds)) {
			add(0, 0, 0, milliSeconds);
		} else {
			System.out.println("error the number you enterd is out of range [0 - 1000000000]");

		}

	}

	public void print(boolean clockDisplay) {// true == 24 hours display - false == 12 hours display
		if (clockDisplay) {
			printFormat(this.hours);
			System.out.println();
		} else {
			printFormat(this.hours - 12);
			if (this.hours > 12) {
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

	public void add(int hours, int minutes, int seconds, int milliSeconds) {
		int remaind = 0;
		int increase = 0;
		int[] increases = new int[3];

		if (outOfRange(this.milliSeconds + milliSeconds, (byte) 4)) {
			remaind = (this.milliSeconds + milliSeconds) % 1000;
			increases[0] = (this.milliSeconds + milliSeconds) / 1000;
			this.milliSeconds = remaind;
		} else {
			this.milliSeconds += milliSeconds;

		}

		if (outOfRange(this.seconds + seconds + increases[0], (byte) 3)) {
			remaind = (this.seconds + seconds + increases[0]) % 60;
			increases[1] = (this.seconds + seconds + increases[0]) / 60;
			this.seconds = remaind;

		} else {
			this.seconds += seconds + increases[0];

		}
		if (outOfRange(this.minutes + minutes + increases[1], (byte) 2)) {

			remaind = (this.minutes + minutes + increases[1]) % 60;
			increases[2] = (this.minutes + minutes + increases[1]) / 60;
			this.minutes = remaind;
		} else {

			this.minutes += minutes + increases[1];

		}
		if (outOfRange(this.hours + hours + increases[2], (byte) 1)) {
			remaind = (this.hours + hours) % 23;
			this.hours = remaind;

		} else {
			this.hours += hours + increases[2];

		}

	}

	public boolean outOfRange(int number, byte positionOnTheClock/* hours=1 minutes=2 second=3 millisecond=4 */) {
		if (positionOnTheClock == 1) {
			if (number < 0 || number > 23) {
				return true;
			}
		}
		if (positionOnTheClock == 2) {
			if (number < 0 || number > 59) {
				return true;
			}
		}
		if (positionOnTheClock == 3) {
			if (number < 0 || number > 59) {
				return true;
			}
		}
		if (positionOnTheClock == 4) {
			if (number < 0 || number > 999) {
				return true;
			}
		}

		return false;
	}

	public void printFormat(int numberOfHours) {

		System.out.print(numberOfHours + ":");
		if (this.minutes < 10) {
			System.out.print("0" + this.minutes + ":");
		} else {
			System.out.print(this.minutes + ":");
		}

		if (this.seconds < 10) {
			System.out.print("0" + this.seconds + ".");
		} else {
			System.out.print(this.seconds + ".");
		}
		if (this.milliSeconds < 10) {
			System.out.print("00" + this.milliSeconds);
		} else if (this.milliSeconds < 100 && this.milliSeconds > 10) {
			System.out.print("0" + this.milliSeconds);
		} else {
			System.out.print(this.milliSeconds);
		}

	}

}
