package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

public abstract class AbstractItem implements Item {

	private BigDecimal price = new BigDecimal(""+10.99);
	private String description = "Default item, default description.";
	private double size = 1;
		
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
	
	public double getSize() { return size; }
	public void setSize(double size) { this.size = size; } 

}