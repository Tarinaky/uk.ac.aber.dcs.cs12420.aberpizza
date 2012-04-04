package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import java.math.BigDecimal;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Item;

/**
 * Test item describing a simple implementation of an Item.
 * 
 * @author Jacob Smith
 *
 */
public class TestItem implements Item {
	
	private BigDecimal price = new BigDecimal(""+10.99);
	private String description = "Test item, default description.";
	
	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
		
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public double getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSize(double d) {
		// TODO Auto-generated method stub
		
	}
	
}