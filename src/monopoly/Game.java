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
	private Queue<Player> players;
	private Player current; // not contained in players
	private IField[] board;
	private IDice dice;
	
	private Queue<IActionCard> chanceCards;
	private Queue<IActionCard> communityChestCards;
	
	private static IField[] initBoard() {
		IField[] b = new IField[Constants.BOARD_SIZE];
		b[00] = null; // GO!
		b[01] = Street.makeMediterranian();
		b[03] = Street.makeBaltic();
		b[37] = Street.makeParkPlace();
		b[39] = Street.makeBoardWalk();
		return b;
	}

}
