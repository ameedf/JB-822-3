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
public class ClockBonus1 {
	private byte hours;
	private byte minutes;
	private byte seconds;
	private short milliseconds;
	
	//C-tor initialize time to 14:07:53.980
	public ClockBonus1() {
        this.hours = 14;
        this.minutes = 7;
        this.seconds = 53;
        this.milliseconds = 980;
    }
	
	//C-tor initialize time by user input
	public ClockBonus1(int hours, int minutes, int seconds, int milliseconds) {
        this.hours = (byte) hours;
        this.minutes = (byte) minutes;
        this.seconds = (byte) seconds;
        this.milliseconds = (short) milliseconds;
    }

	public void addHours(int hours) {
		int hoursToAdd =  this.hours + hours;
		if(hours > -1000000000 && hours < 1000000000 ) {
			//If sum of current and added value is positive number - add the value to class variable
			if( hoursToAdd >= 0 ) {
				//Cut what more than 24 hours (remainder from div to 24)
				this.hours = (byte) (hoursToAdd % 24);
			} else {
				//In case of negative number, make cycled subtract from 24 the remainder  
				this.hours = (byte) ((24 + (hoursToAdd) % 24) %24);
			}
		}
	}
	

	public void addMinutes(int minutes) {
		//Declare variable of sum of minutes to operate
		int minutesToAdd = this.minutes + minutes;
		if(minutes > -1000000000 && minutes < 1000000000 ) {
			//If sum of current and added value is positive number - add the value to class variable
			if(minutesToAdd >= 0) {
				//In case of positive number
				if( minutesToAdd > 59) {
					//Call the addHours() method if needed to increase also the hours count
					addHours(minutesToAdd / 60);
				}
				this.minutes = (byte) (minutesToAdd % 60);
			} else {
				//In case of negative number we need to subtract from current value
				//and call to  addHours() to subtract also the hours 
				addHours((minutesToAdd / 60) - 1);
				
				//The second "%60" needed for case 
				//when the number of minutes received exact 60, needs for zerofill it. Like: 00:00:00 addMinutes(-60);  
				this.minutes = (byte) ((60 + (minutesToAdd) % 60) %60);
			}
		}
	}
	
	//Same logic like in previous method
	public void addSeconds(int seconds) {
		int secondsToAdd = this.seconds + seconds;
		if(seconds > -1000000000 && seconds < 1000000000 ) {
			if( secondsToAdd >= 0) {
				if(secondsToAdd > 59) {
					addMinutes(secondsToAdd / 60);
				}
				this.seconds = (byte) (secondsToAdd % 60);
			} else {
				addMinutes((secondsToAdd / 60) - 1);
				this.seconds = (byte) ((60 + (secondsToAdd) % 60) %60);
			}
		}
	}
	
	//Same logic like in previous method
	public void addMilliseconds(int milliseconds) {
		int millisecondsToAdd = this.milliseconds + milliseconds;
		if(milliseconds > -1000000000 && milliseconds < 1000000000 ) {
			if(millisecondsToAdd >= 0) {
				if(millisecondsToAdd > 999) {
					addSeconds(millisecondsToAdd / 1000);
				}
				this.milliseconds = (short) (millisecondsToAdd % 1000);
			} else {
				addSeconds( (millisecondsToAdd / 1000) - 1);
				this.milliseconds = (short) ((1000 + (millisecondsToAdd) % 1000) %1000);
			}
		} 
	}
	
	public String toString(boolean is12) {
		String postfix = "";
		int hoursToShow = hours;
		if(is12) {
			if(hours<12) {
				if(hours == 0) {
					hoursToShow = 12;
				}
				postfix = "AM";
			} else {
				postfix = "PM";
				hoursToShow -= 12;
			}
		}
		return("\n"+(hoursToShow<10? "0"+hoursToShow:hoursToShow)+":"+(minutes<10? "0"+minutes:minutes)+":"+(seconds<10? "0"+seconds:seconds)+"."
		+(milliseconds<10? "00"+milliseconds:(milliseconds<100? "0"+milliseconds:milliseconds))+" "+postfix);
	}

}
