package fr.treeptik.initjava.exercice.livre;

import java.util.Random;

public class Aleat {
	private Integer[] tabAleat;
	private int n;
	private int lim;

	public Aleat(int n, int lim) {
		this.setN(n);
		this.setLim(lim);
		this.tabAleat = new Integer[n];
		Random alea = new Random();
		for (int i = 0; i < n; i++) {
			tabAleat[i] = alea.nextInt(lim);
			
		}
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getLim() {
		return lim;
	}

	public void setLim(int lim) {
		this.lim = lim;
	}
	
	
	

}
