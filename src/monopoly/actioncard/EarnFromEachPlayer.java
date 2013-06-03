package monopoly.actioncard;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import monopoly.AAction;
import monopoly.AActionCard;
import monopoly.IAction;
import monopoly.IDice;
import monopoly.Player;

public class EarnFromEachPlayer extends AActionCard {
	private final int amount;

	public EarnFromEachPlayer(String description, int amount) {
		super(description);
		this.amount = amount;
	}

	@Override
	public IAction action(final Player current, final Collection<Player> others, IDice dice) {
		return new AAction(this.description, true) {
			Iterable<Player> playersToBeBilled = new LinkedList<Player>(others);
			@Override
			public boolean execute() {
				boolean done = true;
				Iterator<Player> iter = playersToBeBilled.iterator();
				while (iter.hasNext()) {
					Player obligor = iter.next();
					if (obligor.payto(current, amount)) {
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
