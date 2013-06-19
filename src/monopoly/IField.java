package monopoly;

import java.util.Collection;

public interface IField extends ReadField {
	/**
	 * determine action to be taken by player arriving on field
	 * @param current player whose turn it is
	 * @param others  players who are just watching
	 * @param dice
	 * @return the IAction that has to be taken
	 */
	public IAction action(Player current, Collection<Player> others, IDice dice);

}
