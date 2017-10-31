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
}package clocktime;

public class clock {
	private int HH;
	private int MM;
	private int SS;
	private int sss;
	private String Timefinish;
	private int timechange;

	public clock(int HH, int MM, int SS, int sss) {
		this.HH = HH;
		this.MM = MM;
		this.SS = SS;
		this.sss = sss;

	}

	public clock() {
		this.HH = 14;
		this.MM = 7;
		this.SS = 53;
		this.sss = 980;
	}

	public void addhours(int HH) {
		if (HH < 0 || HH > 1_000_000_00) {
			return;
		} else {
			int secnoerHH = this.HH + HH;
			this.HH = (secnoerHH % 24);

		}
	}

	public void addMinutes(int MM) {

		if (MM < 0 || MM > 1_000_000_00) {
			return;

		} else {
			int secnoerMM = this.MM + MM;
			this.MM = (secnoerMM % 60);
			addhours(secnoerMM / 60);
		}
	}

	public void addSecound(int SS) {
		if (SS < 0 || SS > 1_000_000_00) {
			return;

		} else {
			this.SS %= this.SS + SS;

		}

	}

	public void addmilisecound(int sss) {
		if (sss < 0 || sss > 1_000_000_00) {
			return;

		} else {
			int secnoersss = this.sss + sss;
			this.sss = (secnoersss % 100);
			return;

		}

	}

	public void printtime(boolean Timefinish) {
		if (Timefinish == true) {
			this.Timefinish = "AM/PM";
			if (this.HH > 12) {
				this.HH = this.HH - 12;

			}

		} else {
			this.Timefinish = "";
		}
		if (HH < 12) {
			System.out.print(this.HH + ":");

		}
		if (MM < 60) {
			System.out.print(this.MM + ":");

		}
		if (SS < 60) {
			System.out.print(this.SS + ":");

		}
		if (sss < 1000) {
			System.out.print(this.sss + " " + this.Timefinish);
		}
	}

}
