package com.asad.xOGame;

public class Game {
	private String[][] gameBord;

	public Game() {

		this.gameBord = new String[3][3];
		this.gameBord = defultGameBord(gameBord);
	}

	private String[][] defultGameBord(String[][] gameBord) {
		for (int i = 0; i < gameBord.length; i++) {
			for (int j = 0; j < gameBord[i].length; j++) {
				gameBord[i][j]=" ";
			}
		}
		return gameBord;
	}

	public boolean addToTheBord(String lettar, int xAxis, int yAxis) {
		if ((this.gameBord[xAxis][yAxis].equals(" "))) {
			this.gameBord[xAxis][yAxis] = lettar;
			return true;
		}
		return false;

	}

	public boolean winner(String letter) {
		if (this.gameBord[0][0].equals(letter) && this.gameBord[0][1].equals(letter)
				&& this.gameBord[0][2].equals(letter)) {
			return true;
		} else {
			if (this.gameBord[0][0].equals(letter) && this.gameBord[1][1].equals(letter)
					&& this.gameBord[2][2].equals(letter)) {
				return true;
			} else {
				if (this.gameBord[0][0].equals(letter) && this.gameBord[1][0].equals(letter)
						&& this.gameBord[2][0].equals(letter)) {
					return true;
				} else {
					if (this.gameBord[0][1].equals(letter) && this.gameBord[1][1].equals(letter)
							&& this.gameBord[2][1].equals(letter)) {
						return true;
					} else {
						if (this.gameBord[1][0].equals(letter) && this.gameBord[1][1].equals(letter)
								&& this.gameBord[1][2].equals(letter)) {
							return true;
						} else {
							if (this.gameBord[2][0].equals(letter) && this.gameBord[2][1].equals(letter)
									&& this.gameBord[2][2].equals(letter)) {
								return true;
							} else {
								if (this.gameBord[0][2].equals(letter) && this.gameBord[1][2].equals(letter)
										&& this.gameBord[2][2].equals(letter)) {
									return true;
								} else {
									if (this.gameBord[2][0].equals(letter) && this.gameBord[1][1].equals(letter)
											&& this.gameBord[0][2].equals(letter)) {
										return true;
									} else {
										return false;
									}
								}

							}

						}

					}

				}

			}

		}

	}

	public boolean isTheBordFull() {
		int countOfTheEmptyIndexes = 0;
		for (String[] strings : this.gameBord) {
			for (String string : strings) {
				if (string.equals(" ")) {
					countOfTheEmptyIndexes++;
				}
			}
			
		}
		if (countOfTheEmptyIndexes == 1) {
				return true;
			}
		return false;
	}
	private  String bordAI() {
		String bord="";
		for (String[] strings : gameBord) {
			bord+="-------\n";
			for (String string : strings) {
				bord+="|";
				bord+=string;
			}		
			bord+="|\n";
		}
		
		bord+="-------\n";
		return bord;
	}

	public String toString() {
		

		return bordAI();
	}

}
