package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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
	LinkedList<Order> orders = null;

	public Till() {
		orders = new LinkedList<Order>();
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public BigDecimal getTotalForDay() {
		ListIterator<Order> iterator = orders.listIterator(orders.size() );
		
		BigDecimal total = new BigDecimal(""+0);
		
		final long milisInADay = 24 * 60 * 60 * 1000;
		Date today = new Date((new Date().getTime()/milisInADay)*milisInADay);
		
		while (iterator.hasPrevious() ) {
			Order order = iterator.previous();
			if (order.getDate().after(today) ) {
				total = total.add(order.getSubtotal() );
			}
		}
		
		return total;
	}
	
	public void save() throws IOException {}
	
	public static Till load() throws IOException {
		return null;}
	
}
