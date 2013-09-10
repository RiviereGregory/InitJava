package fr.treeptik.initjava.jeurole;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class JeuRole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File filePersonnage = new File("fichierPersonnage");
		if (!filePersonnage.exists()) {
			try {
				filePersonnage.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		HashMap<String, ArrayList<Personnage>> map = new HashMap<>();
		map.put("partie 1", lireFichierPerso(filePersonnage));
		map.put("partie 2", lireFichierPerso(filePersonnage));
		map.put("partie 3", lireFichierPerso(filePersonnage));
		map.put("partie 4", lireFichierPerso(filePersonnage));
		map.put("partie 5", lireFichierPerso(filePersonnage));

		Set<String> set = map.keySet();
		int combat = 1;

		for (String string : set) {
			System.out.println("combat " + combat);

			ArrayList<Personnage> personnages = new ArrayList<>();
			personnages = map.get(string);

			Personnage personnage1 = null;
			Personnage personnage2 = null;

			Random random = new Random();
			int tour = 1;
			while (true) {
				// System.out.println(personnages2.size());
				System.out.println("");
				if (personnages.size() <= 1) {
					break;
				}
				int combattant1;
				int combattant2;
				System.out.println("tour " + tour);
				while (true) {
					combattant1 = random.nextInt(personnages.size());
					combattant2 = random.nextInt(personnages.size());
					while (true) {
						if (combattant1 == combattant2) {
							combattant2 = random.nextInt(personnages.size());
						} else {
							break;
						}
					}
					personnage1 = personnages.get(combattant1);
					personnage2 = personnages.get(combattant2);

					System.out.println(personnage1);
					System.out.println(personnage2);

					if (personnage1.getNombreVie() <= 0 || personnage2.getNombreVie() <= 0) {

					} else {
						break;
					}
				}
				// personnage1.attaquer(personnage2);
				// System.out.println("point de vie " + personnage2);
				// if (personnage2.getNombreVie() <= 0) {
				// personnages2.remove(combattant2);
				//
				// } else {
				// personnage2.attaquer(personnage1);
				// }
				// System.out.println("point de vie " + personnage1);
				// if (personnage1.getNombreVie() <= 0) {
				// personnages2.remove(combattant1);
				// }

				if (personnage1.attaquer(personnage2) <= 0) {
					personnages.remove(combattant2);

				} else if (personnage2.attaquer(personnage1) <= 0) {
					personnages.remove(combattant1);
				}
				System.out.println("point de vie " + personnage1);
				System.out.println("point de vie " + personnage2);

				tour++;
			}
			System.out.println("");
			System.out.println("le gagnant est : " + personnages.get(0));
			System.out.println("");
			combat++;

		}

		// ArrayList<Personnage> personnages = new ArrayList<>();
		// personnages = lireFichierPerso(filePersonnage);
		// HashMap<String, ArrayList<Personnage>> map = new HashMap<>();
		// map.put("partie 1", personnages);
		// map.put("partie 2", personnages);
		// map.put("partie 3", personnages);
		// map.put("partie 4", personnages);
		// map.put("partie 5", personnages);
		//
		//
		//
		//
		// Set<String> set = map.keySet();
		// int combat = 1;
		//
		// for (String string : set) {
		// boolean gagnant = true;
		// ArrayList<Personnage> personnages2 = new ArrayList<>();
		// personnages2 = map.get(string);
		//
		// Personnage personnage1 = null;
		// Personnage personnage2 = null;
		//
		// Random random = new Random();
		// while (true) {
		// Integer combattant1 = random.nextInt(personnages2.size());
		// Integer combattant2 = random.nextInt(personnages2.size());
		// while (true) {
		// if (combattant1.equals(combattant2)) {
		// combattant2 = random.nextInt(personnages2.size());
		// } else {
		// break;
		// }
		// }
		// personnage1 = personnages2.get(combattant1);
		// personnage2 = personnages2.get(combattant2);
		//
		//
		// System.out.println(personnage1);
		// System.out.println(personnage2);
		//
		// if (personnage1.getNombreVie() <= 0 || personnage2.getNombreVie() <= 0) {
		//
		// } else {
		// break;
		// }
		// }
		//
		// int tour = 1;
		// System.out.println("combat " + combat);
		// while (gagnant) {
		// System.out.println("tour " + tour);
		// personnage1.attaquer(personnage2);
		// System.out.println("point de vie " + personnage2);
		// if (personnage2.getNombreVie() <= 0) {
		// gagnant = false;
		// } else {
		// personnage2.attaquer(personnage1);
		// }
		// System.out.println("point de vie " + personnage1);
		// if (personnage1.getNombreVie() <= 0) {
		// gagnant = false;
		// }
		// tour++;
		// }
		// System.out.println("");
		// combat++;
		// if (combat == set.size() + 1) {
		// Personnage persoGagnant = personnages2.get(0);
		// System.out.println(personnages2.get(0));
		// for (int i = 1; i < personnages2.size(); i++) {
		// System.out.println(personnages2.get(i));
		// if (personnages2.get(i).getNombreVie() > persoGagnant.getNombreVie()) {
		// persoGagnant = personnages2.get(i);
		// }
		// }
		// System.out.println("le gagnant est : " + persoGagnant);
		// }
		// }

	}

	public static ArrayList<Personnage> lireFichierPerso(File file) {
		ArrayList<Personnage> personnages = new ArrayList<>();

		FileReader fileReader = null;

		try {
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while (bufferedReader.ready()) {

				Chevalier chevalier = null;
				Elfe elfe = null;
				Magicien magicien = null;

				Arme arme = null;

				String line = bufferedReader.readLine();
				String[] donneesPersonnage = line.split(";");

				String typePersonnage = donneesPersonnage[0];
				Integer pointDeVie = Integer.valueOf(donneesPersonnage[1]);
				String typeArme = donneesPersonnage[2];
				String nom = donneesPersonnage[3];

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

			bufferedReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return personnages;
	}

}
