package fr.treeptik.initjava.exercice.uml;

import java.util.ArrayList;

public class Caddie {
	private ArrayList<Article> listArticle;

	public Caddie(ArrayList<Article> listArticle) {
		super();
		this.listArticle = listArticle;
	}

	public Caddie() {
		super();
	}

	public ArrayList<Article> getListArticle() {
		return listArticle;
	}

	public void setListArticle(ArrayList<Article> listArticle) {
		this.listArticle = listArticle;
	}

}
