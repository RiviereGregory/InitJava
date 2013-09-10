package fr.treeptik.initjava.collection.exemple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TestCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> monTableau = new ArrayList<>();
		LinkedList<String> linkedList = new LinkedList<>();

		// Création ArrayList et LinkedList

		for (int i = 0; i < 1000; i++) {

			monTableau.add("test");
			monTableau.add("le test");
			monTableau.add("a le test");
			monTableau.add("les tests");
			monTableau.add("pas de test");
			monTableau.add("le bon test");
			monTableau.add("a");
			monTableau.add("c");
			monTableau.add("b");
			monTableau.add("toto");
			monTableau.add("j");

			linkedList.add("test");
			linkedList.add("le test");
			linkedList.add("a le test");
			linkedList.add("les test");
			linkedList.add("pas de test");
			linkedList.add("le bon test");
			linkedList.add("a");
			linkedList.add("c");
			linkedList.add("b");
			linkedList.add("toto");
			linkedList.add("j");

		}
		/////////////////////////////////////
		// Création d'une list non modifaible
		List<String> list = new ArrayList<>();
		list.add("test");
		list.add("le test");
		list.add("a le test");
		list.add("les test");
		list.add("pas de test");
		list.add("le bon test");
		list.add("a");
		list.add("c");
		list.add("b");
		list.add("toto");
		list.add("j");
		// Liste non modifiable
		ListNonModifiable listNonModifiable = new ListNonModifiable(list);
		// l'Ajout de valeur déclenche une Exception
//		listNonModifiable.add("test");
		// Affichage de la list non modifiable
		for (String string : listNonModifiable) {
			System.out.println(string);
		}
		/////////////////////////////////////
		
		// System.out.println("affiche la list non triée");
		// System.out.println(monTableau);
		// System.out.println("");
		// System.out.println("affiche la list inverse avec la méthode");
		// System.out.println(inverseList(monTableau));
		// System.out.println("");
		// System.out.println("affiche la list");
		// System.out.println(monTableau);
		// System.out.println("");
		// System.out.println("affiche la list inverse et trié avec la méthode");
		// System.out.println(inverseAlphaList(monTableau));
		// System.out.println("");
		
		System.out.println("//////////////////////");
		System.out.println("");

		HashSet<String> set = new HashSet<>();
		set.add("test");
		set.add("le test");
		set.add("test");
		set.add("le test");
		set.add("un test");
		System.out.println(set.size());
		System.out.println(set);

		System.out.println("//////////////////////");
		System.out.println("");
		
		long start;
		// Arraylist
		start = System.currentTimeMillis();
		for (int i = 0; i < 11000; i++) {
			monTableau.get(i);
		}
		long duree = System.currentTimeMillis() - start;
		// LinkedList
		start = System.currentTimeMillis();
		for (int i = 0; i < 11000; i++) {
			linkedList.get(i);
		}
		long dureeSet = System.currentTimeMillis() - start;
		
		Random r = new Random();
		Integer choix;
		// Arraylist Alea
		start = System.currentTimeMillis();
		for (int i = 0; i < 11000; i++) {
			choix = r.nextInt(11000);
			monTableau.get(choix);
		}
		long dureeArrAlea = System.currentTimeMillis() - start;
		// LinkedList Alea
		start = System.currentTimeMillis();
		for (int i = 0; i < 11000; i++) {
			choix = r.nextInt(11000);
			linkedList.get(choix);
		}
		long dureeSetAlea = System.currentTimeMillis() - start;
		// Resultat
		System.out.println("la duree du ArrayList : " + duree);
		System.out.println("la duree du LinkedList : " + dureeSet);
		System.out.println("la duree alea du ArrayList : " + dureeArrAlea);
		System.out.println("la duree alea du LinkedList : " + dureeSetAlea);
		//////////////////
		// HashMap creation
		HashMap<String, String[]> hashMap = new HashMap<>();
		String[] strings = { "test 1", "test 11" };
		hashMap.put("value 1", strings);
		String[] strings2 = { "test 2" };
		hashMap.put("value 2", strings2);
		String[] strings3 = { "test 3", "test 33" };
		hashMap.put("value 3", strings3);
		String[] strings4 = { "test 4" };
		hashMap.put("value 4", strings4);
		String[] strings5 = { "test 5", "test 55", "test 555" };
		hashMap.put("value 5", strings5);
		// Affichage HashMap<String, String[])
		afficheMap(hashMap);

		//////////////////////////
		// Utilisation du MultiMap que l'on a crée
		MultiMap mapTest = new MultiMap();
		mapTest.put("test 1", "1");
		mapTest.put("test 1", "1");
		mapTest.put("test 2", "2");
		mapTest.put("test 1", "11");
		mapTest.put("test 3", "3");
		mapTest.put("test 4", "4");
		mapTest.put("test 4", "44");
		System.out.println("longueur de la map : " + mapTest.size());
		// Affichage du MultiMap
		for (String string : mapTest.keySet()) {
			for (String value : mapTest.getValue(string)) {
				System.out.println("Key : " + string + " value : " + value);
			}
		}

	}

	public static List<String> inverseList(List<String> list) {
		Collections.reverse(list);
		return list;
	}

	public static List<String> inverseAlphaList(List<String> list) {
		Collections.sort(list, Collections.reverseOrder());

		return list;
	}

	public static void afficheMap(Map<String, String[]> map) {
		for (String key : map.keySet()) {
			for (String value : map.get(key)) {
				System.out.println("clé : " + key + " valeur : " + value);
			}
		}

	}

}
