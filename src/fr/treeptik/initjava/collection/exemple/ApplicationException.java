package fr.treeptik.initjava.collection.exemple;

@SuppressWarnings("serial")
public class ApplicationException extends Exception{
// Permet de créer nos propres exception
	public ApplicationException() {
		super();
	}

	
	public ApplicationException(String message) {
		super(message);
	}

	
}
