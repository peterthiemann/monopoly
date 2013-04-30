package monopoly;

import java.util.List;

public interface IField {
	public IAction action(List<Player> players, int current, IDice dice);
}
