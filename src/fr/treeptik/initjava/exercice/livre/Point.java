package fr.treeptik.initjava.exercice.livre;

public class Point {
	private static Integer origine;
	private Double x;
	
	public Point(Double x) {
		origine = 0;
		this.setX(x);
	}
	
	public void affiche() {
		System.out.println("abscisse = " + (this.getX()-origine));
		System.out.println("relative a une origine d'abscisse " + origine);
		
	}
	
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}



	public static Integer getOrigine() {
		return origine;
	}



	public static void setOrigine(Integer origine) {
		Point.origine = origine;
		System.out.println("origine placé en :" + origine);
	}

	

}
