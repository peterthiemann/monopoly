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
		aproperty.buy(p);
		assertEquals("Player has not paid", 0, p.getCash());
		assertTrue(aproperty.isOwned());
		assertEquals("Player is not owner", p, aproperty.getOwner());
		assertFalse(aproperty.isMortgaged());
	}

}
