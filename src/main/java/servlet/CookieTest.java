package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String firstName = request.getParameter("Prenom");
		String lastName = request.getParameter("Nom");
		System.out.println(firstName);		
		System.out.println(" ");
		String title = "title" ;
		Cookie cookie = new Cookie("username", lastName);  
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);
		PrintWriter out = response.getWriter();
		out.println("<html>\n" +"<head><title>"+ title + "</title></head>\n" + " </body>Hello "+firstName+" "+lastName+"</body></html>"); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		String firstName = request.getParameter("Prenom");
		String lastName = request.getParameter("Nom");
		System.out.println(firstName);		
		System.out.println(" ");
		String title = "title" ;
		Cookie cookie = new Cookie("username", lastName);  
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);
		PrintWriter out = response.getWriter();
		out.println("<html>\n" +"<head><title>"+ title + "</title></head>\n" + " </body>Hello "+firstName+" "+lastName+"</body></html>"); 
		/*RequestDispatcher view = request.getRequestDispatcher(“cookieresult.jsp”);
		view.forward(request, response); */
		}

}
