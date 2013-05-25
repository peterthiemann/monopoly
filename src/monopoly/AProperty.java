/**
 * 
 */
package monopoly;

import java.util.Collection;

/**
 * @author adpult
 *
 */
public abstract class AProperty implements IField, IProperty {

	private final String name;
	private final int price;

	/**
	 * null iff !this.isOwned()
	 */
	protected Player owner;
	
	protected AProperty(String name, int price) {
		this.name = name; this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}


	/**
	 * Buy this property.
	 * @return true if buying the property was successful.
	 */
	public boolean buy(Player p) {
		if ( !this.isOwned() && p.pay(this.price)) {
			/*this.state = State.OWNED;*/
			this.setOwnedState(p);
			p.addProperty(this);
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean isOwned() {
		return this.owner != null;
	}
	protected void setOwnedState(Player p) {
		this.owner = p;
	}

	public abstract int calculateRent(ReadDice dice);
	
	public boolean inColorGroup(Group colorGroup) {
		return false;
	}
	
	public boolean isRailroad() {
		return false;
	}
	
	public boolean isUtility() {
		return false;
	}

	@Override
	public IAction action(Player current, Collection<Player> others, IDice dice) {
		if (!this.isOwned()) {
			// offer to buy the property
			return new BuyAction("Buy " + this.getName() + " for $" + this.getPrice() , current, this);
		} else {
			// pay rent
			if (current == this.owner) {
				return NoAction.getInstance();
			} else {
				int amount = this.calculateRent(dice);
				if (amount>0) {
					return new PayToAction("Pay $" + amount + " rent for " + this.getName() + " to " + owner.getName(),
							current, this.owner, amount);
				} else {
					return NoAction.getInstance();
				}
			}
		}
	}
	

}
