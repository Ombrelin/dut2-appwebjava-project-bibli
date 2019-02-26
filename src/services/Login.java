package services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.MauvaisMDPException;
import exceptions.UtilisateurInexistantException;
import mediatheque.Mediatheque;
import mediatheque.Utilisateur;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération de la session
		HttpSession session = request.getSession();

		// Récupération des informations du formulaire
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		try {
			Utilisateur u = Mediatheque.getInstance().getUser(login, password);
			session.setAttribute("utilisateur", u);
			if(u.isBibliothecaire()) {
				request.getRequestDispatcher("./Bibliothequaire").forward(request, response);
			}
			else {
				request.getRequestDispatcher("./Abonne").forward(request, response);
			}
			
		} catch (UtilisateurInexistantException e) {
			request.setAttribute("erreur", "Login invalide");
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		} catch (MauvaisMDPException e) {
			request.setAttribute("erreur", "Mot de passe invalide");
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
		
	}

}
