package fr.treeptik.initjava.jeurole;

public class Epee extends Arme {
	
	private static final long serialVersionUID = 1L;

	public Epee() {
		super(40);
	}

	@Override
	public String toString() {
		return "Epee";
	}

	@Override
	public int hashCode() {
		return this.getClass().getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Epee) {
			return true;
		}
		return false;
	}

}
