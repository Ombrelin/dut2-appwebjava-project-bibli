package persistance.modele.document;

import java.time.LocalDate;

import mediatheque.Document;
import mediatheque.EmpruntException;
import mediatheque.Utilisateur;

public abstract class ADocument implements Document {

	private int numero;

	private String titre;

	private LocalDate date;

	private EtatDocument etat;

	
	public ADocument(String titre, LocalDate date, EtatDocument etat) {
		super();
		this.titre = titre;
		this.date = date;
		this.etat = etat;
	}
	public ADocument(int numero, String titre, LocalDate date, EtatDocument etat) {
		super();
		this.titre = titre;
		this.date = date;
		this.numero = numero;
		this.etat = etat;
	}

	@Override
	public Object[] affiche() {
		return null;
	}

	@Override
	public void emprunter(Utilisateur u) throws EmpruntException {
		this.etat = etat.emprunter(u, this);
	}

	@Override
	public void retour() {
		this.etat = etat.retour(this);
	}

	public String getTitre() {
		return titre;
	}

	public LocalDate getDate() {
		return date;
	}

	public EtatDocument getEtat() {
		return etat;
	}

	public boolean isEmprunte() {
		return etat.isEmprunte();
	}
	
	public int getNumero() {
		return numero;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.isEmprunte()?"[EMPRUNTE] ":"[LIBRE] ");
		sb.append(this.getNumero());
		sb.append(" - ");
		sb.append(this.getClass().getSimpleName());
		sb.append(" : ");
		sb.append(this.getTitre());
		sb.append(" (");
		sb.append(this.getDate().getYear());
		sb.append(" )");
		
		return sb.toString();
	}

}
