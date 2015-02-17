package cs314.a2;

import javax.swing.*;

import BreezySwing.*;

public class PopupDialog extends GBDialog {
	
	private static final long serialVersionUID = 1L;	
	
	private JLabel infoLabel = addLabel("Select an item", 2, 1, 1, 1);

	private JButton keyButton = addButton("Key", 3, 1, 1, 1);
	private JButton treasureButton = addButton("Treasure", 3, 2, 1, 1);	
	private int keyIndex, treasureIndex, windowType;
	
	private AdventureGameView mainWindow; 

	public PopupDialog(AdventureGameView mFrame)
	{
		super(mFrame);
		setSize(400, 100);		
		
		this.mainWindow=mFrame;
		
		keyButton.setEnabled(false);
		treasureButton.setEnabled(false);
		
		setVisible(false);
		setTitle("Dialog");
	}
	
	public void buttonClicked(JButton buttonObj) {
		
		setVisible(false);				
		
		if (buttonObj == keyButton)
		{
			if(windowType==1)
				mainWindow.grabItem(keyIndex, "Key");
			else
				mainWindow.dropItem(keyIndex, "Key");
		}

		else if (buttonObj == treasureButton)
		{
			if(windowType==1)
				mainWindow.grabItem(treasureIndex, "Treasure");
			else
				mainWindow.dropItem(treasureIndex, "Treasure");			
		}

	}	
	
	public void setIndexes(Item[] iList, int arrayLength)
	{		
		keyButton.setEnabled(false);
		treasureButton.setEnabled(false);
		
		keyIndex=-1;
		treasureIndex=-1;
		
		for(int i=0;i<arrayLength;i++)
		{
			if(iList[i].getButtonText().equals("Key"))
			{
				keyIndex=i;
				keyButton.setEnabled(true);
			}
			
			else if(iList[i].getButtonText().equals("Treasure"))
			{
				treasureIndex=i;
				treasureButton.setEnabled(true);
			}
			
		}		
	}
	
	public void showGrabDialog(Item[] iList)
	{	
		setIndexes(iList, iList.length);
		windowType=1;
		
		infoLabel.setText("Click the buttons to grab an item");
		
		setVisible(true);
	}
	
	public void showDropDialog(Item[] iList, int arrayLength)
	{
		setIndexes(iList, arrayLength);		
		windowType=2;
		
		infoLabel.setText("Click the buttons to drop an item");
		
		setVisible(true);			
	}	
	
}
