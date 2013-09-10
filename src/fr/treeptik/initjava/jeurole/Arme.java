package fr.treeptik.initjava.jeurole;

import java.util.Objects;

public abstract class Arme implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer pointDegat;

	// Faire un constructeur avec valeur permet d'obliger l'initialisation des valeurs
	public Arme(Integer pointDegat) {
		// Permet de tester si on passe pas de valeur null
		Objects.requireNonNull(pointDegat);
		this.pointDegat = pointDegat;
	}

	public Integer getPointDegat() {
		return pointDegat;
	}

	public void setPointDegat(Integer pointDegat) {
		this.pointDegat = pointDegat;
	}

}
