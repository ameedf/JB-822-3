package ameedf.jb8223.assignments.hw02;

/**
 * This class will represent a 24-hours clock up to micro-seconds precision (1000 millisecond = 1 second).
 * That means that it will represent hours of the form "HH:MM:SS.mmm", where
 * HH - represents the hours in 24 format. Range: [0-23]
 * MM - represents the minutes. Range: [0-59]
 * SS - represents the seconds. Range: [0-59]
 * sss - represents the micro-seconds. Range: [0-999]
 *
 * It will have 2 constructors:
 * 1. One constructor with 4 parameters: hours, minutes, seconds and milliseconds.
 *    Assume the input is always valid for this constructor
 * 2. One constructor with no parameters. This will initialize the clock to 14:07:53.980
 *
 * It will have these methods:
 * 1. addHours - with a single parameter which represents the number of hours to add.
 *    It will add the hours only if it's in the range [0..1,000,000,000]. No value is returned
 * 2. addMinutes - with a single parameter which represents the number of minutes to add.
 *    It will add the minutes only if it's in the range [0..1,000,000,000]. No value is returned
 * 3. addSeconds - with a single parameter which represents the number of seconds to add.
 *    It will add the seconds only if it's in the range [0..1,000,000,000]. No value is returned
 * 4. addMilliseconds - with a single parameter which represents the number of milliseconds to add.
 *    It will add the milliseconds only if it's in the range [0..1,000,000,000]. No value is returned
 * 5. print - with a single boolean parameter which represents if we want to display a 24 hours clock
 *    or 12 hours clock. If a 12 hours clock is chosen it will add "AM/PM" at the end of the input.
 *    NOTE: the printout should include leading zeros (don't use any formatting methods !!)
 *    For example: 12:3:9.56 --> 12:03:09.056
 *
 * The implementation must NOT use any external classes (except for the printout)
 * BONUS 1: change the addHours, addMinutes, addSeconds and addMilliseconds methods to accept arguments
 *          within the range [-1,000,000,000 .. 1,000,000,000]. Meaning: negative values are allowed.
 *          For example, adding (-1) seconds to 00:00:00.000 will take the clock back to 23:59:59.000
 * BONUS 2: the same functionality as in "BONUS 1" while using as few member variables / memory as possible
 */
public class Clock {
	private byte hours;
	private byte minutes;
	private byte seconds;
	private short milliseconds;
	
	//C-tor initialize time to 14:07:53.980
	public Clock() {
        this.hours = 14;
        this.minutes = 7;
        this.seconds = 53;
        this.milliseconds = 980;
    }
	
	//C-tor initialize time by user input
	public Clock(int hours, int minutes, int seconds, int milliseconds) {
        this.hours = (byte) hours;
        this.minutes = (byte) minutes;
        this.seconds = (byte) seconds;
        this.milliseconds = (byte) milliseconds;
    }

	public void addHours(int hours) {
		if(hours > 0 && hours < 1000000000 ) {
			this.hours = (byte) ((this.hours + hours) % 24);
		}
	}
	
	public void addMinutes(int minutes) {
		int addToHours = 0;
		if(minutes > 0 && minutes < 1000000000 ) {
			if(this.minutes + minutes > 59) {
				addToHours = (this.minutes + minutes) / 60; 
				addHours(addToHours);
			}
			this.minutes = (byte) ((this.minutes + minutes) % 60);
		}
	}
	
	public void addSeconds(int seconds) {
		int addToMinutes = 0;
		if(seconds > 0 && seconds < 1000000000 ) {
			if(this.seconds + seconds > 59) {
				addToMinutes = (this.seconds + seconds) / 60;
				addMinutes(addToMinutes);
			}
			this.seconds = (byte) ((this.seconds + seconds) % 60);
		}
	}
	
	public void addMilliseconds(int milliseconds) {
		int addToSeconds = 0;
		if(milliseconds > 0 && milliseconds < 1000000000 ) {
			if(this.milliseconds + milliseconds > 999) {
				addToSeconds = (this.milliseconds + milliseconds) / 1000;
				addSeconds(addToSeconds);
			}
			this.milliseconds = (short) ((this.milliseconds + milliseconds) % 1000);
		}
	}
	
	public void print(boolean is12) {
		String postfix = "";
		int hoursToShow = hours;
		if(is12) {
			if(hours<12) {
				//12:00 a.m. is 	00:00
				if(hours == 0) {
					hoursToShow = 12;
				}
				postfix = "AM";
			} else {
				postfix = "PM";
				hoursToShow -= 12;
			}
		}
		System.out.println("\n"+(hoursToShow<10? "0"+hoursToShow:hoursToShow)+":"+(minutes<10? "0"+minutes:minutes)+":"+(seconds<10? "0"+seconds:seconds)+"."
		+(milliseconds<10? "00"+milliseconds:(milliseconds<100? "0"+milliseconds:milliseconds))+" "+postfix);
	}

}
