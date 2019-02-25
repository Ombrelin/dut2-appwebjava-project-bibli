package persistance.modele.etatdoc;

import mediatheque.Document;
import mediatheque.EmpruntException;
import mediatheque.Utilisateur;
import persistance.bdd.Documents;
import persistance.modele.document.EtatDocument;

public class Libre implements EtatDocument {

	@Override
	public EtatDocument emprunter(Utilisateur u, Document d) throws EmpruntException {
		d.emprunter(u);
		new Documents().emprunter(d);
		return new Emprunte();
	}

	@Override
	public EtatDocument retour(Document d) {
		return new Libre();
	}

	@Override
	public boolean isEmprunte() {
		return true;
	}

}
