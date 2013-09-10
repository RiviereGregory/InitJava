package fr.treeptik.initjava.objet3;

public class Personne implements ComportementAvancer {

	private String nom;
	private String prenom;

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne() {
	}

	@Override
	public void avancer() {
		System.out.println("Personne avance");

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
