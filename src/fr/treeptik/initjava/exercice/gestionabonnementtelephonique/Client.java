package fr.treeptik.initjava.exercice.gestionabonnementtelephonique;

import java.util.List;

public class Client {
	private String ref;
	private Adresse adresse;
	private List<Forfait> forfait;

	public Client(String ref, Adresse adresse, List<Forfait> forfait) {
		super();
		this.ref = ref;
		this.adresse = adresse;
		this.forfait = forfait;
	}

	public Client() {
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Forfait> getForfait() {
		return forfait;
	}

	public void setForfait(List<Forfait> forfait) {
		this.forfait = forfait;
	}

}
