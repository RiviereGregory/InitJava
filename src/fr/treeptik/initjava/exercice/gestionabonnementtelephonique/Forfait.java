package fr.treeptik.initjava.exercice.gestionabonnementtelephonique;

import java.util.Date;

public class Forfait {
	private String ref;
	private Date dateDebut;
	private Date dateFin;
	private String numero;
	private Materiel materiel;

	public Forfait(String ref, Date dateDebut, Date dateFin, String numero, Materiel materiel) {
		super();
		this.ref = ref;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.numero = numero;
		this.materiel = materiel;
	}

	public Forfait() {
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
