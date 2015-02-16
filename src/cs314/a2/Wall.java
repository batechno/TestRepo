package cs314.a2;

/**
 * Adventure Game Program Code Copyright (c) 1999 James M. Bieman
 * 
 * To compile: javac AdventureGame.java To run: java AdventureGame
 * 
 * The main routine is AdventureGame.main
 **/

// class Wall

public class Wall implements CaveSite {
	
	private String wallType;
	
	Wall(String wStr) {
		wallType=wStr;
	}

	public String enter(Player p) {
		return "You tried to go "+wallType+". But, ran into a wall! That hurts.";
	}

}
