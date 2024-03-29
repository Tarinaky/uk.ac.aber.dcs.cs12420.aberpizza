package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import java.io.IOException;

import org.junit.*;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Inventory;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Item;
import junit.framework.TestCase;

public class InventoryTest extends TestCase {
	private Inventory fixture = null;
	private Item testItem = null;
	
	/**
	 * Populates a sample inventory with a single item.
	 */
	@Before
	public void setUp() {
		fixture = new Inventory();
		testItem = new TestItem();
		fixture.getItems().add(testItem);
	}
	
	/**
	 * Verifies the integrity of the test inventory.
	 */
	@Test
	public void testItem() {
		
		assertTrue("Expected item to be in fixture.",
				fixture.getItems().contains(testItem) );
	}
	
	/**
	 * Verifies that serialisation, and deserialisation, works.
	 */
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
				((Item) fixture.getItems().toArray()[0]).getDescription(), 
				((Item) loaded.getItems().toArray()[0]).getDescription() );
		
	}

}
