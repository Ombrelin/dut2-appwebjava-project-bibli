package persistance.bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import exceptions.MauvaisMDPException;
import exceptions.UtilisateurInexistantException;
import mediatheque.Utilisateur;
import util.securite.Password;

public class Utilisateurs extends DatabaseAccess<Utilisateur> {

	public Utilisateurs() {
		super();
	}

	@Override
	public void insert(Utilisateur tuple) {
		try {
			PreparedStatement requete = this.getConnexion()
					.prepareStatement("INSERT INTO utilisateur(Pseudo,Adresse_Email,Mot_de_Passe) VALUES(?,?,?)");
			requete.setString(1, tuple.getPseudo());
			requete.setString(2, tuple.getAdresseMail());
			requete.setString(3,Password.hashPassword(tuple.getMdp()) );
			requete.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public List<Utilisateur> getAll() {

		// Cr�ation de la liste qui contient les utilisateurs
		List<Utilisateur> utilisateurs = new LinkedList<Utilisateur>();

		ResultSet resultat = null;
		Statement requete = null;

		try {
			// Initialisation de la requ�te SQL
			requete = this.getConnexion().createStatement();

			// Ex�cution de la requ�te SQL
			resultat = requete.executeQuery("SELECT * FROM utilisateur");

			// R�cup�ration des donn�es
			while (resultat.next()) {
				Utilisateur u = new Utilisateur(resultat.getInt("IdUtilisateur"), resultat.getString("Pseudo"),
						resultat.getString("Adresse_Email"), resultat.getString("Mot_de_Passe"));
				utilisateurs.add(u);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (resultat != null)
					resultat.close();
				if (requete != null)
					requete.close();
			} catch (SQLException ignore) {
				System.err.println(ignore.getMessage());
			}
		}

		return utilisateurs;
	}

	@Override
	public Utilisateur getFromId(int id) {

		Utilisateur u = null;

		ResultSet resultat = null;
		PreparedStatement requete = null;

		try {
			// Initialisation de la requ�te SQL
			requete = this.getConnexion().prepareStatement("SELECT * FROM utilisateur WHERE IdUtilisateur=?");
			requete.setInt(1, id);
			// Ex�cution de la requ�te SQL
			resultat = requete.executeQuery();

			// R�cup�ration des donn�es
			if (resultat.next()) {
				u = new Utilisateur(resultat.getInt("IdUtilisateur"), resultat.getString("Pseudo"),
						resultat.getString("Adresse_Email"), resultat.getString("Mot_de_Passe"));
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (resultat != null)
					resultat.close();
				if (requete != null)
					requete.close();
			} catch (SQLException ignore) {
				System.err.println(ignore.getMessage());
			}
		}

		return u;
	}

	@Override
	public void delete(Utilisateur tuple) {
		PreparedStatement requete = null;

		try {
			// Initialisation de la requ�te SQL
			requete = this.getConnexion().prepareStatement("DELETE FROM utilisateur WHERE id=?");
			requete.setInt(1, tuple.getID());
			// Ex�cution de la requ�te SQL
			requete.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (requete != null)
					requete.close();
			} catch (SQLException ignore) {
				System.err.println(ignore.getMessage());
			}
		}
	}

	public Utilisateur connect(String login, String plainPassword)
			throws MauvaisMDPException, UtilisateurInexistantException {
		ResultSet resultat = null;
		PreparedStatement requete = null;
		boolean pwdCheck = false;
		Utilisateur u = null;

		try {
			requete = this.getConnexion()
					.prepareStatement("SELECT * FROM utilisateur WHERE Adresse_Email=? OR Pseudo=?");
			requete.setString(1, login);
			requete.setString(2, login);
			resultat = requete.executeQuery();

			if (resultat.next()) {
				String passwordHashDB = resultat.getString("Mot_de_Passe");
				pwdCheck = Password.checkPassword(plainPassword, passwordHashDB);

				if (pwdCheck) {
					System.out.println("Mot de passe valide");
					int id = resultat.getInt("IdUtilisateur");
					String pseudo = resultat.getString("Pseudo");
					String email = resultat.getString("Adresse_Email");
					String mdp = resultat.getString("Mot_de_Passe");

					u = new Utilisateur(id, pseudo, email, mdp);

				} else {
					System.out.println("Mot de passe invalide");
					throw new MauvaisMDPException("Le mot de passe : " + plainPassword + " est invalide");
				}

			} else {
				System.out.println("Login invalide");
				throw new UtilisateurInexistantException("L'utilisateur " + login + " n'existe pas");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (resultat != null)
					resultat.close();
				if (requete != null)
					requete.close();
			} catch (SQLException ignore) {
			}
		}
		return u;
	}

	public int getId(Utilisateur u) {
		ResultSet resultat = null;
		PreparedStatement requete = null;
		int id = 0;
		try {
			// Initialisation de la requ�te SQL
			requete = this.getConnexion().prepareStatement("SELECT * FROM projet WHERE Adresse_Email=?");
			requete.setString(1, u.getAdresseMail());
			// Ex�cution de la requ�te SQL
			resultat = requete.executeQuery();

			// R�cup�ration des donn�es
			if (resultat.next()) {
				id = resultat.getInt("IdProjet");
			}

		} catch (Exception e) {
		} finally {
			try {
				if (resultat != null)
					resultat.close();
				if (requete != null)
					requete.close();
			} catch (SQLException ignore) {
			}
		}
		return id;
	}

	public boolean adressIsNouvelle(String adresse) {

		ResultSet resultat = null;
		Statement requete = null;

		try {
			// Initialisation de la requ�te SQL
			requete = this.getConnexion().createStatement();

			// Ex�cution de la requ�te SQL
			resultat = requete.executeQuery("SELECT * FROM utilisateur WHERE Adresse_Email=" + "'" + adresse + "';");

			// R�cup�ration des donn�es
			if (resultat.next()) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {
			System.err.println("Probl�me � la recherche de l'email");
			e.printStackTrace();
		} finally {
			try {
				if (resultat != null)
					resultat.close();
				if (requete != null)
					requete.close();
			} catch (SQLException e) {
				System.err.println("Probl�me de fermeture du resultat");
				e.printStackTrace();
			}
		}

		return false;
	}
}
