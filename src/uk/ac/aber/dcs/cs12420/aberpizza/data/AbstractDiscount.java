package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * Implementation of {@link Discount} interface containing as much general functionality for a
 * discount as possible.
 * 
 * @author Tarinaky
 *
 */
public abstract class AbstractDiscount implements Discount {
	/** Stores the value of the discount when serialised.
	 * This is used to allow for this value to be serialised - removing 
	 * source-code dependence on the implementation. 
	 */
	private BigDecimal savedValue = null;
	/**
	 * Is set true when the discount is finalised.
	 */
	private boolean finalised = false;

	public String toString() { return getDescription(); }
	
	/** Saves the total worth of this discount.
	 * 
	 * @param value A BigDecimal, with the value in pounds, to be deducted from the order this discount is associated with.
	 */
	protected void setValue(BigDecimal value) {
		savedValue = value;
	}
	
	/**
	 * If this discount is finalised, it returns the total value of the discount;
	 * else it returns the per-match value of this discount.
	 */
	public BigDecimal getValue() {
		if (isFinalised() == false) {
			return calculateValue();
		} else {
			return savedValue;
		}
	}
	
	/**
	 * Finalise this discount.
	 * @param order The order this discount is to be included within. This order must have its
	 * finalised flag set true or behavior is undefined.
	 */
	public void finalise(Order order) {
		setValue(getValue().multiply(new BigDecimal(match(order))));
		setFinalised(order.isFinalised());
	}
	
	/**
	 * Calculates the per-match value of this discount.
	 * @return The value to be multiplied by the number of matches.
	 */
	public abstract BigDecimal calculateValue();
	
	/**
	 * XMLEncoder requires a default constructor for all serialised elements.
	 * BigDecimal does not support a default constructor so getStringValue is used to
	 * return a string representation of the BigDecimal value.
	 * @return The saved value of this finalised discount, as a string.
	 * @see #setStringValue
	 */
	public String getStringValue() { return ""+savedValue; }
	/**
	 * XMLEncoder requires a default constructor for all serialised elements.
	 * BigDecimal does not support a default constructor so setStringValue is used to
	 * set a string representation of the BigDecimal value.
	 * @param s The saved value of this finalised discount, as a string.
	 * @see #getStringValue
	 */
	public void setStringValue(String s) { savedValue = new BigDecimal(s); }

	/**
	 * @return True if this discount is finalised and calculateValue/match should not be used.
	 */
	public boolean isFinalised() {
		return finalised;
	}
	/**
	 * 
	 * @param finalised True if this discount is finalised and calculateValue/match should no longer be used.
	 */
	public void setFinalised(boolean finalised) {
		this.finalised = finalised;
	}
	
	/**
	 * Each order should have its own copy of a given discount, with which it can save the
	 * value and other data of that discount at the time the discount was created. This override
	 * allows for the creation of shallow copies of discount objects.
	 */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
	
}
