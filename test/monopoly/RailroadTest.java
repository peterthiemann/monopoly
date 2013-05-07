package monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RailroadTest {
	
	private Railroad rr_reaching;
	private Railroad rr_penn;
	private Player p1;
	private Player p2;
	
	
	@Before
	public void setUp() {
		rr_penn = Railroad.makePennsylvania();
		rr_reaching = Railroad.makeReaching();
		p1 = new Player("Test1");
		p2 = new Player("Test2");
	}


	/**
	 * Test method for {@link monopoly.Street#buy()}.
	 */
	@Test
	public void testBuy() {
		assertTrue(rr_reaching.buy(p1));
		assertEquals("Player did not pay the right amount", -200, p1.getCash() - Constants.START_CASH);		
		assertEquals(rr_reaching.getState(), RState.OWNED);
		assertFalse("Player could by owned railroad", rr_reaching.buy(p2));
	}
	
	/**
	 * Test method for {@link monopoly.Street#calculateRent()}.
	 */
	@Test
	public void testCalculateRent() {
		assertTrue(rr_penn.buy(p1));
		assertEquals(rr_penn.calculateRent(), Constants.RAILROAD_BASE_RENT);
		assertTrue(rr_reaching.buy(p1));
		assertEquals(rr_penn.calculateRent(), 2*Constants.RAILROAD_BASE_RENT);
		assertEquals(rr_reaching.calculateRent(), 2*Constants.RAILROAD_BASE_RENT);
	}

	
}
