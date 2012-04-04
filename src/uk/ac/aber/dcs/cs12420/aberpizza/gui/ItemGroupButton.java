package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.util.*;

import uk.ac.aber.dcs.cs12420.aberpizza.data.*;

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
