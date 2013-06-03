package monopoly.actioncard;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import monopoly.AAction;
import monopoly.AActionCard;
import monopoly.IAction;
import monopoly.IDice;
import monopoly.Player;

public final class PayToEachPlayer extends AActionCard {
	private final int amount;
	public PayToEachPlayer(String description, int amount) {
		super(description);
		this.amount = amount;
	}

	@Override
	public IAction action(final Player current, final Collection<Player> others, IDice dice) {
		return new AAction(this.description, true) {
			Iterable<Player> playersToBePaid = new LinkedList<Player>(others);
			@Override
			public boolean execute() {
				boolean done = true;
				Iterator<Player> iter = playersToBePaid.iterator();
				while (iter.hasNext()) {
					Player obligee = iter.next();
					if (current.payto(obligee, amount)) {
						iter.remove();
					} else {
						done = false;
					}
				}
				return done;
			}
			
		};
	}
}