package fr.treeptik.initjava.collection.exemple;

public enum JourOuvre {

	LUNDI(1), MARDI(2), MERCREDI(3), JEUDI(4), VENDREDI(5);
	
	// Ajout de variable
	private int numeroJour;
	
	// Constructeur
	private JourOuvre(int num){
		numeroJour = num;
		
	}

	public int getNumeroJour() {
		return numeroJour;
	}
	
	
}
