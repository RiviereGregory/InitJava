package fr.treeptik.initjava.collection.exemple;

import java.util.Comparator;

public class PersonneNomComparator implements Comparator<Personne> {

	@Override
	public int compare(Personne personne1, Personne personne2) {
		int result = personne1.getNom().compareToIgnoreCase(personne2.getNom());
		if (result == 0){
			result = personne1.getPrenom().compareToIgnoreCase(personne2.getPrenom());
		}
		
		return result;
	}

}
