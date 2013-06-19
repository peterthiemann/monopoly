/** * */
package monopoly.web.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import monopoly.ConsoleDialog;
import monopoly.Game;
import monopoly.IDialog;
import monopoly.TwoD6;
import monopoly.viewer.StringView;

/**
 * @author adpult
 * 
 */
public class SnapshotClient {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Game game = new Game(new String[] { "Alfred", "Berta", "Chris" },
				new TwoD6());
		IDialog diag = new ConsoleDialog();
		StringView view = new StringView(game);
		while (true) {
			System.out.println(view.stateDescr());
			HttpURLConnection con = (HttpURLConnection) new URL(
					"http://localhost:8080/Java2013git/MonopolySnapshot?"
							+ URLEncoder.encode(view.stateDescr(), "UTF-8")).openConnection();
			con.setRequestMethod("POST");
			System.out.println("" + con.getResponseCode() + " " + con.getResponseMessage());
			game.turn(diag);
		}
	}
}
