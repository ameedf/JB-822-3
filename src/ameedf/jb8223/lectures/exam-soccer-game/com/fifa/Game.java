package com.fifa;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
//this game is created with hashmap
public class Game {

	private Map<Team, Integer> goals;
	private String gameStatus = "";

	public Game(Team team1, Team team2) {
		super();
		this.goals = new HashMap<>();
		this.goals.put(team1, 0);
		this.goals.put(team2, 0);
	}

	public String getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}

	public void setGoals(Map<Team, Integer> goals) {
		this.goals = goals;
	}

	public Map<Team, Integer> getGoals() {
		return goals;
	}

	
	public void Play() {
		//get a random number of goals for each group
		setRandomResult();
		setGroupsNumOfPoint();

	}

	private void setGroupsNumOfPoint() {
		Set<Team> keys = this.goals.keySet();
		
		for (Team t : keys) {
			int currGoals = this.goals.get(t);
		}
		
	}

	
	public void setRandomResult() {
		Random random = new Random();
		Set<Team> keys = this.goals.keySet();
		for (Team t : keys) {
			int currGoals = this.goals.get(t);
			this.goals.put(t, random.nextInt(4));
		}
	}

	public String toString() {
		String msg = "\nThe results for current game are: " + this.gameStatus + " \n";

		Set<Team> keys = this.goals.keySet();
		for (Team t : keys) {
			String groupName = t.getName() + "\n";
			String currPoints = this.goals.get(t).toString();
			msg += groupName + " number of point in this game: " + currPoints + " \n";
		}
		return msg;
	}

}
