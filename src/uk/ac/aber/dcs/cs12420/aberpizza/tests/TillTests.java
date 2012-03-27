package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import org.junit.Before;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Till;
import junit.framework.TestCase;

public class TillTests extends TestCase {
	private Till fixture = null;
	
	@Before
	public void setUp() {
		fixture = new Till();
	}
}
