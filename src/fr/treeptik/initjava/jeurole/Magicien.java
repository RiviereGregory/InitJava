package fr.treeptik.initjava.jeurole;

public class Magicien extends Personnage{
	
	private static final long serialVersionUID = 1L;

	public Magicien(Integer nombreVie, Arme armeCourante, String nom) {
		
		super(nombreVie, new Baguette(), armeCourante, nom);		
	}

	

}
