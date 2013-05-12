/**
 * 
 */
package monopoly;

/**
 * @author adpult
 *
 */
public abstract class AProperty implements IField, IProperty {

	/**
	 * null as long as state == UNOWNED
	 * not null otherwise
	 */
	protected Player owner;
	protected String name;
	protected int price;
	
	protected AProperty(String name, int price) {
		this.name = name; this.price = price;
	}


	/**
	 * Buy this street.
	 * @return true if buying the street was successful.
	 */
	public boolean buy(Player p) {
		if ( !this.isOwned() && p.pay(this.price)) {
			/*this.state = State.OWNED;*/
			this.setOwnedState();
			this.owner = p;
			p.addProperty(this);
			return true;
		} else {
			return false;
		}
	}
	
	protected abstract boolean isOwned();
	protected abstract void setOwnedState();

	protected abstract int calculateRent();
	
	public boolean inColorGroup(Group colorGroup) {
		return false;
	}
	
	public boolean isRailroad() {
		return false;
	}
	

}
