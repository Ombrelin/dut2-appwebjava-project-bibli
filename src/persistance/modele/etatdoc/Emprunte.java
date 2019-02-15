package persistance.modele.etatdoc;

import mediatheque.Document;
import mediatheque.EmpruntException;
import mediatheque.Utilisateur;
import persistance.modele.document.EtatDocument;

public class Emprunte implements EtatDocument {
	
	@Override
	public EtatDocument emprunter(Utilisateur u,  Document d) throws EmpruntException {
		throw new EmpruntException();
	}

	@Override
	public EtatDocument retour(Document d) {
		d.retour();
		return new Libre();
	}

}
