package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.BorderLayout;

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
		
		JPanel layout = new JPanel();
		frame.getContentPane().add(layout);
		
		
		JToolBar toolbar = new JToolBar("toolbar");
		layout.add(toolbar);
		
		JButton button = null;
		
		button = new JButton("New order");
		toolbar.add(button);
		
		button = new JButton("Send order");
		toolbar.add(button);
		
		JPanel orderPanel = new JPanel();
		orderPanel.setSize(640, 480);
		layout.add(orderPanel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main (String[] args) { OrderPlacer foo = new OrderPlacer(new Till()); }
	

	
}
