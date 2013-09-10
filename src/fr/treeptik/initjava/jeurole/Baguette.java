package fr.treeptik.initjava.jeurole;

public class Baguette extends Arme {
		
	private static final long serialVersionUID = 1L;

	public Baguette() {
		super(40);
	}
	
	@Override
	public String toString() {
		return "Baguette";
	}

	@Override
	public int hashCode() {
		return this.getClass().getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Baguette) {
			return true;
		}
		return false;
	}

}
