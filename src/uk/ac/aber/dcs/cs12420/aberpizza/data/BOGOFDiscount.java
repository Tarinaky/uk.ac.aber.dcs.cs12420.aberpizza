package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

public class BOGOFDiscount extends AbstractDiscount {
	private Item item;
	
	@Override
	public int match(Order order) {
		int i = 0;
		for (OrderItem entry : order.getEntries() ) {
			if (entry.getItem() == this.item) {
				i++;
			}
		}
		return i;
	}

	@Override
	public BigDecimal getValue() {
		return item.getPrice();
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public Item getItem() { return item; }
	
	public String getDescription() {
		return "BOGOF: "+item.getDescription();
	}


}
