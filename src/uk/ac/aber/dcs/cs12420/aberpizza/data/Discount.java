package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * Current discounts are stored as a Collection in {@link Inventory}, 
 * but each {@link Order} in a {@link Till}s log will contain its own copy of whatever
 * Discounts applied to that order at the point-of-sale.
 * 
 * It is assumed that these discounts are not exclusive - multiple discounts may apply to a single item.
 * 
 * @author Tarinaky
 *
 */
public interface Discount extends Cloneable {
	
	/**
	 * Match's mapping from {@link Order}->int describes how many times a particular discount
	 * may be applied to an Order. It is this method which describes, formally, how a given
	 * type of Discount works.
	 * 
	 * @param order The order this discount is being applied to.
	 * @return The number of times this discount should be applied to an order.
	 */
	public int match(Order order);
	
	/**
	 * @return A short, one line, description of the discount being applied. 
	 */
	public String getDescription();
	//public void setDescription(String s);
	
	/**
	 * @return If finalised then return the total discount applied; else return the per-match discount to be applied.
	 */
	public BigDecimal getValue();
	
	/**
	 * Finalise a discount.
	 * @param o The order this discount is being included in.
	 */
	public void finalise(Order o);

	/**
	 * Each Order retains its own copy of a Discount at the point-of-sale making this method necessary.
	 * @return
	 */
	public Object clone();		
}
