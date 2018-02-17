package com.fifa;


import java.util.Random;


//this game is created with hashmap
public class Game1 {

	private Team team1;
	private Team team2;
	private int goals1;
	private int goals2;

	public Game1(Team team1, Team team2) {
		super();
		this.team1 = team1;
		this.team2 = team2;

	}


	public void Play() {
		// get a random number of goals for each group
		setRandomResult();
		// set the group point by the result of the game
		setTeamNumOfPoint();

	}

	private void setTeamNumOfPoint() {

		if (this.goals1 > this.goals2) {
			this.team1.addPoints(3);
			
		} else if (this.goals1 < this.goals2) {
			this.team2.addPoints(3);
		} else {
			this.team1.addPoints(1);
			this.team2.addPoints(1);
		}

	}

	public void setRandomResult() {
		Random random = new Random();
		// set first team goals random number
		this.goals1 = random.nextInt(4);
		// set second team goals random number
		this.goals2 = random.nextInt(4);

	}

	public String toString() {
		String msg = "\nThe palying teams in this game are: "
				+ this.team1.getName()+ " VS "+  this.team2.getName()+ "\n";
		if (this.goals1 > this.goals2) {
			msg += "The wining team is " + team1.getName()+ "\n";
	
		} else if (this.goals1 < this.goals2) {
			msg += "The wining team is " + team2.getName()+ "\n";
		} else {
			msg += " The game finish in draw \n";
		}
		
		msg += team1.getName() + " number of point in this game: " + team1.getPoints() + " \n";
		msg += team2.getName() + " number of point in this game: " + team2.getPoints() + " \n";
		return msg;
	}

}
