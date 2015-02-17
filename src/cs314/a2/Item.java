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

// class Item

public class Item {

	private String description;

	public void setDesc(String d) {
		description = d;
	}

	public String getDesc() {
		return description;
	}

	public String getButtonText() {
		return "Item";
	}

}
