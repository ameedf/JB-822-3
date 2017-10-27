package ameedf.jb8223.assignments.hw02;

/**
 * The same clock where negative values are allowed to be added
 */
public class ClockBonus1 {
	private int milliseconds;
	private int seconds;
	private int minutes;
	private int hours;
	
	public ClockBonus1(int milliseconds, int seconds, int minutes, int hours) {
		this.milliseconds = milliseconds;
		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
	}
	
	public ClockBonus1() {
		this.milliseconds = 980;
		this.seconds = 7;
		this.minutes = 53;
		this.hours = 14;
	}
	
 /* Comment for addMilliseconds, addSeconds and addMinutes when working with negative parameters:
  * Default behavior can handle negative input if absolute value of the input less than value of current member variable.
  * In the opposite case, we calculate new value by subtracting ((value + input) % 60) from 60, then shifting next time value back.
  */
	
	public void addMilliseconds(int ms) {
		if (ms > - 1000000000 || ms < 1000000000) {
			if (ms > - 1000000000 || ms < 1000000000) {
				int secondsToAdd = (this.milliseconds + ms) / 1000;
				if (ms < 0 && -this.milliseconds > ms) {
					this.milliseconds = 1000 + ((this.milliseconds + ms) % 1000);
					secondsToAdd -= 1;
				} else {
					this.milliseconds = (this.milliseconds + ms) % 1000;	
				}
				this.addSeconds(secondsToAdd);
			}		
		}
	}
	
	public void addSeconds(int sec) {
		if (sec > - 1000000000 || sec < 1000000000) {
			int minutesToAdd = (this.seconds + sec) / 60;
			if (sec < 0 && -this.seconds > sec) {
				this.seconds = 60 + ((this.seconds + sec) % 60);
				minutesToAdd -= 1;
			} else {
				this.seconds = (this.seconds + sec) % 60;	
			}
			this.addMinutes(minutesToAdd);
		}		
	}
	
	public void addMinutes(int mins) {
		if (mins > - 1000000000 || mins < 1000000000) {
			int hoursToAdd = (this.minutes + mins) / 60;
			if (mins < 0 && -this.minutes > mins) {
				this.minutes = 60 + ((this.minutes + mins) % 60);
				hoursToAdd -= 1;
			} else {
				this.minutes = (this.minutes + mins) % 60;	
			}
			this.addHours(hoursToAdd);
		}
	}
	
	public void addHours(int hrs) {
		if (hrs > - 1000000000 || hrs < 1000000000) {
			this.hours = (this.hours + (hrs % 24)) % 24;			
		}
	}
	
	public void print(boolean format12) {
		// Handle AM/PM format
		int hoursOutput = this.hours;
		String daytimeOutput = "";
		if (format12) {
			if (this.hours <= 12) {
				daytimeOutput = "AM";
			} else {
				hoursOutput -= 12;
				daytimeOutput = "PM";
			}
		}
		
		// Handle prefixes for MM:SS:sss
		String secondsPrefix = "";
		String minutesPrefix = "";
		String millisecondsPrefix = "";
		
		// Handle Milliseconds prefix
		if (milliseconds < 100) {
			millisecondsPrefix += "0";
			if (milliseconds < 10) {
				millisecondsPrefix += "0";
			}
		}
		
		// Handle Seconds prefix
		if (seconds < 10) {
			secondsPrefix = "0";
		}
		
		// Handle Minutes prefix
		if (minutes < 10) {
			minutesPrefix = "0";
		}
		
		System.out.println(hoursOutput + ":" + minutesPrefix + this.minutes + ":" 
				+ secondsPrefix + this.seconds + ":" + millisecondsPrefix + this.milliseconds + " " + daytimeOutput);
	}
}
