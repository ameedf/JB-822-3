package com.fifa;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private List<Player> players;
	private String name;
	private int points=0;
	
	public Team() {
		super();
		this.players = new ArrayList<>(5);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPlayer(Player p) {
		this.players.add(p);
	}
	
	public int getPoints() {
		
		return points;
	}

	public void addPoints(int points) {
		this.points += points;
	}


	public Player getPlayer(String name) {
		for (int i = 0; i < this.players.size(); i++) {
			System.out.println(this.players.get(i).getName());
			String s=(String)this.players.get(i).getName();
			if (this.players.get(i).getName().equals(name)) {
				//System.out.println("Im here");
				return (Player) this.players.get(i);
				
			}
		}

		return null;
	}
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		return true;
	}

}
