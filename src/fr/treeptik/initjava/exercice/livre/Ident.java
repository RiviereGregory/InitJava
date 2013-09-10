package fr.treeptik.initjava.exercice.livre;

public class Ident {

	private static int identMax;
	private int ident;
	
	public Ident(){
		identMax++;
		this.setIdent(identMax);
		
	}

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public static int getIdentMax() {
		return identMax;
	}

	public static void setIdentMax(int identMax) {
		Ident.identMax = identMax;
	}
	
	
	

}
