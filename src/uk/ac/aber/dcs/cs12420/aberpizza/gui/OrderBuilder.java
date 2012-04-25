package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import uk.ac.aber.dcs.cs12420.aberpizza.data.*;

/**
 * A pair of panels, the left describing an order under construction and the right displaying
 * inventory items that can be added to that order.
 * @author Tarinaky
 *
 */
public class OrderBuilder {
	/** The order under construction */
	private Order order = null;
	/** A handle to the inventory used to populate the right hand panel. */
	private Inventory inventory = null;
	private JSplitPane panel = null;
	private JPanel right,left;
	private int y,x;
	
	public OrderBuilder (Inventory inventory) {
		this.inventory = inventory;
		
		
		panel = new JSplitPane();
				
		newOrder();
		
	}
	/**
	 * Draws the order under construction in {@link #left}.
	 */
	public void drawOrder() {
		left = new JPanel(new GridBagLayout() );
		panel.setLeftComponent(left);
		GridBagConstraints c = new GridBagConstraints();
		JButton button = null;
		
		y = 0;
				
		for (OrderItem entry : order.getEntries() ) {
			c.gridy = y;
			c.gridx = 0;
			left.add(new JLabel(entry.getItem().toString() ), c);
			
			c.gridx = 1;
			left.add(new JLabel("x"+entry.getQuantity() ), c);
			
			c.gridx = 2;
			button = new JButton("+1");
			button.addActionListener(new PlusOneListener(order, entry.getItem(), this));
			left.add(button, c);
			
			c.gridx = 3;
			button = new JButton("-1");
			button.addActionListener(new MinusOneListener(order, entry.getItem(), this));
			left.add(button, c);
			
			c.gridx = 4;
			button = new JButton("X");
			button.addActionListener(new RemoveListener(order, entry.getItem(), this));
			left.add(button, c);
			
			y++;
		}
		
		for (Discount entry : inventory.getDiscounts()) {
			if (entry.match(order) > 0) {
				c.gridx = 0;
				c.gridy = y;
				left.add(new JLabel(entry.toString()), c);
				
				c.gridx = 1;
				left.add(new JLabel("-£"+entry.getValue().multiply(new BigDecimal(""+entry.match(order)))
						),c);
				
				y++;
			}
		}
		
		c.gridx = 0;
		c.gridy = y;
		
		left.add(new JLabel("Total: "), c);
		
		c.gridx = 1;
		left.add(new JLabel(""+order.getSubtotal()), c);
	}
	/**
	 * Allows the Inventory to be split into three tabs: Pizza, Drinks and Sides.
	 * This resets the right hand panel.
	 */
	public void resetButtons() {
		right = new JPanel(new GridBagLayout() );
		panel.setRightComponent(right);
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		JButton button = new JButton("Pizza");
		button.addActionListener(new ShowPizzasListener(this));
		right.add(button, c);
		
		c.gridx = 1;
		button = new JButton ("Drinks");
		button.addActionListener(new ShowDrinksListener(this));
		right.add(button,c);
		
		c.gridx = 2;
		button = new JButton("Sides");
		button.addActionListener(new ShowSidesListener(this));
		right.add(button,c);
	}
	/**
	 * Show only pizza items in {@link #right}.
	 */
	public void showPizza() {
		resetButtons();
		
		GridBagConstraints c = new GridBagConstraints();
		y = 1;
		x = 0;
		
		LinkedList<ItemGroupButton> groups = new LinkedList<ItemGroupButton>();
				
		for (Item item : inventory.getItems()) {
			if (item instanceof PizzaItem) {
				makeButton(item, groups, c);
			}
		}
		
		right.repaint();
		
	}
	/**
	 * Show only drink items in {@link #right}.
	 */
	public void showDrinks() {
		resetButtons();
		
		GridBagConstraints c = new GridBagConstraints();
		y = 1;
		x = 0;
		
		LinkedList<ItemGroupButton> groups = new LinkedList<ItemGroupButton>();
				
		for (Item item : inventory.getItems()) {
			if (item instanceof DrinkItem) {
				makeButton(item, groups, c);
			}
		}
		
		right.repaint();
		
	}
	/**
	 * Show only side orders in {@link right}.
	 */
	public void showSides() {
		resetButtons();
		
		GridBagConstraints c = new GridBagConstraints();
		y = 1;
		x = 0;
		
		LinkedList<ItemGroupButton> groups = new LinkedList<ItemGroupButton>();
				
		for (Item item : inventory.getItems()) {
			if (item instanceof SideItem) {
				makeButton(item, groups, c);
			}
		}
		
		right.repaint();
		
	}
	/**
	 * Packs the {@link Item}s in the {@link Inventory} into {@link ItemGroupButton}s.
	 * If an ItemGroupButton for a given item exists, it is placed within it - else a new
	 * group is created to hold it.
	 * @param item
	 * @param groups
	 * @param c
	 */
	public void makeButton(Item item, LinkedList<ItemGroupButton> groups, 
			GridBagConstraints c) {
		
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
			
			c.gridy = y;
			c.gridx = x;
			JButton button = new JButton(item.getDescription() );
			button.addActionListener(new ItemGroupListener(order, group, this));
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
	/** @see #panel */
	public Component getComponent() {
		return panel;
	}
	/** @see #order */
	public void newOrder () {
		order = new Order();
		showPizza();
		drawOrder();
	}
	/** @see #order */
	public Order getOrder() {
		return order;
	}
}

class ShowPizzasListener implements ActionListener {

	private OrderBuilder a = null;
	
	public ShowPizzasListener(OrderBuilder a) {
		this.a = a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		a.showPizza();
	}

}

class ShowDrinksListener implements ActionListener {

	private OrderBuilder a = null;
	
	public ShowDrinksListener(OrderBuilder a) {
		this.a = a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		a.showDrinks();
	}

}

class ShowSidesListener implements ActionListener {

	private OrderBuilder a = null;
	
	public ShowSidesListener(OrderBuilder a) {
		this.a = a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		a.showSides();
	}

}