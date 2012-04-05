package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * An interface that should be implemented by all items
 * available for sale.
 * 
 * @author Jacob Smith
 *
 */
public interface Item {
	
	public BigDecimal getPrice();
	public void setPrice(BigDecimal price);
	
	public String getStringPrice();
	public void setStringPrice(String s);
	
	public String getDescription();
	public void setDescription(String description);
	
	public double getSize();
	public void setSize(double d);
}
