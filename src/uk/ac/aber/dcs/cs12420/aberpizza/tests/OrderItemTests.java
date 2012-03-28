package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import junit.framework.TestCase;

public class OrderItemTests extends TestCase {
	private OrderItem fixture = null;
	
	/**
	 * Initialise a test fixture containing 3 simple Items each priced at £10.99.
	 */
	@Before
	public void setUp() {
		fixture = new OrderItem(new TestItem(), 3);
	}
	
	/**
	 * Tests the OrderItem.getQuantity() method.
	 */
	@Test
	public void testQuantity() {
		assertTrue("Initial quantity is expected to be 3; received"+fixture.getQuantity(),
				fixture.getQuantity() == 3);
	}
	
	/**
	 * Tests the OrderItem.getOrderItemTotal() method.
	 */
	@Test
	public void testTotal() {
		assertTrue("Expected total for 3 items at 10.99 is 32.97; received "+fixture.getOrderItemTotal().toString(), 
				fixture.getOrderItemTotal().compareTo(new BigDecimal(""+32.97) ) == 0 );
	}
}
