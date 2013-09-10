package fr.treeptik.initjava.jeurole;

public abstract class Personnage implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer nombreVie;
	private Arme armeDePredilection;
	private Arme armeCourante;
	private String nom;

	
	public Personnage(Integer nombreVie, Arme armeDePredilection, Arme armeCourante, String nom) {
		this.nombreVie = nombreVie;
		this.armeDePredilection = armeDePredilection;
		this.armeCourante = armeCourante;
		this.setNom(nom);
	}

	public Integer attaquer(Personnage personnage) {
		
		if (armeCourante.equals(armeDePredilection)) {
			// respecte mieux l'encapsulation
			personnage.setNombreVie(personnage.getNombreVie() - armeCourante.getPointDegat()) ;
//			personnage.nombreVie -= (armeCourante.getPointDegat() / 2);
		} else {
			// respecte mieux l'encapsulation
			personnage.setNombreVie(personnage.getNombreVie() - (armeCourante.getPointDegat()/2)) ;
//			personnage.nombreVie -= (armeCourante.getPointDegat() / 2);
		}

		return personnage.nombreVie;
	}

	
	
	
	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", nombreVie=" + nombreVie + ", armeDePredilection=" + armeDePredilection
				+ ", armeCourante=" + armeCourante + "]";
	}

	public Integer getNombreVie() {
		return nombreVie;
	}

	public void setNombreVie(Integer nombreVie) {
		this.nombreVie = nombreVie;
	}

	public Arme getArmeDePredilection() {
		return armeDePredilection;
	}

	public void setArmeDePredilection(Arme armeDePredilection) {
		this.armeDePredilection = armeDePredilection;
	}

	public Arme getArmeCourante() {
		return armeCourante;
	}

	public void setArmeCourante(Arme armeCourante) {
		this.armeCourante = armeCourante;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
