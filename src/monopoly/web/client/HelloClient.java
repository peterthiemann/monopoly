package monopoly.web.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HelloClient {

	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:8080/Java2013git/MonopolySnapshot");
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		System.out.println("" + con.getResponseCode() + con.getResponseMessage());
		Scanner s = new Scanner(con.getInputStream());
		while (s.hasNext()) {
			System.out.println(s.nextLine());
		}
		s.close();
	}

}
