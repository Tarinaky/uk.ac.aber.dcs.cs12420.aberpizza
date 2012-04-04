package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.ac.aber.dcs.cs12420.aberpizza.data.*;

public class ItemGroupPickerListener implements ActionListener {

	private Order order = null;
	private ItemGroupPicker dialogue = null;
	private Item item = null;
	
	public ItemGroupPickerListener(Order order, ItemGroupPicker dialogue, Item item) {
		this.order = order;
		this.dialogue = dialogue;
		this.item = item;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		order.updateItemQuantity(item, 1);
		dialogue.hide();

	}

}
