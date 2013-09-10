package fr.treeptik.initjava.exercice.livre;

public class UtilisationPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point point = new Point( 2.0);
		point.affiche();
		Point point2 = new Point(12.0);
		point2.affiche();
		Point.setOrigine(2);
		point.affiche();
		point2.affiche();
		

	}

}
