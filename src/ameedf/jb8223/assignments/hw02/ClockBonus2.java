package ameedf.jb8223.assignments.hw02;

/**
 * The same clock where minimum memory is occupied
 */
public class ClockBonus2 {
	int milliseconds;
	
	public ClockBonus2(int milliseconds, int seconds, int minutes, int hours) {
		this.milliseconds = milliseconds + (seconds * 1000) + (minutes * 60 * 1000) + (hours * 60 * 60 * 1000);
	}
	
	public ClockBonus2() {
		this.milliseconds = 980 + (53 * 1000) + (7 * 60 * 1000) + (14 * 60 * 60 * 1000);
	}
	
	public void addMilliseconds(int ms) {
		if (ms > 0 || ms < 1000000000) {
			this.milliseconds += ms;
		}
	}
	
	public void addSeconds(int sec) {
		if (sec > 0 || sec < 1000000000) {
			this.milliseconds += sec * 1000;		
		}
	}
	
	public void addMinutes(int mins) {
		if (mins > 0 || mins < 1000000000) {
			this.milliseconds += mins * 60 * 1000;
			
		}
	}
	
	public void addHours(int hrs) {
		if (hrs > 0 || hrs < 1000000000) {
			this.milliseconds += hrs * 60 * 60 * 1000;			
		}
	}
	
	public void print(boolean format12) {
		int milliseconds = this.milliseconds % 1000;
		int seconds = (this.milliseconds / 1000) % 60;
		int minutes = (this.milliseconds / (60 * 1000)) % 60;
		int hours = (this.milliseconds / (60 * 60 * 1000)) % 24;
		
		// Handle AM/PM format
		int hoursOutput = hours;
		String daytimeOutput = "";
		if (format12) {
			if (hours <= 12) {
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
		
		System.out.println(hoursOutput + ":" + minutesPrefix + minutes + ":" 
				+ secondsPrefix + seconds + ":" + millisecondsPrefix + milliseconds + " " + daytimeOutput);
	}
}
