package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		layout.setLayout(new GridBagLayout() );
		GridBagConstraints c = new GridBagConstraints();
		
		
		JToolBar toolbar = new JToolBar("toolbar");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		layout.add(toolbar, c);
		
		JButton button = null;
		
		button = new JButton("New order");
		toolbar.add(button);
		
		button = new JButton("Send order");
		toolbar.add(button);
		
		OrderBuilder orderPanel = new OrderBuilder();
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 1;
		layout.add(orderPanel.getComponent(), c);
		
		//frame.pack();
		frame.setVisible(true);
	}
	
	public static void main (String[] args) { OrderPlacer foo = new OrderPlacer(new Till()); }
	

	
}
