package fr.treeptik.initjava.exercice.gestionabonnementtelephonique;

import java.util.Date;

public class ForfaitMobile extends Forfait {
	private Integer duree;
	private Integer nbSms;

	public ForfaitMobile(String ref, Date dateDebut, Date dateFin, String numero,
			Materiel materiel, Integer duree, Integer nbSms) {
		super(ref, dateDebut, dateFin, numero, materiel);
		this.duree = duree;
		this.nbSms = nbSms;
	}

	public ForfaitMobile() {
		super();
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Integer getNbSms() {
		return nbSms;
	}

	public void setNbSms(Integer nbSms) {
		this.nbSms = nbSms;
	}

}
