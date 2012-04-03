package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.beans.*;
import java.io.*;
import java.util.*;

/**
 * Class for storing Item objects representing goods for sale.
 * 
 * @author Jacob Smith
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
	
	public void save(String filename) throws IOException {
		if (filename == null) {
			filename = "inventory.xml";
		}
		
		File path = new File ("data");
		// If directory does not exist, create it.
		if (path.exists() != true) {
			path.mkdir();
		}
		path = new File(path, filename);
		
		XMLEncoder encoder = new XMLEncoder(
				new BufferedOutputStream(
						new FileOutputStream(path)));
		encoder.writeObject(items);
		encoder.close();
		
	}
	
	public static Inventory load(String filename)
	throws IOException {
		if (filename == null) {
			filename = "inventory.xml";
		}
		
		File path = new File ("data", filename);
		
		XMLDecoder decoder = new XMLDecoder(
				new BufferedInputStream(
						new FileInputStream(path)));
		//Inventory inventory = (Inventory)decoder.readObject();
		Inventory inventory = new Inventory();
		inventory.view().addAll((Collection<? extends Item>) decoder.readObject() );
		decoder.close();
		
		return inventory;
		
	}
	
}
