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
		this.seconds = 53;
		this.minutes = 7;
		this.hours = 14;
	}
	
	 /* Comment for addMilliseconds, addSeconds and addMinutes when working with negative parameters
	 At all methods we handle 3 possible situations:
	 1. If the absolute value of negative parameter bigger than class member value, we turn next value back
	 2. If the negative parameter bigger than one turn, we use special addition operation
	 3. All the other situations are handled by default operation (just addition of negative number) */
	
	public void addMilliseconds(int ms) {
		if (ms > - 1000000000 || ms < 1000000000) {
			int seconds = (this.milliseconds + ms) / 1000;
			this.addSeconds(seconds);
			if (ms < 0 && -this.milliseconds > ms % 1000) {
				this.milliseconds = 1000 + (this.milliseconds + ms % 1000);
				hours -= 1;
			} else if (ms < -999) {
				this.milliseconds += ms % 1000; 
			} else {
				this.milliseconds = (this.milliseconds + ms) % 1000;												
			}
		}
	}
	
	public void addSeconds(int sec) {
		if (sec > - 1000000000 || sec < 1000000000) {
			int minutes = (this.seconds + sec) / 60;
			this.addMinutes(minutes);
			if (sec < 0 && -this.seconds > sec % 60) {
				this.seconds = 60 + (this.seconds + sec % 60);
				hours -= 1;
			} else if (sec < -59) {
				this.seconds += sec % 60; 
			} else {
				this.seconds = (this.seconds + sec) % 60;												
			}
		}
	}
	
	public void addMinutes(int mins) {
		if (mins > - 1000000000 || mins < 1000000000) {
			int hours = (this.minutes + mins) / 60;
			this.addHours(hours);
			if (mins < 0 && -this.minutes > mins % 60) {
				this.minutes = 60 + (this.minutes + mins % 60);
				hours -= 1;
			} else if (mins < -59) {
				this.minutes += mins % 60; 
			} else {
				this.minutes = (this.minutes + mins) % 60;												
			}
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
