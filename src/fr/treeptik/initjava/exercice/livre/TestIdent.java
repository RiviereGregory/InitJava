package fr.treeptik.initjava.exercice.livre;

public class TestIdent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ident ident = new Ident();
		System.out.println(Ident.getIdentMax());
		Ident ident2 = new Ident();
		Ident ident3 = new Ident();
		Ident ident4 = new Ident();
		System.out.println(Ident.getIdentMax());
		Ident ident5 = new Ident();
		Ident ident6 = new Ident();
		System.out.println(Ident.getIdentMax());
		System.out.println("////");
		System.out.println(ident.getIdent());		
		System.out.println(ident2.getIdent());
		System.out.println(ident3.getIdent());
		System.out.println(ident4.getIdent());
		System.out.println(ident5.getIdent());
		System.out.println(ident6.getIdent());
	}

}
