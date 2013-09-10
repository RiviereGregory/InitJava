package fr.treeptik.initjava.exercice.gestionabonnementtelephonique;

public class Adresse {
	private String cp;
	private String ville;
	private String rue;

	public Adresse(String cp, String ville, String rue) {
		super();
		this.cp = cp;
		this.ville = ville;
		this.rue = rue;
	}

	public Adresse() {
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

}
