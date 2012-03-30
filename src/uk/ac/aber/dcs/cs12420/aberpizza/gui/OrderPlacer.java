package uk.ac.aber.dcs.cs12420.aberpizza.gui;

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
	}
	

}
