
public class CheckTheRotation {
	private int firstNumber;
	private int secondNumber;

	public CheckTheRotation(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public void rotationCheck() {
		/////////////////////////////////////////////////////////////////////////////////////
		byte[] firstNumberArray = (byte[]) (new byte[countTheDigitNumber(this.firstNumber)]);
		byte[] secondNumberArray = (byte[]) (new byte[countTheDigitNumber(this.secondNumber)]);
		firstNumberArray = numberToArrayOfDigits(this.firstNumber, firstNumberArray.length);
		secondNumberArray = numberToArrayOfDigits(this.secondNumber, secondNumberArray.length);
		/////////////////////////////////////////////////////////////////////////////////////

		if (firstNumberArray.length == secondNumberArray.length) {

			if (isTheTowArrayIdentical(firstNumberArray, secondNumberArray)) {
				System.out.println("the tow numbers ar identical!!");

			} else {
				int rotationNumber = 0;
				boolean stop = false;
				while (stop == false) {
					rotationNumber++;
					//////////////////////////////
				//	System.out.println(rotationNumber);
					//////////////////////////////////
					firstNumberArray = rotateTheArray(firstNumberArray);
					if (isTheTowArrayIdentical(firstNumberArray, secondNumberArray)) {
						System.out.println("The number " + this.firstNumber + " can be rotated " + rotationNumber
								+ " time(s) to get the number " + this.secondNumber);
						stop = true;
					} if(rotationNumber==firstNumberArray.length && stop==false) {
						System.out.println("We cannot get from " + this.firstNumber + " to " + this.secondNumber
								+ " by performing any number of rotations ");
						stop = true;
					}
				}
			}
		} else {
			System.out.println("the numbers digits you entered are not equale");
		}
	}
	
	
	
	

	public int countTheDigitNumber(int number) {
		int digitsNumber = 0;
		while (number  > 0) {
			digitsNumber++;
			number /= 10;
		}
		//System.out.println(digitsNumber);
		return digitsNumber;
	}

	public byte[] numberToArrayOfDigits(int number, int digitsNumber) {

		byte[] digits = new byte[digitsNumber];
		for (int i = digits.length - 1; i >=  0; i--) {
			digits[i] = (byte) (number % 10);
			number /= 10;
			////////////////////////////////
			//System.out.println(digits[i] + " "+i);
		}
		return digits;
	}

	public boolean isTheTowArrayIdentical(byte[] firstNumberArray, byte[] secondNumberArray) {
		int digitIdenticalCount = 0;
		for (int i = 0; i < secondNumberArray.length; i++) {
			if (firstNumberArray[i] == secondNumberArray[i]) {
				digitIdenticalCount++;
			}
		}
		if (digitIdenticalCount == firstNumberArray.length) {
			return true;
		} else {
			return false;
		}

	}

	public byte[] rotateTheArray(byte[] numberArray) {
		byte tempdigit = numberArray[numberArray.length - 1];
		for (int i = numberArray.length - 1; i > 0; i--) {
			numberArray[i] = numberArray[i - 1];
		}
		numberArray[0] = tempdigit;
		return numberArray;
	}

}
