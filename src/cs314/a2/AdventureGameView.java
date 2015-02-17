package cs314.a2;

import javax.swing.*;

import BreezySwing.*;

public class AdventureGameView extends GBFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Window objects --------------------------------------
	JLabel welcomeLabel = addLabel(
			"Welcome to the Adventure Game "
					+ "(inspired by an old game called the Colossal Cave Adventure)."
					+ " Java implementation Copyright (c) 1999-2012 by James M. Bieman",
			1, 1, 5, 1);

	JLabel viewLabel = addLabel("Your View: ", 2, 1, 1, 1);
	JTextArea viewArea = addTextArea("Start", 3, 1, 4, 3);

	JLabel carryingLabel = addLabel("You are carrying: ", 6, 1, 1, 1);
	JTextArea carryingArea = addTextArea("Nothing", 7, 1, 4, 3);

	JLabel statusLabel = addLabel("Status messages: ", 10, 1, 1, 1);
	JTextArea statusArea = addTextArea("You are in the outside room right now\n",
			11, 1, 4, 3);

	JLabel separator1 = addLabel(
			"------------------------------------------------------------------------------",
			14, 1, 4, 1);

	JLabel choiceLabel = addLabel(
			"Choose a direction, pick-up, or drop an item", 15, 1, 5, 1);

	JButton grabButton = addButton("Grab an item", 16, 5, 1, 1);
	JButton dropButton = addButton("Drop an item", 17, 5, 1, 1);

	JButton northButton = addButton("North", 16, 2, 1, 1);
	JButton southButton = addButton("South", 18, 2, 1, 1);
	JButton eastButton = addButton("East", 17, 3, 1, 1);
	JButton westButton = addButton("West", 17, 1, 1, 1);
	JButton upButton = addButton("Up", 16, 3, 1, 1);
	JButton downButton = addButton("Down", 18, 3, 1, 1);

	AdventureGameModelFacade model;
	
	private PopupDialog iDialog;

	// Constructor-----------------------------------------------

	public AdventureGameView() {
		setTitle("Adventure Game");
		model = new AdventureGameModelFacade();

		viewArea.setEditable(false);
		carryingArea.setEditable(false);
		displayCurrentInfo();
		
		iDialog=new PopupDialog(this);
	}

	// buttonClicked method--------------------------------------

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == upButton)
			updateStatusArea(model.goUp());

		else if (buttonObj == downButton)
			updateStatusArea(model.goDown());

		else if (buttonObj == northButton)
			updateStatusArea(model.goNorth());

		else if (buttonObj == southButton)
			updateStatusArea(model.goSouth());

		else if (buttonObj == eastButton)
			updateStatusArea(model.goEast());

		else if (buttonObj == westButton)
			updateStatusArea(model.goWest());

		else if (buttonObj == grabButton)
			grab();

		else if (buttonObj == dropButton)
			drop();

		displayCurrentInfo();
	}
	
	public void grabItem(int index, String pText)
	{
		model.grabItem(index);
		
		displayCurrentInfo();
		updateStatusArea("Grabbed \""+pText+"\".");
	}
	
	public void dropItem(int index, String pText)
	{
		model.dropItem(index);
		
		displayCurrentInfo();
		updateStatusArea("Dropped \""+pText+"\".");
	}		

	// Private methods-------------------------------------------

	private void displayCurrentInfo() {
		viewArea.setText(model.getView());
			
		String retVal=model.getItemListInStr();		
		carryingArea.setText(retVal==""?"Nothing":retVal);
	}
	
	private void updateStatusArea(String str) {
		statusArea.append(str+"\n");
	}

	private void grab() {

		if (model.canGrabItem()) {
			if (model.roomEmpty()) {
				// Show dialog that the room doesn't have any items at all
				updateStatusArea("The room doesn't have any items for you to pick up");						
			} else {
				// Show Grab Dialog
				iDialog.showGrabDialog(model.getItemsInRoom());				
			}

		} else {
			// Show dialog that the player's hands are already full
			updateStatusArea("You can't pick up any more items");
		}

	}

	private void drop() {

		if (model.canDropItem()) {
			// Show Drop Dialog
			iDialog.showDropDialog(model.getItemsWithPlayer(), model.getNumItemsWithPlayer());			
		} else {
			// Show dialog that the player's hands are empty
			updateStatusArea("You don't have any items to drop");					
		}
	}	

	public static void main(String[] args) {
		JFrame view = new AdventureGameView();
		view.setSize(800, 600); /* was 400, 250 */
		view.setVisible(true);
	}
}
