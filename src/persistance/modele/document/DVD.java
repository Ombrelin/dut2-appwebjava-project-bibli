package persistance.modele.document;

import java.time.LocalDate;

public class DVD extends ADocument {

	private String realisateur;

	private Qualite qualite;

	public DVD(String titre, LocalDate date, String realisateur, String qualite, EtatDocument etat) {
		super(titre, date, etat);
		this.realisateur = realisateur;
		this.qualite = Qualite.valueOf(qualite);
	}

	public DVD(int numero, String titre, LocalDate date, String realisateur, String qualite, EtatDocument etat) {
		super(numero, titre, date, etat);
		this.realisateur = realisateur;
		this.qualite = Qualite.valueOf(qualite);
	}

	public String getRealisateur() {
		return realisateur;
	}

	public Qualite getQualite() {
		return qualite;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append(" réalisé par ");
		sb.append(this.getRealisateur());
		sb.append(" (");
		sb.append(this.getQualite());
		sb.append(")");
		
		return sb.toString();
	}

}
