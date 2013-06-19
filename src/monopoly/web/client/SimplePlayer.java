package monopoly.web.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class SimplePlayer {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("Type the player name to say ``yes''");
			String playerName = s.nextLine();
			URL url = new URL(
					"http://localhost:8080/Java2013git/MonopolySubmit?player="
							+ URLEncoder.encode(playerName, "UTF-8")
							+ "&submit=yes");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			System.out.println("" + con.getResponseCode() + " "
					+ con.getResponseMessage());
		}

	}

}
