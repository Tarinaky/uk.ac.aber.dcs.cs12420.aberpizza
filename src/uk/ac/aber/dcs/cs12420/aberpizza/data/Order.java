package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
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
 * @author Jacob Smith
 */
public class Order {
	
	/**
	 * The date the order was created. This is automatically generated
	 * when the order is constructed, and automatically updated when the order is finalised
	 * to match today's date. This field
	 * is used to sort and filter the orders when they are complete and stored.
	 */
	private Date date = null;
	/**
	 * The name of the customer, as required by the specification.
	 */
	private String customerName = null;
	/**
	 * A list of copied discount objects, used to store the discounts that
	 * applied to this order at the point of sale.
	 */
	private Collection<Discount> appliedDiscounts = null;
	/**
	 * This value is true if the order is finalised. This should be set true before finalising
	 * the order's components.
	 */
	private boolean finalised = false;
	
	/**
	 * A map containing each row of the order
	 * ordered according to the item. This can be thought of as
	 * a table where each item may appear once (or not at all).
	 */
	private Map<Item,OrderItem> orderTable = null;
	
	public Order() {
		setOrderTable(new HashMap<Item,OrderItem>());
		setDate(new Date());
	}
	
	public String toString() {
		String s = "";
		for (OrderItem entry : orderTable.values()) {
			if (s.compareTo("") == 0) {
				s = s + customerName+" "+getDate()+" [";
				s = s + entry;
			} else {
				s = s + ", " + entry.toString();
			}
		}
		s = s + "]";
		return s;
	}
	
	/** @see #customerName */
	public void setCustomerName(String name) {
		this.customerName = name;
	}
	/** @see #customerName */
	public String getCustomerName() {
		return customerName;
	}
	
	/**
	 * Adds an item to the table or sets an existing item's quantity.
	 * <p>
	 * Removing an item can be achieved by 'adding' (or setting) it with
	 * quantity '0'.
	 * 
	 * @param item The item to be set in the table.
	 * @param quantity The number of copies of the item required in the order.
	 * @see #updateItemQuantity
	 * @see #orderTable
	 * 
	 */
	public void addItem(Item item, int quantity) {
		if (quantity > 0) {
			getOrderTable().put(item, new OrderItem(item, quantity) );
		} else {
			getOrderTable().remove(item);
		}
	}
	
	/**
	 * Change an item's quantity. This increments or decrements the quantity.
	 * <p>
	 * Removing an item can be achieved by reducing its quantity to 0.
	 * 
	 * @param item The item to be modified in the table.
	 * @param quantity The number of copies to add (if positive) or remove (if negative)
	 * @see #addItem
	 * @see #orderTable
	 */
	public void updateItemQuantity(Item item, int quantity) {
		if ( getOrderTable().containsKey(item) ) {
			quantity += getOrderTable().get(item).getQuantity();
		} else if (quantity <= 0) {
			return;
		}

		addItem(item,quantity);
	}
	
	/**
	 * 
	 * @return All the Item entries that make up an order.
	 */
	public Collection<OrderItem> getEntries() {
		return getOrderTable().values();
	}
	/**
	 * @see #appliedDiscounts
	 * @return All the discounts that apply to this order.
	 */
	public Collection<Discount> getAppliedDiscounts() {
		return appliedDiscounts;
	}
	/**
	 * Allows deserialisation of {@link #appliedDiscounts}
	 * @param appliedDiscounts The discounts applied to this item.
	 */
	public void setAppliedDiscounts(Collection<Discount> appliedDiscounts) {
		this.appliedDiscounts = appliedDiscounts;
	}
	
	/**
	 * Return the subtotal (including discounts) of this order.
	 * <p>
	 * This is calculated by iterating through each row of orderTable and
	 * obtaining the price associated with that row.
	 * 
	 * @return The price, before discounts, of this order.
	 * @see #orderTable
	 * @see OrderItem#getOrderItemTotal
	 */
	public BigDecimal getSubtotal() {
		BigDecimal subtotal = new BigDecimal(""+0);
		for (OrderItem item : getOrderTable().values() ) {
			subtotal = subtotal.add(item.getOrderItemTotal() );
		}
		return subtotal.subtract(getDiscount() );
	}
	
	/**
	 * If not {@link #finalised}, it checks each discount active in the inventory and, if it applies to this
	 * order, adds it to {@link #appliedDiscounts}. 
	 * @return The total discount applicable to this order.
	 */
	public BigDecimal getDiscount() {
		if (!isFinalised()) {
			
			appliedDiscounts = new LinkedList<Discount>();
		
			Collection<Discount> discounts = Inventory.singleton.getDiscounts();
			BigDecimal discount = new BigDecimal(""+0);
			for (Discount entry : discounts) {
				discount = discount
						.add(entry.getValue()
								.multiply(new BigDecimal(""+entry.match(this) ) ) );
				if(entry.match(this) > 0) {
					appliedDiscounts.add((Discount) entry.clone());
				}
			}
			return discount;
		} else {
			BigDecimal discount = new BigDecimal(""+0);
			for (Discount entry : appliedDiscounts) {
				discount = discount
						.add(entry.getValue());
			}
			return discount;
		}
		
	}
	
	
	/**
	 * Finalises this order and its children.
	 */
	public void finalise() {
		setFinalised(true);
		for (Discount discount : appliedDiscounts) {
			discount.finalise(this);
			setDate(new Date() );
		}
	}
	
	/**
	 * @return A multi-line receipt. 
	 */
	public String getReceipt() {
		StringBuffer s = new StringBuffer(""+niceDate(date)+", AberPizza\n");
		s.append("Order for "+getCustomerName()+"\n");
		for (OrderItem entry : orderTable.values()) {
			s.append("\t"+entry+": £"+entry.getOrderItemTotal()+"\n");
		}
		for (Discount entry : getAppliedDiscounts() ) {
		s.append("\t"+entry+", -£"+entry.getValue()+"\n");
		}
		s.append("Total: £"+getSubtotal()+"\n");
		s.append("\n");
		return s.toString();
	}

	/**
	 * Utility function, not necissarily applicable only to Order.
	 * @param date The date to format.
	 * @return A date in the form 'YYYY-MM-DD @ HH:MM'.
	 */
	public static String niceDate(Date date) {
		StringBuffer s = new StringBuffer(Till.niceDate(date));
		s.append(" @ "+date.getHours()+":"+date.getMinutes());
		return s.toString();
	}

	/**
	 * If not finalised, produces the time that this order was originally constructed.
	 * When the order is finalised it produces the time finalise was called. 
	 * 
	 * @return A Date object referring to the time.
	 */
	public Date getDate() {
		return date;
	}
	/** @see #date */
	public void setDate(Date date) {
		this.date = date;
	}

	/** @see #orderTable */
	public Map<Item,OrderItem> getOrderTable() {
		return orderTable;
	}
	/** @see #orderTable */
	public void setOrderTable(Map<Item,OrderItem> orderTable) {
		this.orderTable = orderTable;
	}
	/** @see #finalised */
	public boolean isFinalised() {
		return finalised;
	}
	/** @see #finalised */
	public void setFinalised(boolean finalised) {
		this.finalised = finalised;
	}
}
