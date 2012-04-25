package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.ac.aber.dcs.cs12420.aberpizza.data.*;

/**
 * Reduces the quantity of an item by one.
 * @author Tarinaky
 *
 */
public class MinusOneListener implements ActionListener {

	private OrderBuilder builder = null;
	private Item item = null;
	private Order order = null;
	
	public MinusOneListener(Order order, Item item, OrderBuilder builder) {
		this.order = order;
		this.item = item;
		this.builder = builder;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		order.updateItemQuantity(item, -1);
		builder.drawOrder();

	}

}
