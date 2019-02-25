package persistance.bdd;

import java.time.LocalDate;
import java.util.List;

import mediatheque.Document;
import mediatheque.Mediatheque;
import mediatheque.PersistentMediatheque;
import mediatheque.Utilisateur;
import persistance.modele.document.CD;
import persistance.modele.document.DVD;
import persistance.modele.document.Livre;
import persistance.modele.etatdoc.Libre;

// classe mono-instance  dont l'unique instance n'est connue que de la bibliotheque
// via une auto-déclaration dans son bloc static

public class MediathequeData implements PersistentMediatheque {
// Jean-François Brette 01/01/2018
	static {
		Mediatheque.getInstance().setData(new MediathequeData());
	}

	private Utilisateurs dbUtilisateur;
	private Documents dbDocuments;
	
	private MediathequeData() {
		dbUtilisateur = new Utilisateurs();
		dbDocuments = new Documents();
	}

	// renvoie la liste de tous les documents de la biblioth�que
	@Override
	public List<Document> tousLesDocuments() {
		return dbDocuments.getAll();
	}

	// va r�cup�rer le User dans la BD et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		return dbUtilisateur.connect(login, password);
	}

	// va r�cup�rer le document de num�ro numDocument dans la BD
	// et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Document getDocument(int numDocument) {
		return dbDocuments.getFromId(numDocument);
	}

	@Override
	public void nouveauDocument(int type, Object... args) {
		Document d = null;
		LocalDate dateDocument = LocalDate.parse(args[1].toString());
		
		switch(type) {
		case 1:
			d = new Livre(args[0].toString(),dateDocument,args[2].toString(),new Libre());
			break;
		case 2:
			d = new DVD(args[0].toString(),dateDocument,args[1].toString(),args[2].toString(), new Libre());
			break;
		case 3:
			d = new CD(args[0].toString(),dateDocument,args[1].toString(),args[2].toString(), new Libre());
		}
		
		dbDocuments.insert(d);
	}

}
