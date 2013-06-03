package monopoly;

import java.util.Collection;

public interface IActionCard {
	public IAction action (Player current, Collection<Player> others, IDice dice);

	public void returnCard();
}
