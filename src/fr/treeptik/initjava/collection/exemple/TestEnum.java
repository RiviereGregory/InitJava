package fr.treeptik.initjava.collection.exemple;

public class TestEnum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Civilite monsieur = Civilite.MONSIEUR;
		System.out.println(monsieur.name());
		System.out.println(monsieur.ordinal());
		System.out.println(monsieur.getChaine());
		System.out.println(monsieur.getValue());
	}

}
