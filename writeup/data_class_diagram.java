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
 * @composed 1 - * Item
 * @composed 1 - * Discount
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
/**
 * @opt all
 * @author Tarinaky
 *
 */
interface Discount {
	public Object clone();
	public void finalise(Order o);
	public String getDescription();
	public BigDecimal getValue();
	public int match(Order o);
}
/**
 * @opt all
 * @composed 1 - * OrderItem
 * @composed 1 - * Discount
 * @author Tarinaky
 *
 */
class Order{
	private Collection<Discount> appliedDiscounts;
	private String customerName;
	private Date date;
	private boolean finalised;
	private Map<Item,OrderItem> orderTable;
	
	public void addItem(Item item, int quantity);
	public void finalise();
	public Collection<Discount> getAppliedDiscounts();
	public String getCustomerName();
	public Date getDate();
	public BigDecimal getDiscount();
	public Collection<OrderItem> getEntries();
	public Map<Item,OrderItem> getOrderTable();
	public String getReceipt();
	public BigDecimal getSubtotal();
	public boolean isFinalised();
}