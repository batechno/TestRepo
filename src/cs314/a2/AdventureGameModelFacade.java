package cs314.a2;

public class AdventureGameModelFacade {

	// some private fields to reference current location,
	// its description, what I'm carrying, etc.
	//
	// These methods and fields are left as exercises.

	private Player thePlayer;

	AdventureGameModelFacade() { // we initialize

		// Create the model and initialize the player

		thePlayer = new Player();

		Adventure theCave = new Adventure();
		Room startRm = theCave.createAdventure();
		thePlayer.setRoom(startRm);

	}

	/*
	 * North - 0 South - 1 East - 2 West - 3 Up - 4 Down - 5
	 */

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

	public String getItems() {
		return thePlayer.showMyThings();
	}

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
