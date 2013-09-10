package fr.treeptik.initjava.exercice.gestionabonnementtelephonique;

public class Materiel {
	public enum TypeMateriel {
		BOX, MOBILE;
	}

	private String ref;
	private TypeMateriel type;

	public Materiel(String ref, TypeMateriel type) {
		super();
		this.ref = ref;
		this.type = type;
	}

	public Materiel() {
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public TypeMateriel getType() {
		return type;
	}

	public void setType(TypeMateriel type) {
		this.type = type;
	}

}
