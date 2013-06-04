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
	 * mortgaged implies this.isOwned()
	 */
	private boolean mortgaged;

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
	@Override
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
			this.setOwnedState(p);
			p.addProperty(this);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isOwned() {
		return this.owner != null;
	}
	protected void setOwnedState(Player p) {
		this.owner = p;
	}

	public abstract int calculateRent(ReadDice dice);
	

	@Override
	public int askRent(ReadDice dice) {
		if (this.isMortgaged()) {
			return 0;
		} else {
			return this.calculateRent(dice);
		}
	}

	
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
	
	public boolean isMortgaged() {
		return this.mortgaged;
	}
	
	public boolean obtainMortgage() {
		if(!this.isOwned() || this.isMortgaged()) {
			return false;
		} else {
			this.mortgaged = true;
			this.owner.earn(this.getMortgageValue());
			return true;
		}
	}
	
	public boolean releaseMortgage() {
		if (this.isOwned() && this.isMortgaged() && this.owner.pay(this.getMortgageReleaseAmount())) {
			this.mortgaged = false;
			return true;
		} else {
			return false;
		}
	}

	protected int getMortgageValue() {
		return getPrice() / 2;
	}

	protected int getMortgageReleaseAmount() {
		int amount = this.getMortgageValue();
		amount += amount / 10;
		return amount;
	}

	public Player getOwner() {
		return this.owner;
	}
	
	public int numberOfHouses() {
		return 0;
	}
	
	public int numberOfHotels() {
		return 0;
	}

}
