package persistance.modele.document;

import java.time.LocalDate;

public class DVD extends ADocument {

	private String realisateur;
	
	private Qualite qualite;
	
	public DVD(int numero,String titre, LocalDate date, String realisateur ,Qualite qualite, EtatDocument etat) {
		super(numero,titre, date, etat);
		this.realisateur = realisateur;
		this.qualite = qualite;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public Qualite getQualite() {
		return qualite;
	}
	
	

}
