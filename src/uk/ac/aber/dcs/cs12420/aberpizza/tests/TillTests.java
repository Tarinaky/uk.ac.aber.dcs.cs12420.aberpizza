package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Till;
import junit.framework.TestCase;

public class TillTests extends TestCase {
	private Till fixture = null;
	
	@Before
	public void setUp() {
		fixture = new Till();
	}
	
	@Test
	public void testAddOrder() {
		Order testOrder = new Order();
		
		testOrder.addItem(new TestItem(), 1);
		assertTrue("Subtotal should be 10.99; received "+testOrder.getSubtotal().toString(),
				testOrder.getSubtotal().compareTo(new BigDecimal(""+10.99) ) == 0);
		
		fixture.addOrder(testOrder);
		assertTrue("Total for day should be 10.99; received "+fixture.getTotalForDay().toString(),
				fixture.getTotalForDay().compareTo(new BigDecimal(""+10.99) ) == 0);

		
	}
	
	@Test
	public void testSerialisation() throws IOException {
		Order testOrder = new Order();
		
		testOrder.addItem(new TestItem(),1);
		assertTrue("Subtotal should be 10.99; received "+testOrder.getSubtotal().toString(),
				testOrder.getSubtotal().compareTo(new BigDecimal(""+10.99)) == 0);
		
		fixture.addOrder(testOrder);
		
		fixture.save();
		fixture = Till.load();
		
		assertTrue("Till failed to deserialise properly.\n"+
				"Loaded: "+testOrder
				+"\nExpected: "+fixture.getOrders().getFirst(),
				testOrder.toString().compareTo(fixture.getOrders().getFirst().toString()) == 0);
		
	}
}
