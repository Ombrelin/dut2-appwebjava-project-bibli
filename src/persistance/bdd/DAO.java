package persistance.bdd;

import java.sql.Connection;
import java.util.List;

/**
 * @brief Repr�sente une interface avec une table de la base de donn�e
 *        correspondant � un type d'objet
 * @author arsen
 *
 * @param <T> Type des objets stock�s dans la table
 */
public abstract class DAO<T> {

	/**
	 * Connexion � la base de donn�e
	 */
	private Connection connexion;

	/**
	 * Constructeur
	 */
	public DAO() {
		this.connexion = Connecteur.getConnexion();
	}

	/**
	 * Permet d'ins�rer un objet dans la table correspondante
	 * 
	 * @param tuple L'objet � ins�rer
	 */
	public abstract void insert(T tuple);

	/**
	 * Permet de r�cup�rer une liste des objets de la table
	 * 
	 * @return Une liste contenant tous les objets de la table
	 */
	public abstract List<T> getAll();

	/**
	 * Permet de r�cup�rer un objet de la table � partir de son ID
	 * 
	 * @param id L'id de l'objet
	 * @return L'objet correspondant
	 */
	public abstract T getFromId(int id);

	/**
	 * Permet de supprimer un objet de la table
	 * 
	 * @param tuple L'ojet � supprimer
	 */
	public abstract void delete(int id);

	public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;

	}

	/**
	 * Permet de r�cup�rer la connexion � la base de donn�e
	 * 
	 * @return La connexion � la base de donn�e
	 */
	public Connection getConnexion() {
		return connexion;
	}

}
