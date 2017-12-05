package consumer;

import extendedClass.Person;

public class AddictedPlayer extends Person implements Consumer {

	public AddictedPlayer(int id, String name) {
		super(id, name);
		
	}

	@Override
	public void consume() {
		System.out.println("drags drags drags I live another day ");
		
	}
	
}
