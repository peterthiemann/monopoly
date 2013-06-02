package monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RailroadTest {
	
	private AProperty rr_reaching;
	private AProperty rr_penn;
	private AProperty rr_bo;
	private AProperty rr_short;
	private Player p1;
	private Player p2;
	private IDice the_dice;
	
	
	@Before
	public void setUp() {
		rr_penn = Railroad.makePennsylvania();
		rr_reaching = Railroad.makeReading();
		rr_bo = Railroad.makeBO();
		rr_short = Railroad.makeShortLine();
		
		p1 = new Player("Test1");
		p2 = new Player("Test2");
		
		the_dice = new TwoD6();
		the_dice.roll();
	}


	/**
	 * Test method for {@link monopoly.Street#buy()}.
	 */
	@Test
	public void testBuy() {
		assertTrue(rr_reaching.buy(p1));
		assertEquals("Player did not pay the right amount", -200, p1.getCash() - Constants.START_CASH);		
		assertTrue("Railroad not bought", rr_reaching.isOwned());
		assertFalse("Player could by owned railroad", rr_reaching.buy(p2));
	}
	
	/**
	 * Test method for {@link monopoly.Street#calculateRent()}.
	 */
	@Test
	public void testCalculateRent() {
		assertTrue(rr_penn.buy(p1));
		assertEquals(25, rr_penn.calculateRent(the_dice));
		assertTrue(rr_reaching.buy(p1));
		assertEquals(50, rr_penn.calculateRent(the_dice));
		assertEquals(50, rr_reaching.calculateRent(the_dice));
		assertEquals(0, rr_bo.calculateRent(the_dice));
		assertTrue(rr_bo.buy(p1));
		assertEquals(100, rr_bo.calculateRent(the_dice));
		assertTrue(rr_short.buy(p1));
		assertEquals(200, rr_bo.calculateRent(the_dice));
	}

}
