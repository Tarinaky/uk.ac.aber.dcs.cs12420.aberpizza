package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import junit.framework.TestCase;

public class OrderTests extends TestCase {
	private Order fixture = null;
	
	@Before
	public void setUp() {
		fixture = new Order();
	}
	
	@Test
	public void testCustomerName() {
		fixture.setCustomerName("Test string");
		assertTrue("Expected 'Test string'; received "+fixture.getCustomerName(),
				fixture.getCustomerName() == "Test string");
	}
	
	@Test
	public void testRemoveItems() {
		TestItem item = new TestItem();
		
		fixture.addItem(item, 1);
		fixture.updateItemQuantity(item, -1);
		
		assertTrue("Expected subtotal to be 0; received "+fixture.getSubtotal(),
				fixture.getSubtotal().compareTo(new BigDecimal(""+0) )== 0 );
	}
	
	//TODO: Test getSubtotal():BigDecimal
	//TODO: Test getDiscount():BigDecimal
	//TODO: Test getReceipt():String
}
