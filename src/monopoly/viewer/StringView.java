/**
 * 
 */
package monopoly.viewer;

import java.util.Collection;
import java.util.List;

import monopoly.Player;
import monopoly.ReadField;
import monopoly.ReadGame;
import monopoly.ReadPlayer;
import monopoly.ReadProperty;

/**
 * @author fennell
 *
 */
public class StringView {
	
	private final ReadGame game;

	
	public StringView(ReadGame game) {
		this.game = game;
	}

	/**
	 * Print the current state. Should be used outside of a turn, as printing
	 * assumes that the player queue contains all players
	 * 
	 * @param w The print writer to print to
	 */
	public String stateDescr() {
		Collection<ReadPlayer> players = game.viewPlayers();
		StringBuffer buf = new StringBuffer();
		buf.append("Monopoly state:\n");
		for (ReadPlayer p : players) {
			buf.append("Player " + p.getName() + " is on field " + fieldDescr(p.getPosition()) + " and has \n");
			buf.append("   Dollars: " + p.getCash() + "\n");
			buf.append("  Property: [ "); 
			for (ReadProperty prop : p.viewProperties()) {
				buf.append(propertyDescr(prop));
				buf.append(", ");
			}
			buf.append("]\n");
		}
		return buf.toString();
	}
	
	public String propertyDescr(ReadProperty prop) {
		String result = prop.getName();
		if (prop.isMortgaged()) {
			result = "(" + result + ")";
		}
		return result;
	}
	
	public String fieldDescr(int position) {
		List<ReadField> board = game.viewBoard();
		if (position >= board.size()) {
			return "<unknown>";
		} else {
			return board.get(position).getName();
		}
	}
}
