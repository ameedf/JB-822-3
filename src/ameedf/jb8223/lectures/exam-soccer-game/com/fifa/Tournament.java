package com.fifa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Tournament {
	private List<Game1> games;
	private List<Team> teams;

	public Tournament() {
		super();
		this.teams = new ArrayList<>();
		this.games = new ArrayList<>();

		Team team1 = new Team();
		team1.setName("Haifa");
		Team team2 = new Team();
		team2.setName("Tel Aviv");

		Scanner input = new Scanner(System.in);
		//Get the first team players
		System.out.println("Plz enter Names of players in " + team1.getName()+"\n ");
		System.out.println("Plz enter Name of GoalKeeper: ");
		Player p1 = new GoalKeeper(input.nextLine());
		team1.addPlayer(p1);
		
		for (int i = 0; i < 2; i++) {
			System.out.println("Plz enter Name of Defensive: " + (i + 1));
			p1 = new Defensive(input.nextLine());
			team1.addPlayer(p1);
		}

		for (int i = 0; i < 2; i++) {
			System.out.println("Plz enter Name of Offensive: " + (i + 1));
			 p1 = new Offensive(input.nextLine());
			team1.addPlayer(p1);
		}
		
		//Get the second team players
		
		System.out.println("Plz enter Names of players in " + team2.getName()+"\n ");
		System.out.println("Plz enter Name of GoalKeeper: ");
	    p1 = new GoalKeeper(input.nextLine());

		team2.addPlayer(p1);
		
		for (int i = 0; i < 2; i++) {
			System.out.println("Plz enter Name of Defensive: " + (i + 1));
		    p1 = new Defensive(input.nextLine());
			team2.addPlayer(p1);
		}

		for (int i = 0; i < 2; i++) {
			System.out.println("Plz enter Name of Offensive: " + (i + 1));
			p1 = new Offensive(input.nextLine());
			team2.addPlayer(p1);
		}
		
		
		

		this.teams.add(team1);

		Game1 game1 = new Game1(team1, team2);
		this.games.add(game1);
		this.teams.add(team2);

		System.out.print(showGroups());

		while (!weHaveWiningTeam(teams)) {
			game1.Play();
			System.out.print(game1.toString());
		}
	}

	private boolean weHaveWiningTeam(List<Team> teams) {

		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).getPoints() >= 7) {
				return true;
			}
		}
		return false;
	}

	public String showGroups() {
		String msg = "";
		for (Team t : teams) {
			if (t instanceof Team) {
				String groupName = t.getName();
				msg += groupName + " \n";
				String playersList = getPlayersName(t);
				if (playersList.length() > 0) {
					msg += "The Players in " + groupName + " are: " + "\n" + playersList + "\n";
				} else {
					msg += "There are no players in " + groupName + " yet \n";
				}

			}
		}

		return msg;
	}

	private String getPlayersName(Team currTeam) {
		String msg = "";
		List<Player> currPlayers;
		currPlayers = currTeam.getPlayers();
		for (Player p : currPlayers) {
			msg += p.getName() + " \n";
		}
		return msg;
	}

	public String toString() {
		String msg = "";

		msg += "On curret game The wining group is " + "" + " \n";
		msg += "On curret game The wining group is " + "" + " \n";

		return msg;
	}

}
