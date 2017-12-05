package consumer;

import extendedClass.Person;

public class Player extends Person implements Consumer {

	public Player(int id, String name) {
		super(id, name);
		
	}

	@Override
	public void consume() {
		System.out.println("its a deal cards received ");
		
	}
	
	
}
