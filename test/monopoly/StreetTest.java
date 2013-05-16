/**
 * 
 */
package monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author thiemann
 *
 */
public class StreetTest {
	
	private Street s_med, s_bal;
	private Player p;
	private IDice the_dice;
	
	@Before 
	public void setUp() {
		s_med = Street.makeMediterranian();
		s_bal = Street.makeBaltic();
		p = new Player("TestPlayer Anton");
		the_dice = new TwoD6();
		the_dice.roll();
	}

	/**
	 * Test method for {@link monopoly.Street#buy()}.
	 */
	@Test
	public void testBuy() {
		assertTrue(s_med.buy(p));
		assertEquals(s_med.getState(), State.OWNED);
	}

	/**
	 * Test method for {@link monopoly.Street#buyHouse()}.
	 */
	@Test
	public void testBuyHouse() {
		assertTrue(s_med.buy(p));
		assertFalse("should own all streets in color group", s_med.buyHouse());
		assertTrue(s_bal.buy(p));
		assertTrue("owns all streets in color group", s_med.buyHouse());
	}

	/**
	 * Test method for {@link monopoly.Street#calculateRent()}.
	 */
	@Test
	public void testCalculateRent() {
		assertTrue(s_med.buy(p));
		assertEquals(s_med.calculateRent(the_dice), 2);
		assertTrue(s_bal.buy(p));
		assertEquals(s_bal.calculateRent(the_dice), 8);
		assertTrue("should be able to mortgage empty street", s_bal.obtainMortgage());
		assertEquals(s_bal.calculateRent(the_dice), 0);
		assertEquals(s_med.calculateRent(the_dice), 4);
		assertFalse("should not be able to build on mortgaged property", s_bal.buyHouse());
		assertFalse("should not be able to build if another street is mortgaged", s_med.buyHouse());
		assertTrue("should have enough cash to release mortgage", s_bal.releaseMortgage());
		assertEquals(s_bal.calculateRent(the_dice), 8);
		assertTrue("should be able to build house", s_med.buyHouse());
		assertEquals(s_med.calculateRent(the_dice), 10);
		// assertFalse("must build houses evenly", s_med.buyHouse());
	}

}
