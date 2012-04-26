/**
 * @hide
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
	String getDescription();
	BigDecimal getPrice();
	double getSize();
	String getStringPrice();
	void setDescription(String s);
	void setPrice(BigDecimal price);
	void setSize(double d);
	setStringPrice(String s);
}