package monopoly;

import java.util.Collection;

public abstract class NoActionField implements IField {

	@Override
	public IAction action(Player current, Collection<Player> others, IDice dice) {
		return NoAction.getInstance();
	}

	
}
