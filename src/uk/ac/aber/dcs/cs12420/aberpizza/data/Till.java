package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
	
	public String toString() {
		String s = "";
		for (Order order : orders) {
			if (s.compareTo("")==0) {
				s = ""+order;
			} else {
				s = s + " " + order;
			}
		}
		return s;
	}
	
	public void setOrders(LinkedList<Order> orders) {
		this.orders = orders;
	}
	
	public LinkedList<Order> getOrders() {
		return orders;
	}
	
	/**
	 * 'Places' an order by entering it into the system. An order cannot be modified
	 * after this point, a new order must be placed instead.
	 * 
	 * @param order The order to be registered.
	 */
	public void addOrder(Order order) {
		orders.add(order);
		try {
			save();
		} catch (IOException e) {
			System.err.println("Could not write to file.");
		}
	}
	
	/**
	 * Totals all orders for a given day.
	 * <p>
	 * Because of limitations in the Date object unusual behavior may occur
	 * about the hour of midnight, and whichever day it is associated with
	 * depends on DST. There is no easy solution to this problem.
	 * <p>
	 * I am also unsure what occurs if an order is placed at -exactly- 00:00:00.000
	 * (to the millisecond).
	 * 
	 * @return The total value of all orders taken since 00:00:00.000 (midnight) UTC.
	 */
	public BigDecimal getTotalForDay() {
		ListIterator<Order> iterator = orders.listIterator(orders.size() );
		
		BigDecimal total = new BigDecimal(""+0);
		
		final long milisInADay = 24 * 60 * 60 * 1000;
		Date today = new Date((new Date().getTime()/milisInADay)*milisInADay);
		
		while (iterator.hasPrevious() ) {
			Order order = iterator.previous();
			if (order.getDate().after(today) ) {
				total = total.add(order.getSubtotal() );
			} else {
				break;
			}
		}
		
		return total;
	}
	
	public void save() throws IOException {
		File path = new File ("data");
		
		if (path.exists() != true) {
			path.mkdir();
		}
		
		final long milisInADay = 24 * 60 * 60 * 1000;
		Date today = new Date((new Date().getTime()/milisInADay)*milisInADay);
				
		path = new File(path, ""+today.getTime()+".xml" );
		
		XMLEncoder encoder = new XMLEncoder(
				new BufferedOutputStream(
						new FileOutputStream(path)));
		encoder.writeObject(this);
		encoder.close();
		
	}
	
	public static Till load() throws IOException {
		final long milisInADay = 24 * 60 * 60 * 1000;
		Date today = new Date((new Date().getTime()/milisInADay)*milisInADay);
		
		File path = new File("data", ""+today.getTime()+".xml" );
		
		XMLDecoder decoder = new XMLDecoder(
				new BufferedInputStream(
						new FileInputStream(path)));
		Till till = (Till) decoder.readObject();
		decoder.close();
		return till;
	}
	
}
