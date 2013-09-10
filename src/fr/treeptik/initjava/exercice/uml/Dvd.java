package fr.treeptik.initjava.exercice.uml;

public class Dvd extends Article{
	enum TypeDvd {
		ACTION, COMEDIE, SPECTACLE;
	}

	
	private String auteur;
	private String acteurs;
	private Integer duree;
	private TypeDvd type;

	public Dvd(String titre, String auteur, String acteurs, Integer duree, TypeDvd type) {
		super(titre);
		this.auteur = auteur;
		this.acteurs = acteurs;
		this.duree = duree;
		this.type = type;
	}

	public Dvd() {
	}
	
	

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getActeurs() {
		return acteurs;
	}

	public void setActeurs(String acteurs) {
		this.acteurs = acteurs;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public TypeDvd getType() {
		return type;
	}

	public void setType(TypeDvd type) {
		this.type = type;
	}

}
