package uk.ac.aber.dcs.cs12420.aberpizza.data;

/**
 * Class describing beverages. It is designed with soft-drinks in mind.
 * 
 * The {@link AbstractItem#size} of a DrinkItem is assumed to be in Litres.
 * @author Tarinaky
 */
public class DrinkItem extends AbstractItem {
	/**
	 * Default constructor.
	 */
	public DrinkItem() {
		setDescription("Default drink");
	}
	/**
	 * A string representation of this item, includes the name of the product, its size in L and
	 * its price in pounds.
	 */
	public String toString() {
		String s = "Drink, " + getDescription() + ", " + getSize() + "L , £" +
				getPrice();
		return s;
	}
	
}
