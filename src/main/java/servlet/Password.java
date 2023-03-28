package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Adresse;
import beans.Personne;

/**
 * Servlet implementation class Password
 */
@WebServlet("/Password")
public class Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am in Password servlet get");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter() ;
		out.println("<form action='' method='post'>" ) ;
		out.println("<label for='Nom'>Nom :</label>") ;
		out.println("<input type='text' id='Nom' name='Nom'><br>") ;
		out.println("<label for='Password'>Password :</label>");
		out.println("<input type='password' id='Password' name='Password'><br>");
		out.println("<input type='submit' value='Se connecter' name='connect'>");
		out.println("</form>") ;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am in passwoed servlet post");
		PrintWriter out = response.getWriter() ;
		response.setContentType("text/html");
		out.println("<form action='Profile' method='post'>" ) ;
		out.println("<label for='Nom'>Nom :</label>") ;
		out.println("<input type='text' id='Nom' name='Nom'><br>") ;
		out.println("<label for='Password'>Password :</label>");
		out.println("<input type='password' id='Password' name='Password'><br>");
		out.println("<input type='submit' value='Se connecter' name='connectpass'>");
		out.println("</form>") ;
		System.out.println("Fin Password servlet");
	}

}
