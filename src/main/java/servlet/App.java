package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Adresse;
import beans.Facade;
import beans.Personne;

/**
 * Servlet implementation class App
 */
@WebServlet("/App")
public class App extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Facade f ;
	
	
	@Override
	public void init() {
		f = new Facade() ;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public App() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String addP = request.getParameter("addPersonne") ;
		String addA = request.getParameter("addAdresse") ;
		String nom = request.getParameter("Nom") ;
		String prenom = request.getParameter("Prénom") ;
		String ville = request.getParameter("Ville") ;
		String rue = request.getParameter("Rue") ;
		String op = request.getParameter("op") ;
		
		if (addP!=null && nom!=null && prenom!=null && !nom.equals("") && !prenom.equals("") ) {
			f.ajoutPersonne(nom, prenom) ;
			response.sendRedirect("index.html") ;
		}
		
		if (addA!=null && ville!=null && rue!=null && !ville.equals("") && !rue.equals("") ) {
			f.ajoutAdresse(rue, ville) ;
			response.sendRedirect("index.html") ;
		}
		
		if (op!=null && op.equals("associer")) {
			PrintWriter out = response.getWriter() ;
			
			out.println("<form action='' method='get' >" ) ;
			out.println("Choisir une personne<\br>") ;
			for(Personne p : f.listePersonnes()) 
				out.println("<input type='radio' name='personneId' value="+p.getId()+">"+p.getNom()+" "+p.getPrenom()+"<\br>");
			out.println("Choisir une adresse<\br>") ;
			for(Adresse a : f.listeAdresses()) 
				out.println("<input type='radio' name='adresseId' value="+a.getId()+">"+a.getRue()+" "+a.getVille()+"<\br>");
			
			out.println("<input type='submit' value='Ok' name'Associer'><\form>") ;
			out.println("<a href='index.html'>Retour></a>") ;
				
				
			
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
