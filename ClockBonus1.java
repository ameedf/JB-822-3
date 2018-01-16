package clock;

/**
 * The same clock where negative values are allowed to be added
 */
public class ClockBonus1 {
	private int hours;
	private int minutes;
	private int seconds;
	private int milliSeconds;

	public ClockBonus1(int hours, int minets, int seconds, int milliSecond) {
		this.hours = hours;
		this.minutes = minets;
		this.seconds = seconds;
		this.milliSeconds = milliSecond;

	}

	public ClockBonus1() {
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

	// this method update the numbers that received from
	// add(hours,minutes,seconds,milliSeconds) to the fields of clock
	public void add(int hours, int minutes, int seconds, int milliSeconds) {
		int remained = 0;
		int[] increasesDecreases = new int[3];// increase decrease the fields

		if (outOfRange(this.milliSeconds + milliSeconds, (byte) 4)) {
			remained = (this.milliSeconds + milliSeconds) % 1000; // store the remain of the milliSeconds
			if (remained < 0) {// if the remained<0 it means that the field that comes after this field most be
								// decreased
				if (this.milliSeconds == 0 && (this.milliSeconds + milliSeconds) / 1000 == 0) {// if the field in the
																								// minimum value and the
																								// number that we need
																								// to decrease is 1
					milliSeconds -= 1000;// decrease the number to a valid number to decrease the number in the next
											// field by -1
				}
				remained += 1000;// increase the remained to reset it to a valid number (not a negative)
				increasesDecreases[0] = -((this.milliSeconds - milliSeconds) / 1000);// saves the number that well
																						// decrease the next field
				this.milliSeconds = remained;// update the field

			} else {
				increasesDecreases[0] = (this.milliSeconds + milliSeconds) / 1000;
				this.milliSeconds = remained;
			}
		} else {

			this.milliSeconds += milliSeconds;

		}

		if (outOfRange(this.seconds + seconds + increasesDecreases[0], (byte) 3)) {
			remained = (this.seconds + seconds + increasesDecreases[0]) % 60;

			if (remained < 0) {
				if (this.seconds == 0 && (this.seconds + seconds) / 60 == 0) {
					seconds -= 60;
				}
				remained += 60;
				increasesDecreases[1] = -((this.seconds - seconds - increasesDecreases[0]) / 60);
				this.seconds = remained;
			} else {
				increasesDecreases[1] = (this.seconds + seconds + increasesDecreases[0]) / 60;
				this.seconds = remained;
			}
		} else {
			this.seconds += seconds + increasesDecreases[0];

		}

		if (outOfRange(this.minutes + minutes + increasesDecreases[1], (byte) 2)) {

			remained = (this.minutes + minutes + increasesDecreases[1]) % 60;

			if (remained < 0) {
				if (this.minutes == 0 && (this.minutes + minutes) / 60 == 0) {
					minutes -= 60;
				}
				remained += 60;
				increasesDecreases[2] = ((this.minutes + minutes + increasesDecreases[1]) / 60);
				this.minutes = remained;
			} else {
				increasesDecreases[2] = (this.minutes + minutes + increasesDecreases[1]) / 60;
				this.minutes = remained;
			}
		} else {
			this.minutes += minutes + increasesDecreases[1];
			if (increasesDecreases[1] < 0) {

			}

		}
		if (outOfRange(this.hours + hours + increasesDecreases[2], (byte) 1)) {
			remained = (this.hours + hours) % 24;
			if (remained < 0) {
				remained += 24;
			}
			this.hours = remained;

		} else {
			this.hours += hours + increasesDecreases[2];

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
