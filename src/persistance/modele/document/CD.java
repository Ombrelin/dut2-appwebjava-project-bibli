package persistance.modele.document;

import java.time.LocalDate;

public class CD extends ADocument {

	private String genre;

	private String artiste;

	public CD(int numero,String titre, LocalDate date, String genre, String artiste, EtatDocument etat) {
		super(numero,titre, date, etat);
		this.genre = genre;
		this.artiste = artiste;

	}

	public String getGenre() {
		return genre;
	}

	public String getArtiste() {
		return artiste;
	}

}
