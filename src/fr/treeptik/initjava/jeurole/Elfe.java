package fr.treeptik.initjava.jeurole;

public class Elfe extends Personnage {
	
	private static final long serialVersionUID = 1L;

	public Elfe(Integer nombreVie, Arme armeCourante, String nom) {
		super(nombreVie, new Gourdin(), armeCourante, nom);

	}

}
