package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Inventory;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;

public class OrderBuilder {
	private Order order = null;
	private Inventory inventory = null;
	private JSplitPane panel = null;
	
	public OrderBuilder (Inventory inventory) {
		this.inventory = inventory;
		newOrder();
		
		panel = new JSplitPane();
				
		JPanel right = new JPanel(new GridBagLayout() );
		panel.setRightComponent(right);
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		JButton button = new JButton("Pizza");
		right.add(button, c);
		
		c.gridx = 1;
		button = new JButton ("Drinks");
		right.add(button,c);
		
		c.gridx = 2;
		button = new JButton("Sides");
		right.add(button,c);
		
		
		
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
