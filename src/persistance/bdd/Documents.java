package persistance.bdd;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import mediatheque.Document;
import persistance.modele.document.EtatDocument;
import persistance.modele.document.Livre;
import persistance.modele.etatdoc.Emprunte;
import persistance.modele.etatdoc.Libre;

public class Documents extends DAO<Document> {

	@Override
	public void insert(Document tuple) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Document> getAll() {
		List<Document> utilisateurs = new LinkedList<Document>();

		ResultSet resultat = null;
		Statement requete = null;

		try {
			requete = this.getConnexion().createStatement();
			resultat = requete.executeQuery("SELECT * FROM document d INNER JOIN livre l ON c.IdDocument=d.IdDocument");

			while (resultat.next()) {
				int idDocument = resultat.getInt("idDocument");
				String titreDocument = resultat.getString("titreDocument");
				LocalDate dateDocument = resultat.getDate("dateDocument").toLocalDate();
				boolean emprunte = resultat.getBoolean("emprunte");

				EtatDocument etat = (emprunte?new Emprunte():new Libre());
				
				Livre l = new Livre(idDocument, titreDocument, dateDocument, etat);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Document getFromId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Document tuple) {
		// TODO Auto-generated method stub

	}

}
