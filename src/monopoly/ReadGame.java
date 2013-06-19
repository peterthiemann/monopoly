package monopoly;

import java.util.List;

public interface ReadGame {

	public abstract ReadDice viewDice();

	public abstract List<ReadField> viewBoard();

	public abstract List<ReadPlayer> viewPlayers();

	public abstract ReadPlayer viewNextPlayer();

}
