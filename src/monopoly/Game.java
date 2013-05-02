/**
 * 
 */
package monopoly;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author adpult
 *
 */
public class Game {
	private final Queue<Player> players;
	private Player current; // not contained in players
	private final IField[] board;
	private final IDice dice;
	
	public Queue<IActionCard> chanceCards;
	public Queue<IActionCard> communityChestCards;
	
	public IDice getDice() {
		return dice;
	}
	
	public IField getField(int n) {
		return board[n];
	}
	
	public Game() {
		this.board = initBoard();
		this.dice = new TwoD6();
		this.players = new LinkedList<Player>();
	}

	private static IField[] initBoard() {
		IField[] b = new IField[Constants.BOARD_SIZE];
		b[00] = null; // GO!
		b[01] = Street.makeBaltic();
		return b;
	}
	
	public void turn() {
		IAction currentAction;
		if (current != null) {
			players.add(current);
		}
		current = players.remove();
		dice.roll();
		current.advance(dice.getValue());
		do {
			int currentPos = current.getPosition();
			currentAction = this.getField(currentPos).action(this);
			if (currentAction != null) {
				current.register(currentAction);
				if (currentAction.isImmediate()) {
					currentAction.execute();
				}
			}
		} while (currentAction != null && currentAction.isImmediate());
		// interaction w current until current.pending is empty
	}

	public Player getCurrent() {
		return this.current;
	}

}
