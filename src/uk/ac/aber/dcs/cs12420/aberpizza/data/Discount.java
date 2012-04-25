package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

public interface Discount extends Cloneable {
	
	public int match(Order order);
	
	public String getDescription();
	//public void setDescription(String s);
	
	public BigDecimal getValue();
	
	public void finalise(Order o);

	public Object clone();		
}
