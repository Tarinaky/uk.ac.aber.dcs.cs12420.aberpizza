package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

public abstract class AbstractDiscount implements Discount {
	private BigDecimal savedValue = null;

	public String toString() { return getDescription(); }
	
	protected void setValue(BigDecimal value) {
		savedValue = value;
	}
	
	public BigDecimal getValue() {
		if (savedValue == null) {
			return calculateValue();
		} else {
			return savedValue;
		}
	}
	
	public void finalise() {
		setValue(getValue());
	}
	
	public abstract BigDecimal calculateValue();
	
	public String getStringValue() { return ""+savedValue; }
	public void setStringValue(String s) { savedValue = new BigDecimal(s); }

}
