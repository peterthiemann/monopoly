package monopoly;

import static org.junit.Assert.*;

import monopoly.mock.TwoD6Mock;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void test() {
		Utility water = Utility.makeWater();
		Utility electric = Utility.makeElectric();
		Player p = new Player("test player");
		
		IDice d = new TwoD6Mock(2, 1);
		assertEquals(0, water.calculateRent(d));
		assertTrue(water.buy(p));
		assertEquals(12, water.calculateRent(d));
		assertEquals(0, electric.calculateRent(d));
		assertTrue(electric.buy(p));
		assertEquals(30, water.calculateRent(d));
		assertEquals(30, electric.calculateRent(d));
		
		d = new TwoD6Mock(3, 4);
		assertEquals(70, water.calculateRent(d));
		assertEquals(70, electric.calculateRent(d));
		
	}

}
