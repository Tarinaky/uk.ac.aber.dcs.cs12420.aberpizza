package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import org.junit.Before;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import junit.framework.TestCase;

public class OrderTests extends TestCase {
	private Order fixture = null;
	
	@Before
	public void setUp() {
		fixture = new Order();
	}
}
