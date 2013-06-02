package monopoly;

import static org.junit.Assert.*;

import org.junit.Test;

public class APropertyTest {

	@Test
	public void testBuy() {
		int price = 100;
		AProperty aproperty = new AProperty("Property", price) {

			@Override
			public int calculateRent(ReadDice dice) {
				return 0;
			}
			
		};
		Player p = new Player("player");
		
		p.setCash(price);
		assertFalse(aproperty.isOwned());
		assertTrue(aproperty.buy(p));
		assertEquals("Player has not paid", 0, p.getCash());
		assertTrue(aproperty.isOwned());
		assertEquals("Player is not owner", p, aproperty.getOwner());
		assertFalse(aproperty.isMortgaged());
	}
	
	@Test
	public void testMortgage() {
		int price = 100;
		AProperty aproperty = new AProperty("Property", price) {

			@Override
			public int calculateRent(ReadDice dice) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		Player p = new Player("player");
		
		p.setCash(price);
		assertFalse(aproperty.obtainMortgage());
		assertTrue(aproperty.buy(p));
		assertTrue(aproperty.obtainMortgage());
		assertEquals("player should receive half of the selling price as mortgage", price/2, p.getCash());
		assertTrue(aproperty.isMortgaged());
		assertFalse(aproperty.releaseMortgage());
		p.setCash(price/2 + price/20);
		assertTrue(aproperty.releaseMortgage());
		assertFalse(aproperty.isMortgaged());
	}

}
