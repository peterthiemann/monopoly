package monopoly;

import java.util.LinkedList;
import java.util.Collection;
import java.util.Queue;

public abstract class AActionCardField implements IField {
	private final String name;
	private final Queue<IActionCard> cards; 
	
	protected AActionCardField(String name) {
		this.name = name;
		this.cards = new LinkedList<IActionCard>();
	}

	protected void initCards(IActionCard[] cards) {
		for (IActionCard c : cards) {
			if (c != null) this.cards.add(c);  // as long as some cards are not yet defined
		}
	}

	@Override
	public IAction action(Player current, Collection<Player> others, IDice dice) {
		IActionCard drawn = cards.poll();
		IAction action = drawn.action(current, others, dice);
		if (!action.isGetOutOfJail()) cards.add(drawn);
		return action;
	}

	@Override
	public String getName() {
		return name;
	}

	public void returnCard(AActionCard aActionCard) {
		cards.add(aActionCard);
	}

}
