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

	JLabel carryingLabel = addLabel("You are carying: ", 6, 1, 1, 1);
	JTextArea carryingArea = addTextArea("Nothing", 7, 1, 4, 3);

	JLabel statusLabel = addLabel("Status of the game: ", 10, 1, 1, 1);
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

	// Constructor-----------------------------------------------

	public AdventureGameView() {
		setTitle("Adventure Game");
		model = new AdventureGameModelFacade();

		viewArea.setEditable(false);
		carryingArea.setEditable(false);
		displayCurrentInfo();
	}

	// buttonClicked method--------------------------------------

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == upButton)
			statusArea.append(model.goUp()+"\n");

		else if (buttonObj == downButton)
			statusArea.append(model.goDown()+"\n");

		else if (buttonObj == northButton)
			statusArea.append(model.goNorth()+"\n");

		else if (buttonObj == southButton)
			statusArea.append(model.goSouth()+"\n");

		else if (buttonObj == eastButton)
			statusArea.append(model.goEast()+"\n");

		else if (buttonObj == westButton)
			statusArea.append(model.goWest()+"\n");

		else if (buttonObj == grabButton)
			grab();

		else if (buttonObj == dropButton)
			drop();

		displayCurrentInfo();
	}

	// Private methods-------------------------------------------

	private void displayCurrentInfo() {
		viewArea.setText(model.getView());
		carryingArea.setText(model.getItems());
	}

	private void grab() {

		if (model.canGrabItem()) {
			if (model.roomEmpty()) {
				// Show dialog that the room doesn't have any items at all
				statusArea.setText("The room doesn't have any items to pick up");						
			} else {
				// Show Grab Dialog
				popGrabDialog();
			}

		} else {
			// Show dialog that the player's hands are already full
			statusArea.setText("You can't pick up any more items");
		}

	}

	private void drop() {

		if (model.canDropItem()) {
			// Show Drop Dialog
			popDropDialog();
		} else {
			// Show dialog that the player's hands are empty
			statusArea.setText("You don't have any items to drop");					
		}
	}

	private void popGrabDialog() {

	}
	
	private void popDropDialog() {
		
	}

	public static void main(String[] args) {
		JFrame view = new AdventureGameView();
		view.setSize(800, 600); /* was 400, 250 */
		view.setVisible(true);
	}
}
