package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JSplitPane;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;

public class OrderBuilder {
	private Order order = null;
	private Component panel = null;
	
	public OrderBuilder () {
		newOrder();
		
		panel = new JSplitPane();
		panel.setMinimumSize(new Dimension(100,50));
		
		
	}
	
	public Component getComponent() {
		return panel;
	}
	
	public void newOrder () {
		order = new Order();
	}
	
	public Order getOrder() {
		return order;
	}
}
