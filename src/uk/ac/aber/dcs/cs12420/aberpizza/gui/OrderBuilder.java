package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import uk.ac.aber.dcs.cs12420.aberpizza.data.*;


public class OrderBuilder {
	private Order order = null;
	private Inventory inventory = null;
	private JSplitPane panel = null;
	private JPanel right;
	
	public OrderBuilder (Inventory inventory) {
		this.inventory = inventory;
		newOrder();
		
		panel = new JSplitPane();
				
		showPizza();
		
	}
	
	public void resetButtons() {
		right = new JPanel(new GridBagLayout() );
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
	
	public void showPizza() {
		resetButtons();
		
		GridBagConstraints c = new GridBagConstraints();
		int y = 1;
		int x = 0;
		
		LinkedList<ItemGroupButton> groups = new LinkedList<ItemGroupButton>();
				
		for (Item item : inventory.getItems()) {
			if (item instanceof PizzaItem) {
				String desc = item.getDescription();
				ItemGroupButton group = null;
				for (ItemGroupButton match : groups) {
					if (desc.compareTo(match.getDescription() ) == 0) {
						group = match;
						break;
					}
				}
				
				if (group == null) { // Create new group and add a button.
					group = new ItemGroupButton(item);
					groups.add(group);
					//TODO: Associate group to the action listener.
					
					c.gridy = y;
					c.gridx = x;
					JButton button = new JButton(item.getDescription() );
					button.addActionListener(new ItemGroupListener(order, group));
					right.add(button, c);
				
					if (x >= 5) {
						y++;
						x = 0;
					} else {
						x++;
					}
				} else {
					group.add(item);//Pack the matched item into the right group.
				}
			}
		}
		
		right.repaint();
		
	}
	
	public void showDrinks() {
		resetButtons();
		
		right.repaint();
		
	}
	
	public void showSides() {
		resetButtons();
		
		right.repaint();
		
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
