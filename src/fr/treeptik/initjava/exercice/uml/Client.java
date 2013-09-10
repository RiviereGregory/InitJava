package fr.treeptik.initjava.exercice.uml;

import java.util.ArrayList;

public class Client {
	private Caddie caddie;
	private ArrayList<Commande> listCommande;

	
	public Client(Caddie caddie, ArrayList<Commande> listCommande) {
		super();
		this.caddie = caddie;
		this.listCommande = listCommande;
	}

	public Client() {
	}

	public ArrayList<Commande> getListCommande() {
		return listCommande;
	}

	public void setListCommande(ArrayList<Commande> listCommande) {
		this.listCommande = listCommande;
	}

	public Caddie getCaddie() {
		return caddie;
	}

	public void setCaddie(Caddie caddie) {
		this.caddie = caddie;
	}

}
