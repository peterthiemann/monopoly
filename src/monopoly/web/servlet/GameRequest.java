package monopoly.web.servlet;

import monopoly.ReadPlayer;

public interface GameRequest {
	/**
	 * @return true, if the request is a YES
	 */
	public boolean isYes();
	
	/**
	 * @return The player that issues the request
	 */
	public String getPlayerName();
	
	/**
	 * @return The choice that the request represents
	 */
	public int getChoice();
}
