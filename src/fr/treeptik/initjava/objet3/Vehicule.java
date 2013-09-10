package fr.treeptik.initjava.objet3;

public abstract class Vehicule implements ComportementAvancer{

	public enum Carburant {
		GPL, DIESEL, SANS_PLOMB, ELECTRIQUE;
	}

	// Données Membres
	protected Integer puissance;
	protected Carburant carburant;

	private static int count;// la variable ne sera pas remis à zéros

	// Constructeurs

	public Vehicule(Integer puissance, Carburant carburant) {
		this.puissance = puissance;
		this.carburant = carburant;
		count++;
	}

	public Vehicule() {
	}

	// Methodes


	// Accesseur
	public Integer getPuissance() {
		return puissance;
	}

	public void setPuissance(Integer puissance) {
		this.puissance = puissance;
	}

	public Carburant getCarburant() {
		return carburant;
	}

	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Vehicule.count = count;
	}


}
