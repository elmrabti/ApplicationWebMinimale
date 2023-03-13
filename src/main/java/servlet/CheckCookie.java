package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCookie
 */
@WebServlet("/CheckCookie")
public class CheckCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		Cookie[] cookies = request.getCookies();
    		request.setAttribute("cookieFound", false);
    		if ( cookies != null ) {
	    		for (int i = 0; i < cookies.length; i++) {
	    			Cookie cookie = cookies[i];
		    		if (cookie.getName().equals("username")) {
			    		String userName = cookie.getValue();
			    		System.out.println("CheckCookie Line 41");
			    		System.out.println(userName);
			    		System.out.println(request.getParameter("Nom"));
			    		if(request.getParameter("Nom").equals(userName) ) {
			    		out.println("Hello " + userName);
			    		System.out.println("CheckCookie Line 46");
			    		request.setAttribute("cookieFound", true);
			    		break;
			    		}
			    		else {
			    			System.out.println("CheckCookie line 47");
			    		   	request.setAttribute("cookieFound", false);
			    		}
			    		}
	    			}
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
