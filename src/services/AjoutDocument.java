package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatheque.Mediatheque;
import mediatheque.Utilisateur;

/**
 * Servlet implementation class AjoutDocument
 */
@WebServlet("/AjoutDocument")
public class AjoutDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutDocument() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("typeAjout", request.getParameter("typeAjout"));
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");

		if (u == null) {
			request.getRequestDispatcher("./Login").forward(request, response);
		} else if (!u.isBibliothecaire()) {
			request.getRequestDispatcher("./Login").forward(request, response);
		}
		else if(request.getParameter("typeAjout") == null) {
			request.getRequestDispatcher("./Bibliothequaire").forward(request, response);
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutDocument.jsp").forward(request, response);;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typeDocument = Integer.parseInt(request.getParameter("typeAjout"));
		
		Mediatheque m = Mediatheque.getInstance();
		
		String titre = request.getParameter("titre");
		String date = request.getParameter("date");
		
		switch(typeDocument) {
		case 1:
			String auteur = request.getParameter("auteur");
			m.nouveauDocument(typeDocument, titre, date, auteur);
			break;
		case 2:
			String realisateur = request.getParameter("realisateur");
			String qualite = request.getParameter("qualite");
			m.nouveauDocument(2, titre, date, realisateur, qualite);
			break;
		case 3:
			String artiste = request.getParameter("artiste");
			String genre = request.getParameter("genre");
			m.nouveauDocument(3, titre, date, artiste, genre);
			break;
		default:
			throw new IllegalStateException("Problème de type d'ajout");
		}
		
		request.getRequestDispatcher("./Bibliothequaire").forward(request, response);
	}

}
