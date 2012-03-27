package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Holds a list of Order objects. The Till provides operations
 * to save the till and load the till. XML Serialisation must be
 * used for the save/load process.
 * 
 * @author Neil Taylor
 *
 */
public class Till {

	public Till() {}
	
	public void addOrder(Order order) {}
	
	public BigDecimal getTotalForDay() {
		return null;}
	
	public void save() {}
	
	public static Till load() throws IOException {
		return null;}
	
}
