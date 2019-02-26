package services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatheque.Document;
import mediatheque.EmpruntException;
import mediatheque.Mediatheque;
import mediatheque.Utilisateur;

/**
 * Servlet implementation class Emprunt
 */
@WebServlet("/Emprunt")
public class Emprunt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Emprunt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();
		
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		
		if( u == null) {
			request.getRequestDispatcher("./Login").forward(request, response);
		}
		else if(u.isBibliothecaire()) {
			request.getRequestDispatcher("./Login").forward(request, response);
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/emprunt.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Mediatheque m = Mediatheque.getInstance();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		
		String numDocParam = request.getParameter("numero");
		int numDoc = Integer.parseInt(numDocParam);
		
		Document d = m.getDocument(numDoc);
		
		try {
			m.emprunt(d, u);
			request.getRequestDispatcher("./Abonne").forward(request, response);
		} catch (EmpruntException e) {
			request.setAttribute("erreur", "Ce document est déjà emprunté");
			this.doGet(request, response);
		}
		
		
	}

}
