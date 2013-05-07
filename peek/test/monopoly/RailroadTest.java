package monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RailroadTest {
	
	private Railroad rr_reading;
	private Railroad rr_penn; 
	private Player p;
	private int startCash;
	private Player p2;

	@Before
	public void setUp() throws Exception {
		rr_reading = Railroad.makeReading();
		rr_penn = Railroad.makePennsylvania();
		p = new Player("Test Player");
		p2 = new Player("Test Player 2");
		startCash = p.getCash();
	}

	@Test
	public void testBuy() {
		assertFalse("Station is owned without being bought", rr_reading.isOwned());
		assertTrue(rr_reading.buy(p));
		assertFalse("Railroad can be bought twice", rr_reading.buy(p2));
		assertTrue("Station was bought but is not owned", rr_reading.isOwned());
		assertEquals("Player did not pay the right amount", -200, p.getCash() - startCash);
	}
	
	/**
	 * Test method for {@link monopoly.Street#calculateRent()}.
	 */
	@Test
	public void testCalculateRent() {
		assertTrue(rr_reading.buy(p));
		assertEquals("Wrong rent for 1 railway station", 25, rr_reading.calculateRent());
		assertTrue(rr_penn.buy(p));
		assertEquals("Wrong rent for 2 railway stations", 50, rr_penn.calculateRent());
		assertEquals("Wrong rent for 2 railway stations", 50, rr_reading.calculateRent());
	}
}
