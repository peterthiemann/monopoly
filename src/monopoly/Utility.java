/**
 * 
 */
package monopoly;

/**
 * @author adpult
 *
 */
public class Utility extends AProperty {
	
	private Utility(String name, int price) {
		super(name, price);
	}
	
	public boolean isUtility() {
		return true;
	}

	public int calculateRent(ReadDice dice) {
		if (!this.isOwned()) {
			return 0;
		}
		return (this.getOwner().ownsAllUtilities() ? 10 : 4) * dice.getValue();
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

}
