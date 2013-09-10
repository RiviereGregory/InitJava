package fr.treeptik.initjava.exercice.livre;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SolutionDefibrillateur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String line = "";
		Double longitudeUtilisateur = null;
		Double latitudeUtilisateur = null;
		Integer nbDefibrillateur = null;

		// System.out.println("Entrer longitude: ");
		line = in.nextLine();
		longitudeUtilisateur = Double.parseDouble(line.replace(",", "."));

		// System.out.println("Entrer latitude: ");
		line = in.nextLine();
		latitudeUtilisateur = Double.parseDouble(line.replace(",", "."));

		Boolean conditionTaille = false;

		while (!conditionTaille) {
			// System.out.println("Entrer nombre défibrillateur : ");
			line = in.nextLine();
			nbDefibrillateur = Integer.valueOf(line);
			if (nbDefibrillateur > -1 && nbDefibrillateur < 10000) {
				conditionTaille = true;
			} else {
				conditionTaille = false;
			}

		}

		String[] tabTemp;
		Map<Integer, String[]> map = new HashMap<>();

		for (int i = 0; i < nbDefibrillateur; i++) {
			line = in.nextLine();
			tabTemp = line.split(";");
			String[] tabDef = new String[tabTemp.length - 1];
			for (int j = 1; j < tabTemp.length; j++) {
				tabDef[j - 1] = tabTemp[j];
			}

			map.put(i, tabDef);
		}

		Double distanceMin = null;
		Set<Integer> keySet = map.keySet();
		String[] tempTab = map.get(0);
		distanceMin = distance(latitudeUtilisateur, longitudeUtilisateur,
				Double.parseDouble(tempTab[4].replace(",", ".")),
				Double.parseDouble(tempTab[3].replace(",", ".")));
		Integer keyDistanceMin = 0;

		for (Integer integer : keySet) {
			tempTab = map.get(integer);
			if (distance(latitudeUtilisateur, longitudeUtilisateur,
					Double.parseDouble(tempTab[4].replace(",", ".")),
					Double.parseDouble(tempTab[3].replace(",", "."))) < distanceMin) {
				distanceMin = distance(latitudeUtilisateur, longitudeUtilisateur,
						Double.parseDouble(tempTab[4].replace(",", ".")),
						Double.parseDouble(tempTab[3].replace(",", ".")));
				keyDistanceMin = integer;
			}
			// System.out.println(distanceMin);
		}
		String[] solTab = map.get(keyDistanceMin);
		System.out.println(solTab[0]);

		in.close();

	}

	public static Double distance(Double latA, Double longA, Double latB, Double longB) {

		Double x = (longB - longA) * Math.cos((latA + latB) / 2);
		Double y = latB - latA;

		Double dist = Math.sqrt(x * x + y * y) * 6371;

		return dist;
	}

}
