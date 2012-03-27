package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	
	private Date date;
	private String customerName;
	
	public Order() {}
	
	public void setCustomerName(String name) {}
	public String getCustomerName() {
		return customerName;}
	
	public void addItem(Item item, int quantity) {}
	public void updateItemQuantity(Item item, int quantity) {}
	
	public BigDecimal getSubtotal() {
		return null;}
	public BigDecimal getDiscount() {
		return null;}
	
	public String getReceipt() {
		return null;}
}
