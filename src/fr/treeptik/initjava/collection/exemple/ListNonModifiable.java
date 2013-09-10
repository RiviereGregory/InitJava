package fr.treeptik.initjava.collection.exemple;

import java.util.AbstractList;
import java.util.List;

public class ListNonModifiable extends AbstractList<String> {
	// on peut créer sa propre list avec les méthode que l'on veut
	// redéfinir il ne faut que get et size

	private List<String> list;

	public ListNonModifiable(List<String> list) {
		this.list = list;
	}

	@Override
	public String get(int index) {

		return list.get(index);
	}

	@Override
	public int size() {
		return list.size();
	}

}
