

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class LogInValidationServlet
 */
@WebServlet("/LogInValidationServlet")
public class LogInValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		
		if(password.equals("yousef"))
		{
			response.sendRedirect("https://google.com");
		}else
		{
			out.print("Wrong Username or Password, try again!");
			RequestDispatcher rd= request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
	}

}
