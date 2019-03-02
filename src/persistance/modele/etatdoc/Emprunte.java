package persistance.modele.etatdoc;

import mediatheque.Document;
import mediatheque.EmpruntException;
import mediatheque.Utilisateur;
import persistance.bdd.Documents;
import persistance.modele.document.EtatDocument;

public class Emprunte implements EtatDocument {
	
	@Override
	public EtatDocument emprunter(Utilisateur u,  Document d) throws EmpruntException {
		throw new EmpruntException();
	}

	@Override
	public EtatDocument retour(Document d) {
		new Documents().retourner(d);
		return new Libre();
	}

	@Override
	public boolean isEmprunte() {
		return true;
	}
	
	

}
