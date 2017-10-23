package ameedf.jb8223.assignments.hw02;

/**
 * The same clock where minimum memory is occupied
 */
public class ClockBonus2 {
	private int milliseconds;

	// C-tor initialize time to 14:07:53.980
	public ClockBonus2() {
		// Convert to milliseconds
		this.milliseconds = (14 * 60 * 60 * 1000) + (7 * 60 * 1000) + (53 * 1000) + 980;
		System.out.println("this.milliseconds: " + this.milliseconds);
	}

	// C-tor initialize time by user input
	public ClockBonus2(int hours, int minutes, int seconds, int milliseconds) {
		this.milliseconds = hours * 60 * 60 * 1000;
		this.milliseconds += minutes * 60 * 1000;
		this.milliseconds += seconds * 1000;
		this.milliseconds += milliseconds;
	}

	public void addHours(int hours) {
		//Check for out of range
		hours /= 24; 
		this.milliseconds += hours * 60 * 60 * 1000;
	}

	public void addMinutes(int minutes) {
		this.milliseconds += minutes * 60 * 1000;
	}
	
	public void addSeconds(int seconds) {
		this.milliseconds += seconds * 1000;
	}
	
	public void addMilliseconds(int milliseconds) {
		this.milliseconds += milliseconds;
	}

	public void print(boolean is12) {
		String postfix = "";
		int tmp = this.milliseconds;

		// Parse from milliseconds
		int hours = tmp / (60 * 60 * 1000);
		tmp %= (60 * 60 * 1000);
		int minutes = tmp / (60 * 1000);
		tmp %= (60 * 1000);
		int seconds = tmp / 1000;
		int milliseconds = tmp % 1000;

		int hoursToShow = hours;
		if (is12) {
			if (hours < 12) {
				if (hours == 0) {
					hoursToShow = 12;
				}
				postfix = "AM";
			} else {
				postfix = "PM";
				hoursToShow -= 12;
			}
		}
		System.out.println("\n" + (hoursToShow < 10 ? "0" + hoursToShow : hoursToShow) + ":"
				+ (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds) + "."
				+ (milliseconds < 10 ? "00" + milliseconds : (milliseconds < 100 ? "0" + milliseconds : milliseconds))
				+ " " + postfix);
	}
}
