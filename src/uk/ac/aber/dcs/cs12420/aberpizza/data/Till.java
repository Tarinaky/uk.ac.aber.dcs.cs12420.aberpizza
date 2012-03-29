package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Holds a list of Order objects. The Till provides operations
 * to save the till and load the till. XML Serialisation must be
 * used for the save/load process.
 * 
 * @author Neil Taylor
 * @author Jacob Smith
 *
 */
public class Till {
	/**
	 * A list of orders. New orders are always appended to the end of this list and,
	 * assuming only a single thread, they will thus be sorted by date in this form
	 * implicitly.
	 */
	List<Order> orders = null;

	public Till() {}
	
	public void addOrder(Order order) {}
	
	public BigDecimal getTotalForDay() {
		return null;}
	
	public void save() {}
	
	public static Till load() throws IOException {
		return null;}
	
}
