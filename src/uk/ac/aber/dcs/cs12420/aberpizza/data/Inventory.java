package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.beans.*;
import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * Class for storing Item objects representing goods for sale.
 * 
 * The Inventory loaded into the program represents the current Inventory for sale. Past products
 * are individually saved in a Till's log. While this bloats the log somewhat it reduces dependencies.
 * 
 * @author Jacob Smith
 *
 */
public class Inventory {
	/**
	 * A collection of Items sold by this store.
	 */
	private ArrayList<Item> items = null;
	/**
	 * A collection of Discounts to be applied to items made at this store. Discounts will be applied
	 * in whatever order they appear in this Collection.
	 */
	private ArrayList<Discount> discounts = null;
	/**
	 * A handle to the last inventory deserialised by {@link #load(String)}. More than one Inventory
	 * should not be in use at a time without removing this field and refactoring appropriately.
	 */
	public static Inventory singleton = null;
	
	public Inventory() {
		items = new ArrayList<Item>();
		discounts = new ArrayList<Discount>();
	}
	/** @see #items */
	public ArrayList<Item> getItems() { return items; }
	/** @see #items */
	public void setItems(ArrayList<Item> items) { this.items = items; }
	
	/** @see #discounts */
	public ArrayList<Discount> getDiscounts() { return discounts; }
	/** @see #discounts */
	public void setDiscounts(ArrayList<Discount> discounts) { this.discounts = discounts; }
	
	/**
	 * Serialise this inventory object to disk. The file will be written in the data directory,
	 * relative to whatever current working directory the JVM is invoked with.
	 * 
	 * This method is not used by the AberPizza program 
	 * ({@link uk.ac.aber.dcs.cs12420.aberpizza.gui.OrderPlacer#main(String[])}) but
	 * is used by {@link uk.ac.aber.dcs.cs12420.aberpizza.pipeline.InventoryEditor#main(String[])} 
	 * @param filename Name of the file the inventory should be serialised to.
	 * @throws IOException
	 */
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
		encoder.writeObject(this);
		encoder.close();
		
	}
	
	/**
	 * Deserialises an Inventory object from the filename specified. The method first attempts
	 * to find the file inside the JAR this class is run from (inside a data directory at said JAR's
	 * root) or fails onto searching data in the current working directory.
	 * @param filename The name of the file to be loaded as an Inventory, or null to default to
	 * 'inventory.xml'
	 * @return The Inventory object. This object will also be referenced by {@link #singleton}.
	 * @throws IOException
	 */
	public static Inventory load(String filename)
	throws IOException {
		if (filename == null) {
			filename = "inventory.xml";
		}
		
		URL url = Inventory.class.getClassLoader().getResource("data/"+filename);
		XMLDecoder decoder;
		if (url != null) {
			decoder = new XMLDecoder(
					new BufferedInputStream(
						url.openStream() ));
		} else {
			//e.printStackTrace();
			System.out.println("Could not open 'data/"+filename+"' from jar, trying filesystem.");
			File path = new File("data", filename);
			decoder = new XMLDecoder(
					new BufferedInputStream(
							new FileInputStream(path)));
		}
		
		//Inventory inventory = (Inventory)decoder.readObject();
		Inventory inventory = (Inventory) decoder.readObject();
		decoder.close();
		
		singleton = inventory;
		return inventory;
		
	}
	
}
