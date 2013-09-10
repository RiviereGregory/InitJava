package fr.treeptik.initjava.jeurole;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import fr.treeptik.initjava.jeurole.xml.ListPerso;
import fr.treeptik.initjava.jeurole.xml.Personnage;

public class FichierXml {

	/**
	 * @param args
	 * @throws JAXBException
	 */
	public static void main(String[] args) throws JAXBException {
		// Package où l'on a généré les class du xml
		JAXBContext context = JAXBContext.newInstance("fr.treeptik.initjava.jeurole.xml");
//		System.out.println(context);
		System.out.println("////////////////");
		// Pour lire un fichier
		Unmarshaller unmarshaller = context.createUnmarshaller();
//		System.out.println(unmarshaller);
		System.out.println("////////////////");

		ListPerso listPerso = (ListPerso) unmarshaller.unmarshal(new File("personnages.xml"));

		for (fr.treeptik.initjava.jeurole.Personnage personnage1 : listPersonnages(listPerso)) {
			System.out.println(personnage1);

		}
		
		//
		// Pour ecrire dans fichier
		//
		
		// Création du personnage de la class xml
		Personnage personnage = new Personnage();
		personnage.setType("M");
		personnage.setNom("Maux");
		fr.treeptik.initjava.jeurole.xml.Arme armeActive = new fr.treeptik.initjava.jeurole.xml.Arme();
		armeActive.setPointDegat(10);
		armeActive.setType("B");
		personnage.setArmeCourante(armeActive);
		personnage.setNbVie(100);
		//Ajout du personnage dans la list des perso lu
		listPerso.getPersonnage().add(personnage);
		//Ajout dans un nouveau fichier
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(listPerso, new File("newPersonnages.xml"));
		// Lecture et affichage de la nouvelle list perso
		unmarshaller = context.createUnmarshaller();
		ListPerso newListPerso = (ListPerso) unmarshaller.unmarshal(new File("newPersonnages.xml"));
		System.out.println("//nouvelle list//");
		for (fr.treeptik.initjava.jeurole.Personnage personnage1 : listPersonnages(newListPerso)) {
			System.out.println(personnage1);

		}
		
		System.out.println("////////////////");
		// Pour le jeu
		partiePersonnage(listPerso);

		System.out.println("////////////////");
		
	}

	public static ArrayList<fr.treeptik.initjava.jeurole.Personnage> listPersonnages(
			ListPerso listPerso) { 
		ArrayList<fr.treeptik.initjava.jeurole.Personnage> personnages = new ArrayList<>();

		for (Personnage personnage : listPerso.getPersonnage()) {
//			System.out.println(personnage.getNbVie());

			Chevalier chevalier = null;
			Elfe elfe = null;
			Magicien magicien = null;

			Arme arme = null;

			String typePersonnage = personnage.getType();
			Integer pointDeVie = personnage.getNbVie();
			String typeArme = personnage.getArmeCourante().getType();
			String nom = personnage.getNom();

			if ("B".equalsIgnoreCase(typeArme)) {
				arme = new Baguette();
			} else if ("E".equalsIgnoreCase(typeArme)) {
				arme = new Epee();
			} else if ("G".equalsIgnoreCase(typeArme)) {
				arme = new Gourdin();

			}

			if ("C".equalsIgnoreCase(typePersonnage)) {

				chevalier = new Chevalier(pointDeVie, arme, nom);
				personnages.add(chevalier);

			} else if ("E".equalsIgnoreCase(typePersonnage)) {
				elfe = new Elfe(pointDeVie, arme, nom);
				personnages.add(elfe);

			} else if ("M".equalsIgnoreCase(typePersonnage)) {
				magicien = new Magicien(pointDeVie, arme, nom);
				personnages.add(magicien);

			}

		}

		return personnages;

	}

	public static void partiePersonnage(ListPerso listPerso) {
		HashMap<String, ArrayList<fr.treeptik.initjava.jeurole.Personnage>> map = new HashMap<>();
		// listPersonnages(listPerso) permet de recontruire une nouvelle liste avec les personnages
		// qui ont leurs point de vie remis au départ
		map.put("partie 1", listPersonnages(listPerso));
		map.put("partie 2", listPersonnages(listPerso));
		map.put("partie 3", listPersonnages(listPerso));
		map.put("partie 4", listPersonnages(listPerso));
		map.put("partie 5", listPersonnages(listPerso));

		Set<String> set = map.keySet();
		int combat = 1;

		for (String string : set) {
			System.out.println("combat " + combat);

			ArrayList<fr.treeptik.initjava.jeurole.Personnage> personnages2 = new ArrayList<>();
			personnages2 = map.get(string);

			fr.treeptik.initjava.jeurole.Personnage personnage1 = null;
			fr.treeptik.initjava.jeurole.Personnage personnage2 = null;

			Random random = new Random();
			int tour = 1;
			while (true) {
				// System.out.println(personnages2.size());
				System.out.println("");
				if (personnages2.size() <= 1) {
					break;
				}
				int combattant1;
				int combattant2;
				System.out.println("tour " + tour);
				while (true) {
					combattant1 = random.nextInt(personnages2.size());
					combattant2 = random.nextInt(personnages2.size());
					while (true) {
						if (combattant1 == combattant2) {
							combattant2 = random.nextInt(personnages2.size());
						} else {
							break;
						}
					}
					personnage1 = personnages2.get(combattant1);
					personnage2 = personnages2.get(combattant2);

					System.out.println(personnage1);
					System.out.println(personnage2);

					if (personnage1.getNombreVie() <= 0 || personnage2.getNombreVie() <= 0) {

					} else {
						break;
					}
				}

				if (personnage1.attaquer(personnage2) <= 0) {
					personnages2.remove(combattant2);

				} else if (personnage2.attaquer(personnage1) <= 0) {
					personnages2.remove(combattant1);
				}
				System.out.println("point de vie " + personnage1);
				System.out.println("point de vie " + personnage2);

				tour++;
			}
			System.out.println("");
			System.out.println("le gagnant est : " + personnages2.get(0));
			System.out.println("");
			combat++;

		}

	}
}
