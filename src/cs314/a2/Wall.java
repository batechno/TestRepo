package cs314.a2;

/**
 * Adventure Game Program Code Copyright (c) 1999 James M. Bieman
 * 
 * To compile: javac AdventureGame.java To run: java AdventureGame
 * 
 * The main routine is AdventureGame.main
 **/

/*
 * Stored info regarding the position of this wall, to print out error messages 
 * which make more sense.
 */

// class Wall

public class Wall implements CaveSite {
	
	private String wallPos;
	
	Wall(String wStr) {
		wallPos=wStr;
	}

	public String enter(Player p) {
		return "You tried to go \""+wallPos+"\". But, ran into a wall! That hurts.";
	}

}
