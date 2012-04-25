package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.ac.aber.dcs.cs12420.aberpizza.data.*;

/**
 * This ActionListener creates a pop up dialog asking the user which size of item
 * they wish to add. If the ItemGroupButton contains only one item then no dialog is presented.
 * @author Tarinaky
 *
 */
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
