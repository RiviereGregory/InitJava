package fr.treeptik.initjava;

import java.util.Scanner;

public class StringSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("saisir une phrase :");
		String line = scanner.nextLine();
		//phraseMaxMin(line);
		
		
		//System.out.println("saisir une phrase :");
		//line = scanner.nextLine();
		System.out.println("l'inverse de "+line +" est " +mirror(line));
		//System.out.println(mirrorBuilder(line));
		palindrome(line, mirror(line));

		scanner.close();

	}
	
	public static void palindrome(String phrase, String phrase2) {
		if(phrase.equalsIgnoreCase(phrase2)){
			System.out.println(phrase +" est un palindrome ");
		}else{
			System.out.println(phrase +" n'est pas un palindrome ");			
		}
		
	}

	public static void phraseMaxMin(String phrase) {
		String[] phraseTab = phrase.split(" ");

		int tailleTab = phraseTab.length;

		for (int i = 0; i < tailleTab; i++) {
			if (i % 2 == 0) {
				System.out.print(phraseTab[i].toUpperCase());
			} else {
				System.out.print(phraseTab[i].toLowerCase());
			}
			System.out.print(" ");
		}
		System.out.println("");
	}
	
	public static String mirror(String line) {
		String lineMirror = "";
		for(int i= line.length()-1; i>=0; i--){
			lineMirror += line.charAt(i);
		}		
		return lineMirror;		
	}
	public static String mirrorBuilder(String line) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=line.length()-1; i>=0; i--){
			stringBuilder.append(line.charAt(i));
		}	
		
		return stringBuilder.toString();
	}

}
