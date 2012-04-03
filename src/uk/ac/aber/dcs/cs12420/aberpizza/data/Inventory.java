package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class for storing Item objects representing goods for sale.
 * 
 * @author Tarinaky
 *
 */
public class Inventory {
	/**
	 * A collection of Items sold by this store.
	 */
	private ArrayList<Item> items = null;
	
	public Inventory() {
		items = new ArrayList<Item>();
	}
	
	/**
	 * Sugar adding an item to the collection items. This should be
	 * equivalent to using view().add.
	 * 
	 * @param item Item to be added to the collection.
	 * @see #view()
	 */
	public void add(Item item) { items.add(item); }
	
	/**
	 * Returns a handle to the Collection of items stored by the
	 * inventory.
	 * 
	 * @return Handle to items object.
	 * @see #add(Item)
	 */
	public Collection<Item> view() { return items; }

}
