package cs314.a2;

/**
 * Adventure Game Program Code Copyright (c) 1999 James M. Bieman
 * 
 * To compile: javac AdventureGame.java To run: java AdventureGame
 * 
 * The main routine is AdventureGame.main
 **/

//Added a function which just returns the text for this item to be used on a button,
//which will be used to grab/drop the items.

// class Treasure

public class Treasure extends Item {

	public String getButtonText() {
		return "Treasure";
	}
}
