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
	public static final int BOARD_SIZE = 40;
	
	public List<Player> players;
	public int current; // index into players
	public IField[] board;
	public IDice dice;
	
	public Queue<IActionCard> chanceCards;
	public Queue<IActionCard> communityChestCards;
	
	private static IField[] initBoard() {
		IField[] b = new IField[BOARD_SIZE];
		b[00] = null; // GO!
		b[01] = Street.makeBaltic();
		return b;
	}

}
