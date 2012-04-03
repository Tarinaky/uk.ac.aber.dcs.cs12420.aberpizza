package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import java.io.IOException;

import org.junit.*;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Inventory;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Item;
import junit.framework.TestCase;

public class InventoryTest extends TestCase {
	private Inventory fixture = null;
	private Item testItem = null;
	
	@Before
	public void setUp() {
		fixture = new Inventory();
		testItem = new TestItem();
		fixture.add(testItem);
	}
	
	@Test
	public void testItem() {
		
		assertTrue("Expected item to be in fixture.",
				fixture.view().contains(testItem) );
	}
	
	@Test
	public void testSerialisation() {
		try {
			
			fixture.save("testInventory.xml");
			fixture = Inventory.load("testInventory.xml");
		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException.");
		}
		
		assertTrue("Expected item to be in fixture.",
				fixture.view().contains(testItem) );
		
	}

}
