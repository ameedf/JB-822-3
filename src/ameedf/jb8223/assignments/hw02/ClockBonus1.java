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
        this.milliseconds = (byte) milliseconds;
    }

	public void addHours(int hours) {
		if(hours > -1000000000 && hours < 1000000000 ) {
			//If sum of current and added value is positive number - add the value to class variable
			if( (this.hours + hours) >= 0 ) {
				//Cut what more than 24 hours (remainder from div to 24)
				this.hours = (byte) ((this.hours + hours) % 24);
			} else {
				//In case of negative number, make cycled subtract from 24 the remainder  
				this.hours = (byte) ((24 + (this.hours + hours) % 24) %24);
			}
		}
	}
	

	public void addMinutes(int minutes) {
		if(minutes > -1000000000 && minutes < 1000000000 ) {
			//If sum of current and added value is positive number - add the value to class variable
			if(this.minutes + minutes >= 0) {
				//In case of positive number
				if(minutes > 59) {
					//In case when we need to increase also the hours
					int addToHours = (this.minutes + minutes) / 60;
					addHours(addToHours);
				}
				this.minutes = (byte) ((this.minutes + minutes) % 60);
			} else {
				//When we need to subtract from current value
				//Calculate number of hours
				int addToHours = ((this.minutes + minutes) / 60);
				
				//If the number of hours is less than one hour, need to subtract this hour  
				if(addToHours == 0) {
					addToHours -= 1;
				}
				//Call to function to change the hours.
				addHours(addToHours);
				
				//The second "%60" needed for case 
				//when the number of minutes received exact 60 for zerofill it. Like: addMinutes(-60);  
				this.minutes = (byte) ((60 + (this.minutes + minutes) % 60) %60);
			}
		}
	}
	
	//Same logic like in previous method
	public void addSeconds(int seconds) {
		if(seconds > -1000000000 && seconds < 1000000000 ) {
			if( this.seconds + seconds >= 0) {
				if(seconds > 59) {
					int addToMinutes = (this.seconds + seconds) / 60;
					addMinutes(addToMinutes);
				}
				this.seconds = (byte) ((this.seconds + seconds) % 60);
			} else {
				int addToMinutes = ((this.seconds + seconds) / 60);
				if(addToMinutes == 0) {
					addToMinutes -= 1;
				}
				addMinutes(addToMinutes);
				this.seconds = (byte) ((60 + (this.seconds + seconds) % 60) %60);
			}
		}
	}
	
	//Same logic like in previous method
	public void addMilliseconds(int milliseconds) {
		if(milliseconds > -1000000000 && milliseconds < 1000000000 ) {
			if( this.milliseconds + milliseconds >= 0) {
				if(milliseconds > 999) {
					int addToSeconds = (this.milliseconds + milliseconds) / 1000;
					addSeconds(addToSeconds);
				}
				this.milliseconds = (short) ((this.milliseconds + milliseconds) % 1000);
			} else {
				int addToSeconds = ((this.milliseconds + milliseconds) / 1000);
				
				if(addToSeconds == 0) {
					addToSeconds -= 1;
				}
				addSeconds(addToSeconds);
				this.milliseconds = (short) ((1000 + (this.milliseconds + milliseconds) % 1000) %1000);
			}
		} 
	}
	
	public void print(boolean is12) {
		String postfix = "";
		int hoursToShow = hours;
		if(is12) {
			if(hours<=12) {
				postfix = "PM";
			} else {
				postfix = "AM";
				hoursToShow -= 12;
			}
		}
		System.out.println("\n"+(hoursToShow<10? "0"+hoursToShow:hoursToShow)+":"+(minutes<10? "0"+minutes:minutes)+":"+(seconds<10? "0"+seconds:seconds)+"."
		+(milliseconds<10? "00"+milliseconds:(milliseconds<100? "0"+milliseconds:milliseconds))+" "+postfix);
	}

}
