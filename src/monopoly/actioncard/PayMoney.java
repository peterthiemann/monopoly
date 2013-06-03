package monopoly.actioncard;

import java.util.Collection;

import monopoly.AActionCard;
import monopoly.IAction;
import monopoly.IDice;
import monopoly.PayAction;
import monopoly.Player;

public final class PayMoney extends AActionCard {
	public PayMoney(String description, int amount) {
		super(description);
	}

	@Override
	public IAction action(final Player current, Collection<Player> others, IDice dice) {
		return new PayAction(this.description, current, 15);
	}
}