/**
 * @opt hide
 * @author Tarinaky
 *
 */
class BigDecimal {}

/**
 * @opt all
 * @author Tarinaky
 *
 */
interface Item {
	public String getDescription();
	public BigDecimal getPrice();
	public double getSize();
	public String getStringPrice();
	public void setDescription(String s);
	public void setPrice(BigDecimal price);
	public void setSize(double d);
	public void setStringPrice(String s);
}
/**
 * @opt all
 * @assoc 1 - * Item
 * @assoc 1 - * Discount
 * @author Tarinaky
 *
 */
class Inventory {
	private ArrayList<Discount> discounts;
	private ArrayList<Item> items;
	public static Inventory singleton;
	
	public ArrayList<Discount> getDiscounts() {}
	public ArrayList<Item> getItems() {}
	public static Inventory load(String filename) {}
	public void save(String filename) {}
	public void setDiscounts(ArrayList<Discount> discounts) {}
	public void setItems(ArrayList<Item> items) {}
}
/** @opt hide */
class ArrayList<Discount> {}
/** @opt hide */
class ArrayList<Item> {}

interface Discount {}