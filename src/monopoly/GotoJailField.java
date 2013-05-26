package monopoly;

import java.util.Collection;

public class GotoJailField implements IField {
	public static final String NAME = "Go to jail";

	@Override
	public IAction action(Player current, Collection<Player> others, IDice dice) {
		return new GotoJailAction(NAME, current);
	}

	@Override
	public String getName() {
		return NAME;
	}
	

}
