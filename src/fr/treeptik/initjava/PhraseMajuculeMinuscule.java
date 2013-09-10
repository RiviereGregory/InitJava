package fr.treeptik.initjava;
import java.util.Scanner;


public class PhraseMajuculeMinuscule {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("saisir une phrase :");
		String line = scanner.nextLine();
		//System.out.println(line);
		phraseMaxMin(line);
		
		scanner.close();

	}
	
	public static void phraseMaxMin(String phrase){
		String[] phraseTab = phrase.split(" ");
		
		int tailleTab = phraseTab.length;
		
		for(int i = 0; i< tailleTab; i++){
			if (i%2 == 0){
				System.out.print(phraseTab[i].toUpperCase());
			}else {
				System.out.print(phraseTab[i].toLowerCase());
			}
			System.out.print(" ");
			
		}
		
	}

}
