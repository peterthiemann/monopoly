/**
 * 
 */
package monopoly;

/**
 * @author adpult
 *
 */
public class Utility implements IProperty {

	public int calculateRent() {
		return 0;
	}

	public boolean buy(Player p) {
		return false;
	}

	public int getPrice() {
		return 0;
	}

	public String getName() {
		return null;
	}

	@Override
	public boolean inColorGroup(Group colorGroup) {
		return false;
	}

	@Override
	public boolean isMortgaged() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRailroad() {
		return false;
	}

}
