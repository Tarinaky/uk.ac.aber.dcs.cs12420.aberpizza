package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * A list of {@link OrderItem} objects. There are methods
 * to add items, use the customer's name and to get information
 * about the subtotal and discounts for a particular order.
 * 
 * The order should also return a receipt. This is specified to
 * return a string, plain text or html.
 * 
 * @author Neil Taylor
 * @author Jacob Smith
 */
public class Order {
	
	/**
	 * The date the order was created. This is automatically generated
	 * when the order is constructed to match today's date. This field
	 * is used to sort and filter the orders when they are complete and stored.
	 */
	private Date date = null;
	private String customerName = null;
	
	/**
	 * A self-balancing tree containing each row of the order
	 * ordered according to the item. This can be thought of as
	 * a table where each item may appear once (or not at all).
	 */
	private Map<Item,OrderItem> orderTable = null;
	
	public Order() {
		orderTable = new TreeMap<Item,OrderItem>();
		date = new Date();
	}
	
	public void setCustomerName(String name) {
		this.customerName = name;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void addItem(Item item, int quantity) {}
	public void updateItemQuantity(Item item, int quantity) {}
	
	public BigDecimal getSubtotal() {
		return null;}
	public BigDecimal getDiscount() {
		return null;}
	
	public String getReceipt() {
		return null;}
}
