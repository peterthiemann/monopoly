package monopoly;

import java.util.LinkedList;
import java.util.Collection;
import java.util.Queue;

public abstract class AActionCardField implements IField {
	private final String name;
	private final Queue<IActionCard> cards; 
	
	protected AActionCardField(String name, IActionCard[] cards) {
		this.name = name;
		this.cards = new LinkedList<IActionCard>();
		for (IActionCard c : cards) {
			this.cards.add(c);
		}
	}

	@Override
	public IAction action(Player current, Collection<Player> others, IDice dice) {
		IActionCard drawn = cards.poll();
		return drawn.action(current, others, dice);
	}

	@Override
	public String getName() {
		return name;
	}

}
