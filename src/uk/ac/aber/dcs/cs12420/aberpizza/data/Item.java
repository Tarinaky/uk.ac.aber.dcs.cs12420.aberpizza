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
	/**
	 * @return The price of the item for sale.
	 */
	public BigDecimal getPrice();
	/**
	 * @param price The price of the item for sale.
	 */
	public void setPrice(BigDecimal price);
	
	/**
	 * XMLEncoder can not serialise BigDecimals as they do not have default constructors.
	 * The inclusion of methods handling Strings is needed as a work-around this problem.
	 * @return
	 */
	public String getStringPrice();
	/**
	 * XMLEncoder can not serialise BigDecimals as they do not have default constructors.
	 * The inclusion of methods handling Strings is needed as a work-around this problem.
	 * @return
	 */
	public void setStringPrice(String s);
	
	/**
	 * @return A short one-line describing this item or brand. For example: 'ACME Cola', or 'Fried Chicken'.
	 */
	public String getDescription();
	/**
	 * @param description A short one-line describing this item or brand. For example: 'ACME Cola', or 'Fried Chicken'.
	 */
	public void setDescription(String description);
	
	/**
	 * @return The size of the Item. The format and meaning of this value depends strictly on specialisation.
	 */
	public double getSize();
	/**
	 * @param d The size of the Item. The format and meaning of this value depends strictly on specialisation.
	 */
	public void setSize(double d);
}
