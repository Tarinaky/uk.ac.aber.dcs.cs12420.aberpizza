package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * An example of a discount specialisation. The BOGOF discount represents a buy one get one free
 * offer on a single item instance. This offer cannot be applied to a class of items, a different
 * discount object (making use of instanceof or some other data) should be used instead.
 * 
 * A further limitation of this implementation is that it only supports 'Buy One Get One Free', 
 * it does not support arbitrary 'Buy N Get M Free'. Again, this could be implemented by adding N and M
 * as fields and specialising {@link #match(Order)} appropriately.
 * @author Tarinaky
 *
 */
public class BOGOFDiscount extends AbstractDiscount {
	/**
	 * The item this BOGOF discount matches.
	 */
	private Item item;
	
	/**
	 * This specialisation searches the given order for {@link #item} and returns half the quantity
	 * of that item in this order, rounded down.
	 */
	@Override
	public int match(Order order) {
		OrderItem entry = order.getOrderTable().get(item);
		if (entry == null) {
			return 0;
		} else {
			return entry.getQuantity()/2;
		}
	}

	/**
	 * The per-match value of a BOGOF order is the value of the item you are receiving for free.
	 */
	@Override
	public BigDecimal calculateValue() {
		return item.getPrice();
	}
		

	/**
	 * @see #item
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	/**
	 * @see #item
	 */
	public Item getItem() { return item; }
	
	/**
	 * @see Discount#description
	 */
	public String getDescription() {
		return "BOGOF: "+item.getDescription();
	}


}
