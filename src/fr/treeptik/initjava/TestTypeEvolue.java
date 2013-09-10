package fr.treeptik.initjava;

import java.util.*;

public class TestTypeEvolue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		// List
		//

		// il faut typer les list pour utiliser le foreach car un seul type
		List<String> list = new LinkedList<String>();

		list.add("toto1 !! ");
		list.add("toto2 !! ");
		list.add("toto3 !! ");

		int i = 0;

		for (String string : list) {
			System.out.println("element à l'index " + i++ + " = " + string);
		}
		list.remove(1);

		i = 0;
		System.out.println("");

		System.out.println("l'element 1 de la list a été supprimé ");

		for (String string : list) {
			System.out.println("element à l'index " + i++ + " = " + string);
		}

		//
		// ArrayList
		//

		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(10);
		arrayList.add(0);
		arrayList.add(20);
		arrayList.add(5);
		arrayList.add(15);

		Integer total = 0;

		for (Integer integer : arrayList) {
			total += integer;
		}
		System.out.println("");
		System.out.println("moyenne de la list " + total / arrayList.size());

		//
		// Hashtable permet de creer un dictionnaire avec la premiere
		// valeur qui est la key et la second qui est la value
		//

		Hashtable<Integer, String> hashtable = new Hashtable<>();

		hashtable.put(1, "printemps");
		hashtable.put(10, "ete");
		hashtable.put(2, "automne");
		hashtable.put(45, "hiver");

		System.out.println("");

		System.out.println("la map contient la key 1 : " + hashtable.containsKey(1));
		System.out.println("la map contient la value ete : " + hashtable.containsValue("ete"));
		System.out.println("la key 10 contient la value : " + hashtable.get(10));// return la value
																					// de la
		// key 10

		// permet d'afficher la table de value en passant par enumeration
		Enumeration<String> enumeration = hashtable.elements();

		System.out.println("");
		System.out.println("Enumération du contenu de la map");

		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}

		System.out.println("");

		// a utiliser à la place de Hashtable
		HashMap<String, List<String>> annuaire = new HashMap<>();
		System.out.println(annuaire);

	}

}
