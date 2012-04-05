package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.ac.aber.dcs.cs12420.aberpizza.data.*;

public class ItemGroupPickerListener implements ActionListener {

	private Order order = null;
	private ItemGroupPicker dialogue = null;
	private Item item = null;
	private OrderBuilder builder = null;
	
	public ItemGroupPickerListener(Order order, ItemGroupPicker dialogue, Item item, OrderBuilder builder) {
		this.order = order;
		this.dialogue = dialogue;
		this.item = item;
		this.builder = builder;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		order.updateItemQuantity(item, 1);
		builder.drawOrder();
		dialogue.hide();

	}

}
