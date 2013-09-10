package fr.treeptik.initjava.exercice.gestionabonnementtelephonique;

import java.util.List;

public class PersonneMorale extends Client {

	private String siret;
	private String codeAPE;

	public PersonneMorale(String ref, Adresse adresse, List<Forfait> forfait, String siret,
			String codeAPE) {
		super(ref, adresse, forfait);
		this.siret = siret;
		this.codeAPE = codeAPE;
	}

	public PersonneMorale() {
		super();
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getCodeAPE() {
		return codeAPE;
	}

	public void setCodeAPE(String codeAPE) {
		this.codeAPE = codeAPE;
	}

}
