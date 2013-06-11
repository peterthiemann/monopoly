package monopoly.web.servlet;

import javax.servlet.ServletContext;

import monopoly.Game;
import monopoly.IDialog;
import monopoly.ReadPlayer;
import monopoly.TwoD6;
import monopoly.viewer.StringView;
import monopoly.web.util.IMQ;
import monopoly.web.util.MQ;

public class GameRunner implements Runnable {

	public static final String[] PLAYER_NAMES = new String[] { "Alfred",
			"Berta", "Chris" };
	
	public static final String REQ_Q_NAME = "monopoly.reqQ";

	private final Game game;
	private final ServletContext ctxt;

	private final StringView view; // new since 2013-06-04
	
	public static String respQName(String n) {
		return "monopoly.resp." + n;
	}

	public GameRunner(ServletContext ctxt) {
		this.ctxt = ctxt;
		// create the queues
		ctxt.setAttribute(REQ_Q_NAME, new MQ<GameRequest>());
		for (String n : PLAYER_NAMES) {
			ctxt.setAttribute(respQName(n), new MQ<String>());
		}
		// create the game
		game = new Game(PLAYER_NAMES, new TwoD6());
		
		// and the view
		view = new StringView(game);
	}

	@Override
	public void run() {
		updateState(); // new since 2013-06-04
		while (true) {
			final ReadPlayer current = game.viewNextPlayer();
			game.turn(new IDialog() {

				@Override
				public void message(String msg) {
					IMQ<String> respQ = (IMQ<String>) ctxt
							.getAttribute(respQName(current.getName()));
					respQ.submitRequest(msg);
				}
				
				@Override
				public boolean askYesOrNo() {
					// notify client that he should answer
					IMQ<String> respQ = (IMQ<String>) ctxt
							.getAttribute(respQName(current.getName()));
					respQ.submitRequest("QUESTION");
					IMQ<GameRequest> q = (IMQ<GameRequest>)ctxt.getAttribute(REQ_Q_NAME);
					while (true) {
						GameRequest req = q.getNextRequest();
						if (req.getPlayerName().equals(current.getName())) {
						   return req.isYes();
						}
					}
				}
				
				@Override
				public int choose(int nrChoices) {
					// TODO Auto-generated method stub
					return 0;
				}

			});
			updateState(); // new since 2013-06-04
		}
	}
	
	private void updateState() {
		// set the new state
		ctxt.setAttribute("monopoly.state", view.stateDescr());
		// notify players
		for (String n : PLAYER_NAMES) {
			MQ<String> q = (MQ<String>)ctxt.getAttribute(respQName(n));
			q.submitRequest("UPDATE");
		}
	}

}
