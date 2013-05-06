/**
 * 
 */
package monopoly;

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

}
