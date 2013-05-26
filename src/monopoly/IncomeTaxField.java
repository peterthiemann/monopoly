/**
 * 
 */
package monopoly;

import java.util.Collection;

/**
 * @author thiemann
 *
 */
public class IncomeTaxField implements IField {

	/* (non-Javadoc)
	 * @see monopoly.IField#action(monopoly.Player, java.util.Collection, monopoly.IDice)
	 */
	@Override
	public IAction action(Player current, Collection<Player> others, IDice dice) {
		int amount = Constants.INCOME_TAX;
		// ... or 10% of all assets: need method Player.allAssets() to compute value of all assets
		return new PayAction("Income tax $" + amount, current, amount);
	}
	
	public String getName() {
		return "Income tax";
	}

}
