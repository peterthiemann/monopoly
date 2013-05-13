package monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RailroadTest {
	
	private Railroad rr_reaching;
	private Railroad rr_penn;
	private Railroad rr_bo;
	private Railroad rr_short;
	private Player p1;
	private Player p2;
	
	
	@Before
	public void setUp() {
		rr_penn = Railroad.makePennsylvania();
		rr_reaching = Railroad.makeReaching();
		rr_bo = Railroad.makeBAndO();
		rr_short = Railroad.makeShortline();
		
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
		assertEquals(25, rr_penn.calculateRent());
		assertTrue(rr_reaching.buy(p1));
		assertEquals(50, rr_penn.calculateRent());
		assertEquals(50, rr_reaching.calculateRent());
		assertEquals(0, rr_bo.calculateRent());
		assertTrue(rr_bo.buy(p1));
		assertEquals(100, rr_bo.calculateRent());
		assertTrue(rr_short.buy(p1));
		assertEquals(200, rr_bo.calculateRent());
	}

	
}
