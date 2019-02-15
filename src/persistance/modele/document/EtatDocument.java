package persistance.modele.document;

import mediatheque.Document;
import mediatheque.EmpruntException;
import mediatheque.Utilisateur;

public interface EtatDocument {
	EtatDocument emprunter(Utilisateur u, Document d) throws EmpruntException;
	EtatDocument retour(Document d);
}
