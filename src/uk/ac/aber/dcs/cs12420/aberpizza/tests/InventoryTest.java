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
		Inventory loaded = null;
		try {
			
			fixture.save("testInventory.xml");
			loaded = Inventory.load("testInventory.xml");
		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException.");
		}
		
		assertEquals("Inventories expected to be the same.",
				((Item) fixture.view().toArray()[0]).getDescription(), 
				((Item) loaded.view().toArray()[0]).getDescription() );
		
	}

}
