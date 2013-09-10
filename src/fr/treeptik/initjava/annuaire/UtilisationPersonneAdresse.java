package fr.treeptik.initjava.annuaire;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class UtilisationPersonneAdresse {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		// Il faut mettre un comparator dans le TreeMap pour qu'il puissent faire le trie
		// et aussi verifier la key
		TreeMap<Personne, ArrayList<Adresse>> annuaire = new TreeMap<>(new PersonneNomComparator());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Adresse> adresseList = new ArrayList<>();

		while (!"Q".equalsIgnoreCase(line)) {
			System.out.println("++++++++++++++++++++++++");
			System.out.println("++++++++++ MENU ++++++++");
			System.out.println("+ 1 - Ajouter Personne");
			System.out.println("+ 2 - Ajouter Adresse");
			System.out.println("+ 3 - Lister les Personnes");
			System.out.println("+ Q - Quitter");
			System.out.println("Choix : ");

			line = scanner.nextLine();

			if ("Q".equalsIgnoreCase(line)) {
				System.out.println("Au revoir  !");
			} else if ("1".equalsIgnoreCase(line)) {

				Date date = null;
				System.out.println("entrer le nom :");
				String nom = scanner.nextLine();
				System.out.println("entrer le prenom :");
				String prenom = scanner.nextLine();
				System.out.println("entrer la date de naissance (jj/mm/aaaa:");
				String sDate = scanner.nextLine();
				try {
					date = dateFormat.parse(sDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				// creation de la nouvelle list pour la map
				adresseList = new ArrayList<>();
				// creation de la personne pour la map
				Personne personne = new Personne(nom, prenom, date);
				// ajout de la key personne dans la map avec value adresseList
				annuaire.put(personne, adresseList);

			} else if ("2".equalsIgnoreCase(line)) {
				System.out.println("entrer le nom :");
				String nom = scanner.nextLine();
				System.out.println("entrer le prenom :");
				String prenom = scanner.nextLine();
				Personne personne = new Personne(nom, prenom, new Date());
				// Creation de la liste
				adresseList = new ArrayList<>();
				// recuperation de la list dans la map grace à la key
				adresseList = annuaire.get(personne);
				// vérification de la presence de la key dans la map
				if (!annuaire.containsKey(personne)) {
					System.out.println("la Personne n'est pas dans l'annuaire");
					continue;
				}

				System.out.println("entrer la ville : ");
				line = scanner.nextLine();
				String ville = line;
				System.out.println("entrer le code postal : ");
				line = scanner.nextLine();
				String codePostal = line;
				// création de l'adresse avec les paramètres
				Adresse adresse = new Adresse(ville, codePostal);

				adresseList.add(adresse); // ajoute le nouveau numero dans list
				annuaire.put(personne, adresseList); // remplace la list dans la map

			} else if ("3".equalsIgnoreCase(line)) {

				System.out.println("Liste des personnes");
				// creation d'un set (liste) des valeurs des key de la map
				Set<Personne> keySet = annuaire.keySet();

				for (Personne valeur : keySet) {
					// Affiche la personne
					System.out.println(valeur);
					// Affiche les adresses
					for (Adresse string2 : annuaire.get(valeur)) {
						System.out.println(" - " + string2);
					}
					System.out.println("");
				}

			} else {

				System.out.println("erreur Saisie");
			}

		}

		scanner.close();
	}

}
