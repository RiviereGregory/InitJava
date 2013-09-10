package fr.treeptik.initjava.collection.exemple;

import java.util.Date;

public class Personne {
	// Attribut
	private String nom;
	private String prenom;
	private Date dateNaissance;

	// constructeur
	public Personne(String nom, String prenom, Date naissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = naissance;
	}

	public Personne() {
	}

	// methode

	// Accesseur
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	// Overide signifie que l'on a redef une méthode qui a été def dans une
	// classe superieure dans la classe mère
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + "]";
	}

	// redefinition de la methode equal pour chercher si la personne est presente

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.toUpperCase().hashCode());
		result = prime * result
				+ ((prenom == null) ? 0 : prenom.toUpperCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equalsIgnoreCase(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equalsIgnoreCase(other.prenom))
			return false;
		return true;
	}

}
