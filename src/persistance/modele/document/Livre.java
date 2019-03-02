package persistance.modele.document;

import java.time.LocalDate;

public class Livre extends ADocument {

	private String auteur;

	
	public Livre(String titre, LocalDate date, String auteur, EtatDocument etat) {
		super(titre, date, etat);
		this.auteur = auteur;
	}

	public Livre(int numero,String titre, LocalDate date, String auteur, EtatDocument etat) {
		super(numero,titre, date, etat);
		this.auteur = auteur;
	}

	public String getAuteur() {
		return this.auteur;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" écrit par ");
		sb.append(this.getAuteur());
		return sb.toString();
	}
	

}
