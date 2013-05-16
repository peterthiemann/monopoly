/**
 * 
 */
package monopoly;

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
	protected int getPrice() {
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
	

}
