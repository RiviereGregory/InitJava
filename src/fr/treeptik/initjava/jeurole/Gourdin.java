package fr.treeptik.initjava.jeurole;

public class Gourdin extends Arme {
	
	private static final long serialVersionUID = 1L;

	public Gourdin() {
		super(40);
	}

	
	@Override
	public String toString() {
		return "Gourdin";
	}

	@Override
	public int hashCode() {
		return this.getClass().getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Gourdin) {
			return true;
		}
		return false;
	}

}
