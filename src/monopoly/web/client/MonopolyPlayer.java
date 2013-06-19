package monopoly.web.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class MonopolyPlayer {

	private final String name;
	private final Scanner in = new Scanner(System.in);

	public MonopolyPlayer(String name) {
		this.name = name;
	}
	
	private URL respUrl() throws IOException {
		return new URL("http://localhost:8080/Java2013git/MonopolyResponse?"
				+ URLEncoder.encode(name, "UTF-8"));
	}

	private URL stateUrl() throws IOException {
		return new URL("http://localhost:8080/Java2013git/MonopolySnapshot");
	}

	private URL submitUrl(String msg) throws MalformedURLException, IOException {
		// Example: http://localhost:8080/Java2013git/MonopolySubmit?player=Alfred&submit=YES"
		return new URL(
				"http://localhost:8080/Java2013git/MonopolySubmit?player="
						+ URLEncoder.encode(name, "UTF-8") + "&submit="
						+ URLEncoder.encode(msg, "UTF-8"));
	}

	public void run() {
		while (true) {
			try {
				printState();
				waitForQuestion();
				sendAnswer();
			} catch (IOException e) {
				System.err.println("IO error. Press any key to continue.");
				in.nextLine();
			}
		}
	}

	// Get a snapshot from the server
	private void printState() throws IOException {
		System.out.println(readUrl(stateUrl(), "GET"));
	}

	// Print messages until the server wants an answer
	private void waitForQuestion() throws IOException {
		String resp;
		while (true) {
			resp = readUrl(respUrl(), "POST");
			if (resp.startsWith("QUESTION")) {
				return; // we are finished waiting
			} else  if (resp.startsWith("UPDATE")) {
				printState(); // print the state again
			} else {
				System.out.print(" >>>> " + resp);
			}
		} 
	}

	
	// Read an answer from the console and send it to the server
	private void sendAnswer() throws MalformedURLException, IOException {
		System.out.println(readUrl(submitUrl(in.nextLine()), "POST"));
	}

	private String readUrl(URL url, String method) throws IOException {
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod(method);

		if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
			return "ERROR: " + con.getResponseCode() + " "
					+ con.getResponseMessage();
		}

		Scanner s = new Scanner(con.getInputStream());
		StringBuffer result = new StringBuffer();
		while (s.hasNext()) {
			result.append(s.nextLine() + "\n");
		}
		s.close();
		return result.toString();
	}


}
