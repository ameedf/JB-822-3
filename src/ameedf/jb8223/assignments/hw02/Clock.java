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
 * 5. print - with a single boolean parameter that indicates weather we want to display a 24 hours clock
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
  // Make variables
	private byte hours;
	private byte minutes;
	private byte seconds;
	private int milliseconds;
	private boolean twentyFourDisplay;  

	//Initializing constructor
	public Clock() {
		this.hours = 14;
		this.minutes = 7;
		this.seconds = 53;
		this.milliseconds = 980;

	}
// Clock constructor
	public Clock(byte hours, byte minutes, byte seconds, int milliseconds) {

		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;

	}
// Validation and hours calculation
	public void addHours(int hours) {
		if (hours >= 0 && hours <= 1000000000) {
			this.hours = (byte) ((this.hours + hours) % 24);

		}
	}
	// Validation and minutes calculation
	public void addMinutes(int minutes) {
		if (minutes >= 0 && minutes <= 1000000000) {

			this.hours = (byte) (this.hours + (this.minutes + minutes) / 60);
			if (this.hours > 23) {
				this.hours = (byte) (this.hours % 24);
			}

			this.minutes = (byte) ((this.minutes + minutes) % 60);

		}

	}
	// Validation and seconds calculation	
	public void addSeconds(int seconds) {
		if (seconds >= 0 && seconds <= 1000000000) {
			
			this.hours = (byte) (this.hours + (this.seconds + seconds) / 3600);
			
			if (this.hours > 23){
				this.hours = (byte) (this.hours % 24);
			}
			
			this.minutes = (byte) (this.minutes + (this.seconds + seconds) / 60);
			if (this.minutes > 59){
				this.minutes = (byte) (this.minutes % 60);
				
			}
			
			this.seconds = (byte) ((this.seconds + seconds) %  60);
		}
	}
	// Validation and milliseconds calculation
	public void addMillisecond(int milliseconds){
		if (milliseconds >= 0 && milliseconds <= 1000000000){
			this.hours = (byte) (this.hours + (this.milliseconds + milliseconds) / 3600000);
			if (this.hours > 23){
				this.hours = (byte)(this.hours %24);
			}
			
			this.minutes = (byte) (this.minutes + (this.milliseconds + milliseconds) / 60000);
			if (this.minutes > 59){
				this.minutes = (byte)(this.minutes % 60);
			}
			
			this.seconds = (byte) (this.seconds + (this.milliseconds + milliseconds) / 1000);
			if (this.seconds > 59){
				this.seconds = (byte) (this.seconds % 60);
			}
			
			this.milliseconds = this.milliseconds % 1000;
		
		}	
		
	}
	// 24/12 hours check + print out + formating with leading zeros
	public void print(boolean twentyFourDisplay) {
		if (twentyFourDisplay == false){
			if (this.hours > 12){
				this.hours = (byte) (this.hours % 12);
				System.out.print("The time is ");
				System.out.format("%02d", this.hours);
				System.out.print(":");
				System.out.format("%02d", this.minutes);
				System.out.print(":");
				System.out.format("%02d", this.seconds);
				System.out.print(".");
				System.out.format("%03d", this.milliseconds);
				System.out.print(" PM");
			}else {
				System.out.print("The time is ");
				System.out.format("%02d", this.hours);
				System.out.print(":");
				System.out.format("%02d", this.minutes);
				System.out.print(":");
				System.out.format("%02d", this.seconds);
				System.out.print(".");
				System.out.format("%03d", this.milliseconds);
				System.out.print(" AM");
			}
		}else {
			System.out.print("The time is ");
			System.out.format("%02d", this.hours);
			System.out.print(":");
			System.out.format("%02d", this.minutes);
			System.out.print(":");
			System.out.format("%02d", this.seconds);
			System.out.print(".");
			System.out.format("%03d", this.milliseconds);	
		}
	}
}
