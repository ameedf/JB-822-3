package dealer;

import consumer.Consumer;
import consumer.Player;
import extendedClass.Person;

public class CardsDealer extends Person implements Dealer {

	private Player[] players;
	public CardsDealer(int id, String name,Player[] players) {
		super(id, name);
		this.players = players;
		
	}
	

	public Player[] getPlayers() {
		return players;
	}


	public void setPlayers(Player[] players) {
		this.players = players;
	}


	@Override
	public void deal(Consumer[] to) {
		for (Player consumer : (Player[])to) {
			System.out.println("tack the cards "+ consumer.getName());
			consumer.consume();
		}
		
	}
 
	
}
