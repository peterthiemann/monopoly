/** * */
package monopoly;

import monopoly.viewer.StringView;

/**
 * @author adpult
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game(new String[] { "Alfred", "Berta", "Chris"}, new TwoD6());
		IDialog diag = new ConsoleDialog();
		StringView view = new StringView(game);
		while (true) {
			System.out.println(view.stateDescr());
			game.turn(diag);
		}
	}
}
