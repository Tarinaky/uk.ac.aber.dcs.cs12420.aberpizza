package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * Represents a link to a particular Item, which is an
 * interface that should be implemented by the products
 * in your design, and the number of the specified item.
 * 
 * For example, an OrderItem might represent a pizza,
 * with quantity 2.
 * 
 * @author Jacob Smith
 *
 */
public class OrderItem {
	/**
	 * The number of copies of item condensed into this table row.
	 */
	private int quantity;
	/**
	 * The actual item in this entry. This was added to the design.
	 */
	private Item item;
	
	/**
	 * 
	 * 
	 * @param item The item to associate with this entry (eg. Pizza, Soda, etc...) 
	 * @param quantity The number of 'copies' to add as part of this entry.
	 */
	public OrderItem(Item item, int quantity) {
		this.setQuantity(quantity);
		this.setItem(item); 
	}
	
	public OrderItem() {
		
	}
	
	public Item getItem() { return item; }
	
	/**
	 * @return The number of copies of this item in this entry.
	 */
	public int getQuantity() {
		return quantity;
	}
	
	public String toString() {
		return getItem().toString() + " x"+getQuantity();
	}
	
	/**
	 * Implemented by multiplying the 'quantity' field by the price stored inside the item.
	 * 
	 * @return The total cost of this order entry.
	 */
	public BigDecimal getOrderItemTotal() {
		return getItem().getPrice().multiply(new BigDecimal(getQuantity()) );
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
