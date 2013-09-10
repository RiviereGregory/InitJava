package fr.treeptik.initjava.exercice.uml;

public abstract class Livre  extends Article{
	private String auteur;
	private Integer nombreDePages;
	private String numeroISBN;
	
	public Livre(String titre, String auteur, Integer nombreDePages, String numeroISBN) {
		super(titre);
		this.auteur = auteur;
		this.nombreDePages = nombreDePages;
		this.numeroISBN = numeroISBN;
	}
	
	public Livre() {
	}


	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Integer getNombreDePages() {
		return nombreDePages;
	}

	public void setNombreDePages(Integer nombreDePages) {
		this.nombreDePages = nombreDePages;
	}

	public String getNumeroISBN() {
		return numeroISBN;
	}

	public void setNumeroISBN(String numeroISBN) {
		this.numeroISBN = numeroISBN;
	}
	
	

}
