package casino;

import java.util.Random;

/**
 * Your mission is to create a Casino.
 * Person: has a final id and a name (with setter/getter)
 * Dealer: INTERFACE - an entity that can deal (not always a Person)
 * Consumer: INTERFACE - an entity that can accept the act of dealing from a Dealer
 * Player: a Person who is also a Consumer (Consume the cards dealing)
 * CardsDealer: a Person who is also a Dealer. Has a list of players to deal to
 * DrugsDealer: a Person who is also a Dealer.
 * Has a list of AddictedPlayers to deal to and a specific amount of drugs to deal (in grams).
 * Each addict will consume 10g each time. When there are no drugs to deal, the dealing action will do nothing
 * Santa: a Dealer of toys. Has a limited number of toys to deal.
 * When there are no toys to deal, the dealing action will do nothing
 * AddictedPlayer: a player that can consume drugs (Consumer)
 */
public class CasinoApplication {
    public static void main(String[] args) {
        Casino casino = new Casino();
        casino.start();
        
    }
}
