package fr.treeptik.initjava.exercice.uml;

public abstract class Article {
	private String titre;
	
	public Article(String titre) {
		this.titre = titre;
	}
	public Article() {
	}
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}
