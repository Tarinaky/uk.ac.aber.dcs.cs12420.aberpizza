package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.util.*;

import uk.ac.aber.dcs.cs12420.aberpizza.data.*;

/**
 * Where there are multiple {@link Item}s with the same description (but different sizes),
 * the buttons on the inventory panel correspond to items grouped by description.
 * @author Tarinaky
 *
 */
public class ItemGroupButton {
	private LinkedList<Item> group = null;
	private String description = null;
	
	public ItemGroupButton(Item item) {
		this.description = item.getDescription();
		group = new LinkedList<Item>();
		group.add(item);
	}
	
	public LinkedList<Item> getList() { return group; }
	public void add(Item item) { group.add(item); }
	
	public String getDescription() { return description; }
	
}
