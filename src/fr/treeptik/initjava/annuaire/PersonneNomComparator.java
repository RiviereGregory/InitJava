package fr.treeptik.initjava.annuaire;

import java.util.Comparator;

public class PersonneNomComparator implements Comparator<Personne> {

	@Override
	public int compare(Personne personne1, Personne personne2) {
		// Il faut ajouter un autre niveau de comparaison pour pouvoir mettre
		// des noms identiques avec des prénom différent
		int result = personne1.getNom().compareToIgnoreCase(personne2.getNom());
		if (result == 0) {
			result = personne1.getPrenom().compareToIgnoreCase(personne2.getPrenom());
		}

		return result;
	}

}