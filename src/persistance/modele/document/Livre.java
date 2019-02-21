package persistance.modele.document;

import java.time.LocalDate;

public class Livre extends ADocument {

	private String auteur;

	public Livre(int numero,String titre, LocalDate date, String auteur, EtatDocument etat) {
		super(numero,titre, date, etat);
		this.auteur = auteur;
	}

	public String getAuteur() {
		return auteur;
	}

}
