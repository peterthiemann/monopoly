/**
 * 
 */
package monopoly;

import java.util.Collection;

/**
 * @author adpult
 *
 */
public class Utility extends AProperty {
	
	protected Utility(String name, int price) {
		super(name, price);
	}
	
	public boolean isUtility() {
		return true;
	}

	public int calculateRent(ReadDice dice) {
		if (!this.isOwned()) {
			return 0;
		}
		return (this.owner.ownsAllUtilities() ? 10 : 4) * dice.getValue();
	}

	@Override
	public boolean isMortgaged() {
		// TODO Auto-generated method stub
		return false;
	}

	public static Utility makeElectric() {
		return new Utility("Electric Company", Constants.UTILITY_PRICE);
	}

	public static Utility makeWater() {
		return new Utility("Water Works", Constants.UTILITY_PRICE);
	}

	@Override
	public IAction action(Player current, Collection<Player> others, IDice dice) {
		// TODO Auto-generated method stub
		return null;
	}

}
