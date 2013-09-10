package fr.treeptik.initjava.jeurole;

public class Chevalier extends Personnage {

	private static final long serialVersionUID = 1L;

	public Chevalier(Integer nombreVie, Arme armeCourante, String nom) {
		super(nombreVie, new Epee(), armeCourante, nom);

	}

}
