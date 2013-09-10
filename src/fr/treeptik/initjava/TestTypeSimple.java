package fr.treeptik.initjava;

import java.util.Arrays;

public class TestTypeSimple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		// Type primitif
		//

		int valeurInt = 2;

		System.out.println(valeurInt);

		valeurInt = 3;

		System.out.println(valeurInt);

		int newInt = 4;

		int result = valeurInt + newInt;

		System.out.println(result);

		valeurInt = valeurInt + newInt;
		valeurInt -= newInt;

		valeurInt++; // valeurInt = valeurInt + 1
		++valeurInt; // valeurInt = valeurInt + 1

		System.out.println(valeurInt);

		byte b = 127; // max 127
		short s = 32767; // max 32767
		long l = 3002154600225555588L; // max 8 octets mais il faut ajouter L

		double d = 12.2;
		float f = 12.2987555F; // il faut ajouter un F

		double resultat = newInt + d;

		System.out.println(b +" "+ s+" " +l+" " +f +" "+ resultat);
		char a = 'A';
		char c = 68;

		System.out.println(a + "  " + c);

		boolean vrai = true;
		boolean faux = false;

		System.out.println(vrai + "  " + faux);

		//
		// Type objet simple
		//

		Integer integer = 1;
		System.out.println(integer); // résultat 1
		System.out.println(integer.doubleValue()); // résultat 1.0

		Byte byte1 = 127;
		Short short1 = 3;
		Long long1 = 51664464878855L;
		Double double1 = 1.4;
		Float float1 = 1.1235646F;
		Character character = 'A';
		Boolean boolean1 = true;

		System.out.println(byte1 +" "+ long1 +" "+ double1+" " + float1 +" " +character);
		Boolean boolean2 = null; // pas de valeur à l'intérieur
		System.out.println(boolean2);

		//
		// String
		//

		String string1 = "Ma super chaine";
		String string2 = string1 + " qui tue ";
		string2 += short1;

		System.out.println(string2);

		System.out.println(string2.charAt(1)); // retourne le charactère en
												// position 1 du string
												// ( le deuxième caractère)

		System.out.println(string2.length()); // retourne la longueur du string

		System.out.println(string2.substring(9, 15)); // affiche une partie du
														// string compris
														// entre 9 et 14 (car le
														// 15ème est exclu)

		String s1 = "AA";
		String s2 = "Aa";
		System.out.println(s1 == s2); // marche mais pas la bonne méthode
		System.out.println(s1.equals(s2)); // bonne méthode
		System.out.println(s1.equalsIgnoreCase(s2)); // bonne méthode

		System.out.println(string2.substring(string2.indexOf("chaine"), string2.indexOf("chaine") + 6));
		String motRecherche = "chaine";
		Integer debutMot = string2.indexOf(motRecherche);
		System.out.println(string2.substring(debutMot, debutMot + motRecherche.length()));

		System.out.println(string2.lastIndexOf(motRecherche)); // cherche le mot
																// en partant de
																// la fin et
																// donne la
																// position du
																// 1er caractère
		System.out.println(string2.contains("chaine")); // retourne vrai ou faux
														// si presence de la
														// chaine

		String string = "   ";
		System.out.println(string.length());
		System.out.println(string.isEmpty());

		string = string.trim(); // supprime les espaces au début et à la fin de
								// chaine mais pas entre
		System.out.println(string.length());
		System.out.println(string.isEmpty());

		String stringTest = "   est essai  ";
		System.out.println(stringTest.length() + " " + stringTest + "/");
		stringTest = stringTest.trim(); // supprime les espaces au début et à la
										// fin de chaine mais pas entre
		System.out.println(stringTest.length() + " " + stringTest + "/");

		String stringInt = String.valueOf(newInt); // methode statique appelé
													// avec la classe
		// valueOf permet de transformer une valeur numérique en string
		System.out.println(stringInt);

		String valueOf = String.valueOf(boolean1);
		System.out.println(valueOf);
		System.out.println(valueOf.length());
		System.out.println(valueOf.toUpperCase().charAt(0));// met tous en
															// majuscule et
															// récupére que le T

		//
		// StringBuilder / StringBuffer
		//

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Ma").append(" ").append("chaine").append(" ").append(1);

		String string3 = stringBuilder.toString();
		System.out.println(string3);

		//
		// Tableaux
		//
		System.out.println("////////////////////////////////////");

		Integer[] integers = new Integer[5]; // il faut mettre la taille du
												// tableau

		System.out.println(integers.length); // donne la taille max du tableau

		integers[0] = 1;
		integers[1] = 2;
		integers[2] = 3;
		integers[3] = 4;
		integers[4] = 5;

		System.out.println(integers[2]);

		// copie de tableaux 1
		Integer[] newIntegers = new Integer[10]; // il faut mettre la taille du
													// tableau

		System.arraycopy(integers, 0, newIntegers, 0, 5);

		System.out.println(newIntegers[2]);

		newIntegers[5] = 6;

		// copie de tableaux 2
		Integer[] newTabIntegers = Arrays.copyOf(integers, 10);
		System.out.println("length :" + newTabIntegers.length);
		System.out.println("tab[2] :" + newTabIntegers[2]);

		//
		// Tableaux à 2D
		//

		String[][] matrice = new String[3][4];

		matrice[0][0] = "11";
		matrice[0][1] = "12";
		matrice[0][2] = "13";
		matrice[0][3] = "14";

		matrice[1][0] = "11";
		matrice[1][1] = "22";
		matrice[1][2] = "23";
		matrice[1][3] = "24";

		matrice[2][0] = "31";
		matrice[2][1] = "32";
		matrice[2][2] = "33";
		matrice[2][3] = "34";

		System.out.println("matrice[1][2] : " + matrice[1][2]);

		//
		// tableaux de string
		//
		System.out.println("///////////////////////////////");

		String bonjour = "Bonjour tout le monde";
		String[] bonjourTab = bonjour.split(" "); // dans split on met le type
													// de séparateur que l'on
													// veut
		System.out.println("Taille tab : " + bonjourTab.length);
		System.out.println("Tab[1] : " + bonjourTab[1]);

		System.out.println("///////////////////////////////");

		System.out.println("########### foreach #########");
		for (String mot : bonjourTab) { // nouvelle methode pour parcourir un
										// tableau
			System.out.println(mot);
			System.out.println("Taille du mot : " + mot.length());
		}

		System.out.println("########### for #########");

		for (int i = 0; i < bonjourTab.length; i++) {

			String mot = bonjourTab[i];
			System.out.println(mot);
		}

		System.out.println("########### while ########");

		int i = 0;
		while (i < bonjourTab.length) {

			String mot = bonjourTab[i];
			System.out.println(mot);
			i++;
		}

		System.out.println("########### do while ########");

		i = 0;
		do {
			String mot = bonjourTab[i];
			System.out.println(mot);
			i++;
		} while (i < bonjourTab.length);

		System.out.println("///////////////////////////////");

		System.out.println("########### if #########");

		String saisie = "Menu 1";

		// si le pointeur saisie est null cela plante
		if (saisie.equalsIgnoreCase("Menu 1")) {

			System.out.println("Saisie utilisateur : Menu 1");

		} else if (saisie.equalsIgnoreCase("Menu 2")) {

			System.out.println("Saisie utilisateur : Menu 2");

		} else {

			System.out.println("erreur de saisie");

		}

		saisie = null;
		// si le pointeur saisie est null cela marche
		if ("Menu 1".equalsIgnoreCase(saisie)) {

			System.out.println("Saisie utilisateur : Menu 1");

		} else if ("Menu 2".equalsIgnoreCase(saisie)) {

			System.out.println("Saisie utilisateur : Menu 2");

		} else {

			System.out.println("erreur de saisie");
		}

		System.out.println("FIN ...........");

	}

}
