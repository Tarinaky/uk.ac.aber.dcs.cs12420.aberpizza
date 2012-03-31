package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Till;

/**
 * Creates a JFrame within which orders may be created and placed.
 * 
 * @author Jacob Smith
 *
 */
public class OrderPlacer {
	/**
	 * Handle to the model that this view inserts orders into.
	 */
	private Till till = null;
	private OrderBuilder orderPanel = null;
	
	/**
	 * Create, arrange and set visible the elements of the JFrame.
	 * 
	 * @param till The till model that this JFrame should operate upon.
	 */
	public OrderPlacer(Till till) {
		this.till = till;
		
		JFrame frame = new JFrame("Order Placer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container layout = frame.getContentPane();
		GridBagLayout gbl = new GridBagLayout();
		layout.setLayout(gbl);
		gbl.layoutContainer(layout);
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		
		JToolBar toolbar = new JToolBar("toolbar");
		toolbar.setFloatable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0;
		layout.add(toolbar, c);
		
		JButton button = null;
		
		button = new JButton("New order");
		button.addActionListener(new NewOrderListener(this));
		toolbar.add(button);
		
		button = new JButton("Send order");
		button.addActionListener(new SendOrderListener(this));
		toolbar.add(button);
		
		orderPanel = new OrderBuilder();
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 1;
		c.weighty = 1;
		layout.add(orderPanel.getComponent(), c);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public OrderBuilder order() { return orderPanel; }
	
	public static void main (String[] args) { OrderPlacer foo = new OrderPlacer(new Till()); }
	

	
}
