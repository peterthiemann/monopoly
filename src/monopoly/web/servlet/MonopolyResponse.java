package monopoly.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monopoly.web.util.MQ;

/**
 * Servlet implementation class MonopolyResponse
 */
@WebServlet("/MonopolyResponse")
public class MonopolyResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getQueryString();
		if (name == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			MQ<String> respQ = (MQ<String>)this.getServletContext().getAttribute(
					GameRunner.respQName(name));
			if (respQ == null) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			} else {
				String r = respQ.getNextRequest();
				response.getWriter().println(r);
			}
		}
	}

}
