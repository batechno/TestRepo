package cs314.a2;

/**  Adventure Game  Program Code
 Copyright (c) 1999 James M. Bieman

 To compile: javac AdventureGame.java
 To run:     java AdventureGame

 The main routine is AdventureGame.main

 Update August 2010: refactored Vector contents into ArrayList<Item> contents.
 This gets rid of the use of obsolete Vector and makes it type safe.

 **/

// class Room

import java.util.ArrayList;
import java.util.ListIterator;

public class Room implements CaveSite {

	private String description, id;

	private CaveSite[] side = new CaveSite[6];

	private ArrayList<Item> contents = new ArrayList<Item>();

	Room() {
		side[0] = new Wall("North");
		side[1] = new Wall("South");
		side[2] = new Wall("East");
		side[3] = new Wall("West");
		side[4] = new Wall("Up");
		side[5] = new Wall("Down");
	}

	public void setId(String idStr) {
		id = idStr;
	}

	public void setDesc(String d) {
		description = d;
	}

	public void setSide(int direction, CaveSite m) {
		side[direction] = m;
	}

	public void addItem(Item theItem) {
		contents.add(theItem);
	}

	public void removeItem(Item theItem) {
		contents.remove(theItem);
	}

	public boolean roomEmpty() {
		return contents.isEmpty();
	}

	public Item[] getRoomContents() {
		Item[] contentsArray = new Item[contents.size()];
		contentsArray = contents.toArray(contentsArray);
		return contentsArray;
	}

	public String enter(Player p) {
		String retString = "You moved from \"" + p.getLoc().getId()
				+ "\" to \"" + this.getId() + "\"";
		p.setLoc(this);
		return retString;
	}

	public String exit(int direction, Player p) {
		return side[direction].enter(p);
	}

	public String getDesc() {
		ListIterator<Item> roomContents = contents.listIterator();
		String contentString = "";
		while (roomContents.hasNext())
			contentString = contentString + (roomContents.next()).getDesc()
					+ " ";

		return description + '\n' + '\n' + "Room Contents: " + contentString
				+ '\n';
	}

	public String getId() {
		return id;
	}

}
