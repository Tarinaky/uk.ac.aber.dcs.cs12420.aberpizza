package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import javax.swing.JPanel;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;

public class OrderBuilder {
	private Order order = null;
	private JPanel panel = null;
	
	public OrderBuilder (Order order) {
		this.order = order;
		panel = new JPanel();
		
		
	}
}
