package fr.treeptik.initjava.collection.exemple;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class UtilisationPersonne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1ere facon d'apeller la classe Personne
		Personne james = new Personne();
		james.setNom("Gosling");
		james.setPrenom("James");
		james.setDateNaissance(new Date());
		// 2eme façon
		Personne linus = new Personne("Torvalds", "Linus", new Date());

		System.out.println(linus); // on affiche l'adresse mémoire si on ne
		// redéfinit pas la méthode toString
		// ////////////////////////////////////////////
		Date date = null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
		try {
			String date1 = "03/02/1978";
			date = simpleDateFormat.parse(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Personne personne = new Personne("RIVIERE", "Gregory", date);
		System.out.println(personne.getPrenom());
		System.out.println(personne.getNom());
		System.out.println(simpleDateFormat.format(personne.getDateNaissance()));

		// ///////////////////////////////////////////////////

		ArrayList<Personne> personnes = new ArrayList<>();

		Personne gavin = new Personne("King", "Gavin", new Date());

		personnes.add(james);
		personnes.add(linus);
		personnes.add(gavin);

		for (Personne personne2 : personnes) {
			System.out.println(personne2);

		}
		System.out.println("//////////////////////////////");
		// Pour trier une list on a vu
		// Collections.sort(personnes); // cela ne fonctionne pas
		// car on a pas def la façon de trie
		// il faut avant la def dans une nouvelle classe comparator

		// le comparator se mais dans le sort avec la list
		Collections.sort(personnes, new PersonneNomComparator());

		for (Personne personne2 : personnes) {
			System.out.println(personne2);

		}

		System.out.println("//////////////////////////////");
		// inversion de la list deja trie
		Collections.reverse(personnes);
		// inverse une list non trie
		// Collections.sort(personnes, Collections.reverseOrder(new
		// PersonneNomComparator()));

		for (Personne personne2 : personnes) {
			System.out.println(personne2);

		}

		// c'est l'objet linus et non pas la chaine de charactere qui est
		// retourné true
		// System.out.println(" contains : " + personnes.contains(linus));
		// pour le faire on a 2 façon de le faire dans la classe ou en externe
		// ici il faut le faire dans la classe car la methode d'égalité doit
		// être unique

		Personne linus2 = new Personne("Torval", "Linus", new Date());
		// on a redef la methode equals dans la classe Personne
		// on verifie le nom et le prenom
		System.out.println("+- Equals : " + linus.equals(linus2));
		System.out.println("+- Contains : " + personnes.contains(linus2));

		//
		// MAP Personne
		//

		HashMap<Personne, Integer> mapPersonne = new HashMap<>();

		mapPersonne.put(linus, 1);
		mapPersonne.put(gavin, 1);
		mapPersonne.put(james, 1);

		mapPersonne.put(new Personne("Torval", "Linus", new Date()), 2);
		mapPersonne.put(gavin, 2);
		mapPersonne.put(james, 2);

		Set<Personne> keySet = mapPersonne.keySet();
		System.out.println("Taille Map " + keySet.size());
		// On ne trouve pas la personne on ne verifie pas bien la presence
		// car les map utilise hashcode à la place de equals
		System.out.println("containKey : " + mapPersonne.containsKey(linus2));

	}

}
