package ameedf.jb8223.assignments.hw02;


public class ClockBonus2 {
	// Make variables
		private int hours;
		private int minutes;
		private int seconds;
		private int milliseconds;
		private boolean twentyFourDisplay;  

		//Initializing constructor
		public ClockBonus2() {
			this.hours = 14;
			this.minutes = 7;
			this.seconds = 53;
			this.milliseconds = 980;

		}
	// Clock constructor
		public ClockBonus2 (int hours, int minutes, int seconds, int milliseconds, boolean twentyFourDisplay ) {

			this.hours = hours;
			this.minutes = minutes;
			this.seconds = seconds;
			this.milliseconds = (short) milliseconds;
			this.twentyFourDisplay = twentyFourDisplay;

		}
		
						/* METHODS */
		
	// Validation and hours calculation
		public void addHours(int hours) {
			if (hours >= 0) {
				this.hours = (byte) ((this.hours + hours) % 24);

			}else {
				this.hours = 24 - (this.hours + hours) % 24;
			}
		}
		// Validation and minutes calculation
		public void addMinutes(int minutes) {
			if (minutes >= 0) {

				this.hours = (byte) (this.hours + (this.minutes + minutes) / 60);
				if (this.hours > 23) {
					this.hours = (byte) (this.hours % 24);
				}
				
				this.minutes = (byte) ((this.minutes + minutes) % 60);
				

			} else {
				
				if(this.minutes < -minutes){
					this.minutes = 60 - (this.minutes + minutes);
					this.hours = this.hours -1;
					if (this.hours < 0){
						this.hours = 24 - this.hours;
					}
					
				
				}else {
					this.minutes = this.minutes + minutes;
				
				}
			}

		}
		// Validation and seconds calculation	
		public void addSeconds(int seconds) {
			if (seconds >= 0) {
				
				this.hours = (byte) (this.hours + (this.seconds + seconds) / 3600);
				
				if (this.hours > 23){
					this.hours = (byte) (this.hours % 24);
				}
				
				if (this.hours < 0){
					this.hours = 24 - this.hours;
				}
				
				this.minutes = (byte) (this.minutes + (this.seconds + seconds) / 60);
				if (this.minutes > 59){
					this.minutes = (byte) (this.minutes % 60);
					
				}
				
				this.seconds = (byte) ((this.seconds + seconds) %  60);
			}else {
				
				if (this.seconds < -seconds){
					this.seconds = 60 + (this.seconds + seconds);
					this.minutes = this.minutes - 1;
					if (this.minutes < 0){
						this.minutes = 60 + this.minutes;
						this.hours = this.hours -1;
					}
				}else {
					this.seconds = this.seconds + seconds;
				}
			}
		}
		// Validation and milliseconds calculation
		public void addMilliseconds(int milliseconds){
			if (milliseconds >= 0){
				if (milliseconds >= 0){
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
				
				this.milliseconds = (short) ((this.milliseconds + milliseconds) % 1000);
				
				}else {
					
					if (this.milliseconds < -milliseconds){
						this.milliseconds = 1000 - (this.milliseconds + milliseconds);
						this.seconds = this.seconds - 1;
						
						if (this.seconds < 0){
							this.seconds = 60 + this.seconds;
							this.minutes = this.minutes - 1;
							if (this.minutes < 0){
								this.minutes = 60 + minutes;
							}
						}
							
					}else {
						this.milliseconds = this.milliseconds + seconds;
					
						
					}
				}
			
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
