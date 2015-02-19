package cs314.a2;

public class AdventureGameModelFacade {

	private Player thePlayer;

	AdventureGameModelFacade() { // we initialize

		// Create a model and initialize the player
		
		Adventure theCave = new Adventure();
		Room startRm = theCave.createAdventure();
		
		thePlayer = new Player();		
		thePlayer.setRoom(startRm);

	}

	/*
	 * 0-North 1-South 2-East 3-West 4-Up 5-Down
	 */

	//Player movement related functions
	//If the player was able to make a move: We return a message that the player moved from R{0-9}*->R{0-9}*
	
	//If he encounters a wall in that direction or doesn't have a key to open a trap door.
	//Then we return the relevant error message.
	
	public String goUp() {
		return thePlayer.go(4);
	}

	public String goDown() {
		return thePlayer.go(5);
	}

	public String goNorth() {
		return thePlayer.go(0);
	}

	public String goSouth() {
		return thePlayer.go(1);
	}

	public String goEast() {
		return thePlayer.go(2);
	}

	public String goWest() {
		return thePlayer.go(3);
	}

	public String getView() {
		return thePlayer.getLoc().getDesc();
	}

	//Info retrieval functions
	public String getItemListInStr() {
		return thePlayer.showMyThings();
	}
	
	public Item[] getItemsInRoom() {
		return thePlayer.getLoc().getRoomContents();
	}
	
	public Item[] getItemsWithPlayer() {
		return thePlayer.getItems();
	}
	
	public int getNumItemsWithPlayer() {
		return thePlayer.getNumItems();
	}	

	//Functionality
	public void grabItem(int index)
	{
		thePlayer.pickUp(thePlayer.getLoc().getItem(index));
	}
	
	public void dropItem(int index)
	{
		thePlayer.drop(index+1);
	}
		
	//Checks
	public boolean canGrabItem() {
		return !thePlayer.handsFull();
	}

	public boolean canDropItem() {
		return !thePlayer.handsEmpty();
	}

	public boolean roomEmpty() {
		return thePlayer.getLoc().roomEmpty();
	}
	
}
