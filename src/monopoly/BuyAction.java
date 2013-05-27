/**
 * 
 */
package monopoly;

/**
 * @author thiemann
 *
 */
public class BuyAction extends AAction {
	private final Player buyer;
	private final AProperty street;

	public BuyAction(String description, Player current, AProperty street) {
		super(description, false);
		this.buyer = current;
		this.street = street;
	}

	@Override
	public boolean execute() {
		return street.buy(buyer);
	}
}
