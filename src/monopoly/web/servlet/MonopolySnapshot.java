package monopoly.web.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MonopolySnapshot
 */
@WebServlet("/MonopolySnapshot")
public class MonopolySnapshot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonopolySnapshot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String state = (String)this.getServletContext().getAttribute("monopoly.state");
		if (state == null) {
			state = "No state yet.";
		} else {
			state = URLDecoder.decode(state, "UTF-8");
		}
		response.setContentType("text/plain");
		response.getWriter().println(state);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getQueryString();
		if (query == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			this.getServletContext().setAttribute("monopoly.state", query);
		}
	}

}
