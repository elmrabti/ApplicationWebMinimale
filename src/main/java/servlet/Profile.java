package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String conn = request.getParameter("connect") ;
		String prenom = request.getParameter("Prenom") ;
		String nom = request.getParameter("Nom") ;
		
		if(conn!=null && prenom!=null && nom!=null) {
			System.out.println("Profile line 45");
			RequestDispatcher view = request.getRequestDispatcher("CheckCookie");
			System.out.println("Profile line 47");
			view.include(request, response) ;
			System.out.println("Profile line 49");
			System.out.println(request.getAttribute("cookieFound"));
			
			if (request.getAttribute("cookieFound").equals(false)) {
				System.out.println("Profile line 53");
				RequestDispatcher pass = request.getRequestDispatcher("password.html") ;
				System.out.println("Profile line 55");
				pass.include(request, response) ;
				System.out.println("Profile line 57");
				System.out.println(request.getParameter("Password"));
				if (request.getParameter("Password").equals("0000")) {
				RequestDispatcher view2 = request.getRequestDispatcher("CookieTest");
				System.out.println("Profile 61");
				view2.include(request, response) ;
				}
			}
				

		}
		
		
		
	}
	

}




