package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.ac.aber.dcs.cs12420.aberpizza.data.*;

public class ItemGroupListener implements ActionListener {
	
	private Order order = null;
	private ItemGroupButton group = null;
	private OrderBuilder builder = null;

	public ItemGroupListener(Order order, ItemGroupButton group, OrderBuilder builder) {
		this.order = order;
		this.group = group;
		this.builder = builder;
	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (group.getList().size() < 2) {
			order.updateItemQuantity(group.getList().getFirst(), 1);
			builder.drawOrder();
			return;
		}
		
		ItemGroupPicker dialogue = new ItemGroupPicker(order, group, builder);
		dialogue.show();

	}

}
