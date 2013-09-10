package fr.treeptik.initjava.annuaire;

public class Adresse {
	// Attribut
	private String ville;
	private String codePostal;

	// Constructeur
	public Adresse(String ville, String codePostale) {
		this.ville = ville;
		this.codePostal = codePostale;
	}

	public Adresse() {
	}

	// Accesseur
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	// Methode redif
	@Override
	public String toString() {
		return "Adresse [ville=" + ville + ", codePostal=" + codePostal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codePostal == null) ? 0 : codePostal.toUpperCase().hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.toUpperCase().hashCode());
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
		Adresse other = (Adresse) obj;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equalsIgnoreCase(other.codePostal))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equalsIgnoreCase(other.ville))
			return false;
		return true;
	}

}
