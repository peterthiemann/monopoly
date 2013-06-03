/**
 * 
 */
package monopoly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author thiemann
 *
 */
public class Player {
	private final String name;
	private int position;
	private int cash;
	private Collection<IProperty> ownedProperty;
	private Queue<IActionCard> cards;
	
	private JailState jailState;
	
	public Player(String name) {
		this.name = name;
		this.position = Constants.START_POSITION;
		this.cash = Constants.START_CASH;
		this.ownedProperty = new ArrayList<IProperty>();
		this.cards = new LinkedList<IActionCard>();
		this.jailState = JailState.FREE;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * @return the cash
	 */
	public int getCash() {
		return cash;
	}

	/**
	 * @param cash the cash to set
	 */
	public void setCash(int cash) {
		this.cash = cash;
	}

	/**
	 * @return the jailState
	 */
	public JailState getJailState() {
		return jailState;
	}

	/**
	 * @return the inJail
	 */
	public boolean isInJail() {
		return this.jailState != JailState.FREE;
	}

	public void gotoJail() {
		this.jailState = JailState.INJAIL;
	}

	public void addProperty(IProperty prop) {
		this.ownedProperty.add(prop);
	}
	
	public boolean ownsProperty(IProperty prop) {
		return this.ownedProperty.contains(prop);
	}
	
	public boolean earn(int amount) {
		if (amount > 0) {
			this.cash += amount;
			return true;
		} else {
			return false;
		}
	}

	public boolean pay(int price) {
		if ( (price > 0) && (price <= this.cash) ) {
			this.cash -= price;
			return true;
		} else {
			return false;
		}
	}

	public boolean payto(Player obligee, int amount) {
		if (this.pay(amount)) {
			obligee.earn(amount);
			return true;
		} else {
			return false;
		}
	}

	public boolean ownsAllInGroup(Group colorGroup) {
		int count = 0;
		for (IProperty prop : this.ownedProperty) {
			if (prop.inColorGroup(colorGroup)) {
				count++;
			}
		}
		return count == colorGroup.getNrInGroup();
	}

	public boolean anyMortgaged(Group group) {
		for (IProperty prop : this.ownedProperty) {
			if (prop.inColorGroup(group) && prop.isMortgaged()) {
				return true;
			}
		}
		return false;
	}

	public int countRailroads() {
		int count = 0;
		for (IProperty prop : this.ownedProperty) {
			if (prop.isRailroad()) {
				count++;
			}
		}
		return count;
	}

	public boolean ownsAllUtilities() {
		int count = 0;
		for (IProperty prop : this.ownedProperty) {
			if (prop.isUtility()) {
				count++;
			}
		}
		return count == Constants.NR_OF_UTILITIES;
	}

	public int numberOfHouses() {
		int count = 0;
		for (IProperty prop : this.ownedProperty) {
			count += prop.numberOfHouses();
		}
		return count;
	}
	
	public int numberOfHotels() {
		int count = 0;
		for (IProperty prop : this.ownedProperty) {
			count += prop.numberOfHotels();
		}
		return count;
	}

	public void addCard(AActionCard aActionCard) {
		this.cards.add(aActionCard);
	}
	
	public boolean playGetOutOfJail() {
		if (this.cards.isEmpty()) {
			return false;
		} else {
			IActionCard ac = this.cards.poll();
			ac.returnCard();
			this.jailState = JailState.FREE;
			return true;
		}
	}

}
