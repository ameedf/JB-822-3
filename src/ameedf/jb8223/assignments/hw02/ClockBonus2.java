package ameedf.jb8223.assignments.hw02;

/**
 * The same clock where minimum memory is occupied
 */
public class ClockBonus2 {
	int milliseconds;
	
	public ClockBonus2(short milliseconds, byte seconds, byte minutes, byte hours) {
		this.milliseconds = (short) (milliseconds + (seconds * 1000) + (minutes * 60 * 1000) + (hours * 60 * 60 * 1000));
	}
	
	public ClockBonus2() {
		this.milliseconds = (980 + (53 * 1000) + (7 * 60 * 1000) + (14 * 60 * 60 * 1000));
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
		short milliseconds = (short) (this.milliseconds % 1000);
		byte seconds = (byte) ((this.milliseconds / 1000) % 60);
		byte minutes = (byte) ((this.milliseconds / (60 * 1000)) % 60);
		byte hours = (byte) ((this.milliseconds / (60 * 60 * 1000)) % 24);
		
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
		
		System.out.println(hoursOutput + ":" + (minutes < 10 ? "0" : "") + minutes + ":" 
				+ (seconds < 10 ? "0" : "") + seconds + ":" + (milliseconds < 100 ? (milliseconds < 10 ? "00" : "0") : "") + milliseconds + " " + daytimeOutput);
	}
}