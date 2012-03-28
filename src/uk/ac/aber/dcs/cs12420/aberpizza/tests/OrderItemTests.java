package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Item;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import junit.framework.TestCase;

/**
 * Test item describing a simple implementation of an Item.
 * 
 * @author Tarinaky
 *
 */
class TestItem implements Item {
	
	private BigDecimal price = new BigDecimal(""+10.99);
	private String description = "Test item, default description.";
	
	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
		
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	
}

public class OrderItemTests extends TestCase {
	private OrderItem fixture = null;
	
	@Before
	public void setUp() {
		fixture = new OrderItem(new TestItem(), 3);
	}
	
	@Test
	public void testQuantity() {
		assertTrue("Initial quantity is expected to be 3; received"+fixture.getQuantity(),
				fixture.getQuantity() == 3);
	}
	
	@Test
	public void testTotal() {
		assertTrue("Expected total for 3 items at 10.99 is 32.97; received "+fixture.getOrderItemTotal().toString(), 
				fixture.getOrderItemTotal().compareTo(new BigDecimal(""+32.97) ) == 0 );
	}
}
