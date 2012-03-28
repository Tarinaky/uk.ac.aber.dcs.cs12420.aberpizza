package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * A list of {@link OrderItem} objects. There are methods
 * to add items, use the customer's name and to get information
 * about the subtotal and discounts for a particular order.
 * 
 * The order should also return a receipt. This is specified to
 * return a string, plain text or html.
 * 
 * @author Neil Taylor
 *
 */
public class Order {
	
	private Date date;
	private String customerName;
	
	public Order() {}
	
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
