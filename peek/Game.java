/**
 * 
 */
package monopoly;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author adpult
 *
 */
public class Game {
	public Queue<Player> players;
	public Player current; // not contained in players
	public IField[] board;
	public IDice dice;
	
	public Queue<IActionCard> chanceCards;
	public Queue<IActionCard> communityChestCards;
	
	private static IField[] initBoard() {
		IField[] b = new IField[Constants.BOARD_SIZE];
		b[00] = null; // GO!
		b[01] = Street.makeMediterranian();
		b[03] = Street.makeBaltic();
		return b;
	}
	
	/**
	 * Start a turn by rolling the dice, moving the player and collecting the available Actions
	 * @return the available actions for the current player
	 */
	public PlayerChoices turn() {
		// get the next player
		current = players.remove();
		// roll dice
		// deal with jail
		// (perhaps) move
		// determine possible actions
		// Let the player choose from the actions he can do.
		return new PlayerChoices(current.collectActions(), this.currentFinalAction());
	}

	private IAction currentFinalAction() {
		IField currentField = this.board[current.getPosition()];
		if (currentField == null) {
			return null;
		} else {
			return currentField.action(current, players, dice);
		}
	}


}
