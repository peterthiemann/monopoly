package monopoly.actioncard;

import java.util.Collection;

import monopoly.AAction;
import monopoly.AActionCard;
import monopoly.IAction;
import monopoly.IDice;
import monopoly.Player;

public final class EarnMoney extends AActionCard {
	private final int amount;
	public EarnMoney(String description, int amount) {
		super(description);
		this.amount = amount;
	}

	@Override
	public IAction action(final Player current, Collection<Player> others, IDice dice) {
		return new AAction(this.description, true) {

			@Override
			public boolean execute() {
				current.earn(amount);
				return false;
			}
			
		};
	}
}