package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * Generic implementation of Item in the context of the AberPizza solution.
 * @author Tarinaky
 *
 */
public abstract class AbstractItem implements Item {

	/**
	 * A BigDecimal storing the price of this item, in pounds.
	 */
	private BigDecimal price = new BigDecimal(""+10.99);
	/**
	 * A short string describing this item. For example, 'ACME Cola' or Chips.
	 */
	private String description = "Default item, default description.";
	/**
	 * The 'size' of the item. The format of this field depends on extensions to this class,
	 * and Items with no meaningful size data (or where there is only one size available) can
	 * safely ignore this value.
	 */
	private double size = 1;
		
	/**
	 * @see #price
	 */
	@Override
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @see #price
	 */
	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
		
	}
	
	/** XML Encoder requires a default constructur so BigDecimals must be serialised in string form.
	 * @param s The price of the item, in pounds.
	 * */
	public void setStringPrice(String s) {
		this.price = new BigDecimal(s);
	}
	/** XML Encoder requires a default constructur so BigDecimals must be serialised in string form.
	 * @return The price of the item, in pounds.
	 */
	public String getStringPrice() {
		return this.price.toString();
	}

	/**
	 * @see #description
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * @see #description
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @see #size
	 */
	public double getSize() { return size; }
	/**
	 * @see #size
	 */
	public void setSize(double size) { this.size = size; } 

}
