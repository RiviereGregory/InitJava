package fr.treeptik.initjava.collection.exemple;

public enum Civilite {
	MONSIEUR(4,"value") , MADAME(5,"value2"), DOCTEUR(6,"value3");
	
	private Integer value;
	private String chaine;

	private Civilite(Integer value, String chaine){
		this.value=value;
		this.chaine=chaine;
	}

	public Integer getValue() {
		return value;
	}


	public String getChaine() {
		return chaine;
	}

}
