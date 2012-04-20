package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

public class BOGOFDiscount extends AbstractDiscount {
	private Item item;
	
	@Override
	public int match(Order order) {
		OrderItem entry = order.getOrderTable().get(item);
		if (entry == null) {
			return 0;
		} else {
			return entry.getQuantity()/2;
		}
	}

	@Override
	public BigDecimal calculateValue() {
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
