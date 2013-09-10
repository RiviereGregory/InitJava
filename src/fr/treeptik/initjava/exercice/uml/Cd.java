package fr.treeptik.initjava.exercice.uml;

public class Cd extends Article{

	enum TypeCd {
		ACTION, COMEDIE, SPECTACLE;
	}

	private String compositeur;
	private Integer nombreDeChansons;
	private Integer duree;
	private TypeCd type;

	public Cd(String titre, String compositeur, Integer nombreDeChansons, Integer duree, TypeCd type) {
		super(titre);
		this.compositeur = compositeur;
		this.nombreDeChansons = nombreDeChansons;
		this.duree = duree;
		this.type = type;
	}

	public Cd() {
	}
	
	

	public String getCompositeur() {
		return compositeur;
	}

	public void setCompositeur(String compositeur) {
		this.compositeur = compositeur;
	}

	public Integer getNombreDeChansons() {
		return nombreDeChansons;
	}

	public void setNombreDeChansons(Integer nombreDeChansons) {
		this.nombreDeChansons = nombreDeChansons;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public TypeCd getType() {
		return type;
	}

	public void setType(TypeCd type) {
		this.type = type;
	}

}
