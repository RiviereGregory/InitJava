package fr.treeptik.initjava.exercice.gestionabonnementtelephonique;

import java.util.Date;

public class ForfaitFixe extends Forfait {
	private Adresse adresse;

	
	public ForfaitFixe(String ref, Date dateDebut, Date dateFin, String numero, Materiel materiel,
			Adresse adresse) {
		super(ref, dateDebut, dateFin, numero, materiel);
		this.adresse = adresse;
	}

	public ForfaitFixe() {
		super();
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
