package monopoly;

import java.util.Collection;

public class LuxuryTaxField implements IField {

	@Override
	public IAction action(Player current, Collection<Player> others, IDice dice) {
		int amount = Constants.LUXURY_TAX;
		return new PayAction("Luxury Tax $", current, amount);
	}

	public String getName() {
		return "Luxury tax";
	}
}
