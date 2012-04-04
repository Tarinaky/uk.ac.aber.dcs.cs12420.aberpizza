package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.ac.aber.dcs.cs12420.aberpizza.data.*;

public class ItemGroupListener implements ActionListener {
	
	private Order order = null;
	private ItemGroupButton group = null;

	public ItemGroupListener(Order order, ItemGroupButton group) {
		this.order = order;
		this.group = group;
	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (group.getList().size() < 2) {
			order.updateItemQuantity(group.getList().getFirst(), 1);
			return;
		}
		
		ItemGroupPicker dialogue = new ItemGroupPicker(order, group);
		dialogue.show();

	}

}
