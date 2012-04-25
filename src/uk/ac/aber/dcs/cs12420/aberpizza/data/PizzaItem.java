package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.util.*;

/**
 * Specialisation representing a pizza.
 * @author Tarinaky
 *
 */
public class PizzaItem extends AbstractItem {
	/**
	 * A collection describing the toppings and components of this pizza.
	 */
	private Collection<String> toppings = null;
	
	public PizzaItem() {
		setDescription("Default Pizza");
		toppings = new LinkedList<String>();
		
	}
	/** @see #toppings */
	public Collection<String> getToppings() { return toppings; }
	/** @see #toppings */
	public void setToppings(Collection<String> s) { toppings = s; }
		
	@Override
	public String toString() {
		String s = "Pizza, "+getDescription()+" "+getSize()+"\" £"+getPrice()+" [ ";
		for (String topping : getToppings() ) {
			s = s + topping + " ";
		}
		s = s + "]";
		return s;
	}
	
}
