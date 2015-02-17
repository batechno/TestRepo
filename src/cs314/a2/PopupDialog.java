package cs314.a2;

import javax.swing.*;

import BreezySwing.*;

/*
 * A GBDialog which can be used in both the cases: Grab and Drop
 * We just change the properties associated with the elements (Buttons, labels)
 * We hide this window whenever it isn't in use
 */

public class PopupDialog extends GBDialog {
	
	private static final long serialVersionUID = 1L;	
	
	//Elements to be added to the GBDialog
	private JLabel infoLabel = addLabel("Select an item", 1, 1, 1, 1);

	private JButton keyButton = addButton("Key", 2, 1, 1, 1);
	private JButton treasureButton = addButton("Treasure", 3, 1, 1, 1);	
		
	private int keyIndex, treasureIndex, windowType;
	
	//A stored reference to the main window
	private AdventureGameView mainWindow; 

	public PopupDialog(AdventureGameView mFrame)
	{
		//Make a call to GBDialog's constructor
		super(mFrame);
		setSize(400, 100);		
		
		this.mainWindow=mFrame;
		
		keyButton.setVisible(false);
		treasureButton.setVisible(false);	
		
		setVisible(false);
		setTitle("Dialog");
	}
	
	public void buttonClicked(JButton buttonObj) {
		
		setVisible(false);				
		
		if (buttonObj == keyButton)
		{
			//Grab
			if(windowType==1)
				mainWindow.grabItem(keyIndex, "Key"); //Return the item's index in its parent list and the associated text to print a meaningful status message
			else//Drop
				mainWindow.dropItem(keyIndex, "Key");
		}

		else if (buttonObj == treasureButton)
		{
			//Grab
			if(windowType==1)
				mainWindow.grabItem(treasureIndex, "Treasure"); //Return the item's index in its parent list and the associated text to print a meaningful status message
			else//Drop
				mainWindow.dropItem(treasureIndex, "Treasure");			
		}

	}	
	
	//We set the indexes associated with the items in their parent lists.
	//We return that index whenever the associated button is clicked 
	public void setIndexes(Item[] iList, int arrayLength)
	{		
		keyButton.setVisible(false);
		treasureButton.setVisible(false);
		
		keyIndex=-1;
		treasureIndex=-1;
		
		for(int i=0;i<arrayLength;i++)
		{
			if(iList[i].getButtonText().equals("Key"))
			{
				keyIndex=i;
				keyButton.setVisible(true);
			}
			
			else if(iList[i].getButtonText().equals("Treasure"))
			{
				treasureIndex=i;
				treasureButton.setVisible(true);
			}
			
		}		
	}
	
	//Plug in properties to pop up a grab related dialog
	public void showGrabDialog(Item[] iList)
	{	
		setIndexes(iList, iList.length);
		windowType=1;
		
		infoLabel.setText("Click the buttons to grab an item");
		
		setVisible(true);
	}
	
	//Plug in properties to pop up a drop related dialog	
	public void showDropDialog(Item[] iList, int arrayLength)
	{
		setIndexes(iList, arrayLength);		
		windowType=2;
		
		infoLabel.setText("Click the buttons to drop an item");
		
		setVisible(true);			
	}	
	
}
