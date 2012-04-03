package uk.ac.aber.dcs.cs12420.aberpizza.data;

public class DrinkItem extends AbstractItem {
	
	private double size = 1;
	
	public DrinkItem() {
		setDescription("Default drink");
	}
	
	public double getSize() { return size; }
	public void setSize(double size) { this.size = size; } 
	
}
