package fr.treeptik.initjava.exercice.gestionabonnementtelephonique;

import java.util.List;

public class PersonnePhysique extends Client {
	private String nom;
	private String prenom;

	public PersonnePhysique(String ref, Adresse adresse, List<Forfait> forfait, String nom,
			String prenom) {
		super(ref, adresse, forfait);
		this.nom = nom;
		this.prenom = prenom;
	}

	public PersonnePhysique() {
		super();
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
